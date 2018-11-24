package com.mengfei.util;


import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Map;

/**
* 工具类：实现根据freemarker生成的word文档的上传与下载
* @author Alex
* @since  Sample1.0  
*/  
public class WordUtil {

    /**
     * 根据freemarker生成word文档并存到指定目录
     * @param wordFilePath word文件生成的目录
     * @param wordFileName word文件名
     * @param templatePath 模板文件所在的目录
     * @param templateFileName 模板文件名
     * @param beanParams 生成word文件所需要的模板数据
     * @return
     */
    public static Boolean writeWordReport(String wordFilePath,String wordFileName,String templatePath,String templateFileName, Map<String, Object> beanParams) {
        Configuration config = new Configuration();
        Writer out = null;
        try {
            config.setDirectoryForTemplateLoading(new File(templatePath));
            config.setObjectWrapper(new DefaultObjectWrapper());
            Template template = config.getTemplate(templateFileName, "UTF-8");

            //获取文件目录，如果不存在则创建
            String filePath = "";
            int index = wordFilePath.lastIndexOf(File.separator);
            if(index != wordFilePath.length()-1){
                filePath = wordFilePath+ File.separator;
            }
            File file1 = new File(filePath);
            if(!file1.exists()){
                file1.mkdirs();
            }

            //输出文件
            File file = new File(filePath+wordFileName);
            FileOutputStream fos = new FileOutputStream(file);
            out = new OutputStreamWriter(fos, "UTF-8");
            template.process(beanParams, out);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally{
            try {
                if(out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 从指定目录下载word文件的方法
     * @param wordFilePath word文档所在的目录
     * @param wordFileName word文档名
     * @param response 响应对象
     * @return
     */
    public static boolean downloadWordReport(String wordFilePath,String wordFileName,HttpServletResponse response){
        //获取文件目录
        String filePath = "";
        int index = wordFilePath.lastIndexOf(File.separator);
        if(index != wordFilePath.length()-1){
            filePath = wordFilePath+ File.separator;
        }
        File file = new File(filePath+wordFileName);
        InputStream fis = null;
        OutputStream out = null;
        try {
            // 转码之后下载的文件不会出现中文乱码
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(wordFileName.getBytes("gbk"), "iso-8859-1"));
            response.addHeader("Content-Length", "" + file.length());

            //读取文件
            fis = new BufferedInputStream(new FileInputStream(file));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);

            //输出文件
            out = new BufferedOutputStream(response.getOutputStream());
            out.write(buffer);

            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }finally {
            try {
                if(null != fis){
                    fis.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }

            try {
                if(null != out){
                    out.close();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}  
