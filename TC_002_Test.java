package testSuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.GoogleHomePage;
import utility.Constant;
import utility.ExcelUtility;
import utility.SelectBrowser;

public class TC_002_Test {

	public static WebDriver driver = null;
	private static int iTestCaseRow = 0;
	public static String sTestCaseName = null; 

	@BeforeTest
	public void OpenBrowser() throws Exception {
		try {
			sTestCaseName = ExcelUtility.getTestCaseName(this.toString());
			ExcelUtility.setExcelFile(Constant.Path_TestData + Constant.File_TestData, "Sheet1");					
			iTestCaseRow = ExcelUtility.getRowContains(sTestCaseName, Constant.Test_Case);
			driver = SelectBrowser.InvokeBrowser(iTestCaseRow);

		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Test
	public void searchValue() throws Exception {
		try {
			String strSearchValue = ExcelUtility.getCellData(iTestCaseRow, Constant.SearchValue);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			GoogleHomePage.Enter_txtSearchInGoogle(driver, strSearchValue);
			GoogleHomePage.Click_btnGoogleSearch(driver);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@AfterTest
	public void exitBrowser() throws Exception {
		try {
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.quit();
			driver.close();
			ExcelUtility.setCellData("PASS", iTestCaseRow, Constant.Status);
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
