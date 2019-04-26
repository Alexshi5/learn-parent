package com.mengfei.learn.swaggercontroller;

import com.mengfei.learn.dto.UserInfoRequestDTO;
import com.mengfei.learn.dto.UserInfoRequestDTO2;
import com.mengfei.learn.mapper.demo.UserMapper;
import com.mengfei.learn.pojo.demo.UserBase;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/user")
public class SwaggerControllerTest {
    //Swagger UI 查看地址：http://localhost:8080/swagger-ui.html

    @Autowired
    private UserMapper userMapper;

    // 演示：路径参数入参，以及注释换行
    // 根据用户OID获取用户信息
    @ApiOperation(value = "获取用户信息",notes = "oid 用户主键  \ncreated 创建时间")
    @ApiImplicitParam(name = "oid",value = "用户ID",required = true, dataType = "long",paramType = "path")
    @RequestMapping(value = "/getUser/{oid}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<UserBase> getUser(@PathVariable(value = "oid") Long oid){
        UserBase userBase = userMapper.findById(oid).get();
        return ResponseEntity.ok(userBase);
    }

    // 演示：json格式的对象信息作为入参
    // 创建新的用户
    @ApiOperation(value = "创建用户")
    @ApiImplicitParam(name = "user",value = "用户的实体信息",required = true,dataType = "UserBase",paramType = "body")
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<UserBase> addUser(@RequestBody UserBase user){
        UserBase save = userMapper.save(user);
        return ResponseEntity.ok(save);
    }

    // 演示：入参使用DTO对象，以及文件上传
    // 更新用户信息
    @ApiOperation(value = "更新用户信息")
    @ApiImplicitParams({
            //@ApiImplicitParam(name = "userInfoDesc",value = "用户信息描述",required = true,dataType = "string",paramType = "query"),
            //@ApiImplicitParam(name = "state",value = "数据状态",required = true,dataType = "int",paramType = "query"),
            @ApiImplicitParam(name = "userLogo",value = "用户头像",required = true,dataType = "file",paramType = "form"),
    })
    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> updateUser(UserInfoRequestDTO requestDTO){
        String userLogoName = requestDTO.getUserLogo().getOriginalFilename();
        System.out.println(userLogoName);
        return ResponseEntity.ok("OK");
    }

    // 演示：入参使用DTO对象，文件入参单独列出
    // 更新用户信息2
    @ApiOperation(value = "更新用户信息2")
    @RequestMapping(value = "/updateUser2",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> updateUser2(UserInfoRequestDTO2 requestDTO,
                                              @ApiParam(value = "用户头像",name = "userLogo", required = true) MultipartFile userLogo){
        String userLogoName = userLogo.getOriginalFilename();
        System.out.println(userLogoName);
        return ResponseEntity.ok("OK");
    }

    // 演示：文件数组
    // 更新用户信息3
    @ApiOperation(value = "更新用户信息3")
    @RequestMapping(value = "/updateUser3",method = RequestMethod.POST)
    @ApiImplicitParam(name = "userLogos",value = "用户头像列表",required = true,dataType = "file",paramType = "form")
    @ResponseBody
    public ResponseEntity<String> updateUser3(MultipartFile[] userLogos){
        for(MultipartFile userLogo:userLogos){
            String userLogoName = userLogo.getOriginalFilename();
            System.out.println(userLogoName);
        }
        return ResponseEntity.ok("OK");
    }
}
