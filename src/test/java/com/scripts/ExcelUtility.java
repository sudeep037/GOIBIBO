package com.scripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public static void writeDataIntoExcel(String sheetName, int rowNo, int colNo, String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("D:\\NewSpace\\IXIGO\\NSEDATA.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet =  book.getSheet(sheetName);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.createCell(colNo);
		cell.setCellValue(data);
		
		FileOutputStream fos = new FileOutputStream("D:\\NewSpace\\IXIGO\\NSEDATA.xlsx");
		book.write(fos);
		book.close();
		fis.close();
		fos.close();
	}
}
