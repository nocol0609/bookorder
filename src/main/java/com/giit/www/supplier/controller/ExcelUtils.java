package com.giit.www.supplier.controller;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExcelUtils {
	public static String getCellValue(Cell cell) {
        String ret="";  
        if(cell!=null){        	
        	switch (cell.getCellType()) {  
        	case Cell.CELL_TYPE_BLANK:
        		ret = "";  
        		break;  
        	case Cell.CELL_TYPE_BOOLEAN:
        		ret = String.valueOf(cell.getBooleanCellValue());  
        		break;  
        	case Cell.CELL_TYPE_ERROR:
        		ret = null;  
        		break;  
        	case Cell.CELL_TYPE_FORMULA:
        		Workbook wb = cell.getSheet().getWorkbook();
        		CreationHelper crateHelper = wb.getCreationHelper();
        		FormulaEvaluator evaluator = crateHelper.createFormulaEvaluator();
        		ret = getCellValue(evaluator.evaluateInCell(cell));  
        		break;  
        	case Cell.CELL_TYPE_NUMERIC:
        		if (DateUtil.isCellDateFormatted(cell)) {
        			Date theDate = cell.getDateCellValue();  
        			ret = new SimpleDateFormat("yyyy-MM-dd").format(theDate);  
        		} else {   
        			ret = NumberToTextConverter.toText(cell.getNumericCellValue());
        		}  
        		break;  
        	case Cell.CELL_TYPE_STRING:
        		ret = cell.getRichStringCellValue().getString();  
        		break;  
        	default:  
        		ret = "";  
        	}  
        }
        return ret.trim();  
    }
	public static Object getCellValueObj(Cell cell) {
		if (cell == null) {
			return null;
		}
		Object ret=null;       	
		switch (cell.getCellType()) {  
		case Cell.CELL_TYPE_BLANK:
		case Cell.CELL_TYPE_ERROR: break;
		case Cell.CELL_TYPE_BOOLEAN:
			ret=cell.getBooleanCellValue(); 
			break;  
		case Cell.CELL_TYPE_FORMULA:
			Workbook wb = cell.getSheet().getWorkbook();
			CreationHelper crateHelper = wb.getCreationHelper();
			FormulaEvaluator evaluator = crateHelper.createFormulaEvaluator();
			ret = getCellValue(evaluator.evaluateInCell(cell));  
			break;  
		case Cell.CELL_TYPE_NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				Date theDate = cell.getDateCellValue();  
				ret = new SimpleDateFormat("yyyy-MM-dd").format(theDate);  
			} else {   
				ret = NumberToTextConverter.toText(cell.getNumericCellValue());
			}  
			break;  
		case Cell.CELL_TYPE_STRING:
			ret = cell.getRichStringCellValue().getString();  
			break;
		default:
		}  
        return ret;  
    }
	public static String encodeFilename(String filename) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < filename.length(); i++) {
			char c = filename.charAt(i);
			if (c >= 0 && c <= 255) {
				sb.append(c);
			} else {
				byte[] b;
				try {
					b = Character.toString(c).getBytes("utf-8");
				} catch (Exception ex) {
					b = new byte[0];
				}
				for (int j = 0; j < b.length; j++) {
					int k = b[j];
					if (k < 0)
						k += 256;
					sb.append("%" + Integer.toHexString(k).toUpperCase());
				}
			}
		}
		return sb.toString();
	}
	public static HSSFCellStyle getHSSFCellStyle(HSSFWorkbook workbook){
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		HSSFFont font = workbook.createFont();
		font.setFontName("宋体");
		font.setFontHeightInPoints((short) 9);
		cellStyle.setFont(font);
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		cellStyle.setFillForegroundColor(HSSFColor.YELLOW.index);
		cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 下边框
		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 左边框
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);// 上边框
		cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);// 右边框
		return cellStyle;
	}
	public static XSSFCellStyle getXSSFCellStyle(XSSFWorkbook workbook){
		XSSFCellStyle cellStyle = workbook.createCellStyle();
		XSSFFont font = workbook.createFont();
		font.setFontName("宋体");
		font.setFontHeightInPoints((short) 9);
		cellStyle.setFont(font);
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		cellStyle.setFillForegroundColor(HSSFColor.YELLOW.index);
		cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN); // 下边框
		cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);// 左边框
		cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);// 上边框
		cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);// 右边框
		return cellStyle;
	}
}
