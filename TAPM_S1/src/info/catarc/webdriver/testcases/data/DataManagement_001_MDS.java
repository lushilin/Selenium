package info.catarc.webdriver.testcases.data;

import java.util.Map;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import info.catarc.webdriver.base.BaseParpare;
import info.catarc.webdriver.pageshelper.LoginPageHelper;

public class DataManagement_001_MDS extends BaseParpare{
	  @Test(dataProvider="testData")
	  public void search(Map<String, String> data) {
		  //等待登录页面加载
		  LoginPageHelper.waitLoginPageLoad(seleniumUtil, timeOut);
		  // 输入登录信息
		  LoginPageHelper.typeLoginInfo(seleniumUtil, data.get("USERNAME"), data.get("PASSWORD"));
		  seleniumUtil.inFrame("leftFrame");		  
		  seleniumUtil.click(By.linkText("材料数据管理"));		  
		  seleniumUtil.outFrame();
		  seleniumUtil.inFrame("mainFrame");
		  
		  //查询类型选择零部件
		  seleniumUtil.click(By.id("queryType-inputEl"));
		  seleniumUtil.click(By.xpath(".//*[@id='boundlist-1051-listEl']/ul/li[2]"));
		  
		  //表单来源选择camds系统
		  seleniumUtil.click(By.id("isMdsOwner-inputEl"));
		  seleniumUtil.click(By.xpath(".//*[@id='boundlist-1053-listEl']/ul/li[1]"));
		  
		  seleniumUtil.type(By.id("name-inputEl"), "测试数据");
		  seleniumUtil.type(By.id("symbol-inputEl"), "中汽测试数据");
		  seleniumUtil.type(By.id("cid-inputEl"), "CA_5_2547415");
		  
		  seleniumUtil.click(By.id("button-1014-btnEl"));
		  
		  seleniumUtil.pause(3000);
		  
		  seleniumUtil.assertTrue(seleniumUtil.findElementBy(By.xpath(".//*[@id='gridview-1027']/table/tbody/tr[2]/td[3]/div")), "CA_5_2547415");
		  seleniumUtil.assertTrue(seleniumUtil.findElementBy(By.xpath(".//*[@id='gridview-1027']/table/tbody/tr[2]/td[6]/div")), "中汽测试数据");
		  
	  }	 
	}

