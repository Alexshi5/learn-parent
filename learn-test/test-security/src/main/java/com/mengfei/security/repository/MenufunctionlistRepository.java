package com.mengfei.security.repository;

import com.mengfei.security.pojo.Menufunctionlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.sql.Timestamp;

public interface MenufunctionlistRepository extends JpaRepository<Menufunctionlist, Long>
{
	//region 根据序号id查找记录
	/**
	*根据序号id查找记录
	*@param id 
	*@return 
	**/
	Menufunctionlist findTop1ById(long id);
	//endregion

	//region 根据菜单IDmenuid查找记录
	/**
	*根据菜单IDmenuid查找记录
	*@param menuid 
	*@return 
	**/
	Menufunctionlist findTop1ByMenuid(long menuid);
	//endregion

	//region 根据功能编号funcno查找记录
	/**
	*根据功能编号funcno查找记录
	*@param funcno 
	*@return 
	**/
	Menufunctionlist findTop1ByFuncno(String funcno);
	//endregion

	//region 根据功能名称funcname查找记录
	/**
	*根据功能名称funcname查找记录
	*@param funcname 
	*@return 
	**/
	Menufunctionlist findTop1ByFuncname(String funcname);
	//endregion

	//region 根据功能url地址funcurl查找记录
	/**
	*根据功能url地址funcurl查找记录
	*@param funcurl 
	*@return 
	**/
	Menufunctionlist findTop1ByFuncurl(String funcurl);
	//endregion

	//region 根据操作时间datetime查找记录
	/**
	*根据操作时间datetime查找记录
	*@param datetime 
	*@return 
	**/
	Menufunctionlist findTop1ByDatetime(Timestamp datetime);
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
	@Query(value = "insert into menufunctionlist(menuid,funcno,funcname,funcurl,datetime) values (:menuid,:funcno,:funcname,:funcurl,:datetime)", nativeQuery = true)
	@Modifying
	int insert(@Param("menuid") long menuid, @Param("funcno") String funcno, @Param("funcname") String funcname, @Param("funcurl") String funcurl, @Param("datetime") Timestamp datetime);
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
	@Query(value = "update menufunctionlist set menuid=:menuid,funcno=:funcno,funcname=:funcname,funcurl=:funcurl,datetime=:datetime where id=:id", nativeQuery = true)
	@Modifying
	int update(@Param("menuid") long menuid, @Param("funcno") String funcno, @Param("funcname") String funcname, @Param("funcurl") String funcurl, @Param("datetime") Timestamp datetime, @Param("id") long id);
	//endregion


}
