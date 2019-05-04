package TestData;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSheetReader 
{
	static FileInputStream fisObject = null ;
	public static FileInputStream getFileInputStream()
	{
		String ExcelSheetPath = System.getProperty("user.dir")+ "\\src\\test\\java\\TestData\\TestData.xlsx";
		try {
			fisObject = new FileInputStream(ExcelSheetPath);
		} catch (FileNotFoundException e) 
		{
			System.out.println("error has been occureed" + e.getMessage());
			System.exit(0);
		}
		return fisObject;
	}

	public Object[][] readExcelSheet() throws IOException
	{
		fisObject = getFileInputStream();
		XSSFWorkbook WB = new XSSFWorkbook(fisObject);
		XSSFSheet sheet = WB.getSheetAt(0);
		int TotalRows = sheet.getLastRowNum()+ 1 ;
		int TotalCols = 5 ;
		String [][] arrayUserData = new String [TotalRows][TotalCols];
		System.out.println(TotalRows);

		for (int i = 0 ; i < TotalRows ; i++)
		{
			for (int j = 0 ; j <TotalCols ; j ++ )
			{
				XSSFRow row = sheet.getRow(i);
				arrayUserData[i][j]  = row.getCell(j).toString();
			}
		}
		WB.close();
		return arrayUserData;
	}

}

