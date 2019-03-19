package com.mengfei.learn.mapper.demo2;

import com.mengfei.learn.pojo.demo2.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoRepository extends JpaRepository<UserInfo,Long> {

}

