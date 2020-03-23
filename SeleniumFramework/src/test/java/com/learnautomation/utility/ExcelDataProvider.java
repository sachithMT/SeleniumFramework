package com.learnautomation.utility;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook wb;

	public ExcelDataProvider() {

		File src = new File("./TestData/Data.xlsx");

		try {
			FileInputStream fis = new FileInputStream(src);

			wb = new XSSFWorkbook(fis);

		} catch (Exception e) {

			System.out.println("Error in reading Excel file " + e.getMessage());

		}

	}

	//Read String data from Excel sheets
	public String getStringData(String sheetName, int row, int col) {

		return wb.getSheet(sheetName).getRow(row).getCell(col).getStringCellValue();

	}

	//Read numeric data from Excel sheets
	public double getNumericData(String sheetName, int row, int col) {

		return wb.getSheet(sheetName).getRow(row).getCell(col).getNumericCellValue();
	}
}
