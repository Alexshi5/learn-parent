package com.mengfei.security.service;

import com.mengfei.security.ReturnMessage;
import com.mengfei.security.pojo.Menulist;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
@Service
public interface MenulistService{
	//region 根据序号id查找记录
	/**
	*根据序号id查找记录
	*@param id 
	*@return 
	**/
	ReturnMessage<Menulist> findById(long id);
	//endregion

	//region 根据菜单编号menuno查找记录
	/**
	*根据菜单编号menuno查找记录
	*@param menuno 
	*@return 
	**/
	ReturnMessage<Menulist> findByMenuno(String menuno);
	//endregion

	//region 根据菜单名称menutext查找记录
	/**
	*根据菜单名称menutext查找记录
	*@param menutext 
	*@return 
	**/
	ReturnMessage<Menulist> findByMenutext(String menutext);
	//endregion

	//region 根据上级编号parentno查找记录
	/**
	*根据上级编号parentno查找记录
	*@param parentno 
	*@return 
	**/
	ReturnMessage<Menulist> findByParentno(String parentno);
	//endregion

	//region 根据Url地址menuurl查找记录
	/**
	*根据Url地址menuurl查找记录
	*@param menuurl 
	*@return 
	**/
	ReturnMessage<Menulist> findByMenuurl(String menuurl);
	//endregion

	//region 根据操作时间datetime查找记录
	/**
	*根据操作时间datetime查找记录
	*@param datetime 
	*@return 
	**/
	ReturnMessage<Menulist> findByDatetime(Timestamp datetime);
	//endregion


	//region 自定义插入记录
	/**
	*自定义插入记录
	*@param menuno 菜单编号 
	*@param menutext 菜单名称 
	*@param parentno 上级编号 
	*@param menuurl Url地址 
	*@param datetime 操作时间 
	*@return 插入成功返回1 失败返回0 
	**/
	ReturnMessage insert(String menuno, String menutext, String parentno, String menuurl, Timestamp datetime);
	//endregion


	//region 自定义更新记录
	/**
	*自定义更新记录
	*@param menuno 菜单编号 
	*@param menutext 菜单名称 
	*@param parentno 上级编号 
	*@param menuurl Url地址 
	*@param datetime 操作时间 
	*@return 更新成功返回1 失败返回0 
	**/
	ReturnMessage update(String menuno, String menutext, String parentno, String menuurl, Timestamp datetime, long id);
	//endregion

}
