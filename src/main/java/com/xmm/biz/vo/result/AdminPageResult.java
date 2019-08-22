package com.xmm.biz.vo.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(description = "分页信息返回")
public class AdminPageResult<T> implements Serializable {

    private static final long serialVersionUID = -7359291291321323382L;

    @ApiModelProperty(value="页码",position=1)
    private int pageNum;
    @ApiModelProperty(value="每页条数",position=2)
    private int pageSize;
    @ApiModelProperty(value="总条数",position=3)
    private long total;
    @ApiModelProperty(value="总页数",position=4)
    private int pages;
    @ApiModelProperty(value="数据",position=5)
    private List<T> list;
    @ApiModelProperty(value="上一页页码",position=6)
    private int prePage;
    @ApiModelProperty(value="下一页页码",position=7)
    private int nextPage;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getPrePage() {
        return prePage;
    }

    public void setPrePage(int prePage) {
        this.prePage = prePage;
    }

    public int getNextPage() {
        return nextPage;
    }

    public void setNextPage(int nextPage) {
        this.nextPage = nextPage;
    }

}
