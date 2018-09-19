package com.mengfei.maibao.cms.service;

import com.mengfei.maibao.cms.mapper.TbItemCatMapper;
import com.mengfei.maibao.cms.pojo.TbItemCat;
import com.mengfei.maibao.cms.pojo.TbItemCat;
import com.mengfei.maibao.cms.pojo.TbItemCatExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author Alex
 * date 2018/9/19
 * description 商品类目相关的服务类
 */
@Service
public class ItemCatService {
    @Autowired
    private TbItemCatMapper tbItemCatMapper;

    /**
     * 根据父节点的id来查询商品类目列表
     * @param parentId
     * @return
     */
    public List<TbItemCat> getItemCat(Long parentId){
        TbItemCatExample example = new TbItemCatExample();
        TbItemCatExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        return tbItemCatMapper.selectByExample(example);
    }
}
