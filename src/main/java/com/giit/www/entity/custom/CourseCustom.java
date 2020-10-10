package com.giit.www.entity.custom;

import com.giit.www.entity.Course;

/**
 * @Author:nocol
 */

public class CourseCustom extends Course{

    //所属学院名
    private String deptName;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
