package com.mengfei.springboot.springbootdemo1.service;

import com.mengfei.springboot.springbootdemo1.dto.UserBase;
import com.mengfei.springboot.springbootdemo1.repository.UserBaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserBaseServiceImplTest {
    @Autowired
    private UserBaseRepository userBaseRepository;

    @Transactional(rollbackFor = Exception.class)
    public void update1(UserBase base) throws Exception{

        //int j = 10/0;

        UserBase userBase = userBaseRepository.findTopByOid(base.getOid());
        userBase.setPhone(base.getPhone());

        int i = 10/0;
    }
}
