package com.mengfei.security;

import org.springframework.beans.BeanUtils;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class BaseEntity implements Serializable {

    public String timestampToString(Timestamp timestamp){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return  sdf.format(timestamp);
    }

     /**
     * 对象复制，不支持List等复制类型
     * @return
     */
    public BaseEntity clone(){
        Object model=null;
        Class entityClass=this.getClass();
        try {
            model = entityClass.newInstance();
            BeanUtils.copyProperties(this, model);
        }
        catch (Exception e) {
        }
        return (BaseEntity)model;
    }
}
