package com.giit.www.college.service;

import com.giit.www.entity.Dept;

import java.util.List;

/**
 * 业务层接口
 * @author Nocol
 *
 */
public interface DeptBiz {
    public List<Dept> findAll();

    public void add(String deptName);

    public void update(String deptId,String deptName);

    public void delete(int deptId);

}
