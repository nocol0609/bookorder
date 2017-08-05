package com.giit.www.college.service;

import com.giit.www.entity.Course;

import java.util.List;

/**
 * 业务接口
 * @author Nocol
 *
 */
public interface CourseBiz {
    public List<Course> findAll();

    public List<String> findAllSpecName();

    public void add(Course course);

    public void delete(String courseTitle);
}
