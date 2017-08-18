package com.ptp.usermanage.bean;

import java.io.Serializable;
import java.util.List;

public class ResultCount implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private Long total; // 总条数
    private List<?> rows;
 
    private Integer status;  // 响应业务状态
    
    //构造方法
    public ResultCount(){
        
    }
    public ResultCount(Long total, List<?> rows) {
        super();
        this.total = total;
        this.rows = rows;
        this.status = 200;
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
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
