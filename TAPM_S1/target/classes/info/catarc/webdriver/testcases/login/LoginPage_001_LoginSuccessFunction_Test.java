package info.catarc.webdriver.testcases.login;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import info.catarc.webdriver.base.BaseParpare;
import info.catarc.webdriver.pages.HomePage;
import info.catarc.webdriver.pages.LoginPage;
import info.catarc.webdriver.pageshelper.LoginPageHelper;

/**
 * @author Guojs
 * @description 登录之后验证用户名是不是正确的
 * */

public class LoginPage_001_LoginSuccessFunction_Test extends BaseParpare{
  @Test(dataProvider="testData")
  public void loginSuccessFunction(Map<String, String> data) {
	  //等待登录页面加载
	  LoginPageHelper.waitLoginPageLoad(seleniumUtil, timeOut);
	  // 输入登录信息
	  LoginPageHelper.typeLoginInfo(seleniumUtil, data.get("USERNAME"), data.get("PASSWORD"));
	  //seleniumUtil.inFrame("leftFrame");
	  //System.out.println(seleniumUtil.getText(By.xpath("/html/body/div/div/table/tr/td/ul[@id='navCircle']/li[5]/span")));
	  //seleniumUtil.click(By.linkText("基础数据同步"));
	  //seleniumUtil.click(By.xpath(".//*[@id='treeview-1013']/table/tbody/tr[2]/td/div/"));
  }
}
