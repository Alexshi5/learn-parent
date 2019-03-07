package com.mengfei.learn.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * author Alex
 * date 2018/11/12
 * description 用户实体类
 */
@Entity
public class UserBase implements Serializable{
    private static final long serialVersionUID = 6208820779001972177L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "oid",columnDefinition = "bigint COMMENT '主键自增'")
    private Long oid;

    @Column(name = "UserBasename",columnDefinition = "varchar(50) COMMENT '用户名'")
    private String UserBasename;

    @Column(name = "password",columnDefinition = "varchar(50) COMMENT '用户密码'")
    private String password;

    @Column(name = "phone",columnDefinition = "varchar(20) COMMENT '用户电话'")
    private String phone;

    @Column(name = "created",columnDefinition = "datetime COMMENT '创建时间'")
    private Date created;

    //记录是否逻辑删除的状态：0为已删除，1为未删除
    @Column(name = "state",columnDefinition = "int COMMENT '记录是否删除的状态：0为已删除，1为正常'")
    private Integer state;

    public UserBase(){}

    public UserBase(String UserBasename, String password, String phone, Date created, Integer state) {
        this.UserBasename = UserBasename;
        this.password = password;
        this.phone = phone;
        this.created = created;
        this.state = state;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public String getUserBasename() {
        return UserBasename;
    }

    public void setUserBasename(String UserBasename) {
        this.UserBasename = UserBasename;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
        return "UserBase{" +
                "oid=" + oid +
                ", UserBasename='" + UserBasename + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", created=" + created +
                ", state=" + state +
                '}';
    }
}
