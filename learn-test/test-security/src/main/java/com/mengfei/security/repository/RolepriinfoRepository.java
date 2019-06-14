package com.mengfei.security.repository;

import com.mengfei.security.pojo.Rolepriinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

public interface RolepriinfoRepository extends JpaRepository<Rolepriinfo, Long>
{
	//region 根据自增长IDid查找记录
	/**
	*根据自增长IDid查找记录
	*@param id 
	*@return 
	**/
	Rolepriinfo findTop1ById(long id);
	//endregion

	//region 根据角色IDroleid查找记录
	/**
	*根据角色IDroleid查找记录
	*@param roleid 
	*@return 
	**/
	Rolepriinfo findTop1ByRoleid(long roleid);
	//endregion

	//region 根据菜单IDmenuid查找记录
	/**
	*根据菜单IDmenuid查找记录
	*@param menuid 
	*@return 
	**/
	Rolepriinfo findTop1ByMenuid(long menuid);
	//endregion

	//region 根据功能IDfuncid查找记录
	/**
	*根据功能IDfuncid查找记录
	*@param funcid 
	*@return 
	**/
	Rolepriinfo findTop1ByFuncid(long funcid);
	//endregion

	//region 根据操作时间datetime查找记录
	/**
	*根据操作时间datetime查找记录
	*@param datetime 
	*@return 
	**/
	Rolepriinfo findTop1ByDatetime(Timestamp datetime);
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
	@Query(value = "insert into rolepriinfo(roleid,menuid,funcid,datetime) values (:roleid,:menuid,:funcid,:datetime)", nativeQuery = true)
	@Modifying
	int insert(@Param("roleid") long roleid, @Param("menuid") long menuid, @Param("funcid") long funcid, @Param("datetime") Timestamp datetime);
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
	@Query(value = "update rolepriinfo set roleid=:roleid,menuid=:menuid,funcid=:funcid,datetime=:datetime where id=:id", nativeQuery = true)
	@Modifying
	int update(@Param("roleid") long roleid, @Param("menuid") long menuid, @Param("funcid") long funcid, @Param("datetime") Timestamp datetime, @Param("id") long id);
	//endregion


	List<Rolepriinfo> findByRoleidInAndFuncid(Set<Long> roleIdSet, long funcid);

	List<Rolepriinfo> findByMenuidInAndFuncidNot(Set<Long> menuIdSet, long funcid);
}
