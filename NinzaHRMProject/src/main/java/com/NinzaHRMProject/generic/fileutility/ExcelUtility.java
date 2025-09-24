package com.NinzaHRMProject.generic.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String getDataFromExcel(String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./TestData/TestScriptData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		Row row=sh.getRow(rowNum);
		Cell cell=row.getCell(cellNum);
		String data=cell.toString();
		wb.close();
		return data;
	}
	
	public void setDataIntoExcel(String sheetName, int rowNum,int cellNum,String value) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./TestData/testScriptData.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		Cell cell=wb.getSheet(sheetName).createRow(rowNum).createCell(cellNum, CellType.STRING); 
		cell.setCellValue(value);
		FileOutputStream fos=new FileOutputStream("./testData/testScriptData.xlsx");
		wb.write(fos);
		wb.close();
	}
}
