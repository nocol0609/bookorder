package com.giit.www.college.dao;

import com.giit.www.entity.Teacher;
import com.giit.www.entity.custom.MarkVo;
import com.giit.www.entity.custom.TeachedCourseVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 持久层接口
 * @author Nocol
 *
 */
public interface TeacherDao {
    public List<Teacher> findAll();

    public void add(Teacher teacher);

    public void update(Teacher teacher);

    public void delete(@Param(value = "staffNo") String staffNo);

    Teacher findTeacherByStaffNo(String staffNo);

    List<TeachedCourseVo> findTeachedCourse(String staffId);

    List<MarkVo> findStudentMarkBySecId(String secId);

    void insertStudentMark(String score);

    void updateStudentMark(MarkVo markVo);
}
