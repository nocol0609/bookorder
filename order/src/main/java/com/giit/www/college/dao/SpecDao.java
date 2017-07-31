package com.giit.www.college.dao;

import com.giit.www.entity.Spec;
import com.giit.www.entity.custom.DeptAndSpec;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 持久层接口
 * @author Nocol
 *
 */
public interface SpecDao {
    public List<Spec> findAll();

    public void update(@Param("specName") String specName, @Param("newSpecName") String newSpecName);

    public void add(Spec spec);

    public void delete(String specName);

    public List<DeptAndSpec> findDeptAndSpec();

    public String findIdByName(String specName);

    public List<String> findAllSpecName();
}
