package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelOperation {

	public static void excelWrite(String filepath, int row, int cell, List<List<String>> data) throws Throwable {

		File f = new File(filepath);
		FileInputStream f1 = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(f1);
		Sheet s = w.getSheet("Sheet1");
	for(int j=0;j<data.get(1).size();j++) {
		if(j<data.get(0).size()) {
			Row r = s.createRow(j);

			Cell c = r.createCell(0);

			c.setCellValue(data.get(0).get(j));
			Cell c1 = r.createCell(1);

			c1.setCellValue(data.get(1).get(j));
		}else {
			Row r = s.createRow(j);

			
			Cell c1 = r.createCell(1);

			c1.setCellValue(data.get(1).get(j));
	}
}
		
		f1.close();
		FileOutputStream o = new FileOutputStream(f);
		w.write(o);

		w.close();
		o.close();

	}

}
