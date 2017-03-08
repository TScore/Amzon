package com.amzone.abstrctCollation;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;

import com.amzone.interfaceCollation.HomePageAmzone;
import com.amzone.objectRepositry.SighIn_Locater;
import com.amzone.utili.AmozoneDriver;
import com.amzone.utili.AmzoneAbstrat;
import com.amzone.utili.AmzoneUtili;
import com.amzone.utili.PropertyHandler;


public abstract class AmzoneHomePageAbstrat extends AmzoneAbstrat implements HomePageAmzone {
	private static Logger Log = Logger.getLogger(AmzoneHomePageAbstrat.class.getName());
	AmzoneUtili amzoneUtili=new AmzoneUtili();
	//Log Log=new Log();
	private WebElement element;

	public void signinAmzone()
	{
		try{
			SighIn_Locater sighIn_Locater=loadObject(new SighIn_Locater());
			WebElement moveToMouse=sighIn_Locater.getYourOder_Locater();
			Log.info("move to locater of you oder!");
			amzoneUtili.getMouseMoveMent(moveToMouse);
			Log.info("succ to move mouse on you oder locater.");
			sighIn_Locater.getSighIn_Locater().click();
			Log.info("click sign in button of amzone webpage");

			element=sighIn_Locater.getLoginPageTitle();
			Log.info("findout page of login is displaying or not?");
			String loginLabelName=amzoneUtili.getText(element);
			Log.info("Login page>log in label is :"+loginLabelName);
			Log.info("comper excepted and actual value");
			Assert.assertEquals(loginLabelName.trim(),"Login");
			Log.info("excepted and actual value sucessfuly comper");

			Log.info("comper email id label is present or not");
			element=sighIn_Locater.getEmailHader_Locater();
			String emailIdLabelName=amzoneUtili.getText(element);
			Log.info("emailIdLabel name is:"+emailIdLabelName);
			Assert.assertEquals(emailIdLabelName.trim(), "Email or mobile phone number");
			Log.info("email id label >excepted and actual value sucessfuly comper");

			//send emai adress to email edit box
			sighIn_Locater.getEmailEditTextBox().sendKeys("tapana.testing@outlook.com");
			Log.info("send user email adress to amzone!");

			//Verify password label text present or not.
			Log.info("password  label is present or not");
			//element=sighIn_Locater.getLableOFPassword_Locater();
			//String passwordLabel=amzoneUtili.getText(element);
			//Log.info("passwordLabel name is:"+emailIdLabelName);
			//Assert.assertEquals(passwordLabel.trim(), "Password");
			//Log.info("passwordLabel >excepted and actual value sucessfuly comper");


			sighIn_Locater.getPasswordEdit_Locater().sendKeys("#Tapana9");
			Reporter.log("send password value to password eddit pages");
			Log.info("send password value to password eddit pages");


			sighIn_Locater.getLogin_Locater().click();
			Reporter.log("click sighIn buttion!");
			Log.info("click sighIn buttion!");
			
		}
		catch(Exception e)
		{
			Log.warn(e);
			Log.warn("get exception in signinAmzone");
			Reporter.log("click sighIn buttion!");
		}
	}
	public void verifyUser(){

	}

}
