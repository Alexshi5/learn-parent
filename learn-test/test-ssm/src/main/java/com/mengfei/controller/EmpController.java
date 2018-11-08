package com.mengfei.controller;

import com.mengfei.pojo.Emp;
import com.mengfei.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * author Alex
 * date 2018/4/22
 * description
 */
@Controller
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    private EmpService empService;

    @RequestMapping("/get")
    public void getEmps(String[] empno) {
        List<Emp> emps = empService.getEmps(empno);
        System.out.println(emps.size());
    }
}
