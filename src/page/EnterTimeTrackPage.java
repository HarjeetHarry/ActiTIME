package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class EnterTimeTrackPage {
	@FindBy(xpath="//div[contains(text(),'Help')]")
	private WebElement help;

	@FindBy(linkText="About your actiTIME")
	private WebElement AboutYourActiTime;

	@FindBy(xpath="//span[starts-with(.,'actiTIME')]")
	private WebElement ProductVersion;

	@FindBy(id="aboutPopupCloseButtonId")
	private WebElement closeBTN;
	
	@FindBy(id="logoutLink")
	private WebElement logout;
	
	public EnterTimeTrackPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}

	public void clickHelp(){
		help.click();
	}

	public void clickAboutYourActiTime(){
		AboutYourActiTime.click();
	}
	public void VerifyVersion(String eVersion){
		String aVersion=ProductVersion.getText();
		Assert.assertEquals(aVersion, eVersion);
	}
	
	public void verifyTitle(WebDriver driver, String eTitle){
		WebDriverWait wait=new WebDriverWait(driver, 10);
		try{
			wait.until(ExpectedConditions.titleIs(eTitle));
			Reporter.log("Title is Matching",true);
		}
		catch(Exception e){
			Reporter.log("Title is NOT Matching",true);
			Assert.fail();
		}
	}
	
	public void clickClose(){
		closeBTN.click();
	}
	public void clickLogout(){
		logout.click();
	}
}
