package com.mengfei.security.service;

import com.mengfei.security.ReturnMessage;
import com.mengfei.security.pojo.Rolepriinfo;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Set;

@Service
public interface RolepriinfoService{
	//region 根据自增长IDid查找记录
	/**
	*根据自增长IDid查找记录
	*@param id 
	*@return 
	**/
	ReturnMessage<Rolepriinfo> findById(long id);
	//endregion

	//region 根据角色IDroleid查找记录
	/**
	*根据角色IDroleid查找记录
	*@param roleid 
	*@return 
	**/
	ReturnMessage<Rolepriinfo> findByRoleid(long roleid);
	//endregion

	//region 根据菜单IDmenuid查找记录
	/**
	*根据菜单IDmenuid查找记录
	*@param menuid 
	*@return 
	**/
	ReturnMessage<Rolepriinfo> findByMenuid(long menuid);
	//endregion

	//region 根据功能IDfuncid查找记录
	/**
	*根据功能IDfuncid查找记录
	*@param funcid 
	*@return 
	**/
	ReturnMessage<Rolepriinfo> findByFuncid(long funcid);
	//endregion

	//region 根据操作时间datetime查找记录
	/**
	*根据操作时间datetime查找记录
	*@param datetime 
	*@return 
	**/
	ReturnMessage<Rolepriinfo> findByDatetime(Timestamp datetime);
	//endregion


	//region 自定义插入记录
	/**
	*自定义插入记录
	*@param roleid 角色ID 
	*@param menuid 菜单ID 
	*@param funcid 功能ID 
	*@param datetime 操作时间 
	*@return 插入成功返回1 失败返回0 
	**/
	ReturnMessage insert(long roleid, long menuid, long funcid, Timestamp datetime);
	//endregion


	//region 自定义更新记录
	/**
	*自定义更新记录
	*@param roleid 角色ID 
	*@param menuid 菜单ID 
	*@param funcid 功能ID 
	*@param datetime 操作时间 
	*@return 更新成功返回1 失败返回0 
	**/
	ReturnMessage update(long roleid, long menuid, long funcid, Timestamp datetime, long id);
	//endregion

	//通过角色集合查询一级菜单
	ReturnMessage<Rolepriinfo> findByRoleIdSet(Set<Long> roleIdSet, long funcid);

	//通过菜单ID集合查询功能列表
	ReturnMessage<Rolepriinfo> findByMenuidInAndFuncidNot(Set<Long> roleIdSet, long funcid);

	//通过角色集合查询所有
	ReturnMessage<Rolepriinfo> findByRoleIdSet(Set<Long> roleIdSet);
}
