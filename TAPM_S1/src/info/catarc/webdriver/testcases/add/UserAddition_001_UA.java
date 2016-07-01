package info.catarc.webdriver.testcases.add;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import info.catarc.webdriver.base.BaseParpare;
import info.catarc.webdriver.pageshelper.LoginPageHelper;

public class UserAddition_001_UA extends BaseParpare{
	@Test(dataProvider="testData")
	  public void addUser(Map<String, String> data) {
		  //等待登录页面加载
		  LoginPageHelper.waitLoginPageLoad(seleniumUtil, timeOut);
		  // 输入登录信息
		  LoginPageHelper.typeLoginInfo(seleniumUtil, data.get("USERNAME"), data.get("PASSWORD"));
		  seleniumUtil.inFrame("leftFrame");
		  //选择主frame
		  seleniumUtil.click(By.id("treepanel-1030_header_hd-textEl"));
		  seleniumUtil.click(By.linkText("用户信息"));
		  seleniumUtil.outFrame();
		  seleniumUtil.inFrame("mainFrame");	
		  
		  
		  //跳转到新增用户窗口页面
		  seleniumUtil.switchToNewPage("http://60.30.69.61:8290/CESEMDMS/userInfo/addNewUserInfoAction.action");
		  seleniumUtil.pause(3000);
		  
		  SimpleDateFormat df = new SimpleDateFormat("HH_mm_ss");//设置日期格式
		  String currentTime = df.format(new Date());// new Date()为获取当前系统时间	
		  //输入用户各种信息
		  seleniumUtil.type(By.id("UserDetailInfo.userCname-inputEl"), "TJU_tester" + currentTime);
		  seleniumUtil.type(By.id("UserDetailInfo.loginName-inputEl"), "TJU_tester" + currentTime);
		  seleniumUtil.click(By.id("button-1018-btnEl"));
		  seleniumUtil.click(By.xpath(".//*[@id='gridview-1062']/table/tbody/tr[2]/td[1]/div/div"));
		  seleniumUtil.click(By.id("button-1077-btnEl"));
		  seleniumUtil.click(By.xpath(".//*[@id='gridview-1016']/table/tbody/tr[2]/td[1]/div/div"));
		  seleniumUtil.click(By.id("role10-inputEl"));
		  seleniumUtil.click(By.id("button-1032-btnEl"));
		  seleniumUtil.click(By.xpath(".//*[@id='gridview-1104']/table/tbody/tr[2]/td[1]/div/div"));
		  seleniumUtil.click(By.id("button-1119-btnEl"));
		  seleniumUtil.click(By.xpath(".//*[@id='gridview-1030']/table/tbody/tr[2]/td[1]/div/div"));
		  seleniumUtil.click(By.id("button-1036-btnEl"));	
		  seleniumUtil.pause(3000);
		  seleniumUtil.click(By.id("button-1005-btnEl"));
		  
		  //验证是否新增成功
		  seleniumUtil.switchToNewPage("http://60.30.69.61:8290/CESEMDMS/login/welcomeAction.action");
		  seleniumUtil.inFrame("leftFrame");		  
		  seleniumUtil.click(By.id("treepanel-1030_header_hd-textEl"));
		  seleniumUtil.click(By.linkText("用户信息"));
		  seleniumUtil.outFrame();
		  seleniumUtil.inFrame("mainFrame");		  
		  //seleniumUtil.click(By.xpath(".//*[@id='gridview-1019']/table/tbody/tr[2]/td[1]/div/div")); 
		  seleniumUtil.pause(5000);		  
		  seleniumUtil.isContains(seleniumUtil.getText(By.xpath(".//*[@id='gridview-1019']/table/tbody/tr[2]/td[3]/div")), "TJU_tester" + currentTime);
		  
		  
	 }
	 
}
