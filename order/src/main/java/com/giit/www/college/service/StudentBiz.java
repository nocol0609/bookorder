package com.giit.www.college.service;

import com.giit.www.entity.Student;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * 业务层接口
 * @author Nocol
 *
 */

public interface StudentBiz {
    public List<Student> studentView();

    public void add(Student student, MultipartFile pic) throws IOException;

    public void update(Student student);

    public void delete(int studentId);
}
