package com.giit.www.entity;

/**
 * 课程类
 * @author Nocol
 *
 */
public class Course {
    String courseTitle; //课程名称
    String type;
    String speciality;  //所属专业
    float credits; //学分

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public float getCredits() {
        return credits;
    }

    public void setCredits(float credits) {
        this.credits = credits;
    }
}
