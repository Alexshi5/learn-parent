package com.mengfei.maibao.cms.controller;

import com.mengfei.maibao.cms.pojo.TbItemCat;
import com.mengfei.maibao.cms.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * author Alex
 * date 2018/9/19
 * description 商品类目相关的控制器
 */
@Controller
@RequestMapping("/item/cat")
public class ItemCatController {
    @Autowired
    private ItemCatService itemCatService;

    /**
     * 根据父节点的id查询商品的类目列表
     * @param parentId
     * @return
     */
    @RequestMapping(value = "/list")
    public ResponseEntity<List<TbItemCat>> getItemCat(@RequestParam(value = "id",defaultValue = "0") Long parentId){
        try {
            List<TbItemCat> itemCats = itemCatService.getItemCat(parentId);
            if(itemCats.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            return ResponseEntity.ok(itemCats);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
