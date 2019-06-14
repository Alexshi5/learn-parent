package com.mengfei.security.service.impl;

import com.mengfei.security.ReturnMessage;
import com.mengfei.security.pojo.Rolestore;
import com.mengfei.security.repository.RolestoreRepository;
import com.mengfei.security.service.RolestoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;

@Service
public class RolestoreServiceImpl implements RolestoreService {
	private static final Logger log = LoggerFactory.getLogger(RolestoreServiceImpl.class);
	@Autowired
	private RolestoreRepository rolestoreRepository;

	//region 根据自增长IDid查找记录
	/**
	*根据自增长IDid查找记录
	*@param id 
	*@return 
	**/
	@Override
	public ReturnMessage<Rolestore> findById(long id){
		Rolestore model= rolestoreRepository.findTop1ById(id);
		if(model==null){
			return new ReturnMessage<Rolestore>(true,"99","信息错误");
		}
		return new ReturnMessage<Rolestore>("00","获取成功",model);
	}
	//endregion

	//region 根据角色IDroleid查找记录
	/**
	*根据角色IDroleid查找记录
	*@param roleid 
	*@return 
	**/
	@Override
	public ReturnMessage<Rolestore> findByRoleid(long roleid){
		Rolestore model= rolestoreRepository.findTop1ByRoleid(roleid);
		if(model==null){
			return new ReturnMessage<Rolestore>(true,"99","信息错误");
		}
		return new ReturnMessage<Rolestore>("00","获取成功",model);
	}
	//endregion

	//region 根据店铺ID-暂用发布方IDhostshopid查找记录
	/**
	*根据店铺ID-暂用发布方IDhostshopid查找记录
	*@param hostshopid 
	*@return 
	**/
	@Override
	public ReturnMessage<Rolestore> findByHostshopid(long hostshopid){
		List<Rolestore> model= rolestoreRepository.findByHostshopid(hostshopid);
		if(model==null){
			return new ReturnMessage<Rolestore>(true,"99","信息错误");
		}
		return new ReturnMessage<Rolestore>("00","获取成功",model);
	}
	//endregion

	//region 根据操作时间datetime查找记录
	/**
	*根据操作时间datetime查找记录
	*@param datetime 
	*@return 
	**/
	@Override
	public ReturnMessage<Rolestore> findByDatetime(Timestamp datetime){
		Rolestore model= rolestoreRepository.findTop1ByDatetime(datetime);
		if(model==null){
			return new ReturnMessage<Rolestore>(true,"99","信息错误");
		}
		return new ReturnMessage<Rolestore>("00","获取成功",model);
	}
	//endregion


	//region 自定义插入记录
	/**
	*自定义插入记录
	*@param roleid 角色ID 
	*@param hostshopid 店铺ID-暂用发布方ID 
	*@param datetime 操作时间 
	*@return 插入成功返回1 失败返回0 
	**/
	@Override
	@Transactional(value = "transactionManagerReport",rollbackFor = Exception.class)
	public ReturnMessage insert(long roleid,long hostshopid,Timestamp datetime){
		int rows= rolestoreRepository.insert(roleid,hostshopid,datetime);
		if(rows<=0){
			return new ReturnMessage(true,"99","保存错误");
		}
		return new ReturnMessage();
	}
	//endregion


	//region 自定义更新记录
	/**
	*自定义更新记录
	*@param roleid 角色ID 
	*@param hostshopid 店铺ID-暂用发布方ID 
	*@param datetime 操作时间 
	*@return 更新成功返回1 失败返回0 
	**/
	@Override
	@Transactional(value = "transactionManagerReport",rollbackFor = Exception.class)
	public ReturnMessage update(long roleid,long hostshopid,Timestamp datetime,long id){
		int rows= rolestoreRepository.update(roleid,hostshopid,datetime,id);
		if(rows<=0){
			return new ReturnMessage(true,"99","保存错误");
		}
		return new ReturnMessage();
	}
	//endregion
}
