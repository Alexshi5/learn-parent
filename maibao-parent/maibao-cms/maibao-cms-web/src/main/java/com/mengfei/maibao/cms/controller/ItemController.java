package com.mengfei.maibao.cms.controller;

import com.mengfei.maibao.cms.pojo.Item;
import com.mengfei.maibao.cms.service.ItemService;
import com.mengfei.maibao.common.EasyUIResult;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * author Alex
 * date 2019/2/27
 * description
 */
@Controller
@RequestMapping("/item")
public class ItemController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ItemController.class);

    @Autowired
    private ItemService itemService;

    /**
     * 新增商品
     * @param item
     * @param desc
     * @return
     */
    @PostMapping("/add")
    public ResponseEntity<Void> addItem(Item item, @RequestParam("desc") String desc){

        try {
            if(LOGGER.isDebugEnabled()){
                LOGGER.debug("开始新增商品，参数item = " + item + "，参数desc = " + desc);
            }
            if(StringUtils.isBlank(desc)){
                //返回400
                return ResponseEntity.status(HttpStatus.SC_BAD_REQUEST).build();
            }

            Boolean bool = itemService.addItem(item, desc);
            if(LOGGER.isDebugEnabled()){
                LOGGER.debug("商品新增成功，商品id = " + item.getId());
            }

            if(!bool){
                //保存失败
                return ResponseEntity.status(HttpStatus.SC_INTERNAL_SERVER_ERROR).build();
            }

            //返回201
            return ResponseEntity.status(HttpStatus.SC_CREATED).build();
        }catch (Exception e){
            e.getStackTrace();
            LOGGER.error("新增商品失败！ item = " + item, e);
        }

        //返回500
        return ResponseEntity.status(HttpStatus.SC_INTERNAL_SERVER_ERROR).build();
    }

    /**
     * 修改商品
     * @param item
     * @param desc
     * @return
     */
    @PostMapping("/update")
    public ResponseEntity<Void> updateItem(Item item, @RequestParam("desc") String desc){

        try {
            if(LOGGER.isDebugEnabled()){
                LOGGER.debug("开始修改商品，参数item = " + item + "，参数desc = " + desc);
            }
            if(StringUtils.isBlank(desc)){
                //返回400
                return ResponseEntity.status(HttpStatus.SC_BAD_REQUEST).build();
            }

            Boolean bool = itemService.updateItem(item, desc);
            if(LOGGER.isDebugEnabled()){
                LOGGER.debug("商品修改成功，商品id = " + item.getId());
            }

            if(!bool){
                //保存失败500
                return ResponseEntity.status(HttpStatus.SC_INTERNAL_SERVER_ERROR).build();
            }

            //返回204
            return ResponseEntity.status(HttpStatus.SC_NO_CONTENT).build();
        }catch (Exception e){
            e.getStackTrace();
            LOGGER.error("修改商品失败！ item = " + item, e);
        }

        //返回500
        return ResponseEntity.status(HttpStatus.SC_INTERNAL_SERVER_ERROR).build();
    }

    /**
     * 查询商品列表
     * @param page
     * @param rows
     * @return
     */
    @GetMapping("/list")
    public ResponseEntity<EasyUIResult> getItemPageList(@RequestParam(value = "page",defaultValue = "1") Integer page,
                                                        @RequestParam(value = "rows",defaultValue =  "30") Integer rows){

        try {
            EasyUIResult list = this.itemService.getItemPageList(page, rows);
            return ResponseEntity.ok(list);

        }catch (Exception e){
            e.getStackTrace();
        }

        return ResponseEntity.status(HttpStatus.SC_INTERNAL_SERVER_ERROR).body(null);
    }
}
