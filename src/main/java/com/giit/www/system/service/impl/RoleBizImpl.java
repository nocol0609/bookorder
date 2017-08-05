package com.giit.www.system.service.impl;

import com.giit.www.entity.Role;
import com.giit.www.system.dao.RoleDao;
import com.giit.www.system.service.ResourceBiz;
import com.giit.www.system.service.RoleBiz;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 角色管理业务实现类
 * @author Nocol
 *
 */
@Service
public class RoleBizImpl implements RoleBiz {

    @Resource
    private RoleDao roleDao;
    @Resource(name = "resourceBizImpl")
    private ResourceBiz resourceBiz;

    public void createRole(Role role) {
        roleDao.createRole(role);
    }

    public void updateRole(Role role) {
         roleDao.updateRole(role);
    }

    public void deleteRole(Long roleId) {
        roleDao.deleteRole(roleId);
    }

    @Override
    public Role findOne(Long roleId) {
        return roleDao.findOne(roleId);
    }

    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public Set<String> findRoles(Long... roleIds) {
        Set<String> roles = new HashSet<String>();
        for (Long roleId : roleIds) {
        	//根据角色id查询角色
            Role role = findOne(roleId);
            if (role != null) {
                roles.add(role.getRole());
            }
        }
        return roles;
    }

    @Override
    public Set<String> findPermissions(Long[] roleIds) {
        Set<Long> resourceIds = new HashSet<Long>();
        for (Long roleId : roleIds) {
            Role role = findOne(roleId);
            if (role != null) {
                resourceIds.addAll(role.getResourceIds());
            }
        }
        return resourceBiz.findPermissions(resourceIds);
    }
}
