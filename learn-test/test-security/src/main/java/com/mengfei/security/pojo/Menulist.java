package com.mengfei.security.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mengfei.security.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Entity
@Table(name = "menulist")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Menulist extends BaseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String menuno;
    private String menutext;
    private String parentno;
    private String menuurl;

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
     *获取菜单编号
     *@return 菜单编号
     */
    @Column(name = "menuno")
    public String getMenuno()
    {
        return menuno;
    }
    /**
     *设置菜单编号
     *@param menuno
     */
    public void setMenuno(String menuno)
    {
        this.menuno = menuno;
    }

    /**
     *获取菜单名称
     *@return 菜单名称
     */
    @Column(name = "menutext")
    public String getMenutext()
    {
        return menutext;
    }
    /**
     *设置菜单名称
     *@param menutext
     */
    public void setMenutext(String menutext)
    {
        this.menutext = menutext;
    }

    /**
     *获取上级编号
     *@return 上级编号
     */
    @Column(name = "parentno")
    public String getParentno()
    {
        return parentno;
    }
    /**
     *设置上级编号
     *@param parentno
     */
    public void setParentno(String parentno)
    {
        this.parentno = parentno;
    }

    /**
     *获取Url地址
     *@return Url地址
     */
    @Column(name = "menuurl")
    public String getMenuurl()
    {
        return menuurl;
    }
    /**
     *设置Url地址
     *@param menuurl
     */
    public void setMenuurl(String menuurl)
    {
        this.menuurl = menuurl;
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
        bstr.append("menuno:" + menuno + "\r\n");
        bstr.append("menutext:" + menutext + "\r\n");
        bstr.append("parentno:" + parentno + "\r\n");
        bstr.append("menuurl:" + menuurl + "\r\n");
        bstr.append("datetime:" + super.timestampToString(datetime) + "\r\n");
        return bstr.toString();
    }
}
