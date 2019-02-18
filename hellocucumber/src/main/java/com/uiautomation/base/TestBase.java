package com.uiautomation.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.uiautomation.util.TestUtil;

//entering all basic details
public class TestBase {

	public static WebDriver driver;
	public static Properties prop;
	public static final String testDataExcelFileName = "UIAutomationTestData.xlsx";
	// public static String changeColour=null;
	// public static String chooseDress=null;

	// creating a constructor
	public TestBase() {
		try {
			prop = new Properties();
			FileInputStream ip;
			ip = new FileInputStream(
					System.getProperty("user.dir") + "/src/main/java/com/uiautomation/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");
		String urlAddress = prop.getProperty("url");

		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "D:\\soft\\New folder\\UIAutomationAssg-master\\UIAutomationAsgnmt2\\chromedriver.exe");

			driver = new ChromeDriver();

		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "D:\\soft\\New folder\\UIAutomationAssg-master\\UIAutomationAsgnmt2\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		driver.navigate().to(urlAddress);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_load_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITWait_value, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

	}

}
