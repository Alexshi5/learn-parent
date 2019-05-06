package com.mengfei.test.fbsep.controller;

import com.mengfei.test.fbsep.dto.UserRequestDTO;
import com.mengfei.test.fbsep.pojo.ApiResponse;
import com.mengfei.test.fbsep.pojo.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class ApiController {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public ApiResponse hello(){
        return new ApiResponse<>("hello world");
    }

    //测试参数验证和Swagger UI 查看地址：http://localhost:8080/swagger-ui.html
    @ApiOperation(value = "添加新用户")
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public ApiResponse addUser(@RequestBody @Valid UserRequestDTO requestDTO){
        System.out.println(requestDTO);
        User user = new User();
        BeanUtils.copyProperties(requestDTO, user);
        System.out.println(user);

        //正常返回数据为空
        return new ApiResponse();
    }

    //测试全局的异常处理
    @RequestMapping(value = "/exception",method = RequestMethod.GET)
    public ApiResponse testExceptionHandle(){
        int i = 10;
        int j = i/0;

        //正常返回数据为空
        return new ApiResponse();
    }

    //测试接口返回数据格式
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public ApiResponse testResponseData(@RequestParam("type") String type){

        //正常返回数据为空
        if("1".equals(type)){
            return new ApiResponse();
        }

        //正常返回数据为字符串
        if("2".equals(type)){
            return new ApiResponse<String>("构造REST风格的接口");
        }

        //正常返回数据为List
        if("3".equals(type)){
            String[] arr = {"1", "2", "3"};
            List<String> list = new ArrayList<>(arr.length);
            Collections.addAll(list,arr);
            return new ApiResponse<List<String>>(list);
        }

        //正常返回数据为Map
        if("4".equals(type)){
            Map<String,String> map = new HashMap<>();
            map.put("s01","张华");
            map.put("s02","李白");
            map.put("s03","小红");
            return new ApiResponse<Map<String,String>>(map);
        }

        //正常返回通用类型
        if("5".equals(type)){
            return new ApiResponse<>(true,200,"操作正常","前后端分离实践");
        }

        //异常返回数据为空
        if("6".equals(type)){
            return new ApiResponse<>(HttpStatus.NOT_FOUND.value(),HttpStatus.NOT_FOUND.getReasonPhrase());
        }

        //正返回常数据为空
        return new ApiResponse();
    }
}
