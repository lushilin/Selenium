package info.catarc.webdriver.testcases.login;

import info.catarc.webdriver.base.BaseParpare;
import info.catarc.webdriver.pageshelper.LoginPageHelper;

import java.util.Map;

import org.testng.annotations.Test;

public class LoginPage_002_LoginFailFunction_Test extends BaseParpare {
	@Test(dataProvider="testData")
	  public void loginSuccessFunction(Map<String, String> data) {
		  //等待登录页面加载
		  LoginPageHelper.waitLoginPageLoad(seleniumUtil, timeOut);
		  // 输入登录信息
		  LoginPageHelper.typeLoginInfo(seleniumUtil, data.get("USERNAME"), data.get("PASSWORD"));
}}
