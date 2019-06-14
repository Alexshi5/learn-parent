package com.mengfei.security.repository;

import com.mengfei.security.pojo.Menulist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.sql.Timestamp;

public interface MenulistRepository extends JpaRepository<Menulist, Long>
{
	//region 根据序号id查找记录
	/**
	*根据序号id查找记录
	*@param id 
	*@return 
	**/
	Menulist findTop1ById(long id);
	//endregion

	//region 根据菜单编号menuno查找记录
	/**
	*根据菜单编号menuno查找记录
	*@param menuno 
	*@return 
	**/
	Menulist findTop1ByMenuno(String menuno);
	//endregion

	//region 根据菜单名称menutext查找记录
	/**
	*根据菜单名称menutext查找记录
	*@param menutext 
	*@return 
	**/
	Menulist findTop1ByMenutext(String menutext);
	//endregion

	//region 根据上级编号parentno查找记录
	/**
	*根据上级编号parentno查找记录
	*@param parentno 
	*@return 
	**/
	Menulist findTop1ByParentno(String parentno);
	//endregion

	//region 根据Url地址menuurl查找记录
	/**
	*根据Url地址menuurl查找记录
	*@param menuurl 
	*@return 
	**/
	Menulist findTop1ByMenuurl(String menuurl);
	//endregion

	//region 根据操作时间datetime查找记录
	/**
	*根据操作时间datetime查找记录
	*@param datetime 
	*@return 
	**/
	Menulist findTop1ByDatetime(Timestamp datetime);
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
	@Query(value = "insert into menulist(menuno,menutext,parentno,menuurl,datetime) values (:menuno,:menutext,:parentno,:menuurl,:datetime)", nativeQuery = true)
	@Modifying
	int insert(@Param("menuno") String menuno, @Param("menutext") String menutext, @Param("parentno") String parentno, @Param("menuurl") String menuurl, @Param("datetime") Timestamp datetime);
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
	@Query(value = "update menulist set menuno=:menuno,menutext=:menutext,parentno=:parentno,menuurl=:menuurl,datetime=:datetime where id=:id", nativeQuery = true)
	@Modifying
	int update(@Param("menuno") String menuno, @Param("menutext") String menutext, @Param("parentno") String parentno, @Param("menuurl") String menuurl, @Param("datetime") Timestamp datetime, @Param("id") long id);
	//endregion


}
