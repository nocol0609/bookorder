package com.giit.www.college.service;

import com.giit.www.entity.Student;

import java.util.List;

/**
 * 业务层接口
 * @author Nocol
 *
 */

public interface StudentBiz {
    public List<Student> studentView();

    public void add(Student student);

    public void update(Student student);

    public void delete(String studentId);

    Student findStudentByStudentId(String studentId);
}
