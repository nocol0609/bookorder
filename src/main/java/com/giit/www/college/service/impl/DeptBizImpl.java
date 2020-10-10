package com.giit.www.college.service.impl;

import com.giit.www.college.dao.DeptDao;
import com.giit.www.college.service.DeptBiz;
import com.giit.www.entity.Dept;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 业务实现类
 * @author Nocol
 *
 */

@Service
public class DeptBizImpl implements DeptBiz {
    @Resource
    private DeptDao deptDao;

    public List<Dept> findAll() {
        return deptDao.findAll();
    }

    public void add(String deptName) {
        deptDao.add(deptName);
    }

    public void update(String deptId, String deptName) {
        deptDao.update(deptId,deptName);
    }

    public void delete(int deptId) {
        deptDao.delete(deptId);
    }

}
