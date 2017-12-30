package generic;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


public abstract class BaseTest implements IAutoConst{
public static WebDriver driver;
static{
	System.setProperty(CHROME_KEY, CHROME_VALUE);
	System.setProperty(GECKO_KEY, GECKO_VALUE);
}   @Parameters({"browser","ip"})
	@BeforeMethod(alwaysRun=true)
	public void openApplication(@Optional("chrome")String browser) throws MalformedURLException{
		//driver.get("http://localhost/login.do");      //Don't ever Hard Code
	String ip = "192.168.1.9";
	URL remote=new URL("http://"+ip+":4444/wd/hub");
	DesiredCapabilities dc;
		if(browser.equals("chrome")){
			dc=DesiredCapabilities.chrome();
		}
		else{
			dc=DesiredCapabilities.firefox();
		}
		driver=new RemoteWebDriver(remote,dc);
		
		String AUT=AUL.getProperty(SETTINGS_PATH, "AUT");
		driver.get(AUT);
		
		String strITO=AUL.getProperty(SETTINGS_PATH, "ITO");
		long ITO=Long.parseLong(strITO);
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
	}
	@AfterMethod
	public void closeApplication(){
		driver.quit();
	}
}

