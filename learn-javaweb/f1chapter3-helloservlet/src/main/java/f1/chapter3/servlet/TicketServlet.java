package f1.chapter3.servlet;

import f1.chapter3.pojo.Attachment;
import f1.chapter3.pojo.Ticket;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

@WebServlet(
        name = "ticketServlet",
        urlPatterns = {"/tickets"},
        loadOnStartup = 1
)
@MultipartConfig(//告诉web容器为servlet提供上传文件的支持
        fileSizeThreshold = 5_242_880,//5MB
        /**
         * 告诉web容器文件必须达到多大才能写入到临时目录中（这里小于5MB的将保存在内存中，请求完成后将由垃圾回收器回收，
         * 大于5MB的将保存在location指向的目录中，服务器会有一个默认的location目录，请求完成后，容器将从磁盘中删除此文件）
        */
        maxFileSize = 20_971_520L,//20MB,禁止上传文件大小超过20MB的文件
        maxRequestSize = 41_943_040L//40MB，禁止大小超过40MB的请求
)
public class TicketServlet extends HttpServlet {
    private volatile int TICKET_ID_SEQUENCE = 0;//使用volatile关键字，可以保证其他线程始终可以读取变量修改后的最终值
    private Map<Integer, Ticket> ticketDB = new LinkedHashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (null == action) {
            action = "list";
        }
        switch (action) {
            case "create":
                this.showTicketForm(resp);
                break;
            case "view":
                this.viewTicket(req, resp);
                break;
            case "download":
                this.downloadAttachment(req, resp);
                break;
            case "list":
            default:
                this.showTicketList(resp);
                break;
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (null == action) {
            action = "list";
        }
        switch (action) {
            case "create":
                this.createTicket(req, resp);
                break;
            case "list":
            default:
                resp.sendRedirect("tickets");
                break;
        }
    }

    /**
     * 下载attachment
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void downloadAttachment(HttpServletRequest request,
                                    HttpServletResponse response)
            throws ServletException, IOException {
        String idString = request.getParameter("ticketId");
        Ticket ticket = this.getTicket(idString, response);
        if (ticket == null) {
            return;
        }

        String name = request.getParameter("attachment");
        if (name == null) {
            response.sendRedirect("tickets?action=view&ticketId=" + idString);
            return;
        }

        Attachment attachment = ticket.getAttachments().get(name);
        if (attachment == null) {
            response.sendRedirect("tickets?action=view&ticketId=" + idString);
            return;
        }

        response.setHeader("Content-Disposition",//强制浏览器询问是保存还是下载文件，而不是在线打开文件
                "attachment; filename=" + attachment.getName());
        response.setContentType("application/octet-stream");

        ServletOutputStream stream = response.getOutputStream();
        stream.write(attachment.getContents());//如果是下载大文件，则不应该将数据存在内存中，而是应该经常刷新ResponseOutputStream，这样数据才会不断的发送到浏览器

    }

    /**
     * 根据ticketID显示查找对应的ticket并显示
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void viewTicket(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ticketId = request.getParameter("ticketId");
        Ticket ticket = this.getTicket(ticketId, response);
        if (null == ticket) {
            return;
        }
        PrintWriter writer = this.writerHeader(response);

        writer.append("<h2>Ticket #").append(ticketId)
                .append(": ").append(ticket.getSubject()).append("</h2>\r\n");
        writer.append("<i>Customer Name - ").append(ticket.getCustomerName())
                .append("</i><br/><br/>\r\n");
        writer.append(ticket.getBody()).append("<br/><br/>\r\n");
        if (ticket.getAttachments().size() > 0) {
            int i = 0;
            for (Attachment attachment : ticket.getAttachments().values()) {
                if (i++ > 0) {
                    writer.append(", ");
                }
                writer.append("<a href=\"tickets?action=download&ticketId=")
                        .append(ticketId).append("&attachment=")
                        .append(attachment.getName()).append("\">")
                        .append(attachment.getName()).append("</a>");
            }
            writer.append("<br/><br/>\r\n");
        }
        writer.append("<a href=\"tickets\">Return to list tickets</a>\r\n");

        this.writerFooter(writer);
    }

    /**
     * 根据key值从tikcetDB中获取ticket
     *
     * @param idString
     * @param response
     * @return
     * @throws IOException
     */
    public Ticket getTicket(String idString, HttpServletResponse response) throws IOException {
        if (null == idString && idString.length() == 0) {
            response.sendRedirect("tickets");
            return null;
        }
        try {
            Ticket ticket = this.ticketDB.get(Integer.parseInt(idString));
            if (null == ticket) {
                response.sendRedirect("tickets");
                return null;
            }
            return ticket;
        } catch (Exception e) {
            response.sendRedirect("tickets");
            return null;
        }
    }

