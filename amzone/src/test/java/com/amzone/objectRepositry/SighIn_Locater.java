package com.amzone.objectRepositry;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
/**
 * @author tapanakumarbadhai
 *@Date: Sunday fab 2017
 */
public class SighIn_Locater 
{
	//Collation of locater of yourOder
	@FindBy(id="nav-link-yourAccount")
	private WebElement yourOder_Locater;
	@FindBy(xpath="//div[@id='nav-flyout-ya-signin']//descendant::span[text()='Sign in']")
	private WebElement sighIn_Locater;
	@FindBy(xpath="//h1[@class='a-spacing-small']")
	private WebElement LoginPageTitle;
	@FindBy(xpath="//label[@for='ap_email']")
	private WebElement emailHader_Locater;
	@FindBy(id="ap_email")
	private WebElement emailEditTextBox;
	@FindBy(id="//label[@for='ap_password']")
	private WebElement lableOFPassword_Locater;
	@FindBy(id="auth-fpp-link-bottom")
	private WebElement ForgotPassword;
	@FindBy(id="ap_password")
	private WebElement passwordEdit_Locater;
	@FindBy(id="signInSubmit")
	private WebElement login_Locater;
	@FindBy(xpath="//span[@class='a-label a-checkbox-label']")
	private WebElement labelOfKeepMeSighn_Locater;
	@FindBy(xpath="//input[@name='rememberMe']")
	private WebElement rememberMeRediobutton_Locater;
	@FindBy(id="createAccountSubmit")
	private WebElement createAccountSubmitButton_Locater;
	@FindBy(xpath="//a[contains(text(),'Conditions of Use')]")
	private WebElement condition_Locater;
	@FindBy(xpath="//a[contains(text(),'Privacy Notice')]")
	private WebElement privacyNotice;
	@FindBy(xpath="//a[contains(text(),'Help')]")
	private WebElement help_Locater;
	@FindBy(xpath="//span[@class='a-size-mini a-color-secondary']")
	private WebElement copyWrit_Locater;
	public WebElement getYourOder_Locater() {
		return yourOder_Locater;
	}
	public void setYourOder_Locater(WebElement yourOder_Locater) {
		this.yourOder_Locater = yourOder_Locater;
	}
	public WebElement getSighIn_Locater() {
		return sighIn_Locater;
	}
	public void setSighIn_Locater(WebElement sighIn_Locater) {
		this.sighIn_Locater = sighIn_Locater;
	}
	public WebElement getLoginPageTitle() {
		return LoginPageTitle;
	}
	public void setLoginPageTitle(WebElement loginPageTitle) {
		LoginPageTitle = loginPageTitle;
	}
	public WebElement getEmailHader_Locater() {
		return emailHader_Locater;
	}
	public void setEmailHader_Locater(WebElement emailHader_Locater) {
		this.emailHader_Locater = emailHader_Locater;
	}
	public WebElement getEmailEditTextBox() {
		return emailEditTextBox;
	}
	public void setEmailEditTextBox(WebElement emailEditTextBox) {
		this.emailEditTextBox = emailEditTextBox;
	}
	public WebElement getLableOFPassword_Locater() {
		return lableOFPassword_Locater;
	}
	public void setLableOFPassword_Locater(WebElement lableOFPassword_Locater) {
		this.lableOFPassword_Locater = lableOFPassword_Locater;
	}
	public WebElement getForgotPassword() {
		return ForgotPassword;
	}
	public void setForgotPassword(WebElement forgotPassword) {
		ForgotPassword = forgotPassword;
	}
	public WebElement getPasswordEdit_Locater() {
		return passwordEdit_Locater;
	}
	public void setPasswordEdit_Locater(WebElement passwordEdit_Locater) {
		this.passwordEdit_Locater = passwordEdit_Locater;
	}
	public WebElement getLogin_Locater() {
		return login_Locater;
	}
	public void setLogin_Locater(WebElement login_Locater) {
		this.login_Locater = login_Locater;
	}
	public WebElement getLabelOfKeepMeSighn_Locater() {
		return labelOfKeepMeSighn_Locater;
	}
	public void setLabelOfKeepMeSighn_Locater(WebElement labelOfKeepMeSighn_Locater) {
		this.labelOfKeepMeSighn_Locater = labelOfKeepMeSighn_Locater;
	}
	public WebElement getRememberMeRediobutton_Locater() {
		return rememberMeRediobutton_Locater;
	}
	public void setRememberMeRediobutton_Locater(WebElement rememberMeRediobutton_Locater) {
		this.rememberMeRediobutton_Locater = rememberMeRediobutton_Locater;
	}
	public WebElement getCreateAccountSubmitButton_Locater() {
		return createAccountSubmitButton_Locater;
	}
	public void setCreateAccountSubmitButton_Locater(WebElement createAccountSubmitButton_Locater) {
		this.createAccountSubmitButton_Locater = createAccountSubmitButton_Locater;
	}
	public WebElement getCondition_Locater() {
		return condition_Locater;
	}
	public void setCondition_Locater(WebElement condition_Locater) {
		this.condition_Locater = condition_Locater;
	}
	public WebElement getPrivacyNotice() {
		return privacyNotice;
	}
	public void setPrivacyNotice(WebElement privacyNotice) {
		this.privacyNotice = privacyNotice;
	}
	public WebElement getHelp_Locater() {
		return help_Locater;
	}
	public void setHelp_Locater(WebElement help_Locater) {
		this.help_Locater = help_Locater;
	}
	public WebElement getCopyWrit_Locater() {
		return copyWrit_Locater;
	}
	public void setCopyWrit_Locater(WebElement copyWrit_Locater) {
		this.copyWrit_Locater = copyWrit_Locater;
	}
	
}
