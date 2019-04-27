package com.mengfei.learn.swaggercontroller;

import com.mengfei.learn.dto.UserInfoRequestDTO;
import com.mengfei.learn.dto.UserInfoRequestDTO2;
import com.mengfei.learn.mapper.demo.UserMapper;
import com.mengfei.learn.pojo.demo.UserBase;
import io.swagger.annotations.*;
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

    // 演示：路径参数入参，以及注释换行（注释换行使用两个空格和一个\n）
    @ApiOperation(value = "获取用户信息",notes = "oid 用户主键  \ncreated 创建时间")
    @ApiImplicitParam(name = "oid",value = "用户ID",required = true, dataType = "long",paramType = "path")
    @RequestMapping(value = "/getUser/{oid}",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<UserBase> getUser(@PathVariable(value = "oid") Long oid){
        UserBase userBase = userMapper.findById(oid).get();
        return ResponseEntity.ok(userBase);
    }

    // 演示：入参使用json格式的对象（使用@RequestBody注解，paramType可省略，name名与对象名保持一致）
    @ApiOperation(value = "创建用户")
    @ApiImplicitParam(name = "user",value = "用户的实体信息",required = true,dataType = "UserBase",paramType = "body")
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<UserBase> addUser(@RequestBody UserBase user){
        UserBase save = userMapper.save(user);
        return ResponseEntity.ok(save);
    }

    // 演示：表单入参使用DTO对象，以及文件上传
    // 对象入参可以使用@ApiImplicitParams注解描述，也可在对象属性上添加@ApiModelProperty注解描述，但文件入参比较特殊不能
    // 用@ApiModelProperty来描述。@ApiModelProperty的描述示例如下：
    // 数据状态（0删除，1正常）
    // @ApiModelProperty(value = "数据状态00",name = "state",notes = "0删除，1正常",required = true,dataType = "int")
    // private Integer state;）
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

    // 演示：表单入参使用DTO对象，文件入参单独列出（文件入参也可在参数列表中直接使用@ApiParam注解来描述）
    @ApiOperation(value = "更新用户信息2")
    @RequestMapping(value = "/updateUser2",method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<String> updateUser2(UserInfoRequestDTO2 requestDTO,
                                              @ApiParam(value = "用户头像",name = "userLogo", required = true) MultipartFile userLogo){
        String userLogoName = userLogo.getOriginalFilename();
        System.out.println(userLogoName);
        return ResponseEntity.ok("OK");
    }

    // 演示：表单入参文件数组，上传多个文件
    // 在@RequestMapping中添加consumes = "multipart/form-data"可以支持多文件数组上传，否则Swagger将自动将Content-Type设置
    // 为application/json，但设置之后Swagger还是无法选择多个文件进行接口测试的，只是显示可以传递文件数组，这时可以采用Postman
    // 或RestClient等接口测试工具进行接口测试，多文件上传建议使用@ApiParam注解
    @ApiOperation(value = "更新用户信息3")
    @RequestMapping(value = "/updateUser3",method = RequestMethod.POST,consumes = "multipart/form-data")
    @ResponseBody
    public ResponseEntity<String> updateUser3(@ApiParam(value = "用户头像列表",name = "userLogos",required = true) MultipartFile[] userLogos){
        for(MultipartFile userLogo:userLogos){
            String userLogoName = userLogo.getOriginalFilename();
            System.out.println(userLogoName);
        }
        return ResponseEntity.ok("OK");
    }
}
