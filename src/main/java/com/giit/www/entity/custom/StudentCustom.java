package com.giit.www.entity.custom;

import com.giit.www.entity.Student;

import java.util.List;

/**
 * @Author:nocol
 */
public class StudentCustom extends Student {

    //所属学院名
    private String deptName;

    //选课列表
    private List<SelectedCourseCustom> selectedCourseList;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<SelectedCourseCustom> getSelectedCourseList() {
        return selectedCourseList;
    }

    public void setSelectedCourseList(List<SelectedCourseCustom> selectedCourseList) {
        this.selectedCourseList = selectedCourseList;
    }
}
