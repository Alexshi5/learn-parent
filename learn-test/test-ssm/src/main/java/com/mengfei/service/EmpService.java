package com.mengfei.service;

import com.mengfei.pojo.Emp;

import java.util.List;

/**
 * author Alex
 * date 2018/4/22
 * description
 */
public interface EmpService {
    List<Emp> getEmps(String[] empno);
}
