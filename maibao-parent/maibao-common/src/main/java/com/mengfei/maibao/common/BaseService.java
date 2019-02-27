package com.mengfei.maibao.common;

import com.github.abel533.mapper.Mapper;

import java.util.List;

/**
 * author Alex
 * date 2018/9/29
 * description 一个封装的基础service抽象类，用于service相关类的继承
 */
public abstract class BaseService<T> {

    public abstract Mapper<T> getMapper();

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    public T getById(Long id){
        return this.getMapper().selectByPrimaryKey(id);
    }

    /**
     * 查询所有数据
     * @return
     */
    public List<T> getAll(){
        return this.getMapper().select(null);
    }

    /**
     * 根据条件来查询一条记录，如果是查询多个记录会抛出异常
     * @param obj
     * @return
     */
    public T getOne(T obj){
        return this.getMapper().selectOne(obj);
    }

    /**
     * 通过条件查询数据列表
     * @param obj
     * @return
     */
    public List<T> getListByWhere(T obj){
        return this.getMapper().select(obj);
    }

}
