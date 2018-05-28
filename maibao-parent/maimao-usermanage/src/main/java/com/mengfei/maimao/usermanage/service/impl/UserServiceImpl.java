package com.mengfei.maimao.usermanage.service.impl;

import com.github.abel533.entity.Example;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mengfei.maimao.usermanage.mapper.UserMapper;
import com.mengfei.maimao.usermanage.pojo.User;
import com.mengfei.maimao.usermanage.service.UserService;
import com.mengfei.maimao.usermanage.util.EasyuiResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author Alex
 * date 2018/5/28
 * description 用户服务实现类
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public EasyuiResult getUserList(Integer page, Integer rows) {
        //设置分页条件
        PageHelper.startPage(page,rows);
        //设置查询条件
        Example example = new Example(User.class);
        //设置通过创建时间进行降序查询
        example.setOrderByClause("created DESC");
        //执行查询
        List<User> users = userMapper.selectByExample(example);
        //获取分页信息
        PageInfo<User> pageInfo = new PageInfo<User>(users);
        //向返回结果中添加数据
        EasyuiResult result = new EasyuiResult();
        result.setTotal(pageInfo.getTotal());
        result.setRows(pageInfo.getList());
        return result;
    }
}
