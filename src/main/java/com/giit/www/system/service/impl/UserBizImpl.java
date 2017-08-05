package com.giit.www.system.service.impl;

import com.giit.www.college.dao.StaffDao;
import com.giit.www.entity.Role;
import com.giit.www.entity.Staff;
import com.giit.www.entity.User;
import com.giit.www.entity.custom.UserVo;
import com.giit.www.system.dao.RoleDao;
import com.giit.www.system.dao.UserDao;
import com.giit.www.system.service.RoleBiz;
import com.giit.www.system.service.UserBiz;
import com.giit.www.util.PasswordHelper;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

/**
 * 用户管理业务实现类
 * @author Nocol
 *
 */

@Service
public class UserBizImpl implements UserBiz {

    @Resource
    UserDao userDao;

    @Resource
    RoleDao roleDao;

    @Resource
    StaffDao staffDao;

    @Resource
    private PasswordHelper passwordHelper;
    @Resource(name = "roleBizImpl")
    private RoleBiz roleBiz;

    @Override
    public List<UserVo> findAll() throws InvocationTargetException, IllegalAccessException {
        List<UserVo> userVoList = new ArrayList<>();
        List userList = userDao.findAll();


        Iterator iterator = userList.iterator();

        while (iterator.hasNext()) {
            StringBuilder s = new StringBuilder();
            User user = (User) iterator.next();
            List<Long> roleIds = user.getRoleIds();

            UserVo userVo = new UserVo();
            BeanUtils.copyProperties(userVo, user);

            if (roleIds != null) {
                int i = 0;
                int size = roleIds.size();
                for (; i < size - 1; i++) {
                    Role role = roleDao.findOne(roleIds.get(i));

                    s.append(role.getDescription());
                    s.append(",");
                }
                Role role = roleDao.findOne(roleIds.get(i));
                s.append(role.getDescription());
                userVo.setRoleIdsStr(s.toString());
            }


            userVoList.add(userVo);

        }

        return userVoList;
    }

    @Override
    public User findById(String id) {
        return userDao.findById(id);
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    public void add(User user) {
        //TODO 这里为了完成功能直接按照权限判断添加到staff中,应该新增一个前端页面,进行教师的管理- -
    	
    	//将用户密码加密 -------salt=username+salt
        passwordHelper.encryptPassword(user);
        //添加用户
        userDao.add(user);    //填充用户RoleId的占位符由重写的RoleId分割方法填充
        
        /**
         * 下面是添加老师用户时，将老师插入到任课老师的表内
         */
        String id = user.getUserId();  //admin、student、teacher、supplier
        String teacherRoleId = roleDao.findByDescription("老师").getId().toString();
        
        //获取用户RoleId与Role表中老师的id对比，若相同说明新添加的用户角色是老师，添加进Staff表内
        if (user.getRoleIdsStr().indexOf(teacherRoleId) != -1) {
            Staff staff = new Staff();
            staff.setStaffId(id);
            staff.setStaffName(id);
            staffDao.add(staff);
        }


    }

    //TODO 删除staff和student连带的功能未完成
    @Transactional
    @Override
    public void delete(String id) {
        userDao.delete(id);
    }

    @Override
    public void changePassword(String userId, String newPassword) {
        User user = userDao.findById(userId);
        user.setPassword(newPassword);
        passwordHelper.encryptPassword(user);
        userDao.update(user);

    }

    @Override
    public User findByUsername(String username) {
        return userDao.findById(username);
    }

    @Override
    public Set<String> findRoles(String username) {
        User user = findByUsername(username);
        if (user == null) {
            return Collections.EMPTY_SET;
        }
        return roleBiz.findRoles(user.getRoleIds().toArray(new Long[0]));
    }

    @Override
    public Set<String> findPermissions(String username) {
        User user = findByUsername(username);
        if (user == null) {
            return Collections.EMPTY_SET;
        }
        return roleBiz.findPermissions(user.getRoleIds().toArray(new Long[0]));
    }
}

