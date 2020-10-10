package com.giit.www.college.dao;

import com.giit.www.entity.Takes;
import com.giit.www.entity.custom.SelectedCourseCustom;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * ³Ö¾Ã²ã½Ó¿Ú
 * @author Nocol
 *
 */
public interface TakesDao {
    public int getStdCountInSection(int secId);

    public void add(@Param("secId") int secId, @Param("stdId") String stdId);

    public void delete(@Param("secId") int secId, @Param("stdId") String stdId);

    List<SelectedCourseCustom> findStudentAndSelectCourseListByName(String studentId);

    List<SelectedCourseCustom> findHasPlayedCourse(String studentId);

    Takes findTakesByStuIdAndSecId(@Param("studentId") String studentId, @Param("secId") int secId);

}
