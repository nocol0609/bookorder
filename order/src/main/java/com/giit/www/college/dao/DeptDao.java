package com.giit.www.college.dao;

import com.giit.www.entity.Dept;

import java.util.List;

/**
 * 持久层接口
 * @author Nocol
 *
 */
public interface DeptDao {
    public List<Dept> findAll();

    public void add(String deptName);

    public String findIdByName(String deptName);

    public void update(Dept dept);

    public void delete(int deptId);

    public List<String> findAllDeptName();

}
