package com.giit.www.entity.custom;

import com.giit.www.entity.Course;

/**
 * @Author:nocol
 */

public class CourseCustom extends Course{

    //����ѧԺ��
    private String deptName;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
