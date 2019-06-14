package com.mengfei.security.service.impl;

import com.mengfei.security.ReturnMessage;
import com.mengfei.security.pojo.Hostinfo;
import com.mengfei.security.repository.HostinfoRepository;
import com.mengfei.security.service.HostinfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@Service
public class HostinfoServiceImpl implements HostinfoService {
	private static final Logger log = LoggerFactory.getLogger(HostinfoServiceImpl.class);
	@Autowired
	private HostinfoRepository hostinfoRepository;

	//region 根据自增IDid查找记录
	/**
	*根据自增IDid查找记录
	*@param id 
	*@return 
	**/
	@Override
	public ReturnMessage<Hostinfo> findById(long id){
		Hostinfo model= hostinfoRepository.findTop1ById(id);
		if(model==null){
			return new ReturnMessage<Hostinfo>(true,"99","信息错误");
		}
		return new ReturnMessage<Hostinfo>("00","获取成功",model);
	}
	//endregion

	//region 根据登录名loginname查找记录
	/**
	*根据登录名loginname查找记录
	*@param loginname 
	*@return 
	**/
	@Override
	public ReturnMessage<Hostinfo> findByLoginname(String loginname){
		Hostinfo model= hostinfoRepository.findTop1ByLoginname(loginname);
		if(model==null){
			return new ReturnMessage<Hostinfo>(true,"99","信息错误");
		}
		return new ReturnMessage<Hostinfo>("00","获取成功",model);
	}
	//endregion

	//region 根据登录密码password查找记录
	/**
	*根据登录密码password查找记录
	*@param password 
	*@return 
	**/
	@Override
	public ReturnMessage<Hostinfo> findByPassword(String password){
		Hostinfo model= hostinfoRepository.findTop1ByPassword(password);
		if(model==null){
			return new ReturnMessage<Hostinfo>(true,"99","信息错误");
		}
		return new ReturnMessage<Hostinfo>("00","获取成功",model);
	}
	//endregion

	//region 根据操作时间datetime查找记录
	/**
	*根据操作时间datetime查找记录
	*@param datetime 
	*@return 
	**/
	@Override
	public ReturnMessage<Hostinfo> findByDatetime(Timestamp datetime){
		Hostinfo model= hostinfoRepository.findTop1ByDatetime(datetime);
		if(model==null){
			return new ReturnMessage<Hostinfo>(true,"99","信息错误");
		}
		return new ReturnMessage<Hostinfo>("00","获取成功",model);
	}
	//endregion


	//region 自定义插入记录
	/**
	*自定义插入记录
	*@param loginname 登录名 
	*@param password 登录密码 
	*@param datetime 操作时间 
	*@return 插入成功返回1 失败返回0 
	**/
	@Override
	@Transactional(value = "transactionManagerReport",rollbackFor = Exception.class)
	public ReturnMessage insert(String loginname,String password,Timestamp datetime){
		int rows= hostinfoRepository.insert(loginname,password,datetime);
		if(rows<=0){
			return new ReturnMessage(true,"99","保存错误");
		}
		return new ReturnMessage();
	}
	//endregion


	//region 自定义更新记录
	/**
	*自定义更新记录
	*@param loginname 登录名 
	*@param password 登录密码 
	*@param datetime 操作时间 
	*@return 更新成功返回1 失败返回0 
	**/
	@Override
	@Transactional(value = "transactionManagerReport",rollbackFor = Exception.class)
	public ReturnMessage update(String loginname,String password,Timestamp datetime,long id){
		int rows= hostinfoRepository.update(loginname,password,datetime,id);
		if(rows<=0){
			return new ReturnMessage(true,"99","保存错误");
		}
		return new ReturnMessage();
	}
	//endregion

}
