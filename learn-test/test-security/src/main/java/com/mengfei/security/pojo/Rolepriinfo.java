package com.mengfei.security.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mengfei.security.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "rolepriinfo")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Rolepriinfo extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long roleid;
    private long menuid;
    private long funcid;

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
     *获取菜单ID
     *@return 菜单ID
     */
    @Column(name = "menuid")
    public long getMenuid()
    {
        return menuid;
    }
    /**
     *设置菜单ID
     *@param menuid
     */
    public void setMenuid(long menuid)
    {
        this.menuid = menuid;
    }

    /**
     *获取功能ID
     *@return 功能ID
     */
    @Column(name = "funcid")
    public long getFuncid()
    {
        return funcid;
    }
    /**
     *设置功能ID
     *@param funcid
     */
    public void setFuncid(long funcid)
    {
        this.funcid = funcid;
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
        bstr.append("menuid:" + menuid + "\r\n");
        bstr.append("funcid:" + funcid + "\r\n");
        bstr.append("datetime:" + super.timestampToString(datetime) + "\r\n");
        return bstr.toString();
    }
}
