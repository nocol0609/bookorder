package com.giit.www.student.service;

import com.giit.www.entity.Student;
import com.giit.www.entity.Takes;
import com.giit.www.entity.custom.SectionCustom;
import com.giit.www.entity.custom.SelectedCourseCustom;

import java.util.List;

/**
 * 
 * @author Nocol
 *
 */
public interface ElectiveBiz {
    public void add(int secId, String stdId);

    public List<SectionCustom> findAllSection();

    public void delete(int secId, String stdId);

    Student findStudentByStudentId(Object principal);

    List<SelectedCourseCustom> findStudentAndSelectCourseListByName(String principal);

    List<SelectedCourseCustom> findHasPlayedCourse(String principal);

    Takes findTakesByStuIdAndSecId(String studentId, int secId);

}
