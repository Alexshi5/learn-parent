package com.mengfei.maibao.cms.service;

import com.mengfei.maibao.cms.pojo.ItemCat;
import com.mengfei.maibao.common.ItemCatData;
import com.mengfei.maibao.common.ItemCatResult;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author Alex
 * date 2018/9/19
 * description 商品类目相关的服务类
 */
@Service
public class ItemCatService extends BaseService<ItemCat>{

    /**
     * 获取所有商品类目的json数据
     */
    public ItemCatResult getItemCatJson() {
        ItemCatResult result = new ItemCatResult();
        // 全部查出，并且在内存中生成树形结构
        List<ItemCat> cats = this.getAll();

        // 转为map存储，key为父节点ID，value为数据集合
        Map<Long, List<ItemCat>> itemCatMap = new HashMap<Long, List<ItemCat>>();
        for (ItemCat itemCat : cats) {
            if(!itemCatMap.containsKey(itemCat.getParentId())){
                itemCatMap.put(itemCat.getParentId(), new ArrayList<ItemCat>());
            }
            itemCatMap.get(itemCat.getParentId()).add(itemCat);
        }

        // 封装一级对象
        List<ItemCat> itemCatList1 = itemCatMap.get(0L);
        for (ItemCat itemCat : itemCatList1) {
            ItemCatData itemCatData = new ItemCatData();
            itemCatData.setUrl("/products/" + itemCat.getId() + ".html");
            itemCatData.setName("<a href='"+itemCatData.getUrl()+"'>"+itemCat.getName()+"</a>");
            result.getItemCats().add(itemCatData);
            if(!itemCat.getIsParent()){
                continue;
            }

            // 封装二级对象
            List<ItemCat> itemCatList2 = itemCatMap.get(itemCat.getId());
            List<ItemCatData> itemCatData2 = new ArrayList<ItemCatData>();
            itemCatData.setItems(itemCatData2);
            for (ItemCat itemCat2 : itemCatList2) {
                ItemCatData id2 = new ItemCatData();
                id2.setName(itemCat2.getName());
                id2.setUrl("/products/" + itemCat2.getId() + ".html");
                itemCatData2.add(id2);
                if(itemCat2.getIsParent()){
                    // 封装三级对象
                    List<ItemCat> itemCatList3 = itemCatMap.get(itemCat2.getId());
                    List<String> itemCatData3 = new ArrayList<String>();
                    id2.setItems(itemCatData3);
                    for (ItemCat itemCat3 : itemCatList3) {
                        itemCatData3.add("/products/" + itemCat3.getId() + ".html|"+itemCat3.getName());
                    }
                }
            }
            if(result.getItemCats().size() >= 14){
                break;
            }
        }
        return result;
    }

    /*@Autowired
    private TbItemCatMapper tbItemCatMapper;*/

    /**
     * 根据父节点的id来查询商品类目列表
     * @param parentId
     * @return
     */
    /*public List<TbItemCat> getItemCat(Long parentId){
        TbItemCat itemCat = new TbItemCat();
        itemCat.setParentId(parentId);
        return tbItemCatMapper.select(itemCat);
    }*/

    /*@Override
    public Mapper<TbItemCat> getMapper() {
        return this.tbItemCatMapper;
    }*/
}
