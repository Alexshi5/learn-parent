package com.mengfei.security.service;

import com.mengfei.security.ReturnMessage;
import com.mengfei.security.pojo.Rolestore;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;

@Service
public interface RolestoreService{
	//region 根据自增长IDid查找记录
	/**
	*根据自增长IDid查找记录
	*@param id 
	*@return 
	**/
	ReturnMessage<Rolestore> findById(long id);
	//endregion

	//region 根据角色IDroleid查找记录
	/**
	*根据角色IDroleid查找记录
	*@param roleid 
	*@return 
	**/
	ReturnMessage<Rolestore> findByRoleid(long roleid);
	//endregion

	//region 根据店铺ID-暂用发布方IDhostshopid查找记录
	/**
	*根据店铺ID-暂用发布方IDhostshopid查找记录
	*@param hostshopid 
	*@return 
	**/
	ReturnMessage<Rolestore> findByHostshopid(long hostshopid);
	//endregion

	//region 根据操作时间datetime查找记录
	/**
	*根据操作时间datetime查找记录
	*@param datetime 
	*@return 
	**/
	ReturnMessage<Rolestore> findByDatetime(Timestamp datetime);
	//endregion


	//region 自定义插入记录
	/**
	*自定义插入记录
	*@param roleid 角色ID 
	*@param hostshopid 店铺ID-暂用发布方ID 
	*@param datetime 操作时间 
	*@return 插入成功返回1 失败返回0 
	**/
	ReturnMessage insert(long roleid, long hostshopid, Timestamp datetime);
	//endregion


	//region 自定义更新记录
	/**
	*自定义更新记录
	*@param roleid 角色ID 
	*@param hostshopid 店铺ID-暂用发布方ID 
	*@param datetime 操作时间 
	*@return 更新成功返回1 失败返回0 
	**/
	ReturnMessage update(long roleid, long hostshopid, Timestamp datetime, long id);
	//endregion

}
