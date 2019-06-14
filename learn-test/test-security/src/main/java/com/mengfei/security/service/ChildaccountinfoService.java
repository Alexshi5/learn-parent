package com.mengfei.security.service;

import com.mengfei.security.ReturnMessage;
import com.mengfei.security.pojo.Childaccountinfo;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public interface ChildaccountinfoService{
	//region 根据自增长IDid查找记录
	/**
	*根据自增长IDid查找记录
	*@param id 
	*@return 
	**/
	ReturnMessage<Childaccountinfo> findById(long id);
	//endregion

	//region 根据发布方IDhostid查找记录
	/**
	*根据发布方IDhostid查找记录
	*@param hostid 
	*@return 
	**/
	ReturnMessage<Childaccountinfo> findByHostid(long hostid);
	//endregion

	//region 根据店铺ID-暂用发布方IDhostshopid查找记录
	/**
	*根据店铺ID-暂用发布方IDhostshopid查找记录
	*@param hostshopid 
	*@return 
	**/
	ReturnMessage<Childaccountinfo> findByHostshopid(long hostshopid);
	//endregion

	//region 根据时间datetime查找记录
	/**
	*根据时间datetime查找记录
	*@param datetime 
	*@return 
	**/
	ReturnMessage<Childaccountinfo> findByDatetime(Timestamp datetime);
	//endregion


	//region 自定义插入记录
	/**
	*自定义插入记录
	*@param hostid 发布方ID 
	*@param hostshopid 店铺ID-暂用发布方ID 
	*@param datetime 时间 
	*@return 插入成功返回1 失败返回0 
	**/
	ReturnMessage insert(long hostid, long hostshopid, Timestamp datetime);
	//endregion


	//region 自定义更新记录
	/**
	*自定义更新记录
	*@param hostid 发布方ID 
	*@param hostshopid 店铺ID-暂用发布方ID 
	*@param datetime 时间 
	*@return 更新成功返回1 失败返回0 
	**/
	ReturnMessage update(long hostid, long hostshopid, Timestamp datetime, long id);
	//endregion
}
