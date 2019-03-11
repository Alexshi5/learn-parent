package com.mengfei.maibao.cms.controller.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mengfei.maibao.cms.service.ItemCatService;
import com.mengfei.maibao.common.ItemCatResult;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * author Alex
 * date 2019/3/11
 * description 提供外部接口请求的api入口
 */
@Controller
@RequestMapping("/api/item/cat")
public class ApiItemCatController {
    @Autowired
    private ItemCatService itemCatService;

    private static final ObjectMapper MAPPER = new ObjectMapper();

    /**
     * 获取所有商品类目的json数据（通过将spring的json处理器扩展之后可以直接使用此方式）
     * @return
     */
    /*@RequestMapping("/all")
    public ResponseEntity<ItemCatResult> getItemCatJson(){
        try {
            ItemCatResult itemCatJson = itemCatService.getItemCatJson();
            if(null == itemCatJson){
                //204
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
            }
            return ResponseEntity.ok(itemCatJson);
        }catch (Exception e){
           e.getStackTrace();
        }
        //500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }*/

    /**
     * 获取所有商品类目的json数据（解决跨域请求的问题）
     * @return
     */
    @RequestMapping("/all")
    public ResponseEntity<String> getItemCatJson(@RequestParam("callback") String callback){
        try {
            ItemCatResult itemCatJson = itemCatService.getItemCatJson();
            String jsonStr = MAPPER.writeValueAsString(itemCatJson);
            if(StringUtils.isBlank(callback)){
                //无需跨域支持直接返回json数据即可
                return ResponseEntity.ok(jsonStr);
            }
            return ResponseEntity.ok(callback + "(" + jsonStr + ");");
        }catch (Exception e){
            e.getStackTrace();
        }
        //500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}
