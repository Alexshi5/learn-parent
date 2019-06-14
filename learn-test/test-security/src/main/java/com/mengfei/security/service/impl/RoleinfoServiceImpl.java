package com.mengfei.security.service.impl;

import com.mengfei.security.ReturnMessage;
import com.mengfei.security.pojo.Roleinfo;
import com.mengfei.security.repository.RoleinfoRepository;
import com.mengfei.security.service.RoleinfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@Service
public class RoleinfoServiceImpl implements RoleinfoService {
	private static final Logger log = LoggerFactory.getLogger(RoleinfoServiceImpl.class);
	@Autowired
	private RoleinfoRepository roleinfoRepository;

	//region 根据自增长IDid查找记录
	/**
	*根据自增长IDid查找记录
	*@param id 
	*@return 
	**/
	@Override
	public ReturnMessage<Roleinfo> findById(long id){
		Roleinfo model= roleinfoRepository.findTop1ById(id);
		if(model==null){
			return new ReturnMessage<Roleinfo>(true,"99","信息错误");
		}
		return new ReturnMessage<Roleinfo>("00","获取成功",model);
	}
	//endregion

	//region 根据角色名称rolename查找记录
	/**
	*根据角色名称rolename查找记录
	*@param rolename 
	*@return 
	**/
	@Override
	public ReturnMessage<Roleinfo> findByRolename(String rolename){
		Roleinfo model= roleinfoRepository.findTop1ByRolename(rolename);
		if(model==null){
			return new ReturnMessage<Roleinfo>(true,"99","信息错误");
		}
		return new ReturnMessage<Roleinfo>("00","获取成功",model);
	}
	//endregion

	//region 根据角色描述desp查找记录
	/**
	*根据角色描述desp查找记录
	*@param desp 
	*@return 
	**/
	@Override
	public ReturnMessage<Roleinfo> findByDesp(String desp){
		Roleinfo model= roleinfoRepository.findTop1ByDesp(desp);
		if(model==null){
			return new ReturnMessage<Roleinfo>(true,"99","信息错误");
		}
		return new ReturnMessage<Roleinfo>("00","获取成功",model);
	}
	//endregion

	//region 根据操作时间datetime查找记录
	/**
	*根据操作时间datetime查找记录
	*@param datetime 
	*@return 
	**/
	@Override
	public ReturnMessage<Roleinfo> findByDatetime(Timestamp datetime){
		Roleinfo model= roleinfoRepository.findTop1ByDatetime(datetime);
		if(model==null){
			return new ReturnMessage<Roleinfo>(true,"99","信息错误");
		}
		return new ReturnMessage<Roleinfo>("00","获取成功",model);
	}
	//endregion


	//region 自定义插入记录
	/**
	*自定义插入记录
	*@param rolename 角色名称 
	*@param desp 角色描述 
	*@param datetime 操作时间 
	*@return 插入成功返回1 失败返回0 
	**/
	@Override
	@Transactional(value = "transactionManagerReport",rollbackFor = Exception.class)
	public ReturnMessage insert(String rolename,String desp,Timestamp datetime){
		int rows= roleinfoRepository.insert(rolename,desp,datetime);
		if(rows<=0){
			return new ReturnMessage(true,"99","保存错误");
		}
		return new ReturnMessage();
	}
	//endregion

}
