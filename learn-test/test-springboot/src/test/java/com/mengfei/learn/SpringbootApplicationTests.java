package com.mengfei.learn;

import com.mengfei.learn.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//使用指明的类来进行单元测试
@RunWith(SpringRunner.class)
//用于SpringBoot应用测试，默认根据包名逐级往上查找直到找到@SpringBootApplication
@SpringBootTest
public class SpringbootApplicationTests {
	@Autowired
	private UserMapper userMapper;

	@Test
	public void contextLoads() throws Exception{
		Assert.assertEquals("张三","张三");
	}

	/*@Test
	public void saveUser() throws Exception{
		User user = new User("lisi001","001","136001",new Date(),1);
		userMapper.save(user);
	}*/

}
