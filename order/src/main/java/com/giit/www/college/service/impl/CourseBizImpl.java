package com.giit.www.college.service.impl;

import com.giit.www.college.dao.CourseDao;
import com.giit.www.college.dao.SpecDao;
import com.giit.www.college.service.CourseBiz;
import com.giit.www.entity.Course;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 业务实现类
 * @author Nocol
 *
 */
@Service
public class CourseBizImpl implements CourseBiz {

    @Resource
    private CourseDao courseDao;

    @Resource
    private SpecDao specDao;

    @Override
    public List<Course> findAll() {
        return courseDao.findAll();
    }

    @Override
    public List<String> findAllSpecName() {
        return specDao.findAllSpecName();
    }

    @Override
    public void add(Course course) {
        courseDao.add(course);
    }

    @Override
    public void delete(String courseTitle) {
        courseDao.delete(courseTitle);
    }
}
