package com.mengfei.learn;

import com.mengfei.learn.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

//使用指明的类来进行单元测试
@RunWith(SpringRunner.class)
//用于SpringBoot应用测试，默认根据包名逐级往上查找直到找到@SpringBootApplication
@SpringBootTest
public class SpringbootApplicationTests {
	@Autowired
	private UserMapper userMapper;

	@Autowired
	private RedisTemplate redisTemplate;

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Test
	public void contextLoads() throws Exception{
		Assert.assertEquals("张三","张三");
	}

	//测试数据库连接
	@Test
	public void saveUser() throws Exception{
		/*UserBase user = new UserBase("cesi001","001","136001",new Date(),1);
		userMapper.save(user);*/

		int size = userMapper.findAll().size();
		boolean b = false;
		if(size > 0){
			b = true;
		}
		Assert.assertEquals("当前数据库用户的数量为：" + size + "个",true,b);
	}

	//测试连接redis
	@Test
	public void testRedis(){
		ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
		valueOperations.set("a","10");

		Assert.assertEquals("10",valueOperations.get("a"));
	}

	//测试在redis中手动添加对象
	/*@Test
	public void testRedisAddUser(){
		UserBase user = new UserBase("cesi002","002","136002",new Date(),1);
		ValueOperations valueOperations = redisTemplate.opsForValue();
		valueOperations.set(user.getUserBasename(),user);

		UserBase user2 = (UserBase)valueOperations.get("cesi002");
		Assert.assertEquals("002",user2.getPassword());
	}*/
}
