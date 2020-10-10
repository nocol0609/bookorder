package com.giit.www.student.service.Impl;

import com.giit.www.college.dao.SectionDao;
import com.giit.www.college.dao.TakesDao;
import com.giit.www.entity.Student;
import com.giit.www.entity.Takes;
import com.giit.www.entity.custom.SectionCustom;
import com.giit.www.entity.custom.SelectedCourseCustom;
import com.giit.www.student.service.ElectiveBiz;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ElectiveBizImpl implements ElectiveBiz {

    @Resource
    private TakesDao takesDao;

    @Resource
    private SectionDao sectionDao;

    public void add(int secId, String stdId) {
        takesDao.add(secId, stdId);
    }

    @Override
    public List<SectionCustom> findAllSection() {
        return sectionDao.findAllCustom();
    }

    @Override
    public void delete(int secId, String stdId) {
        takesDao.delete(secId,stdId);
    }

    @Override
    public Student findStudentByStudentId(Object principal) {
        return null;
    }

    @Override
    public List<SelectedCourseCustom> findStudentAndSelectCourseListByName(String studentId) {
        return takesDao.findStudentAndSelectCourseListByName(studentId);
    }

    @Override
    public List<SelectedCourseCustom> findHasPlayedCourse(String studentId) {
        return takesDao.findHasPlayedCourse(studentId);
    }

    @Override
    public Takes findTakesByStuIdAndSecId(String studentId, int secId) {
        return takesDao.findTakesByStuIdAndSecId(studentId,secId);
    }

}
