package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class GoogleHomePage {

	public static WebElement element = null;

	// Implement All the WebElement in Home page
	public static WebElement lbl_google(WebDriver driver) {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	public static WebElement lnk_gmail(WebDriver driver) {
		element = driver.findElement(By.xpath(""));
		return element;
	}

	public static WebElement btn_GoogleSearch(WebDriver driver) {
		element = driver.findElement(By.xpath(".//div[@class='FPdoLc VlcLAe']//input[@value='Google Search']"));
		return element;
	}

	public static WebElement txt_google(WebDriver driver) {
		element = driver.findElement(By.xpath(".//input[@class='gLFyf gsfi']"));
		return element;
	}

	// Method implementation
	// Enter value in Google search text area
	public static void Enter_txtSearchInGoogle(WebDriver driver, String value) throws Exception {
		try {
			if (txt_google(driver).isDisplayed()) {
				txt_google(driver).sendKeys(value);
			}
		} catch (Exception e) {
			e.getMessage();
		}

	}

	// Click on gmail link
	public static void Click_lnkGmail(WebDriver driver) {
		Assert.assertEquals(lnk_gmail(driver).getText(), "");
		lnk_gmail(driver).click();

	}

	public static void Click_btnGoogleSearch(WebDriver driver) throws Exception {
		try {
			btn_GoogleSearch(driver).click();
		} catch (Exception e) {
			e.getMessage();
		}

	}
}
