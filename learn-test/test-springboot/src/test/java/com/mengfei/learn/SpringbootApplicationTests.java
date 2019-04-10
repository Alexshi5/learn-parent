package com.mengfei.learn;

import com.mengfei.learn.mapper.demo.UserMapper;
import com.mengfei.learn.mapper.demo2.UserInfoRepository;
import com.mengfei.learn.pojo.demo.UserBase;
import com.mengfei.learn.rabbitmq.MQSender;
import com.mengfei.learn.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

//使用指明的类来进行单元测试
@RunWith(SpringRunner.class)
//用于SpringBoot应用测试，默认根据包名逐级往上查找直到找到@SpringBootApplication
@SpringBootTest
public class SpringbootApplicationTests {
	@Autowired
	private UserMapper userMapper;

	@Autowired
	private UserInfoRepository userInfoRepository;

	@Autowired
	private UserService userService;

	@Autowired
	private RedisTemplate redisTemplate;

	@Autowired
	private StringRedisTemplate stringRedisTemplate;

	@Autowired
	private MQSender mqSender;

	@Test
	public void contextLoads() throws Exception{
		Assert.assertEquals("张三","张三");
	}

	//测试数据库连接，并添加数据
	@Test
	public void saveUser() throws Exception{
		/*UserBase user = new UserBase("cesi001","001","136001",new Date(),1);
		UserBase save = userMapper.save(user);
		System.out.println(save);

		UserInfo userInfo = new UserInfo(1L,"这是用户cesi001的详细描述",new Date(),1);
		UserInfo save1 = userInfoRepository.save(userInfo);
		System.out.println(save1);*/
	}


	//测试连接redis
	@Test
	public void testRedis(){
		/*ValueOperations<String, String> valueOperations = stringRedisTemplate.opsForValue();
		valueOperations.set("a","10");

		Assert.assertEquals("10",valueOperations.get("a"));*/
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

	//自定义简单查询
	@Test
	public void simpleQueryTest(){
		UserBase cesi001 = userMapper.getUserBaseByUserBasename("cesi001");
		System.out.println(cesi001);

		/*Optional<UserBase> byId = userMapper.findById(1L);
		System.out.println(byId);*/
	}

	/**
	 * 测试自定义事务
	 */
	@Test
	public void transactionTest(){
		//多个数据源先抓异常再向外抛
		/*try {
			UserBase userBase = new UserBase("cesi002","002","136002",new Date(),1);
			UserInfo userInfo = new UserInfo(1L,"这是用户cesi001的详细描述",new Date(),1);

			String save = userService.save(userBase,userInfo);
			System.out.println(save);
		}catch (CustomException cus){
			System.out.println(cus.getMessage());
		}*/

		//多个数据源直接向外抛异常
		/*try {
			UserBase userBase = new UserBase("cesi002","002","136002",new Date(),1);
			UserInfo userInfo = new UserInfo(1L,"这是用户cesi001的详细描述",new Date(),1);

			String save = userService.save2(userBase,userInfo);
			System.out.println(save);
		}catch (Exception e){
			System.out.println(e);
		}*/

		//单个数据源直接向外抛异常
		/*try {
			UserBase userBase = new UserBase("cesi002","002","136002",new Date(),1);

			String save = userService.save3(userBase);
			System.out.println(save);
		}catch (Exception e){
			System.out.println(e);
		}*/

		//单个数据源直接向外抛异常，方法体中调用了其他的方法
		try {
			UserBase userBase = new UserBase("cesi002","002","136002",new Date(),1);

			String save = userService.save4(userBase);
			System.out.println(save);
		}catch (Exception e){
			System.out.println(e);
		}
	}

	/**
	 * 测试rabbitmq，发送并接收队列消息
	 */
	/*@Test
	public void rabbitmqTest(){
		this.mqSender.send();
	}*/
}
