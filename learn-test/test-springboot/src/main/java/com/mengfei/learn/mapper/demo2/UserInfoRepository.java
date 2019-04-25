package com.mengfei.learn.mapper.demo2;

import com.mengfei.learn.pojo.demo2.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserInfoRepository extends JpaRepository<UserInfo,Long> {

    //更新用户信息表的状态和描述（使用参数列表）
    @Query(value = "update user_info set state=:state,user_info_desc=:userInfoDesc where oid =:oid",nativeQuery = true)
    @Modifying
    int updateUserInfo(@Param("state") Integer state, @Param("userInfoDesc") String userInfoDesc,@Param("oid")Long oid);

    //更新用户信息表的状态和描述（使用参数对象）
    @Query(value = "update user_info set state=:#{#userInfo.state},user_info_desc=:#{#userInfo.userInfoDesc} where oid =:#{#userInfo.oid}",nativeQuery = true)
    @Modifying
    int updateUserInfo(@Param("userInfo") UserInfo userInfo);
}

