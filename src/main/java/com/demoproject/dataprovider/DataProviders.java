package com.demoproject.dataprovider;

import org.testng.annotations.DataProvider;

import com.demoproject.utility.NewExcelLibrary;

public class DataProviders {
	
	NewExcelLibrary obj=new NewExcelLibrary();
	@DataProvider(name="OpencatloginData")
	public Object[][] getOpencatloginData() {
		int rows=obj.getRowCount("Sheet1");
		int columns=obj.getColumnCount("Sheet1");
		int actrow=rows-1;
		Object[][] data=new Object[actrow][columns];
		for(int i=0;i<actrow; i++) {
			for(int j=0; j<columns; j++) {
				data[i][j]=obj.getCellData("Sheet1", j, i+2);
			}
		}
		return data;
	}

}
