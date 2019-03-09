package com.mengfei.maibao.cms.service;

import com.github.abel533.entity.Example;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mengfei.maibao.cms.mapper.TbItemMapper;
import com.mengfei.maibao.cms.pojo.Item;
import com.mengfei.maibao.cms.pojo.ItemDesc;
import com.mengfei.maibao.common.EasyUIResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author Alex
 * date 2019/2/27
 * description 用于商品相关的业务逻辑
 */
@Service
public class ItemService extends BaseService<Item>{
    @Autowired
    private ItemDescService itemDescService;

    @Autowired
    private TbItemMapper itemMapper;
    /**
     * 新增商品
     * @param item
     * @param desc
     * @return
     */
    public Boolean addItem(Item item, String desc){

        //写入商品表
        item.setId(null);//出于安全的考虑
        item.setStatus(1);
        super.saveRecord(item);

        //写入商品描述表
        ItemDesc itemDesc = new ItemDesc();
        itemDesc.setItemId(item.getId());
        itemDesc.setItemDesc(desc);
        this.itemDescService.saveRecord(itemDesc);

        return true;
    }

    /**
     * 查询商品列表
     * @param page
     * @param rows
     */
    public EasyUIResult getItemPageList(Integer page, Integer rows) {
        PageHelper.startPage(page,rows);

        Example example = new Example(Item.class);
        example.setOrderByClause("created desc");
        List<Item> list = itemMapper.selectByExample(example);
        PageInfo<Item> pageInfo = new PageInfo<Item>(list);

        return new EasyUIResult(pageInfo.getTotal(),pageInfo.getList());
    }

    /**
     * 修改商品
     * @param item
     * @param desc
     * @return
     */
    public Boolean updateItem(Item item, String desc) {
        //强制设置不能更新的字段为null
        item.setCreated(null);
        item.setUpdated(null);

        Integer count1 = super.updateSelective(item);
        //更新商品描述数据
        ItemDesc itemDesc = new ItemDesc();
        itemDesc.setItemId(item.getId());
        itemDesc.setItemDesc(desc);
        Integer count2 = this.itemDescService.updateSelective(itemDesc);

        return count1 == 1 && count2 == 1;
    }
}
