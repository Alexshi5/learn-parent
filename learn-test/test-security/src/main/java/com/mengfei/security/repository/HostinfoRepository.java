package com.mengfei.security.repository;

import com.mengfei.security.pojo.Hostinfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.sql.Timestamp;

public interface HostinfoRepository extends JpaRepository<Hostinfo, Long>
{
	//region 根据自增IDid查找记录
	/**
	*根据自增IDid查找记录
	*@param id 
	*@return 
	**/
	Hostinfo findTop1ById(long id);
	//endregion

	//region 根据登录名loginname查找记录
	/**
	*根据登录名loginname查找记录
	*@param loginname 
	*@return 
	**/
	Hostinfo findTop1ByLoginname(String loginname);
	//endregion

	//region 根据登录密码password查找记录
	/**
	*根据登录密码password查找记录
	*@param password 
	*@return 
	**/
	Hostinfo findTop1ByPassword(String password);
	//endregion

	//region 根据操作时间datetime查找记录
	/**
	*根据操作时间datetime查找记录
	*@param datetime 
	*@return 
	**/
	Hostinfo findTop1ByDatetime(Timestamp datetime);
	//endregion


	//region 自定义插入记录
	/**
	*自定义插入记录
	*@param loginname 登录名 
	*@param password 登录密码 
	*@param datetime 操作时间 
	*@return 插入成功返回1 失败返回0 
	**/
	@Query(value = "insert into hostinfo(loginname,password,datetime) values (:loginname,:password,:datetime)", nativeQuery = true)
	@Modifying
	int insert(@Param("loginname") String loginname, @Param("password") String password, @Param("datetime") Timestamp datetime);
	//endregion


	//region 自定义更新记录
	/**
	*自定义更新记录
	*@param loginname 登录名 
	*@param password 登录密码 
	*@param datetime 操作时间 
	*@return 更新成功返回1 失败返回0 
	**/
	@Query(value = "update hostinfo set loginname=:loginname,password=:password,datetime=:datetime where id=:id", nativeQuery = true)
	@Modifying
	int update(@Param("loginname") String loginname, @Param("password") String password, @Param("datetime") Timestamp datetime, @Param("id") long id);
	//endregion


}
