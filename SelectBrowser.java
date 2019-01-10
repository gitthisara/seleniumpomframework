package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectBrowser {

	public static WebDriver driver = null;

	public static WebDriver InvokeBrowser(int iTestCaseRow) throws Exception

	{
		String browserName = null;
		try {
			browserName = ExcelUtility.getCellData(iTestCaseRow, Constant.Browser);
			if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver", Constant.chromeDriverPath);
				driver = new ChromeDriver();
				driver.get(Constant.strURL);
				driver.manage().window().maximize();
			}
			if(browserName.equalsIgnoreCase("firefox"))
			{
				//TODO
			}
		} catch (Exception e) {
			e.getMessage();
		}

		return driver;
	}
}
