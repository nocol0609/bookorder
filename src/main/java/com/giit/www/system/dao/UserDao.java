package com.giit.www.system.dao;

import com.giit.www.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户相关接口
 * @author Nocol
 *
 */
public interface UserDao {
    public List<User> findAll();

    public User findById(String id);

    public void update(User user);

    public void add(User user);

    public void delete(String id);

    public User findByIdAndPassword(@Param("id") String username, @Param("password") String password);

    public void updatePassword(@Param("userId") String id, @Param("password") String password,@Param("salt") String salt);

    User findByUsername(String username);
}
