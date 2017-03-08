package com.amzone.utili;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.openqa.selenium.remote.Augmentable;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;

import com.sun.jmx.snmp.Timestamp;
import com.sun.webkit.Utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;



//import io.appium.java_client.AppiumDriver;
//import io.appium.java_client.android.AndroidDriver;
public class AmzoneUtili extends AmzoneAbstrat
{
	private JavascriptExecutor js=null;
	private 	WebElement element=null;
	private static Logger Log = Logger.getLogger(AmzoneUtili.class.getName());
	private String SelectionMember=null;
	private String apkID=null;
	private List<WebElement>webList =null;

	private String ExcelPath=PropertyHandler.getProperty("CHECKLISTOFANDROID");
	private String TestCase=PropertyHandler.getProperty("AUTOMATIONTESTCASE");



	public void getWaitForElementPresent(String elementXpath,int time)
	{ 	
		WebDriverWait wt = new WebDriverWait(AmozoneDriver.driver,time);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXpath)));
	}
	public void getWaitForNamePresent(String Name,int time)
	{	
		WebDriverWait wt = new WebDriverWait(AmozoneDriver.driver, time);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.name(Name)));
	}
	public void getWaitForIdPresent(String id,int time)
	{		
		WebDriverWait wt = new WebDriverWait(AmozoneDriver.driver,time);
		wt.until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
	}
	public void getDroupDown(WebElement element,String value)
	{
		Select select=new Select(element);
		select.selectByVisibleText(value);
	}

	public void getScroolToText(String Scrooltext)
	{
		HashMap scrollObject = new HashMap();
		RemoteWebElement element = (RemoteWebElement)AmozoneDriver.driver.findElement(By.className("android.widget.ListView"));
		JavascriptExecutor js = (JavascriptExecutor)AmozoneDriver.driver;
		String webElementId = ((RemoteWebElement) element).getId();
		scrollObject.put("text", Scrooltext);
		scrollObject.put("element", webElementId);
		js.executeScript("mobile: scrollTo", scrollObject);
	}

	public void getScroolToText(String Xapth,String Scrooltext)
	{
		HashMap scrollObject = new HashMap();
		RemoteWebElement element = (RemoteWebElement)AmozoneDriver.driver.findElement(By.className(Xapth));
		JavascriptExecutor js = (JavascriptExecutor)AmozoneDriver.driver;
		String webElementId = ((RemoteWebElement) element).getId();
		scrollObject.put("text", Scrooltext);
		scrollObject.put("element", webElementId);
		js.executeScript("mobile: scrollTo", scrollObject);
	}

	/*	public void getTakeScreenShot(String testName) 
	{	
		try {
			String str = System.getProperty("user.dir") + "/";
			Timestamp timestamp = new Timestamp(new Date().getTime());
			String filename = PropertyHandler.getProperty("TAKESCREENHOT")+testName+timestamp+".jpg";
			WebDriver augmentedDriver = new Augmenter().augment(AmozoneDriver.driver);
			if (AmozoneDriver.driver.getClass().isAnnotationPresent(Augmentable.class)) 
			{
				AmozoneDriver.driver = (AppiumDriver) new Augmenter().augment(AmozoneDriver.driver);
			} else
			{
				System.out.println("Non augmentable, so augmentation can be performed but does nothing");
				AmozoneDriver.driver = (AppiumDriver) new Augmenter().augment(AmozoneDriver.driver);
			}
			File scrFile = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(filename), true);
			Reporter.log("<img src=\"file:///" + str + filename + "\" alt=\"\"/><br />");
		} 
		catch (IOException e)
		{

		} catch (Exception e) 
		{
			Log.info("exception in taking screen shot");
		}
	}	*/
	public void getMouseMoveMent(WebElement MoveToLocater)
	{
		Actions actions = new Actions(AmozoneDriver.driver);
		WebElement subMenu = MoveToLocater;
		actions.moveToElement(subMenu).build().perform();;
	}

	public String getText(WebElement textPrint)
	{
		String textOFLocater=textPrint.getText();
		return textOFLocater;
	}
	public String getColor(WebElement textPrint,String color)
	{
		String textOFLocater=textPrint.getCssValue(color);
		return textOFLocater;
	}
	public String getText_UseAttribute(WebElement textPrint,String AttributeName)
	{
		String textOFLocater=textPrint.getAttribute(AttributeName);
		return textOFLocater;
	}
	public void getSetup(String browser) throws Exception
	{
		//Check if parameter passed from TestNG is 'firefox'
		if(browser.equalsIgnoreCase("firefox"))
		{
			//create firefox instance
			AmozoneDriver.driver = new FirefoxDriver();
			AmozoneDriver.driver.get(PropertyHandler.getProperty("url"));
			AmozoneDriver.driver.manage().window().maximize();
		}
		//Check if parameter passed as 'chrome'
		else if(browser.equalsIgnoreCase("chrome"))
		{
			//set path to chromedriver.exe You may need to download it from http://code.google.com/p/selenium/wiki/ChromeDriver
			System.setProperty("webdriver.chrome.driver","/Users/tapanakumarbadhai/git/amzone/amzone/src/test/java/com/amzone/resource/chromedriver");
			//create chrome instance
			AmozoneDriver.driver = new ChromeDriver();
		}


	}


	public void onTestFailure(ITestResult result) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		String methodName = result.getName();
		if(!result.isSuccess()){
			File scrFile = ((TakesScreenshot)AmozoneDriver.driver).getScreenshotAs(OutputType.FILE);
			try {
				String reportDirectory = new File(System.getProperty("user.dir")).getAbsolutePath() + "/target/surefire-reports";
				File destFile = new File((String) reportDirectory+"/failure_screenshots/"+methodName+"_"+formater.format(calendar.getTime())+".png");
				FileUtils.copyFile(scrFile, destFile);
				Reporter.log("<a href='"+ destFile.getAbsolutePath() + "'> <img src='"+ destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void getTakeScreenShot(String nameScreenshot) throws IOException
	{
		//WebDriver augmentedDriver = new Augmenter().augment(AmzoneDriver.driver);
		File screenshot = ((TakesScreenshot) AmozoneDriver.driver).getScreenshotAs(OutputType.FILE);
		//String nameScreenshot = testMethod.getTestClass().getRealClass().getSimpleName() + "_" + testMethod.getMethodName();
		String path = getPath(nameScreenshot);
		FileUtils.copyFile(screenshot, new File(path));
		//		      Reporter.log("<a href=" + path + " target='_blank' >" + this.getFileName(nameScreenshot) + "</a>");
		//Reporter.log("<img src=\"file:///" +path+ "\" alt=\"\"/><br />");
		//		      System.out.println("<a href=" + path + " target='_blank' >" + this.getFileName(nameScreenshot) + "</a>");
		//System.out.println("<br><img src=\"file:///" + path+ "\" alt=\"\"/></br>");
		Reporter.log("<a href=\"" + path + "\"><p align=\"left\">Error screenshot at " + "</p>");
		Reporter.log("<p><img width=\"250\" src=\"" + path+"\" alt=\"screenshot at " + new Date()+ "\"/></p></a><br />"); 
		//Reporter.log("<a href=\"" + screenShot + "\"><p align=\"left\">Error screenshot at " + new Date()+ "</p>");
		//.log("<p><img width=\"1024\" src=\"" + file.getAbsoluteFile()  + "\" alt=\"screenshot at " + new Date()+ "\"/></p></a><br />"); 
	}


	private String getFileName(String nameTest) throws IOException 
	{
		DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy_hh.mm.ss");
		Date date = new Date();
		return dateFormat.format(date) + "_" + nameTest + ".png";
	}
	private String getPath(String nameTest) throws IOException 
	{
		File directory = new File(".");
		//String newFileNamePath =  directory.getCanonicalPath()+PropertyHandler.getProperty("TAKESCREENHOT") + getFileName(nameTest);
		String newFileNamePath =  directory.getCanonicalPath()+"/target/surefire-reports/screenShots/"+ getFileName(nameTest);
		return newFileNamePath;
	}


}
