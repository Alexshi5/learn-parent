package com.mengfei.learn.service;

import com.mengfei.learn.pojo.demo.UserBase;
import com.mengfei.learn.pojo.demo2.UserInfo;
import com.mengfei.learn.util.CustomException;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    String save(UserBase userBase, UserInfo userInfo) throws CustomException;
}
