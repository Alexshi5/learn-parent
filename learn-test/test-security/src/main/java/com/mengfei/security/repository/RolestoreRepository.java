package com.mengfei.security.repository;

import com.mengfei.security.pojo.Rolestore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;

public interface RolestoreRepository extends JpaRepository<Rolestore, Long>
{
	//region 根据自增长IDid查找记录
	/**
	*根据自增长IDid查找记录
	*@param id 
	*@return 
	**/
	Rolestore findTop1ById(long id);
	//endregion

	//region 根据角色IDroleid查找记录
	/**
	*根据角色IDroleid查找记录
	*@param roleid 
	*@return 
	**/
	Rolestore findTop1ByRoleid(long roleid);
	//endregion

	//region 根据店铺ID-暂用发布方IDhostshopid查找记录
	/**
	*根据店铺ID-暂用发布方IDhostshopid查找记录
	*@param hostshopid 
	*@return 
	**/
	List<Rolestore> findByHostshopid(long hostshopid);
	//endregion

	//region 根据操作时间datetime查找记录
	/**
	*根据操作时间datetime查找记录
	*@param datetime 
	*@return 
	**/
	Rolestore findTop1ByDatetime(Timestamp datetime);
	//endregion


	//region 自定义插入记录
	/**
	*自定义插入记录
	*@param roleid 角色ID 
	*@param hostshopid 店铺ID-暂用发布方ID 
	*@param datetime 操作时间 
	*@return 插入成功返回1 失败返回0 
	**/
	@Query(value = "insert into rolestore(roleid,hostshopid,datetime) values (:roleid,:hostshopid,:datetime)", nativeQuery = true)
	@Modifying
	int insert(@Param("roleid") long roleid, @Param("hostshopid") long hostshopid, @Param("datetime") Timestamp datetime);
	//endregion


	//region 自定义更新记录
	/**
	*自定义更新记录
	*@param roleid 角色ID 
	*@param hostshopid 店铺ID-暂用发布方ID 
	*@param datetime 操作时间 
	*@return 更新成功返回1 失败返回0 
	**/
	@Query(value = "update rolestore set roleid=:roleid,hostshopid=:hostshopid,datetime=:datetime where id=:id", nativeQuery = true)
	@Modifying
	int update(@Param("roleid") long roleid, @Param("hostshopid") long hostshopid, @Param("datetime") Timestamp datetime, @Param("id") long id);
	//endregion


}
