package com.giit.www.system.service;

import com.giit.www.entity.User;

/**
 * 账号相关业务接口
 * @author Nocol
 *
 */
public interface AccountBiz {

    public User findByIdAndPassword(String username, String password);

    public void updatePassword(String id, String password);
}
