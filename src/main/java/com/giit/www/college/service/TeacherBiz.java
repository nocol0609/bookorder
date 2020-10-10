package com.giit.www.college.service;

import com.giit.www.entity.Teacher;
import com.giit.www.entity.custom.MarkVo;
import com.giit.www.entity.custom.TeachedCourseVo;

import java.util.List;

/**
 * 业务层接口
 * @author Nocol
 *
 */

public interface TeacherBiz {
    public List<Teacher> teacherView();

    public void add(Teacher teacher);

    public void update(Teacher teacher);

    public void delete(String staffNo);

    Teacher findTeacherByStaffNo(String staffNo);

    List<TeachedCourseVo> findTeachedCourse(String staffId);

    List<MarkVo> findStudentMarkBySecId(String secId);

    void updateStudentMark(MarkVo markVo);
}
