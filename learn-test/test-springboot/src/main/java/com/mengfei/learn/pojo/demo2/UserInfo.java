package com.mengfei.learn.pojo.demo2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 用户信息描述实体类
 */
@Entity
@Table(name = "user_info")
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 3351721746033141506L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "oid",columnDefinition = "bigint COMMENT '主键自增'")
    private Long oid;

    @Column(name = "user_id",columnDefinition = "bigint COMMENT '用户id'")
    private Long userId;

    @Column(name = "user_info_desc",columnDefinition = "varchar(2000) COMMENT '用户详细描述'")
    private String userInfoDesc;

    @Column(name = "created",columnDefinition = "datetime COMMENT '创建时间'")
    private Date created;

    @Column(name = "state",columnDefinition = "int COMMENT '记录是否已删除的状态，0为已删除，1为正常'")
    private Integer state;

    public UserInfo(){}

    public UserInfo(Long userId, String userInfoDesc, Date created, Integer state) {
        this.userId = userId;
        this.userInfoDesc = userInfoDesc;
        this.created = created;
        this.state = state;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserInfoDesc() {
        return userInfoDesc;
    }

    public void setUserInfoDesc(String userInfoDesc) {
        this.userInfoDesc = userInfoDesc;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "oid=" + oid +
                ", userId=" + userId +
                ", userInfoDesc='" + userInfoDesc + '\'' +
                ", created=" + created +
                ", state=" + state +
                '}';
    }
}
