package com.mengfei.security.repository;

import com.mengfei.security.pojo.Childaccountinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;

public interface ChildaccountinfoRepository extends JpaRepository<Childaccountinfo, Long>
{
	//region 根据自增长IDid查找记录
	/**
	*根据自增长IDid查找记录
	*@param id 
	*@return 
	**/
	Childaccountinfo findTop1ById(long id);
	//endregion

	//region 根据发布方IDhostid查找记录
	/**
	*根据发布方IDhostid查找记录
	*@param hostid 
	*@return 
	**/
	Childaccountinfo findTop1ByHostid(long hostid);
	//endregion

	//region 根据店铺ID-暂用发布方IDhostshopid查找记录
	/**
	*根据店铺ID-暂用发布方IDhostshopid查找记录
	*@param hostshopid 
	*@return 
	**/
	Childaccountinfo findTop1ByHostshopid(long hostshopid);
	//endregion

	//region 根据时间datetime查找记录
	/**
	*根据时间datetime查找记录
	*@param datetime 
	*@return 
	**/
	Childaccountinfo findTop1ByDatetime(Timestamp datetime);
	//endregion


	//region 自定义插入记录
	/**
	*自定义插入记录
	*@param hostid 发布方ID 
	*@param hostshopid 店铺ID-暂用发布方ID 
	*@param datetime 时间 
	*@return 插入成功返回1 失败返回0 
	**/
	@Query(value = "insert into childaccountinfo(hostid,hostshopid,datetime) values (:hostid,:hostshopid,:datetime)", nativeQuery = true)
	@Modifying
	int insert(@Param("hostid") long hostid, @Param("hostshopid") long hostshopid, @Param("datetime") Timestamp datetime);
	//endregion


	//region 自定义更新记录
	/**
	*自定义更新记录
	*@param hostid 发布方ID 
	*@param hostshopid 店铺ID-暂用发布方ID 
	*@param datetime 时间 
	*@return 更新成功返回1 失败返回0 
	**/
	@Query(value = "update childaccountinfo set hostid=:hostid,hostshopid=:hostshopid,datetime=:datetime where id=:id", nativeQuery = true)
	@Modifying
	int update(@Param("hostid") long hostid, @Param("hostshopid") long hostshopid, @Param("datetime") Timestamp datetime, @Param("id") long id);
	//endregion


}
