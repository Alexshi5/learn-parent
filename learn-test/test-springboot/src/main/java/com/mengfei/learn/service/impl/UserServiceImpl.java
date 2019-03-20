package com.mengfei.learn.service.impl;

import com.mengfei.learn.mapper.demo.UserMapper;
import com.mengfei.learn.mapper.demo2.UserInfoRepository;
import com.mengfei.learn.pojo.demo.UserBase;
import com.mengfei.learn.pojo.demo2.UserInfo;
import com.mengfei.learn.service.UserService;
import com.mengfei.learn.util.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserInfoRepository userInfoRepository;

    @Override
    @Transactional(value = "jtaTransactionManager",rollbackFor = CustomException.class)
    public String save(UserBase userBase, UserInfo userInfo) throws CustomException{
        UserBase save = new UserBase();
        UserInfo save1 = new UserInfo();
        try {
            save = userMapper.save(userBase);
            //int i = 10/0;
        }catch (Exception e){
            throw new CustomException(e.getMessage());
        }

        try {
            save1 = userInfoRepository.save(userInfo);
            int i = 10/0;
        }catch (Exception e){
            throw new CustomException(e.getMessage());
        }

        if(null != save && null != save1){
            return save + "==" + save1;
        }else {
            return save.toString() + "==" + save1.toString();
        }
    }

    @Override
    @Transactional(value = "demoTransactionManager",rollbackFor = Exception.class)
    public String save2(UserBase userBase, UserInfo userInfo) throws Exception{
        UserBase save = new UserBase();
        save = userMapper.save(userBase);

        UserInfo save1 = new UserInfo();


        save1 = userInfoRepository.save(userInfo);
        int i = 10/0;

        if(null != save && null != save1){
            return save + "==" + save1;
        }else {
            return save.toString() + "==" + save1.toString();
        }
    }
}
