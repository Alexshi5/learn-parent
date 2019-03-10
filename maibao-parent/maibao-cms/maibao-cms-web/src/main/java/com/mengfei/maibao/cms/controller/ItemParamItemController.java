package com.mengfei.maibao.cms.controller;

import com.mengfei.maibao.cms.pojo.ItemParamItem;
import com.mengfei.maibao.cms.service.ItemParamItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * author Alex
 * date 2019/3/9
 * description
 */
@Controller
@RequestMapping("/item/param/item")
public class ItemParamItemController {
    @Autowired
    private ItemParamItemService itemParamItemService;
    /**
     * 通过商品id查询商品的规格参数
     * @param itemId
     * @return
     */
    @RequestMapping("{itemId}")
    public ResponseEntity<ItemParamItem> getItemParamByItemCatId(@PathVariable("itemId") Long itemId){
        try {
            ItemParamItem itemParamItem = new ItemParamItem();
            itemParamItem.setItemId(itemId);
            ItemParamItem itemParamItem1 = this.itemParamItemService.getOne(itemParamItem);
            if(null == itemParamItem1){
                //204
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
            }
            return ResponseEntity.ok(itemParamItem1);
        }catch (Exception e){
            e.getStackTrace();
        }
        //500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}
