package com.mengfei.security.service;

import com.mengfei.security.ReturnMessage;
import com.mengfei.security.pojo.Hostinfo;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
@Service
public interface HostinfoService{
	//region 根据自增IDid查找记录
	/**
	*根据自增IDid查找记录
	*@param id 
	*@return 
	**/
	ReturnMessage<Hostinfo> findById(long id);
	//endregion

	//region 根据登录名loginname查找记录
	/**
	*根据登录名loginname查找记录
	*@param loginname 
	*@return 
	**/
	ReturnMessage<Hostinfo> findByLoginname(String loginname);
	//endregion

	//region 根据登录密码password查找记录
	/**
	*根据登录密码password查找记录
	*@param password 
	*@return 
	**/
	ReturnMessage<Hostinfo> findByPassword(String password);
	//endregion

	//region 根据操作时间datetime查找记录
	/**
	*根据操作时间datetime查找记录
	*@param datetime 
	*@return 
	**/
	ReturnMessage<Hostinfo> findByDatetime(Timestamp datetime);
	//endregion


	//region 自定义插入记录
	/**
	*自定义插入记录
	*@param loginname 登录名 
	*@param password 登录密码 
	*@param datetime 操作时间 
	*@return 插入成功返回1 失败返回0 
	**/
	ReturnMessage insert(String loginname, String password, Timestamp datetime);
	//endregion


	//region 自定义更新记录
	/**
	*自定义更新记录
	*@param loginname 登录名 
	*@param password 登录密码 
	*@param datetime 操作时间 
	*@return 更新成功返回1 失败返回0 
	**/
	ReturnMessage update(String loginname, String password, Timestamp datetime, long id);
	//endregion

}
