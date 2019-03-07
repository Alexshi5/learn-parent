package com.mengfei.learn.mapper;

import com.mengfei.learn.pojo.UserBase;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author Alex
 * date 2019/3/6
 * description 用户实体类相关的持久化接口
 */
public interface UserMapper extends JpaRepository<UserBase,Long>{

}
