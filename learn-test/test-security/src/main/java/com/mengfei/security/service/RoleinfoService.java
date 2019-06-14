package com.mengfei.security.service;

import com.mengfei.security.ReturnMessage;
import com.mengfei.security.pojo.Roleinfo;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
@Service
public interface RoleinfoService{
	//region 根据自增长IDid查找记录
	/**
	*根据自增长IDid查找记录
	*@param id 
	*@return 
	**/
	ReturnMessage<Roleinfo> findById(long id);
	//endregion

	//region 根据角色名称rolename查找记录
	/**
	*根据角色名称rolename查找记录
	*@param rolename 
	*@return 
	**/
	ReturnMessage<Roleinfo> findByRolename(String rolename);
	//endregion

	//region 根据角色描述desp查找记录
	/**
	*根据角色描述desp查找记录
	*@param desp 
	*@return 
	**/
	ReturnMessage<Roleinfo> findByDesp(String desp);
	//endregion

	//region 根据操作时间datetime查找记录
	/**
	*根据操作时间datetime查找记录
	*@param datetime 
	*@return 
	**/
	ReturnMessage<Roleinfo> findByDatetime(Timestamp datetime);
	//endregion


	//region 自定义插入记录
	/**
	*自定义插入记录
	*@param rolename 角色名称 
	*@param desp 角色描述 
	*@param datetime 操作时间 
	*@return 插入成功返回1 失败返回0 
	**/
	ReturnMessage insert(String rolename, String desp, Timestamp datetime);
	//endregion

}
