package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="LoginData")
	public String[][] loginData() throws IOException{
		String path = ".\\testData\\login_test_data.xlsx";
		ExcelUtilities util = new ExcelUtilities(path);
		String sheetName = "Sheet1";
		int rows = util.getRowCount(sheetName);
		int cells = util.getCellCount(sheetName, 1);
		String data[][] = new String[rows][cells];
		for(int r=1; r<=rows; r++) {
			cells = util.getCellCount(sheetName, r);
			for(int c=0; c<cells; c++) {
				data[r-1][c] = util.getCellData(sheetName, r, c);
			}
		}
		return data;
	}
}
