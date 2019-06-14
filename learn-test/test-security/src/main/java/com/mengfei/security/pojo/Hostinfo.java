package com.mengfei.security.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mengfei.security.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "hostinfo")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Hostinfo extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String loginname;
    private String password;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp datetime;

    /**
     *获取自增ID
     *@return 自增ID
     */
    @Column(name = "id")
    public long getId()
    {
        return id;
    }
    /**
     *设置自增ID
     *@param id
     */
    public void setId(long id)
    {
        this.id = id;
    }

    /**
     *获取登录名
     *@return 登录名
     */
    @Column(name = "loginname")
    public String getLoginname()
    {
        return loginname;
    }
    /**
     *设置登录名
     *@param loginname
     */
    public void setLoginname(String loginname)
    {
        this.loginname = loginname;
    }

    /**
     *获取登录密码
     *@return 登录密码
     */
    @Column(name = "password")
    public String getPassword()
    {
        return password;
    }
    /**
     *设置登录密码
     *@param password
     */
    public void setPassword(String password)
    {
        this.password = password;
    }

    /**
     *获取操作时间
     *@return 操作时间
     */
    @Column(name = "datetime")
    public Timestamp getDatetime()
    {
        return datetime;
    }
    /**
     *设置操作时间
     *@param datetime
     */
    public void setDatetime(Timestamp datetime)
    {
        this.datetime = datetime;
    }

    public String toString()
    {
        StringBuilder bstr = new StringBuilder();
        bstr.append("id:" + id + "\r\n");
        bstr.append("loginname:" + loginname + "\r\n");
        bstr.append("password:" + password + "\r\n");
        bstr.append("datetime:" + super.timestampToString(datetime) + "\r\n");
        return bstr.toString();
    }
}
