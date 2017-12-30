package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import page.EnterTimeTrackPage;
import page.LoginPage;

public class CheckProductVersion extends BaseTest{
@Test(priority=3,groups="Product")
public void testCheckProductVersion(){
	String un=Excel.getCellValue(XL_PATH, "CheckProductVersion", 1, 0);
	String pw=Excel.getCellValue(XL_PATH, "CheckProductVersion", 1, 1);
	String eVersion=Excel.getCellValue(XL_PATH, "CheckProductVersion", 1, 2);
	//Enter Valid UserName
	LoginPage l=new LoginPage(driver);
	l.SetUserName(un);
	//Enter Valid Password
	l.SetPassword(pw);
	//click on Login
	l.clickLogin();
	//Click on Help
	EnterTimeTrackPage e=new EnterTimeTrackPage(driver);
	e.clickHelp();
	//Click on About Your ActiTIME
	e.clickAboutYourActiTime();
	//Verify that Product version is ActiTIME 2017.1
	e.VerifyVersion(eVersion);
	//Click on Close Button
	e.clickClose();
	//Click on Logout
	e.clickLogout();
}
}
