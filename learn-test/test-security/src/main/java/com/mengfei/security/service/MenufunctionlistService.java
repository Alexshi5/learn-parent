package com.mengfei.security.service;

import com.mengfei.security.ReturnMessage;
import com.mengfei.security.pojo.Menufunctionlist;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
@Service
public interface MenufunctionlistService{
	//region 根据序号id查找记录
	/**
	*根据序号id查找记录
	*@param id 
	*@return 
	**/
	ReturnMessage<Menufunctionlist> findById(long id);
	//endregion

	//region 根据菜单IDmenuid查找记录
	/**
	*根据菜单IDmenuid查找记录
	*@param menuid 
	*@return 
	**/
	ReturnMessage<Menufunctionlist> findByMenuid(long menuid);
	//endregion

	//region 根据功能编号funcno查找记录
	/**
	*根据功能编号funcno查找记录
	*@param funcno 
	*@return 
	**/
	ReturnMessage<Menufunctionlist> findByFuncno(String funcno);
	//endregion

	//region 根据功能名称funcname查找记录
	/**
	*根据功能名称funcname查找记录
	*@param funcname 
	*@return 
	**/
	ReturnMessage<Menufunctionlist> findByFuncname(String funcname);
	//endregion

	//region 根据功能url地址funcurl查找记录
	/**
	*根据功能url地址funcurl查找记录
	*@param funcurl 
	*@return 
	**/
	ReturnMessage<Menufunctionlist> findByFuncurl(String funcurl);
	//endregion

	//region 根据操作时间datetime查找记录
	/**
	*根据操作时间datetime查找记录
	*@param datetime 
	*@return 
	**/
	ReturnMessage<Menufunctionlist> findByDatetime(Timestamp datetime);
	//endregion


	//region 自定义插入记录
	/**
	*自定义插入记录
	*@param menuid 菜单ID 
	*@param funcno 功能编号 
	*@param funcname 功能名称 
	*@param funcurl 功能url地址 
	*@param datetime 操作时间 
	*@return 插入成功返回1 失败返回0 
	**/
	ReturnMessage insert(long menuid, String funcno, String funcname, String funcurl, Timestamp datetime);
	//endregion


	//region 自定义更新记录
	/**
	*自定义更新记录
	*@param menuid 菜单ID 
	*@param funcno 功能编号 
	*@param funcname 功能名称 
	*@param funcurl 功能url地址 
	*@param datetime 操作时间 
	*@return 更新成功返回1 失败返回0 
	**/
	ReturnMessage update(long menuid, String funcno, String funcname, String funcurl, Timestamp datetime, long id);
	//endregion
}
