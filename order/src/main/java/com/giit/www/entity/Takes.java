package com.giit.www.entity;

/**
 * 成绩录入
 * @author Nocol
 *
 */
public class Takes {
    String studentId;  //学生ID
    String secId;      //专业id
    float score;       //学分

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getSecId() {
        return secId;
    }

    public void setSecId(String secId) {
        this.secId = secId;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
}
