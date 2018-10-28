package f1.chapter5.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * author Alex
 * date 2018/10/27
 * description 在servlet中创建一个简单的map，用于表示产品数据库
 */
@WebServlet(
        name = "storeServlet",
        urlPatterns = "/shop"
)
public class StoreServlet extends HttpServlet {

    private final Map<Integer,String> products = new HashMap<>();

    public StoreServlet(){
        products.put(1,"桌子");
        products.put(2,"椅子");
        products.put(3,"床");
        products.put(4,"电视");
        products.put(5,"洗衣机");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(null == action){
            action = "browse";
        }
        switch (action){
            case "clearCart":
                clearCart(request,response);
                break;
            case "addToCart":
                addToCart(request,response);
                break;
            case "showCart":
                showCart(request,response);
                break;
            case "browse":
            default:
                browse(request,response);
                break;
        }
    }

    private void clearCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().removeAttribute("cart");
        response.sendRedirect("shop?action=showCart");
    }

    private void showCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("products",products);
        request.getRequestDispatcher("/WEB-INF/jsp/showCart.jsp").forward(request,response);
    }

    private void browse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("products",products);
        request.getRequestDispatcher("/WEB-INF/jsp/browse.jsp").forward(request,response);
    }

    private void addToCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId;
        try {
            productId  = Integer.parseInt(request.getParameter("productId"));
        }catch (Exception e){
            e.printStackTrace();
            response.sendRedirect("shop");
            return;
        }

        HttpSession session = request.getSession();
        if(null == session.getAttribute("cart")){
            session.setAttribute("cart",new Hashtable<Integer,Integer>());
        }

        Map<Integer,Integer> cart = (Map<Integer,Integer>)session.getAttribute("cart");
        if(cart.containsKey(productId)){
            cart.put(productId,cart.get(productId)+1);
        }else {
            cart.put(productId,1);
        }

        response.sendRedirect("shop?action=showCart");
    }
}
