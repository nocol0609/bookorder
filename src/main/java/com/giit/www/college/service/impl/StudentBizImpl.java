package com.giit.www.college.service.impl;

import com.giit.www.college.dao.StudentDao;
import com.giit.www.college.service.StudentBiz;
import com.giit.www.entity.Student;
import com.giit.www.entity.User;
import com.giit.www.system.dao.RoleDao;
import com.giit.www.system.dao.UserDao;
import com.giit.www.system.service.UserBiz;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

/**
 * 业务层实现类
 * @author Nocol
 *
 */
@Service
public class StudentBizImpl implements StudentBiz {
    @Resource
    private StudentDao studentDao;

    @Resource
    private RoleDao roleDao;
    
    @Resource
    private UserDao userDao;

    @Resource(name = "userBizImpl")
    private UserBiz userBiz;

    public List<Student> studentView() {
        return studentDao.findAll();
    }

    @Transactional
    public void add(Student student) {
    	
    	try {
			//添加到学生列表
			studentDao.add(student);
			
			//将学生同时添加到用户列表
			User user = new User();
			
			//将学生学号作为学生的登录账号
			user.setUserId(student.getStudentId());
			Long roleId = roleDao.findByDescription("学生").getId();
			ArrayList<Long> tempList = new ArrayList<>();
			tempList.add(roleId);
			user.setRoleIds(tempList);
			user.setLocked(false);
			user.setPassword(student.getPassword());
			userBiz.add(user);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @Override
    public void update(Student student) {
        studentDao.update(student);
    }

    //TODO 
    @Transactional
    @Override
    public void delete(String studentId) {
    	//从学生列表删除
        studentDao.delete(studentId);
        //从用户列表删除
        User user = userDao.findById(studentId);
        if(user!=null){
        	userDao.delete(studentId);
        }
    }

}
