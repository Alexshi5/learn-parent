package com.mengfei.security.service.impl;

import com.mengfei.security.ReturnMessage;
import com.mengfei.security.pojo.Rolepriinfo;
import com.mengfei.security.repository.RolepriinfoRepository;
import com.mengfei.security.service.RolepriinfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Service
public class RolepriinfoServiceImpl implements RolepriinfoService {
	private static final Logger log = LoggerFactory.getLogger(RolepriinfoServiceImpl.class);
	@Autowired
	private RolepriinfoRepository rolepriinfoRepository;

	//region 根据自增长IDid查找记录
	/**
	*根据自增长IDid查找记录
	*@param id 
	*@return 
	**/
	@Override
	public ReturnMessage<Rolepriinfo> findById(long id){
		Rolepriinfo model= rolepriinfoRepository.findTop1ById(id);
		if(model==null){
			return new ReturnMessage<Rolepriinfo>(true,"99","信息错误");
		}
		return new ReturnMessage<Rolepriinfo>("00","获取成功",model);
	}
	//endregion

	//region 根据角色IDroleid查找记录
	/**
	*根据角色IDroleid查找记录
	*@param roleid 
	*@return 
	**/
	@Override
	public ReturnMessage<Rolepriinfo> findByRoleid(long roleid){
		Rolepriinfo model= rolepriinfoRepository.findTop1ByRoleid(roleid);
		if(model==null){
			return new ReturnMessage<Rolepriinfo>(true,"99","信息错误");
		}
		return new ReturnMessage<Rolepriinfo>("00","获取成功",model);
	}

	//region 根据菜单IDmenuid查找记录
	/**
	*根据菜单IDmenuid查找记录
	*@param menuid 
	*@return 
	**/
	@Override
	public ReturnMessage<Rolepriinfo> findByMenuid(long menuid){
		Rolepriinfo model= rolepriinfoRepository.findTop1ByMenuid(menuid);
		if(model==null){
			return new ReturnMessage<Rolepriinfo>(true,"99","信息错误");
		}
		return new ReturnMessage<Rolepriinfo>("00","获取成功",model);
	}
	//endregion

	//region 根据功能IDfuncid查找记录
	/**
	*根据功能IDfuncid查找记录
	*@param funcid 
	*@return 
	**/
	@Override
	public ReturnMessage<Rolepriinfo> findByFuncid(long funcid){
		Rolepriinfo model= rolepriinfoRepository.findTop1ByFuncid(funcid);
		if(model==null){
			return new ReturnMessage<Rolepriinfo>(true,"99","信息错误");
		}
		return new ReturnMessage<Rolepriinfo>("00","获取成功",model);
	}
	//endregion

	//region 根据操作时间datetime查找记录
	/**
	*根据操作时间datetime查找记录
	*@param datetime 
	*@return 
	**/
	@Override
	public ReturnMessage<Rolepriinfo> findByDatetime(Timestamp datetime){
		Rolepriinfo model= rolepriinfoRepository.findTop1ByDatetime(datetime);
		if(model==null){
			return new ReturnMessage<Rolepriinfo>(true,"99","信息错误");
		}
		return new ReturnMessage<Rolepriinfo>("00","获取成功",model);
	}
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
	@Override
	@Transactional(value = "transactionManagerReport",rollbackFor = Exception.class)
	public ReturnMessage insert(long roleid,long menuid,long funcid,Timestamp datetime){
		int rows= rolepriinfoRepository.insert(roleid,menuid,funcid,datetime);
		if(rows<=0){
			return new ReturnMessage(true,"99","保存错误");
		}
		return new ReturnMessage();
	}
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
	@Override
	@Transactional(value = "transactionManagerReport",rollbackFor = Exception.class)
	public ReturnMessage update(long roleid,long menuid,long funcid,Timestamp datetime,long id){
		int rows= rolepriinfoRepository.update(roleid,menuid,funcid,datetime,id);
		if(rows<=0){
			return new ReturnMessage(true,"99","保存错误");
		}
		return new ReturnMessage();
	}
	//endregion

	@Override
	public ReturnMessage<Rolepriinfo> findByRoleIdSet(Set<Long> roleIdSet, long funcid) {
		List<Rolepriinfo> model = this.rolepriinfoRepository.findByRoleidInAndFuncid(roleIdSet, funcid);
		if(model==null){
			return new ReturnMessage<Rolepriinfo>(true,"99","信息错误");
		}
		return new ReturnMessage<Rolepriinfo>("00","获取成功",model);
	}
	//endregion

	@Override
	public ReturnMessage<Rolepriinfo> findByRoleIdSet(Set<Long> roleIdSet) {
		List<Rolepriinfo> model = this.rolepriinfoRepository.findByRoleidIn(roleIdSet);
		if(model==null){
			return new ReturnMessage<Rolepriinfo>(true,"99","信息错误");
		}
		return new ReturnMessage<Rolepriinfo>("00","获取成功",model);
	}
	//endregion

	@Override
	public ReturnMessage<Rolepriinfo> findByMenuidInAndFuncidNot(Set<Long> roleIdSet, long funcid) {
		List<Rolepriinfo> model = this.rolepriinfoRepository.findByMenuidInAndFuncidNot(roleIdSet, funcid);
		if(model==null){
			return new ReturnMessage<Rolepriinfo>(true,"99","信息错误");
		}
		return new ReturnMessage<Rolepriinfo>("00","获取成功",model);
	}


}
