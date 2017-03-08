package com.amzone.automationScript;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.ScreenshotException;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.amzone.abstrctCollation.AmzoneHomePageAbstrat;
import com.amzone.utili.AmozoneDriver;
import com.amzone.utili.AmzoneUtili;
import com.amzone.utili.LogUtili;
import com.amzone.utili.PropertyHandler;


@Listeners(com.amzone.utili.Listener.class)
public class Amzone_HomePage_LoginTest  extends AmzoneHomePageAbstrat  {
	private static Logger Log = Logger.getLogger(Amzone_HomePage_LoginTest.class.getName());
	LogUtili logUtili=new LogUtili();
	AmzoneUtili amzoneUtili=new AmzoneUtili();
	@BeforeClass
	public void startBrowser() throws Exception
	{
		DOMConfigurator.configure(PropertyHandler.getProperty("Loger"));
		amzoneUtili.getSetup("firefox");

	}
	@BeforeMethod
	public void loadLocater()
	{
		
	}
	@Test
	public void Amzone_HomePage_LoginTest01() throws IOException
	{
		signinAmzone();
		amzoneUtili.getTakeScreenShot("regisater");
		
		
	}
	@AfterMethod
	public void setScreenshot(ITestResult result) {
		

	}
	@AfterClass
	public void closeBrowser()
	{
		AmozoneDriver.driver.quit();
	}


}
