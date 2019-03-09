package com.mengfei.maibao.cms.controller;

import com.mengfei.maibao.cms.pojo.ItemDesc;
import com.mengfei.maibao.cms.service.ItemDescService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * author Alex
 * date 2019/2/27
 * description 用于商品描述相关操作的控制器
 */
@Controller
@RequestMapping("/item/desc")
public class ItemDescController {
    @Autowired
    private ItemDescService itemDescService;

    @RequestMapping("{itemId}")
    public ResponseEntity<ItemDesc> getItemDescById(@PathVariable("itemId") Long itemId){
        try {
            ItemDesc itemDesc = this.itemDescService.getById(itemId);
            if(null == itemDesc){
                //404
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            //200
            return ResponseEntity.ok(itemDesc);
        }catch (Exception e){
            e.getStackTrace();
        }
        //500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}
