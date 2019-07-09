package com.mengfei.security.service.impl;

import com.mengfei.security.ReturnMessage;
import com.mengfei.security.pojo.Menufunctionlist;
import com.mengfei.security.repository.MenufunctionlistRepository;
import com.mengfei.security.service.MenufunctionlistService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

@Service
public class MenufunctionlistServiceImpl implements MenufunctionlistService {
	private static final Logger log = LoggerFactory.getLogger(MenufunctionlistServiceImpl.class);
	@Autowired
	private MenufunctionlistRepository menufunctionlistRepository;

	//region 根据序号id查找记录
	/**
	*根据序号id查找记录
	*@param id 
	*@return 
	**/
	@Override
	public ReturnMessage<Menufunctionlist> findById(long id){
		Menufunctionlist model= menufunctionlistRepository.findTop1ById(id);
		if(model==null){
			return new ReturnMessage<Menufunctionlist>(true,"99","信息错误");
		}
		return new ReturnMessage<Menufunctionlist>("00","获取成功",model);
	}
	//endregion

	//region 根据菜单IDmenuid查找记录
	/**
	*根据菜单IDmenuid查找记录
	*@param menuid 
	*@return 
	**/
	@Override
	public ReturnMessage<Menufunctionlist> findByMenuid(long menuid){
		Menufunctionlist model= menufunctionlistRepository.findTop1ByMenuid(menuid);
		if(model==null){
			return new ReturnMessage<Menufunctionlist>(true,"99","信息错误");
		}
		return new ReturnMessage<Menufunctionlist>("00","获取成功",model);
	}
	//endregion

	//region 根据功能编号funcno查找记录
	/**
	*根据功能编号funcno查找记录
	*@param funcno 
	*@return 
	**/
	@Override
	public ReturnMessage<Menufunctionlist> findByFuncno(String funcno){
		Menufunctionlist model= menufunctionlistRepository.findTop1ByFuncno(funcno);
		if(model==null){
			return new ReturnMessage<Menufunctionlist>(true,"99","信息错误");
		}
		return new ReturnMessage<Menufunctionlist>("00","获取成功",model);
	}

	@Override
	public ReturnMessage<Menufunctionlist> findByFuncnos(Set<String> funcnoSet) {
		List<Menufunctionlist> model= menufunctionlistRepository.findByFuncnoIn(funcnoSet);
		if(model==null){
			return new ReturnMessage<Menufunctionlist>(true,"99","信息错误");
		}
		return new ReturnMessage<Menufunctionlist>("00","获取成功",model);
	}
	//endregion

	@Override
	public ReturnMessage<Menufunctionlist> findByFuncids(Set<Long> funcids) {
		List<Menufunctionlist> model= menufunctionlistRepository.findByIdIn(funcids);
		if(model==null){
			return new ReturnMessage<Menufunctionlist>(true,"99","信息错误");
		}
		return new ReturnMessage<Menufunctionlist>("00","获取成功",model);
	}

	//region 根据功能名称funcname查找记录
	/**
	*根据功能名称funcname查找记录
	*@param funcname 
	*@return 
	**/
	@Override
	public ReturnMessage<Menufunctionlist> findByFuncname(String funcname){
		Menufunctionlist model= menufunctionlistRepository.findTop1ByFuncname(funcname);
		if(model==null){
			return new ReturnMessage<Menufunctionlist>(true,"99","信息错误");
		}
		return new ReturnMessage<Menufunctionlist>("00","获取成功",model);
	}
	//endregion

	//region 根据功能url地址funcurl查找记录
	/**
	*根据功能url地址funcurl查找记录
	*@param funcurl 
	*@return 
	**/
	@Override
	public ReturnMessage<Menufunctionlist> findByFuncurl(String funcurl){
		Menufunctionlist model= menufunctionlistRepository.findTop1ByFuncurl(funcurl);
		if(model==null){
			return new ReturnMessage<Menufunctionlist>(true,"99","信息错误");
		}
		return new ReturnMessage<Menufunctionlist>("00","获取成功",model);
	}
	//endregion

	//region 根据操作时间datetime查找记录
	/**
	*根据操作时间datetime查找记录
	*@param datetime 
	*@return 
	**/
	@Override
	public ReturnMessage<Menufunctionlist> findByDatetime(Timestamp datetime){
		Menufunctionlist model= menufunctionlistRepository.findTop1ByDatetime(datetime);
		if(model==null){
			return new ReturnMessage<Menufunctionlist>(true,"99","信息错误");
		}
		return new ReturnMessage<Menufunctionlist>("00","获取成功",model);
	}
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
	@Override
	@Transactional(value = "transactionManagerReport",rollbackFor = Exception.class)
	public ReturnMessage insert(long menuid,String funcno,String funcname,String funcurl,Timestamp datetime){
		int rows= menufunctionlistRepository.insert(menuid,funcno,funcname,funcurl,datetime);
		if(rows<=0){
			return new ReturnMessage(true,"99","保存错误");
		}
		return new ReturnMessage();
	}
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
	@Override
	@Transactional(value = "transactionManagerReport",rollbackFor = Exception.class)
	public ReturnMessage update(long menuid,String funcno,String funcname,String funcurl,Timestamp datetime,long id){
		int rows= menufunctionlistRepository.update(menuid,funcno,funcname,funcurl,datetime,id);
		if(rows<=0){
			return new ReturnMessage(true,"99","保存错误");
		}
		return new ReturnMessage();
	}
	//endregion
}
