package com.giit.www.college.dao;

import com.giit.www.entity.Course;

import java.util.List;

/**
 * 持久层接口
 * @author Nocol
 *
 */
public interface CourseDao {
    public List<Course> findAll();

    public void add(Course course);

    public void delete(String courseTitle);

    public List<String> findAllCourseTitle();
}
