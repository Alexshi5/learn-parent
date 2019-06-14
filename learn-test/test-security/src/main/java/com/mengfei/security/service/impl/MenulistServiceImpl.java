package com.mengfei.security.service.impl;

import com.mengfei.security.ReturnMessage;
import com.mengfei.security.pojo.Menulist;
import com.mengfei.security.repository.MenulistRepository;
import com.mengfei.security.service.MenulistService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@Service
public class MenulistServiceImpl implements MenulistService {
	private static final Logger log = LoggerFactory.getLogger(MenulistServiceImpl.class);
	@Autowired
	private MenulistRepository menulistRepository;

	//region 根据序号id查找记录
	/**
	*根据序号id查找记录
	*@param id 
	*@return 
	**/
	@Override
	public ReturnMessage<Menulist> findById(long id){
		Menulist model= menulistRepository.findTop1ById(id);
		if(model==null){
			return new ReturnMessage<Menulist>(true,"99","信息错误");
		}
		return new ReturnMessage<Menulist>("00","获取成功",model);
	}
	//endregion

	//region 根据菜单编号menuno查找记录
	/**
	*根据菜单编号menuno查找记录
	*@param menuno 
	*@return 
	**/
	@Override
	public ReturnMessage<Menulist> findByMenuno(String menuno){
		Menulist model= menulistRepository.findTop1ByMenuno(menuno);
		if(model==null){
			return new ReturnMessage<Menulist>(true,"99","信息错误");
		}
		return new ReturnMessage<Menulist>("00","获取成功",model);
	}
	//endregion

	//region 根据菜单名称menutext查找记录
	/**
	*根据菜单名称menutext查找记录
	*@param menutext 
	*@return 
	**/
	@Override
	public ReturnMessage<Menulist> findByMenutext(String menutext){
		Menulist model= menulistRepository.findTop1ByMenutext(menutext);
		if(model==null){
			return new ReturnMessage<Menulist>(true,"99","信息错误");
		}
		return new ReturnMessage<Menulist>("00","获取成功",model);
	}
	//endregion

	//region 根据上级编号parentno查找记录
	/**
	*根据上级编号parentno查找记录
	*@param parentno 
	*@return 
	**/
	@Override
	public ReturnMessage<Menulist> findByParentno(String parentno){
		Menulist model= menulistRepository.findTop1ByParentno(parentno);
		if(model==null){
			return new ReturnMessage<Menulist>(true,"99","信息错误");
		}
		return new ReturnMessage<Menulist>("00","获取成功",model);
	}
	//endregion

	//region 根据Url地址menuurl查找记录
	/**
	*根据Url地址menuurl查找记录
	*@param menuurl 
	*@return 
	**/
	@Override
	public ReturnMessage<Menulist> findByMenuurl(String menuurl){
		Menulist model= menulistRepository.findTop1ByMenuurl(menuurl);
		if(model==null){
			return new ReturnMessage<Menulist>(true,"99","信息错误");
		}
		return new ReturnMessage<Menulist>("00","获取成功",model);
	}
	//endregion

	//region 根据操作时间datetime查找记录
	/**
	*根据操作时间datetime查找记录
	*@param datetime 
	*@return 
	**/
	@Override
	public ReturnMessage<Menulist> findByDatetime(Timestamp datetime){
		Menulist model= menulistRepository.findTop1ByDatetime(datetime);
		if(model==null){
			return new ReturnMessage<Menulist>(true,"99","信息错误");
		}
		return new ReturnMessage<Menulist>("00","获取成功",model);
	}
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
	@Override
	@Transactional(value = "transactionManagerReport",rollbackFor = Exception.class)
	public ReturnMessage insert(String menuno,String menutext,String parentno,String menuurl,Timestamp datetime){
		int rows= menulistRepository.insert(menuno,menutext,parentno,menuurl,datetime);
		if(rows<=0){
			return new ReturnMessage(true,"99","保存错误");
		}
		return new ReturnMessage();
	}
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
	@Override
	@Transactional(value = "transactionManagerReport",rollbackFor = Exception.class)
	public ReturnMessage update(String menuno,String menutext,String parentno,String menuurl,Timestamp datetime,long id){
		int rows= menulistRepository.update(menuno,menutext,parentno,menuurl,datetime,id);
		if(rows<=0){
			return new ReturnMessage(true,"99","保存错误");
		}
		return new ReturnMessage();
	}
	//endregion

}
