package com.giit.www.entity.custom;

import java.util.List;

/**
 * 
 * @author Nocol
 *
 */
//TODO
public class AddedBookVo {
    String secId;
    String courseTitle;  //

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    List<BookInfo> bookInfoList;

    public String getSecId() {
        return secId;
    }

    public void setSecId(String secId) {
        this.secId = secId;
    }

    public List<BookInfo> getBookInfoList() {
        return bookInfoList;
    }

    public void setBookInfoList(List<BookInfo> bookInfoList) {
        this.bookInfoList = bookInfoList;
    }
}
