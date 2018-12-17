package com.mengfei.redis;

import java.io.Serializable;
import java.util.Date;

/**
 * 预警数据模型
 * 
 * @author dengfa
 *
 */
public class WarnDataModel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6398056518847342192L;
	/**
	 * 预警ID
	 */
	private String warnId;
	private String monitorCode;
	/**
	 * 待审核类型——事件信息——事件类别
	 */
	private Integer warnTypes;
	/**
	 * 预警类型
	 */
	private Integer warnType;
	/**
	 * 待审核 标识值
	 */
	private String eventOid;
	/**
	 * 首页右下角弹出信息列表类型 1：事件待处理；2：接警；3：待审核
	 */
	private Integer type;
	/**
	 * 用户单位编码
	 */
	private String funcCode;
	/**
     * 用户登录帐号
     */
	private String loginAccount;
	/**
	 * 话务上级领导rid
	 */
	private String rId;
	/**
	 * 话务审核员——审核同意转向的领导
	 */
	private String turnUnit;
	/**
	 * 预警名称
	 */
	private String warnContent;
	/**
	 * 经度
	 */
	private Double lon;
	/**
	 * 纬度
	 */
	private Double lat;
	/**
	 * 路线编码
	 */
	private String roadCode;
	/**
	 * 桩号
	 */
	private Double stake;
	/**
	 * 桩号
	 */
	private Double endStake;
	/**
	 * 区域编码
	 */
	private String areaCode;
	/**
	 * 
	 */
	private Integer eventValue;
	private Integer count;
	/**
	 * 
	 */
	private String equipCode;
	
	/**
	 * 止点经度
	 */
	private Double endLon;
	/**
	 * 止点纬度
	 */
	private Double endLat;
	
    private String filterSql;
    
    private String fullCode;
    
    private Date intime;
    
    private Integer dataCategory;
    
    private Integer serviceStep;
    
    private Integer handleState;
    
    private Integer handleStateService;
    
    private Integer handleStateCenter;
    
    private Integer auditState;
    
    private String referHigher;
    
    private String visibleRole;
    
    private Integer processCompletion;
    
    private Long roadid;

    //查询开始
    private Integer queryBegin;

    //查询结束
    private Integer queryEnd;

    //插入时间
    private Date insertTime;
    
    private Double warnLvl;//预警等级  或  预警值

	//可进行处理的角色（已经拆分，一条数据只有一个）
	private String roles;

	//用于标记当前的提示信息是否为已读状态
	private String readUserIds;

	//用于传递工单处置页面所需要的参数值，中间用"#"分隔
	private String params;

	//用于判断话务提示信息接收者的主体对象编码
	private Integer telReceiveObjId;

	//在缓存中的数据唯一ID
	private String cacheId;

	public String getCacheId() {
		return cacheId;
	}

	public void setCacheId(String cacheId) {
		this.cacheId = cacheId;
	}

	public Integer getTelReceiveObjId() {
		return telReceiveObjId;
	}

	public void setTelReceiveObjId(Integer telReceiveObjId) {
		this.telReceiveObjId = telReceiveObjId;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getReadUserIds() {
		return readUserIds;
	}

	public void setReadUserIds(String readUserIds) {
		this.readUserIds = readUserIds;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public Double getWarnLvl() {
		return warnLvl;
	}

	public void setWarnLvl(Double warnLvl) {
		this.warnLvl = warnLvl;
	}

	public Date getInsertTime() {
		return insertTime;
	}

	public void setInsertTime(Date insertTime) {
		this.insertTime = insertTime;
	}

	public Integer getQueryBegin() {
		return queryBegin;
	}

	public void setQueryBegin(Integer queryBegin) {
		this.queryBegin = queryBegin;
	}

	public Integer getQueryEnd() {
		return queryEnd;
	}

	public void setQueryEnd(Integer queryEnd) {
		this.queryEnd = queryEnd;
	}

	public Long getRoadid() {
		return roadid;
	}
	public void setRoadid(Long roadid) {
		this.roadid = roadid;
	}
	public Integer getHandleStateService() {
		return handleStateService;
	}
	public void setHandleStateService(Integer handleStateService) {
		this.handleStateService = handleStateService;
	}
	public Integer getHandleStateCenter() {
		return handleStateCenter;
	}
	public void setHandleStateCenter(Integer handleStateCenter) {
		this.handleStateCenter = handleStateCenter;
	}
	public String getVisibleRole() {
		return visibleRole;
	}
	public void setVisibleRole(String visibleRole) {
		this.visibleRole = visibleRole;
	}
	public Integer getProcessCompletion() {
		return processCompletion;
	}
	public void setProcessCompletion(Integer processCompletion) {
		this.processCompletion = processCompletion;
	}
	public String getReferHigher() {
		return referHigher;
	}
	public void setReferHigher(String referHigher) {
		this.referHigher = referHigher;
	}
	public Integer getAuditState() {
		return auditState;
	}
	public void setAuditState(Integer auditState) {
		this.auditState = auditState;
	}
	public Integer getHandleState() {
		return handleState;
	}
	public void setHandleState(Integer handleState) {
		this.handleState = handleState;
	}
	public Integer getServiceStep() {
		return serviceStep;
	}
	public void setServiceStep(Integer serviceStep) {
		this.serviceStep = serviceStep;
	}
	public Integer getDataCategory() {
		return dataCategory;
	}
	public void setDataCategory(Integer dataCategory) {
		this.dataCategory = dataCategory;
	}
	public String getWarnId() {
		return warnId;
	}
	public void setWarnId(String warnId) {
		this.warnId = warnId;
	}
	public Integer getWarnType() {
		return warnType;
	}
	public void setWarnType(Integer warnType) {
		this.warnType = warnType;
	}
	public String getWarnContent() {
		return warnContent;
	}
	public void setWarnContent(String warnContent) {
		this.warnContent = warnContent;
	}
	public Double getLon() {
		return lon;
	}
	public void setLon(Double lon) {
		this.lon = lon;
	}
	public Double getLat() {
		return lat;
	}
	public void setLat(Double lat) {
		this.lat = lat;
	}
	public String getRoadCode() {
		return roadCode;
	}
	public void setRoadCode(String roadCode) {
		this.roadCode = roadCode;
	}
	public Double getStake() {
		return stake;
	}
	public void setStake(Double stake) {
		this.stake = stake;
	}
	public String getAreaCode() {
		return areaCode;
	}
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	public Integer getEventValue() {
		return eventValue;
	}
	
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public void setEventValue(Integer eventValue) {
		this.eventValue = eventValue;
	}
	public String getEquipCode() {
		return equipCode;
	}
	public void setEquipCode(String equipCode) {
		this.equipCode = equipCode;
	}
	public Double getEndLon() {
		return endLon;
	}
	public void setEndLon(Double endLon) {
		this.endLon = endLon;
	}
	public Double getEndLat() {
		return endLat;
	}
	public void setEndLat(Double endLat) {
		this.endLat = endLat;
	}
	public Double getEndStake() {
		return endStake;
	}
	public void setEndStake(Double endStake) {
		this.endStake = endStake;
	}
	public String getFilterSql() {
		return filterSql;
	}
	
	public String getMonitorCode() {
		return monitorCode;
	}
	public void setMonitorCode(String monitorCode) {
		this.monitorCode = monitorCode;
	}
	public void setFilterSql(String filterSql) {
		this.filterSql = filterSql;
	}
	public String getFullCode() {
		return fullCode;
	}
	public void setFullCode(String fullCode) {
		this.fullCode = fullCode;
	}
	public Date getIntime() {
		return intime;
	}
	public void setIntime(Date intime) {
		this.intime = intime;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public String getEventOid() {
		return eventOid;
	}

	public void setEventOid(String eventOid) {
		this.eventOid = eventOid;
	}

	public String getFuncCode() {
		return funcCode;
	}

	public void setFuncCode(String funcCode) {
		this.funcCode = funcCode;
	}

	public String getLoginAccount() {
		return loginAccount;
	}

	public void setLoginAccount(String loginAccount) {
		this.loginAccount = loginAccount;
	}

	public Integer getWarnTypes() {
		return warnTypes;
	}

	public void setWarnTypes(Integer warnTypes) {
		this.warnTypes = warnTypes;
	}

	public String getrId() {
		return rId;
	}

	public void setrId(String rId) {
		this.rId = rId;
	}

	public String getTurnUnit() {
		return turnUnit;
	}

	public void setTurnUnit(String turnUnit) {
		this.turnUnit = turnUnit;
	}
	
}
