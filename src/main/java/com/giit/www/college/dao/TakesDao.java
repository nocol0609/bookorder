package com.giit.www.college.dao;

import org.apache.ibatis.annotations.Param;

/**
 * ³Ö¾Ã²ã½Ó¿Ú
 * @author Nocol
 *
 */
public interface TakesDao {
    public int getStdCountInSection(int secId);

    public void add(@Param("secId") int secId, @Param("stdId") String stdId);

    public void delete(@Param("secId") int secId, @Param("stdId") String stdId);
}
