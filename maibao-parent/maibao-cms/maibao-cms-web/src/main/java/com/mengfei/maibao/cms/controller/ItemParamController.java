package com.mengfei.maibao.cms.controller;

import com.mengfei.maibao.cms.pojo.ItemParam;
import com.mengfei.maibao.cms.service.ItemParamService;
import com.mengfei.maibao.common.EasyUIResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * author Alex
 * date 2019/3/9
 * description
 */
@Controller
@RequestMapping("/item/param")
public class ItemParamController {
    @Autowired
    private ItemParamService itemParamService;

    /**
     * 通过商品的类目id查找商品的参数模板
     * @param itemCatId
     * @return
     */
    @RequestMapping("{itemCatId}")
    public ResponseEntity<ItemParam> getItemParamByItemCatId(@PathVariable("itemCatId") Long itemCatId){
        try {
            ItemParam itemParam = new ItemParam();
            itemParam.setItemCatId(itemCatId);
            ItemParam itemParam1 = this.itemParamService.getOne(itemParam);
            if(null == itemParam1){
                //204
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
            }
            return ResponseEntity.ok(itemParam1);
        }catch (Exception e){
            e.getStackTrace();
        }
        //500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    @RequestMapping("/add/{itemCatId}")
    public ResponseEntity<Void> addItemParam(@PathVariable("itemCatId") Long itemCatId,
                                             @RequestParam("paramData") String paramData){
        try {
            ItemParam itemParam = new ItemParam();
            itemParam.setId(null);
            itemParam.setItemCatId(itemCatId);
            itemParam.setParamData(paramData);
            this.itemParamService.saveRecord(itemParam);
            //201
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }catch (Exception e){
            e.getStackTrace();
        }
        //500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    /**
     * 查询商品规格参数列表
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("/list")
    public ResponseEntity<EasyUIResult> getItemParamPageList(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                                         @RequestParam(value = "rows",defaultValue = "30") Integer rows){
        try {
            EasyUIResult itemParamPageList = this.itemParamService.getItemParamPageList(page, rows);
            if(null == itemParamPageList){
                //204
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
            }
            return ResponseEntity.ok(itemParamPageList);
        }catch (Exception e){
            e.getStackTrace();
        }

        //500
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }
}
