package com.mengfei.learn.mapper.demo;

import com.mengfei.learn.pojo.demo.UserBase;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author Alex
 * date 2019/3/6
 * description 用户实体类相关的持久化接口
 */
public interface UserMapper extends JpaRepository<UserBase,Long>{

    /**
     * 自定义方法，根据用户名去查询用户
     * @param username
     * @return
     */
    UserBase getUserBaseByUserBasename(String username);
}
