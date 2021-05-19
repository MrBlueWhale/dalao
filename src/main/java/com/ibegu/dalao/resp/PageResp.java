package com.ibegu.dalao.resp;

import java.util.List;

//返回一个列表 不确定类型（电子书 用户等等）--用泛型
public class PageResp<T> {
    //总行数
    private long total;

    //列表数据
    private List<T> list;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "PageResp{" +
                "total=" + total +
                ", list=" + list +
                '}';
    }
}