package com.mengfei.maibao.cms.service;

import com.github.abel533.entity.Example;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mengfei.maibao.cms.mapper.ItemParamMapper;
import com.mengfei.maibao.cms.pojo.ItemParam;
import com.mengfei.maibao.common.EasyUIResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * author Alex
 * date 2019/3/9
 * description
 */
@Service
public class ItemParamService extends BaseService<ItemParam>{
    @Autowired
    private ItemParamMapper itemParamMapper;

    /**
     * 查询商品的规格参数列表
     * @param page
     * @param rows
     * @return
     */
    public EasyUIResult getItemParamPageList(Integer page, Integer rows) {
        PageHelper.startPage(page,rows);

        Example example = new Example(ItemParam.class);
        example.setOrderByClause("created desc");
        List<ItemParam> itemParams = itemParamMapper.selectByExample(example);

        PageInfo<ItemParam> pageInfo = new PageInfo<ItemParam>(itemParams);
        return new EasyUIResult(pageInfo.getTotal(),pageInfo.getList());
    }
}
