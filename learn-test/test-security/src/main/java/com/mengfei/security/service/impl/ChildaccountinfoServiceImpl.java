package com.mengfei.security.service.impl;

import com.mengfei.security.ReturnMessage;
import com.mengfei.security.pojo.Childaccountinfo;
import com.mengfei.security.repository.ChildaccountinfoRepository;
import com.mengfei.security.service.ChildaccountinfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@Service
public class ChildaccountinfoServiceImpl implements ChildaccountinfoService {
	private static final Logger log = LoggerFactory.getLogger(ChildaccountinfoServiceImpl.class);
	@Autowired
	private ChildaccountinfoRepository childaccountinfoRepository;

	//region 根据自增长IDid查找记录
	/**
	*根据自增长IDid查找记录
	*@param id 
	*@return 
	**/
	@Override
	public ReturnMessage<Childaccountinfo> findById(long id){
		Childaccountinfo model= childaccountinfoRepository.findTop1ById(id);
		if(model==null){
			return new ReturnMessage<Childaccountinfo>(true,"99","信息错误");
		}
		return new ReturnMessage<Childaccountinfo>("00","获取成功",model);
	}
	//endregion

	//region 根据发布方IDhostid查找记录
	/**
	*根据发布方IDhostid查找记录
	*@param hostid 
	*@return 
	**/
	@Override
	public ReturnMessage<Childaccountinfo> findByHostid(long hostid){
		Childaccountinfo model= childaccountinfoRepository.findTop1ByHostid(hostid);
		if(model==null){
			return new ReturnMessage<Childaccountinfo>(true,"99","信息错误");
		}
		return new ReturnMessage<Childaccountinfo>("00","获取成功",model);
	}
	//endregion

	//region 根据店铺ID-暂用发布方IDhostshopid查找记录
	/**
	*根据店铺ID-暂用发布方IDhostshopid查找记录
	*@param hostshopid 
	*@return 
	**/
	@Override
	public ReturnMessage<Childaccountinfo> findByHostshopid(long hostshopid){
		Childaccountinfo model= childaccountinfoRepository.findTop1ByHostshopid(hostshopid);
		if(model==null){
			return new ReturnMessage<Childaccountinfo>(true,"99","信息错误");
		}
		return new ReturnMessage<Childaccountinfo>("00","获取成功",model);
	}
	//endregion

	//region 根据时间datetime查找记录
	/**
	*根据时间datetime查找记录
	*@param datetime 
	*@return 
	**/
	@Override
	public ReturnMessage<Childaccountinfo> findByDatetime(Timestamp datetime){
		Childaccountinfo model= childaccountinfoRepository.findTop1ByDatetime(datetime);
		if(model==null){
			return new ReturnMessage<Childaccountinfo>(true,"99","信息错误");
		}
		return new ReturnMessage<Childaccountinfo>("00","获取成功",model);
	}
	//endregion


	//region 自定义插入记录
	/**
	*自定义插入记录
	*@param hostid 发布方ID 
	*@param hostshopid 店铺ID-暂用发布方ID 
	*@param datetime 时间 
	*@return 插入成功返回1 失败返回0 
	**/
	@Override
	@Transactional(value = "transactionManagerReport",rollbackFor = Exception.class)
	public ReturnMessage insert(long hostid,long hostshopid,Timestamp datetime){
		int rows= childaccountinfoRepository.insert(hostid,hostshopid,datetime);
		if(rows<=0){
			return new ReturnMessage(true,"99","保存错误");
		}
		return new ReturnMessage();
	}
	//endregion


	//region 自定义更新记录
	/**
	*自定义更新记录
	*@param hostid 发布方ID 
	*@param hostshopid 店铺ID-暂用发布方ID 
	*@param datetime 时间 
	*@return 更新成功返回1 失败返回0 
	**/
	@Override
	@Transactional(value = "transactionManagerReport",rollbackFor = Exception.class)
	public ReturnMessage update(long hostid,long hostshopid,Timestamp datetime,long id){
		int rows= childaccountinfoRepository.update(hostid,hostshopid,datetime,id);
		if(rows<=0){
			return new ReturnMessage(true,"99","保存错误");
		}
		return new ReturnMessage();
	}
	//endregion


}
