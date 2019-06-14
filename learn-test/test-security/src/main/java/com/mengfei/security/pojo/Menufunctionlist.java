package com.mengfei.security.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mengfei.security.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "menufunctionlist")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Menufunctionlist extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long menuid;
    private String funcno;
    private String funcname;
    private String funcurl;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Timestamp datetime;

    /**
     *获取序号
     *@return 序号
     */
    @Column(name = "id")
    public long getId()
    {
        return id;
    }
    /**
     *设置序号
     *@param id
     */
    public void setId(long id)
    {
        this.id = id;
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
     *获取功能编号
     *@return 功能编号
     */
    @Column(name = "funcno")
    public String getFuncno()
    {
        return funcno;
    }
    /**
     *设置功能编号
     *@param funcno
     */
    public void setFuncno(String funcno)
    {
        this.funcno = funcno;
    }

    /**
     *获取功能名称
     *@return 功能名称
     */
    @Column(name = "funcname")
    public String getFuncname()
    {
        return funcname;
    }
    /**
     *设置功能名称
     *@param funcname
     */
    public void setFuncname(String funcname)
    {
        this.funcname = funcname;
    }

    /**
     *获取功能url地址
     *@return 功能url地址
     */
    @Column(name = "funcurl")
    public String getFuncurl()
    {
        return funcurl;
    }
    /**
     *设置功能url地址
     *@param funcurl
     */
    public void setFuncurl(String funcurl)
    {
        this.funcurl = funcurl;
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
        bstr.append("menuid:" + menuid + "\r\n");
        bstr.append("funcno:" + funcno + "\r\n");
        bstr.append("funcname:" + funcname + "\r\n");
        bstr.append("funcurl:" + funcurl + "\r\n");
        bstr.append("datetime:" + super.timestampToString(datetime) + "\r\n");
        return bstr.toString();
    }
}
