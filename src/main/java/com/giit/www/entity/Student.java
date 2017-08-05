package com.giit.www.entity;

/**
 * 学生类
 * 
 * @author Nocol
 *
 */
public class Student {
	String studentId;
	String studentName;
	String password;
	String idCard;
	String year;
	String className;
	String telephoneNumber;
	String studentOriginBase; // 生源地
	String gender;

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getTelephoneNumber() {
		return telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}

	public String getStudentOriginBase() {
		return studentOriginBase;
	}

	public void setStudentOriginBase(String studentOriginBase) {
		this.studentOriginBase = studentOriginBase;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
