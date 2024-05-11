package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {
	public static String location = "test-data/excel.xlsx";
	public static XSSFWorkbook wbook;
	public static XSSFSheet sheet;

	public static String[][] readExcel1(String sheetName) throws IOException {

		FileInputStream fis= null;
		
		fis = new FileInputStream(location);
		wbook = new XSSFWorkbook(fis);
		sheet = wbook.getSheet(sheetName);
		int lastRowNum = sheet.getLastRowNum();
		short lastCellNum = sheet.getRow(0).getLastCellNum();
		String data[][] = new String[lastRowNum][lastCellNum];
		for (int i = 1; i <= lastRowNum; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j < lastCellNum; j++) {
				XSSFCell cell = row.getCell(j);
				DataFormatter dft = new DataFormatter();
				String value = dft.formatCellValue(cell);
				data[i - 1][j] = value;
			}
		}
		return data;
	}

}
