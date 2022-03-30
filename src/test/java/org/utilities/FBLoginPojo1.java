package org.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class FBLoginPojo1 extends BaseClass{
	public FBLoginPojo1() {
		PageFactory.initElements(driver, this);
		}
	// @FindBys Act as AND Operator
	@CacheLookup
	@FindBys({
		@FindBy(id="email"),
		@FindBy(xpath="//input[@type='text']")
	})
		private WebElement txtuser;
	//@FindAll Act As OR Operator
	@CacheLookup
	@FindAll({
		@FindBy(id="senthil"),
		@FindBy(xpath="//input[@type='password']")
	})
		private WebElement txtpass;
	@CacheLookup
	@FindBy(xpath="//button[@name='login']")
	private WebElement btnlogin;
	public WebElement getTxtuser() {
		return txtuser;
	}
	public WebElement getTxtpass() {
		return txtpass;
	}
	public WebElement getBtnlogin() {
		return btnlogin;
	}
	

	}


