package com.giit.www.college.dao;

import com.giit.www.entity.Staff;

import java.util.List;

/**
 * ³Ö¾Ã²ã½Ó¿Ú
 * @author Nocol
 *
 */
public interface StaffDao {
    public List<String> findAllName();

    public String findIdByName(String staffId);

    public List<Staff> findAll();

    void add(Staff staff);
}
