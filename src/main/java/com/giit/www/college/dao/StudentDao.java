package com.giit.www.college.dao;

import com.giit.www.entity.Student;

import java.util.List;

import org.apache.ibatis.annotations.Param;

/**
 * 持久层接口
 * @author Nocol
 *
 */
public interface StudentDao {
    public List<Student> findAll();

    public void add(Student student);

    public void update(Student student);

    public void delete(@Param(value="studentId") String studentId);
}
