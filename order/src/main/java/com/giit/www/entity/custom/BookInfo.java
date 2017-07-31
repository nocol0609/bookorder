package com.giit.www.entity.custom;

import com.giit.www.entity.Book;

/**
 * 
 * @author Nocol
 *
 */
public class BookInfo extends Book {
    String remark;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
