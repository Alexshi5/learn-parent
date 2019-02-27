package com.mengfei.maibao.usermanage.util;

import java.util.List;

/**
 * author Alex
 * date 2018/5/23
 * description 返回easyui结果数据
 */
public class EasyuiResult {

    private Long total;

    private List<?> rows;

    public EasyuiResult(){

    }

    public EasyuiResult(Long total, List<?> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
