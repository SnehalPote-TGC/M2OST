package com.m2ost.Login;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class DataPRividerClass  {
	@DataProvider
	
	public String[][] file() throws Exception {
	
	File excelfile = new File("./src/test/resources/TestNew.xlsx");
	
	FileInputStream fis = new FileInputStream(excelfile);
	System.out.println(excelfile.exists());
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
	XSSFSheet sheet = workbook.getSheet("Sheet1");
	int noOfRows = sheet.getPhysicalNumberOfRows();
	System.out.println("Rows "+noOfRows);
	int noOfCol = sheet.getRow(0).getLastCellNum();
	System.out.println("Col "+noOfCol);

	String[][] data = new String[noOfRows-1][noOfCol];
	for(int i=0; i<noOfRows-1; i++) {
		for(int j=0; j<noOfCol; j++) {
			DataFormatter df = new DataFormatter();
			data[i][j] = df.formatCellValue(sheet.getRow(i+1).getCell(j));
			System.out.println(df.formatCellValue(sheet.getRow(i+1).getCell(j)));
			
		}
	}
	workbook.close();
	fis.close();
	System.out.println("data "+Arrays.toString(data));
return data;
	}
}
