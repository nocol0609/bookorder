package com.giit.www.supplier.service;

import com.giit.www.entity.custom.ReviewedBookVo;

import java.util.List;

/**
 * 
 * @author Nocol
 *
 */
public interface SupplierBiz {
    public List<ReviewedBookVo> findAllReviewedBook();
}
