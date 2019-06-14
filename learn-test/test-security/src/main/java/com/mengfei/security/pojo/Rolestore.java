package com.mengfei.security.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mengfei.security.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "rolestore")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Rolestore extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long roleid;
    private long hostshopid;

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
     *获取角色ID
     *@return 角色ID
     */
    @Column(name = "roleid")
    public long getRoleid()
    {
        return roleid;
    }
    /**
     *设置角色ID
     *@param roleid
     */
    public void setRoleid(long roleid)
    {
        this.roleid = roleid;
    }

    /**
     *获取店铺ID-暂用发布方ID
     *@return 店铺ID-暂用发布方ID
     */
    @Column(name = "hostshopid")
    public long getHostshopid()
    {
        return hostshopid;
    }
    /**
     *设置店铺ID-暂用发布方ID
     *@param hostshopid
     */
    public void setHostshopid(long hostshopid)
    {
        this.hostshopid = hostshopid;
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
        bstr.append("roleid:" + roleid + "\r\n");
        bstr.append("hostshopid:" + hostshopid + "\r\n");
        bstr.append("datetime:" + super.timestampToString(datetime) + "\r\n");
        return bstr.toString();
    }
}
