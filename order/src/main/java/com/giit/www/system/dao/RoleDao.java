package com.giit.www.system.dao;


import com.giit.www.entity.Role;

import java.util.List;

/**
 * 角色相关接口
 * @author Nocol
 *
 */
public interface RoleDao {

    public void createRole(Role role);

    public void updateRole(Role role);

    public void deleteRole(Long roleId);

    public Role findOne(Long roleId);

    public Role findByDescription(String description);

    public List<Role> findAll();
}
