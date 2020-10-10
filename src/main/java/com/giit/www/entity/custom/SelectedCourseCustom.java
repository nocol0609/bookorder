package com.giit.www.entity.custom;

/**
 * @Author:nocol
 */

public class SelectedCourseCustom {

    private String courseTitle; //课程名称

    private String staffName; //授课教师

    private String year; //学年

    private String type;

    private String credits;

    private String limitCount;

    private String score; //成绩

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getLimitCount() {
        return limitCount;
    }

    public void setLimitCount(String limitCount) {
        this.limitCount = limitCount;
    }

    public String getCredits() {
        return credits;
    }

    public void setCredits(String credits) {
        this.credits = credits;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getYear() {

        String y=year.substring(0,4)+"-"+year.substring(4);
        return y;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }
}
