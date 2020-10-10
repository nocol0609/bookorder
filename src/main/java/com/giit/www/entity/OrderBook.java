package com.giit.www.entity;

/**
 * 需要订购的书
 * @author Nocol
 *
 */
public class OrderBook {
    String staffNo;     //
    String DateOfPrinting;
    String bookTitle;   //教材名
    String isbn;        //教材便编号
    String remark;
    int secId;          //所属课程id
    boolean approval;   //订购的数量

    public String getDateOfPrinting() {
        return DateOfPrinting;
    }

    public void setDateOfPrinting(String dateOfPrinting) {
        DateOfPrinting = dateOfPrinting;
    }

    public String getStaffNo() {
        return staffNo;
    }

    public void setStaffNo(String staffNo) {
        this.staffNo = staffNo;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getSecId() {
        return secId;
    }

    public void setSecId(int secId) {
        this.secId = secId;
    }

    public boolean isApproval() {
        return approval;
    }

    public void setApproval(boolean approval) {
        this.approval = approval;
    }
}
