package com.mengfei.controller;

import com.mengfei.pojo.Person;
import com.mengfei.util.WordUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author Alex
 * date 2018/11/24
 * description 一个用于演示使用的Controller
 */
@Controller
@RequestMapping("/demo")
public class DemoController {

    @RequestMapping("/word")
    @ResponseBody
    public String generateWord(String imgData){
        // 传递过程中  "+" 变为了 " " ，所以需要替换
        String newImageInfo = imgData.replaceAll(" ", "+");
        // 数据中：data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAABI4AAAEsCAYAAAClh/jbAAA ...
        // 在"base64,"之后的才是图片信息
        String[] arr = newImageInfo.split("base64,");

        //添加模板数据
        Map<String,Object> dataMap = new HashMap<>();
        dataMap.put("userName","张三");
        dataMap.put("imgData",arr[1]);

        Person person1 = new Person("李四", "男", 36, "18811240001");
        Person person2 = new Person("王五", "女", 22, "18811240002");
        Person person3 = new Person("赵六", "男", 46, "18811240003");
        List<Person> personList = new ArrayList<>();
        personList.add(person1);
        personList.add(person2);
        personList.add(person3);
        dataMap.put("personList",personList);

        //文件生成路径
        String wordFilePath = "E:\\ftl";
        //文件生成名称
        String wordFileName = "演示文档.doc";
        //模板路径
        String templatePath = "E:\\ftl";
        //模板文件名称
        String templateFileName = "demo.ftl";

        //生成word文档
        Boolean result = WordUtil.writeWordReport(wordFilePath, wordFileName, templatePath, templateFileName, dataMap);
        if(result){
            return "success";
        }else {
            return "error";
        }
    }
}
