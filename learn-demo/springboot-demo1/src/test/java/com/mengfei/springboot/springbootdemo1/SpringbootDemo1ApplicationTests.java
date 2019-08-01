package com.mengfei.springboot.springbootdemo1;

import com.mengfei.springboot.springbootdemo1.dto.UserBase;
import com.mengfei.springboot.springbootdemo1.service.UserBaseServiceImplTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootDemo1ApplicationTests {
    @Autowired
    private UserBaseServiceImplTest userBaseServiceImplTest;

    @Test
    public void contextLoads() {
        try {
            UserBase userBase = new UserBase();
            userBase.setOid(1l);
            userBase.setPhone("111");
            userBaseServiceImplTest.update1(userBase);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
