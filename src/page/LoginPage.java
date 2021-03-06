package page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class LoginPage {
	@FindBy(id="username")
	private WebElement unTB;

	@FindBy(name="pwd")
	private WebElement pwTB;

	@FindBy(xpath="//div[.='Login ']")
	private WebElement loginBTN;

	@FindBy(xpath="//span[contains(.,'invalid')]")
	private WebElement errMsg;

	public LoginPage(WebDriver driver){     //Initalization using Constructor
		PageFactory.initElements(driver, this);
	}
	public void SetUserName(String un){
		unTB.sendKeys(un);
	}
	public void SetPassword(String pw){
		pwTB.sendKeys(pw);
	}
	public void clickLogin(){
		loginBTN.click();
	}
	public void verifyErrMsgIsDisplayed(WebDriver driver){
		WebDriverWait wait = new WebDriverWait(driver, 10);
		try{
			wait.until(ExpectedConditions.visibilityOf(errMsg));
			Reporter.log("ErrMsg is Displayd",true);
		}
		catch(Exception e){
			Reporter.log("ErrMsg is NOT Displayd",true);
			Assert.fail();
		}
	}
}

