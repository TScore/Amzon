package com.amzone.utili;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AmzoneAbstrat {
	@SuppressWarnings("unchecked")
	public <T> T loadObject(T t)
	{
		return (T) PageFactory.initElements(AmozoneDriver.driver, t.getClass());
	}
	public void getTextVerify(String actual,String expected)
	{
		Assert.assertEquals(actual, expected);
	}
}
