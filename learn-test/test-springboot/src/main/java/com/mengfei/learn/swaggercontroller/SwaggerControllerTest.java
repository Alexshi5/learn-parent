package com.mengfei.learn.swaggercontroller;

import com.mengfei.learn.mapper.demo.UserMapper;
import com.mengfei.learn.pojo.demo.UserBase;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/swagger/user")
public class SwaggerControllerTest {
    /**
     * 根据用户ID获取用户信息
     * @param oid
     * @return
     */
    @ApiOperation(value = "获取用户信息")
    @ApiImplicitParam(name = "oid",value = "用户ID",required = true, dataType = "Long",paramType = "path")
    @RequestMapping(value = "/getUser/{oid}",method = RequestMethod.GET)
    public ResponseEntity<UserBase> getUser(@PathVariable(value = "oid") Long oid){
        Optional<UserBase> userBase1 = userMapper.findById(oid);
        return ResponseEntity.ok(userBase1.get());
    }

    @Autowired
    private UserMapper userMapper;

    /**
     * 创建新的用户
     * @param user
     * @return
     */
    @ApiOperation(value = "创建用户")
    @ApiImplicitParam(name = "user",value = "用户的实体信息",required = true,dataType = "com.mengfei.learn.pojo.demo.UserBase")
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public ResponseEntity<UserBase> addUser(@RequestBody UserBase user){
        UserBase save = userMapper.save(user);
        return ResponseEntity.ok(save);
    }
}
