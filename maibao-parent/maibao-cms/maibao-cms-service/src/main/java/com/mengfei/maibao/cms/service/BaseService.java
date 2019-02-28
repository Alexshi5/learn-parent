package com.mengfei.maibao.cms.service;

import com.github.abel533.entity.Example;
import com.github.abel533.mapper.Mapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mengfei.maibao.cms.pojo.BasePojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * author Alex
 * date 2018/9/29
 * description 一个封装的基础service抽象类，用于service相关类的继承
 */
@Service
public abstract class BaseService<T extends BasePojo> {

    //public abstract Mapper<T> getMapper();

    @Autowired
    private Mapper<T> mapper;

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    public T getById(Long id){
        return this.mapper.selectByPrimaryKey(id);
    }

    /**
     * 查询所有数据
     * @return
     */
    public List<T> getAll(){
        return this.mapper.select(null);
    }

    /**
     * 根据条件来查询一条记录，如果是查询多个记录会抛出异常
     * @param obj
     * @return
     */
    public T getOne(T obj){
        return this.mapper.selectOne(obj);
    }

    /**
     * 通过条件查询数据列表
     * @param obj
     * @return
     */
    public List<T> getListByWhere(T obj){
        return this.mapper.select(obj);
    }

    /**
     * 分页查询
     * @param page
     * @param rows
     * @param obj
     * @return
     */
    public PageInfo<T> getPageListByWhere(Integer page, Integer rows, T obj){
        //设置分页条件
        PageHelper.startPage(page,rows);
        List<T> list = this.getListByWhere(obj);
        return new PageInfo<T>(list);
    }

    /**
     * 新增数据，返回成功的条数
     * @param obj
     * @return
     */
    public Integer saveRecord(T obj){
        obj.setCreated(new Date());
        obj.setUpdated(obj.getCreated());
        return this.mapper.insert(obj);
    }

    /**
     * 新增数据，使用不为null的字段，返回条数
     * @param obj
     * @return
     */
    public Integer saveRecordSelective(T obj){
        obj.setCreated(new Date());
        obj.setUpdated(obj.getCreated());
        return this.mapper.insertSelective(obj);
    }

    /**
     * 通过主键更新记录，返回更新的条数
     * @param obj
     * @return
     */
    public Integer updateById(T obj){
        obj.setUpdated(new Date());
        return this.mapper.updateByPrimaryKey(obj);
    }

    /**
     * 通过主键更新记录，使用不为null的记录，返回更新的条数
     * @param obj
     * @return
     */
    public Integer updateSelectiveById(T obj){
        obj.setUpdated(new Date());
        return this.mapper.updateByPrimaryKeySelective(obj);
    }

    /**
     * 通过主键删除记录，返回删除的条数
     * @param obj
     * @return
     */
    public Integer deleteById(T obj){
        return this.mapper.deleteByPrimaryKey(obj);
    }

    /**
     * 根据条件删除，返回删除的条数
     * @param obj
     * @return
     */
    public Integer deleteByWhere(T obj){
        return this.mapper.delete(obj);
    }

    /**
     * 批量删除，返回删除的条数
     * @param classObj
     * @param property
     * @param values
     * @return
     */
    public Integer deleteByIds(Class<T> classObj, String property, List<Object> values){
        Example example = new Example(classObj);
        example.createCriteria().andIn(property,values);
        return this.mapper.deleteByExample(example);
    }


}
