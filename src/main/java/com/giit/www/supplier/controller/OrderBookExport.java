package com.giit.www.supplier.controller;

import com.giit.www.entity.custom.ReviewedBookVo;
import com.giit.www.supplier.service.SupplierBiz;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * @author  Nocol
 */

public class OrderBookExport extends AbstractExcelView {

    private SupplierBiz supplierBiz;

    public SupplierBiz getSupplierBiz() {
        return supplierBiz;
    }

    public void setSupplierBiz(SupplierBiz supplierBiz) {
        this.supplierBiz = supplierBiz;
    }

    @Override
    protected void buildExcelDocument(Map<String, Object> map, HSSFWorkbook Workbook, HttpServletRequest httpServletRequest, HttpServletResponse response) throws Exception {

        List<ReviewedBookVo> reviewedBookVoList=supplierBiz.findAllReviewedBook();
        addOrderBookSheet(reviewedBookVoList,Workbook);

        String fielName="书单采购列表.xls";
        response.reset();
        response.setContentType("application/vnd.ms-excel;charset=gb2312");
        response.setHeader("Content-Disposition", "attachment;filename=" +ExcelUtils.encodeFilename(fielName));
        OutputStream ouputStream = response.getOutputStream();
        Workbook.write(ouputStream);
        ouputStream.flush();
        ouputStream.close();
    }

    private void addOrderBookSheet(List<ReviewedBookVo> reviewedBookVoList, HSSFWorkbook workbook) throws Exception {
        int rowNum=0;
        HSSFSheet sheet=workbook.createSheet();
        workbook.setSheetName(0,"书单采购列表");
        HSSFCellStyle cellStyle=ExcelUtils.getHSSFCellStyle(workbook);
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        sheet.setColumnWidth(0,5000);
        sheet.setColumnWidth(1, 5000);
        sheet.setColumnWidth(2, 7000);
        sheet.setColumnWidth(3, 3000);
        sheet.setColumnWidth(4, 5000);
        sheet.setColumnWidth(5, 5000);
        HSSFRow row=sheet.createRow(rowNum);
        HSSFCell cell=null;
        String[] column = {"书名","图书编号","印刷日期","作者","出版社","采购数量"};
        for (int i = 0; i < column.length; i++) {
            cell = row.createCell(i);
            cell.setCellValue(column[i]);
            cell.setCellStyle(cellStyle);
            cell.setCellType(HSSFCell.ENCODING_UTF_16);
        }

        for(int i=0;i<reviewedBookVoList.size();i++){
            ReviewedBookVo reviewedBookVo=reviewedBookVoList.get(i);
            row=sheet.createRow(i+1);
            cell=row.createCell(0);
            if (reviewedBookVo.getBookTitle()!=null && reviewedBookVo.getBookTitle()!= ""){
                cell.setCellValue(reviewedBookVo.getBookTitle());
            }
            cell=row.createCell(1);
            if (reviewedBookVo.getIsbn()!=null){
                cell.setCellValue(reviewedBookVo.getIsbn());
            }

            cell=row.createCell(2);
            if (reviewedBookVo.getDateOfPrinting()!=null){
                cell.setCellValue(reviewedBookVo.getDateOfPrinting());
            }
            cell=row.createCell(3);
            if (reviewedBookVo.getAuthor()!=null){
                cell.setCellValue(reviewedBookVo.getAuthor());
            }
            cell=row.createCell(4);
            if (reviewedBookVo.getPress()!=null){
                cell.setCellValue(reviewedBookVo.getPress());
            }

            cell=row.createCell(5);
            if (reviewedBookVo.getCount()!=-1){
                cell.setCellValue(reviewedBookVo.getCount());
            }
        }
    }
}
