package com.mengfei.security.repository;

import com.mengfei.security.pojo.Roleinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.sql.Timestamp;

public interface RoleinfoRepository extends JpaRepository<Roleinfo, Long>
{
	//region 根据自增长IDid查找记录
	/**
	*根据自增长IDid查找记录
	*@param id 
	*@return 
	**/
	Roleinfo findTop1ById(long id);
	//endregion

	//region 根据角色名称rolename查找记录
	/**
	*根据角色名称rolename查找记录
	*@param rolename 
	*@return 
	**/
	Roleinfo findTop1ByRolename(String rolename);
	//endregion

	//region 根据角色描述desp查找记录
	/**
	*根据角色描述desp查找记录
	*@param desp 
	*@return 
	**/
	Roleinfo findTop1ByDesp(String desp);
	//endregion

	//region 根据操作时间datetime查找记录
	/**
	*根据操作时间datetime查找记录
	*@param datetime 
	*@return 
	**/
	Roleinfo findTop1ByDatetime(Timestamp datetime);
	//endregion


	//region 自定义插入记录
	/**
	*自定义插入记录
	*@param rolename 角色名称 
	*@param desp 角色描述 
	*@param datetime 操作时间 
	*@return 插入成功返回1 失败返回0 
	**/
	@Query(value = "insert into roleinfo(rolename,desp,datetime) values (:rolename,:desp,:datetime)", nativeQuery = true)
	@Modifying
	int insert(@Param("rolename") String rolename, @Param("desp") String desp, @Param("datetime") Timestamp datetime);
	//endregion


	//region 自定义更新记录
	/**
	*自定义更新记录
	*@param rolename 角色名称 
	*@param desp 角色描述 
	*@param datetime 操作时间 
	*@return 更新成功返回1 失败返回0 
	**/
	@Query(value = "update roleinfo set rolename=:rolename,desp=:desp,datetime=:datetime where id=:id", nativeQuery = true)
	@Modifying
	int update(@Param("rolename") String rolename, @Param("desp") String desp, @Param("datetime") Timestamp datetime, @Param("id") long id);
	//endregion


}
