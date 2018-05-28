package com.mengfei.maimao.usermanage.service;

import com.mengfei.maimao.usermanage.util.EasyuiResult;

/**
 * author Alex
 * date 2018/5/28
 * description 用户服务接口
 */
public interface UserService {
    /**
     * 通过要查询的页数以及每页展示的条数来进行颁布查询，返回EasyuiResult
     * @param page
     * @param rows
     * @return
     */
    public EasyuiResult getUserList(Integer page,Integer rows);
}
