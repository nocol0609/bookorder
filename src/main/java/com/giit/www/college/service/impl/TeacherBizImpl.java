package com.giit.www.college.service.impl;

import com.giit.www.college.dao.TeacherDao;
import com.giit.www.college.service.TeacherBiz;
import com.giit.www.entity.Teacher;
import com.giit.www.entity.User;
import com.giit.www.entity.custom.MarkVo;
import com.giit.www.entity.custom.TeachedCourseVo;
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
public class TeacherBizImpl implements TeacherBiz {

    @Resource
    private RoleDao roleDao;
    
    @Resource
    private UserDao userDao;

    @Resource
    private TeacherDao teacherDao;

    @Resource(name = "userBizImpl")
    private UserBiz userBiz;

    public List<Teacher> teacherView() {
        return teacherDao.findAll();
    }

    @Override
    public void add(Teacher teacher) {
        try {
            //添加到教师列表
            teacherDao.add(teacher);

            //将教师同时添加到用户列表
            User user = new User();

            //将教师学号作为教师的登录账号
            user.setUserId(teacher.getStaffNo());
            Long roleId = roleDao.findByDescription("老师").getId();
            ArrayList<Long> tempList = new ArrayList<>();
            tempList.add(roleId);
            user.setRoleIds(tempList);
            user.setLocked(false);
            user.setPassword(teacher.getPassword());
            userBiz.add(user);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void update(Teacher teacher) {
        teacherDao.update(teacher);
    }

    //TODO 
    @Transactional
    @Override
    public void delete(String staffNo) {
    	//从教师列表删除
        teacherDao.delete(staffNo);
        //从用户列表删除
        User user = userDao.findById(staffNo);
        if(user!=null){
        	userDao.delete(staffNo);
        }
    }

    @Override
    public Teacher findTeacherByStaffNo(String staffNo) {
        return teacherDao.findTeacherByStaffNo(staffNo);
    }

    @Override
    public List<TeachedCourseVo> findTeachedCourse(String staffId) {
        return teacherDao.findTeachedCourse(staffId);
    }

    @Override
    public List<MarkVo> findStudentMarkBySecId(String secId) {
        return teacherDao.findStudentMarkBySecId(secId);
    }

    @Override
    public void updateStudentMark(MarkVo markVo) {
        teacherDao.updateStudentMark(markVo);
    }

}
