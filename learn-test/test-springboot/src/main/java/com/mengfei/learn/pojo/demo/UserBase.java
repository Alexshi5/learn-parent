package com.mengfei.learn.pojo.demo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * author Alex
 * date 2018/11/12
 * description 用户实体类
 */
@Entity
@Table(name = "user_base")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class UserBase implements Serializable{
    private static final long serialVersionUID = 6208820779001972177L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "oid")
    private Long oid;

    @Column(name = "user_basename")
    private String userBasename;

    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    private String phone;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    @ApiModelProperty(value = "创建时间", example = "2018-04-26 00:00:00")
    @Column(name = "created")
    private Date created;

    @Column(name = "state")
    private Integer state;

    public UserBase(){}

    public UserBase(String userBasename, String password, String phone, Date created, Integer state) {
        this.userBasename = userBasename;
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

    public String getuserBasename() {
        return userBasename;
    }

    public void setuserBasename(String userBasename) {
        this.userBasename = userBasename;
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
                ", userBasename='" + userBasename + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", created=" + created +
                ", state=" + state +
                '}';
    }
}
