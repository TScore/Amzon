package com.amzone.objectRepositry;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePageLocator 
{	
	@FindBy(xpath="//a[text()[normalize-space()='Try Prime']]")
	private WebElement primeLink_Locater;	
}
