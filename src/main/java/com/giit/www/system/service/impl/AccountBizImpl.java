package com.giit.www.system.service.impl;

import com.giit.www.entity.User;
import com.giit.www.system.dao.UserDao;
import com.giit.www.system.service.AccountBiz;
import com.giit.www.util.PasswordHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 账号业务实现类
 * @author Nocol
 *
 */
@Service
public class AccountBizImpl implements AccountBiz {

    @Resource
    UserDao userDao;

    @Resource
    private PasswordHelper passwordHelper;

    @Override
    public User findByIdAndPassword(String username, String password) {
        return userDao.findByIdAndPassword(username, password);
    }


    @Override
    public void updatePassword(String userId, String password) {
        User user = userDao.findById(userId);
        user.setPassword(password);
        passwordHelper.encryptPassword(user);
        userDao.updatePassword(userId, user.getPassword(),user.getSalt());
    }
}
