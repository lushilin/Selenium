package info.catarc.webdriver.testcases.add;

import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import info.catarc.webdriver.base.BaseParpare;
import info.catarc.webdriver.pageshelper.LoginPageHelper;

public class SynManagement_001_MDS extends BaseParpare{
	 @Test(dataProvider="testData")
	  public void Syn(Map<String, String> data) {
		  //等待登录页面加载
		  LoginPageHelper.waitLoginPageLoad(seleniumUtil, timeOut);
		  // 输入登录信息
		  LoginPageHelper.typeLoginInfo(seleniumUtil, data.get("USERNAME"), data.get("PASSWORD"));
		  seleniumUtil.inFrame("leftFrame");
		  seleniumUtil.click(By.linkText("基础数据同步"));
		  seleniumUtil.outFrame();
		  seleniumUtil.inFrame("mainFrame");
		  
		  //step 1
		  //点击CAMDS企业同步
		  seleniumUtil.click(By.id("button-1010-btnEl"));
		  //等待同步结束
		  seleniumUtil.isContains(seleniumUtil.getText(By.id("messagebox-1001-displayfield-inputEl")), "正在处理，请稍等");
		  seleniumUtil.pause(6000);
		  seleniumUtil.isContains(seleniumUtil.getText(By.id("messagebox-1001-displayfield-inputEl")), "同步成功");
		  //点击确定
		  seleniumUtil.click(By.id("button-1005-btnEl"));
		  
		  
		  /*//step 2
		  //向输入框选择开始时间和结束时间（开始时间晚于结束时间）
		  selectDate("dateFrom-inputEl", "dateTo-inputEl", ".//*[@id='ext-gen1255']/a/em/span", ".//*[@id='ext-gen1196']/a/em/span");
		  //点击CAMDS企业同步
		  seleniumUtil.click(By.id("button-1010-btnEl"));
		  //验证弹出“开始时间早于结束时间”
		  seleniumUtil.isContains(seleniumUtil.getText(By.id("messagebox-1001-displayfield-inputEl")), "开始时间早于结束时间");
		  //点击确定
		  seleniumUtil.click(By.id("button-1005-btnEl"));*/
		  
		  
		  //step 3
		  //向输入框选择开始时间和结束时间（开始时间等于结束时间）
		  selectDate("dateFrom-inputEl", "dateTo-inputEl", ".//*[@id='ext-gen1141']/a/em/span", ".//*[@id='ext-gen1201']/a/em/span");	  	  
		  //点击CAMDS企业同步
		  seleniumUtil.click(By.id("button-1010-btnEl"));
		  seleniumUtil.pause(8000);
		  //点击确定
		  seleniumUtil.click(By.id("button-1005-btnEl"));
		  //同步完成后验证
		  seleniumUtil.isContains(seleniumUtil.getText(By.xpath(".//*[@id='gridview-1026']/table/tbody/tr[2]/td[2]/div")), data.get("USERNAME"));
		  //get system's current time
		  SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH");//设置日期格式
		  String currentTime = df.format(new Date());// new Date()为获取当前系统时间	
		  seleniumUtil.isContains(seleniumUtil.getText(By.xpath(".//*[@id='gridview-1026']/table/tbody/tr[2]/td[3]/div")), currentTime);
		  seleniumUtil.isContains(seleniumUtil.getText(By.xpath(".//*[@id='gridview-1026']/table/tbody/tr[2]/td[4]/div")), "同步企业");
		  
		  //step4
		  //向输入框选择开始时间和结束时间（开始时间小于结束时间）
		  selectDate("dateFrom-inputEl", "dateTo-inputEl", ".//*[@id='ext-gen1141']/a/em/span", ".//*[@id='ext-gen1202']/a/em/span");
		  //点击CAMDS企业同步
		  seleniumUtil.click(By.id("button-1010-btnEl"));
		  seleniumUtil.pause(8000);
		  //点击确定
		  seleniumUtil.click(By.id("button-1005-btnEl"));
		  currentTime = df.format(new Date());// new Date()为获取当前系统时间
		  seleniumUtil.isContains(seleniumUtil.getText(By.xpath(".//*[@id='gridview-1026']/table/tbody/tr[2]/td[3]/div")), currentTime);		  
		  seleniumUtil.isContains(seleniumUtil.getText(By.xpath(".//*[@id='gridview-1026']/table/tbody/tr[2]/td[2]/div")), data.get("USERNAME"));
		  seleniumUtil.isContains(seleniumUtil.getText(By.xpath(".//*[@id='gridview-1026']/table/tbody/tr[2]/td[4]/div")), "同步企业");
		  
		  //step5
		  //向输入框选择开始时间和结束时间（结束时间在未来）
		  selectDate("dateFrom-inputEl", "dateTo-inputEl", ".//*[@id='ext-gen1141']/a/em/span", ".//*[@id='ext-gen1210']/a/em/span");
		  //点击CAMDS企业同步
		  seleniumUtil.click(By.id("button-1010-btnEl"));
		  seleniumUtil.pause(8000);
		  //点击确定
		  seleniumUtil.click(By.id("button-1005-btnEl"));
		  seleniumUtil.isContains(seleniumUtil.getText(By.xpath(".//*[@id='gridview-1026']/table/tbody/tr[2]/td[2]/div")), data.get("USERNAME"));
		  currentTime = df.format(new Date());// new Date()为获取当前系统时间
		  seleniumUtil.isContains(seleniumUtil.getText(By.xpath(".//*[@id='gridview-1026']/table/tbody/tr[2]/td[3]/div")), currentTime);
		  seleniumUtil.isContains(seleniumUtil.getText(By.xpath(".//*[@id='gridview-1026']/table/tbody/tr[2]/td[4]/div")), "同步企业");
		  
		  //step6
		  //时间跨度很长
		  selectDate("dateFrom-inputEl", "dateTo-inputEl", ".//*[@id='ext-gen1141']/a/em/span", ".//*[@id='ext-gen1210']/a/em/span"); 
		  //点击CAMDS企业同步
		  seleniumUtil.click(By.id("button-1010-btnEl"));
		  seleniumUtil.isContains(seleniumUtil.getText(By.id("messagebox-1001-displayfield-inputEl")), "正在处理，请稍等");	
		  seleniumUtil.pause(8000);
		  //点击确定
		  seleniumUtil.click(By.id("button-1005-btnEl"));
	 }
	 
	 public void selectDate(String fromBoxId, String toBoxId, String fromDatePath, String toDatePath){
		 seleniumUtil.click(By.id(fromBoxId));
		 seleniumUtil.pause(1000);
		 seleniumUtil.click(By.xpath(fromDatePath));
		 seleniumUtil.click(By.id(toBoxId));
		 seleniumUtil.pause(1000);
		 seleniumUtil.click(By.xpath(toDatePath));
	 }
}
