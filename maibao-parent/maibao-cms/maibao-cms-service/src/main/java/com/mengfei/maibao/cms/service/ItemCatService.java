package com.mengfei.maibao.cms.service;

import com.mengfei.maibao.cms.pojo.ItemCat;
import org.springframework.stereotype.Service;

/**
 * author Alex
 * date 2018/9/19
 * description 商品类目相关的服务类
 */
@Service
public class ItemCatService extends BaseService<ItemCat>{

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
