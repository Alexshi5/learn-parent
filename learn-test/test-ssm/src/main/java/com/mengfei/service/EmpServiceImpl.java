package com.mengfei.service;

import com.mengfei.mapper.EmpMapper;
import com.mengfei.pojo.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author Alex
 * date 2018/4/22
 * description
 */
@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<Emp> getEmps(String[] empnos) {
        for (String s : empnos) {
            System.out.println(s);
        }
        Emp emp = new Emp();
        emp.setEmpnoStr(empnos);
        List<Emp> emps = empMapper.getEmps(emp);
        return emps;
    }
}