    /**
     * 创建ticket并转发到ticket页面
     *
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    private void createTicket(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Ticket ticket = new Ticket();
        ticket.setCustomerName(request.getParameter("customerName"));
        ticket.setSubject(request.getParameter("subject"));
        ticket.setBody(request.getParameter("body"));

        Part filePart = request.getPart("file1");
        //如果filePart不为空，就向ticket中添加attachment
        if (null != filePart && filePart.getSize() > 0) {
            Attachment attachment = this.getAttachment(filePart);
            if (null != attachment) {
                ticket.getAttachments().put(attachment.getName(), attachment);
            }
        }
        int id;

        synchronized (this) {//这两个都是servlet的实例变量，这意味着多个线程可以同时访问他们，将这些操作添加到同步代码块中，可以保证其他线程无法同时执行这两行代码
            id = this.TICKET_ID_SEQUENCE++;
            this.ticketDB.put(id, ticket);
        }
        //转发到ticket页面
        response.sendRedirect("tickets?action=view&ticketId=" + id);
    }

    /**
     * 通过filePart来获取attachment
     *
     * @param filePart
     * @return
     * @throws IOException
     */
    private Attachment getAttachment(Part filePart) throws IOException {
        InputStream inputStream = filePart.getInputStream();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        int read;
        byte[] bytes = new byte[1024];
        while ((read = inputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, read);
        }
        Attachment attachment = new Attachment();
        attachment.setName(filePart.getSubmittedFileName());//获取文件上传之前的原始名称
        attachment.setContents(outputStream.toByteArray());
        return attachment;
    }

    /**
     * 创建ticket时显示此表单，让客户填写相关信息
     *
     * @param response
     * @throws IOException
     */
    public void showTicketForm(HttpServletResponse response) throws IOException {
        PrintWriter writer = this.writerHeader(response);
        writer.append("<h2>Create a Ticket</h2>\r\n");
        writer.append("<form method=\"POST\" action=\"tickets\" ")
                .append("enctype=\"multipart/form-data\">\r\n");
        writer.append("<input type=\"hidden\" name=\"action\" ")
                .append("value=\"create\"/>\r\n");
        writer.append("Your Name<br/>\r\n");
        writer.append("<input type=\"text\" name=\"customerName\"/><br/><br/>\r\n");
        writer.append("Subject<br/>\r\n");
        writer.append("<input type=\"text\" name=\"subject\"/><br/><br/>\r\n");
        writer.append("Body<br/>\r\n");
        writer.append("<textarea name=\"body\" rows=\"5\" cols=\"30\">")
                .append("</textarea><br/><br/>\r\n");
        writer.append("<b>Attachments</b><br/>\r\n");
        writer.append("<input type=\"file\" name=\"file1\"/><br/><br/>\r\n");
        writer.append("<input type=\"submit\" value=\"Submit\"/>\r\n");
        writer.append("</form>\r\n");
        this.writerFooter(writer);
    }

    /**
     * 显示ticket列表，如果没有显示提示信息
     *
     * @param response
     * @throws IOException
     */
    public void showTicketList(HttpServletResponse response) throws IOException {
        PrintWriter writer = this.writerHeader(response);
        writer.append("<h2>Tickets</h2>")
                .append("<a href=\"tickets?action=create\">Create Ticket</a><br/>");//可点击执行创建ticket操作
        if (this.ticketDB.size() == 0) {
            writer.append("<i>There are no tickets in the system.</i>\r\n");
        } else {
            for (int id : this.ticketDB.keySet()) {
                Ticket ticket = this.ticketDB.get(id);
                String idStr = Integer.toString(id);
                writer.append("Ticket #").append(idStr)
                        .append(": <a href=\"tickets?action=view&ticketId=")
                        .append(idStr).append("\">").append(ticket.getSubject())
                        .append("</a> (customer: ").append(ticket.getCustomerName())
                        .append(")<br/>");
            }
        }
        this.writerFooter(writer);
    }

    /**
     * html头部标签
     *
     * @param response
     * @throws IOException
     */
    private PrintWriter writerHeader(HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();
        writer.append("<!DOCTYPE html>")
                .append("<html><head>")
                .append("<title>测试</title>")
                .append("</head>")
                .append("<body>");
        return writer;
    }

    /**
     * html底部标签
     *
     * @param writer
     */
    private void writerFooter(PrintWriter writer) {
        writer.append("</body>")
                .append("</html>");
    }
}
