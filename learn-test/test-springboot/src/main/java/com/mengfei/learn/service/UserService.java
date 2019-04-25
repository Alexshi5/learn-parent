package com.mengfei.learn.service;

import com.mengfei.learn.pojo.demo.UserBase;
import com.mengfei.learn.pojo.demo2.UserInfo;
import com.mengfei.learn.util.CustomException;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    String save(UserBase userBase, UserInfo userInfo) throws CustomException;

    String save2(UserBase userBase, UserInfo userInfo) throws Exception;

    String save3(UserBase userBase) throws CustomException;

    String save4(UserBase userBase) throws CustomException;

    Integer save5(UserInfo userInfo) throws CustomException;

    void save6(UserInfo userInfo) throws CustomException;
}
