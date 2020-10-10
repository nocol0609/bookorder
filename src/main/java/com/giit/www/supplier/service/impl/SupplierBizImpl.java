package com.giit.www.supplier.service.impl;

import com.giit.www.college.dao.OrderBookDao;
import com.giit.www.entity.custom.ReviewedBookVo;
import com.giit.www.supplier.service.SupplierBiz;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 
 * @author Nocol
 *
 */
@Service
public class SupplierBizImpl implements SupplierBiz {

    @Resource
    private OrderBookDao orderBookDao;

    @Override
    public List<ReviewedBookVo> findAllReviewedBook() {
        List<ReviewedBookVo> reviewedBookVoList = orderBookDao.findAllReviewedBook();
        return reviewedBookVoList;
    }

}
