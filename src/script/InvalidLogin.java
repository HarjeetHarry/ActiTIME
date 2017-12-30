package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import page.LoginPage;

public class InvalidLogin extends BaseTest{
	@Test(priority=2,groups="login")
	public void testInvalidLogin(){
		int rc=Excel.getRowCount(XL_PATH,"InvalidLogin");
		for(int i=1;i<=rc;i++){
		String un=Excel.getCellValue(XL_PATH,"InvalidLogin", i, 0);
		String pw=Excel.getCellValue(XL_PATH, "InvalidLogin", i, 1);
	    //Enter Invalid UserName
		LoginPage l=new LoginPage(driver);
		l.SetUserName(un);
		//Enter Invalid Password
		l.SetPassword(pw);
		//Click on Login
		l.clickLogin();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {

		}
		//Verify that Err msg is Displayed
		l.verifyErrMsgIsDisplayed(driver);
	}
}
}
