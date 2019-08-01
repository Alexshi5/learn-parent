package com.mengfei.springboot.springbootdemo1.repository;

import com.mengfei.springboot.springbootdemo1.dto.UserBase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserBaseRepository extends JpaRepository<UserBase,Long>, JpaSpecificationExecutor<UserBase> {

    UserBase findTopByOid(long oid);
}
