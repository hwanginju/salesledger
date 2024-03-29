package com.iyf.salesledger.common.file;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.iyf.salesledger.common.model.CustomMap;
import com.iyf.salesledger.common.utils.DateUtils;
import com.iyf.salesledger.common.utils.MapUtils;

import lombok.extern.log4j.Log4j2;


@Component @Log4j2
public class ExcelUtils {
    @Value("${upload-dir}")
    private String uploadDir; // Path to your upload directory (configured in application.properties)

    /***
     * @기능 엑셀 데이터를 자바맵으로 변환
     * @param file
     * @return
     */
    public CustomMap convertExceltoMap(MultipartFile file) {
    	if (log.isInfoEnabled()) {log.info("ExcelUtils.convertExceltoMap ::: uploadDir ::: " + uploadDir);}
    	if (log.isInfoEnabled()) {log.info("ExcelUtils.convertExceltoMap ::: file.getOriginalFilename ::: " + file.getOriginalFilename());}
    	
    	CustomMap returnMap = new CustomMap();
    	
        if (file.isEmpty()) {
        	if (log.isInfoEnabled()) {log.info("ExcelUtils.convertExceltoMap ::: file.isEmpty");}
            return returnMap;
        }

        try (Workbook workbook = WorkbookFactory.create(file.getInputStream())) {
            Sheet sheet = workbook.getSheetAt(0); // Assuming you have only one sheet

            Iterator<Row> rowIterator = sheet.iterator();
            List<String> headers = new ArrayList<>();
            List<CustomMap> dataList = new ArrayList<>();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();

                CustomMap rowData = new CustomMap();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();

                    if (row.getRowNum() == 0) {
                        // The first row contains headers
                        headers.add(cell.toString());
                    } else {
                        // Data rows
                    	String key = headers.get(cell.getColumnIndex());
						if (cell.getCellType() == CellType.NUMERIC) {// Numeric cell type (whole numbers, fractional numbers, dates)
                    		if (DateUtil.isCellDateFormatted(cell)) {
                    			Date cellValue = cell.getDateCellValue();
                    			String value = DateUtils.formatObject(cellValue, "yyyy-MM-dd");
                            	rowData.put(key, value);

                    		} else {
                    			double value = cell.getNumericCellValue();
								rowData.put(key, value);
                    		}
                    	} else {
                    		String cellValue = cell.getStringCellValue();
                    		rowData.put(key, cellValue);
                    	}
                    }
                }

                if (!MapUtils.areAllPropertiesNullOrEmpty(rowData)) {
                    dataList.add(rowData);
                }
            }

            // Delete the uploaded file
            File uploadedFile = new File(uploadDir + file.getOriginalFilename());
            if (uploadedFile.delete()) {
            	if (log.isInfoEnabled()) {log.info("ExcelUtils.convertExceltoMap ::: uploadedFile.delete ::: true");}
            } else {
            	if (log.isInfoEnabled()) {log.info("ExcelUtils.convertExceltoMap ::: uploadedFile.delete ::: false");}
            }
            returnMap.put("sheetName", sheet.getSheetName());
            returnMap.put("headerList", headers);
            returnMap.put("dataList", dataList);
            if (log.isInfoEnabled()) {log.info("ExcelUtils.convertExceltoMap ::: sheetName ::: " + sheet.getSheetName());}
            if (log.isInfoEnabled()) {log.info("ExcelUtils.convertExceltoMap ::: headerList ::: " + headers);}
            if (log.isInfoEnabled()) {log.info("ExcelUtils.convertExceltoMap ::: dataList.size ::: " + dataList.size());}
            return returnMap;
        } catch (IOException e) {
        	if (log.isInfoEnabled()) {log.info("ExcelUtils.convertExceltoMap ::: IOException ::: " + e);}
            e.printStackTrace();
            return returnMap;
        } catch (Exception e) {
        	if (log.isInfoEnabled()) {log.info("ExcelUtils.convertExceltoMap ::: Exception ::: " + e);}
            e.printStackTrace();
            return returnMap;
		}

    }
}
