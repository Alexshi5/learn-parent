package com.mengfei.security.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mengfei.security.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "roleinfo")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Roleinfo extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String rolename;
    private String desp;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp datetime;

    /**
     *获取自增长ID
     *@return 自增长ID
     */
    @Column(name = "id")
    public long getId()
    {
        return id;
    }
    /**
     *设置自增长ID
     *@param id
     */
    public void setId(long id)
    {
        this.id = id;
    }

    /**
     *获取角色名称
     *@return 角色名称
     */
    @Column(name = "rolename")
    public String getRolename()
    {
        return rolename;
    }
    /**
     *设置角色名称
     *@param rolename
     */
    public void setRolename(String rolename)
    {
        this.rolename = rolename;
    }

    /**
     *获取角色描述
     *@return 角色描述
     */
    @Column(name = "desp")
    public String getDesp()
    {
        return desp;
    }
    /**
     *设置角色描述
     *@param desp
     */
    public void setDesp(String desp)
    {
        this.desp = desp;
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
        bstr.append("rolename:" + rolename + "\r\n");
        bstr.append("desp:" + desp + "\r\n");
        bstr.append("datetime:" + super.timestampToString(datetime) + "\r\n");
        return bstr.toString();
    }
}
