package com.giit.www.entity.custom;

import com.giit.www.entity.Section;
import com.giit.www.entity.Timetable;

import java.util.List;

/**
 * 
 * @author Nocol
 *
 */
//TODO 
public class SectionCustom extends Section {
    String teacher;

    String time;  //第几节课
    String weeks; //周次
    String week;  //星期几
    String classroom; //教室

    private List<Timetable> timetableList;

    public List<Timetable> getTimetableList() {
        return timetableList;
    }

    public void setTimetableList(List<Timetable> timetableList) {
        this.timetableList = timetableList;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getWeeks() {
        return weeks;
    }

    public void setWeeks(String weeks) {
        this.weeks = weeks;
    }
}
