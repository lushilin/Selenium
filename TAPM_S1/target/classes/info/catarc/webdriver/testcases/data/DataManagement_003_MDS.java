package info.catarc.webdriver.testcases.data;

import java.util.Map;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import info.catarc.webdriver.base.BaseParpare;
import info.catarc.webdriver.pageshelper.LoginPageHelper;

public class DataManagement_003_MDS extends BaseParpare{
	@Test(dataProvider="testData")
	public void verify(Map<String, String> data) {		
		//等待登录页面加载
		LoginPageHelper.waitLoginPageLoad(seleniumUtil, timeOut);
		// 输入登录信息
		LoginPageHelper.typeLoginInfo(seleniumUtil, data.get("USERNAME"), data.get("PASSWORD"));
		
		seleniumUtil.inFrame("leftFrame");		  
		seleniumUtil.click(By.linkText("审核信息"));		  
		seleniumUtil.outFrame();
		seleniumUtil.inFrame("mainFrame");
		//点击"审核状态"
		seleniumUtil.click(By.id("auditType-inputEl"));
		//选中"自己审核过"
		seleniumUtil.waitForElementToLoad(3000, By.xpath(".//*[@id='boundlist-1049-listEl']/ul/li[4]"));
		seleniumUtil.click(By.xpath(".//*[@id='boundlist-1049-listEl']/ul/li[4]"));
		//点击"查找"
		seleniumUtil.click(By.id("button-1014-btnEl"));
		seleniumUtil.waitForElementToLoad(3000, By.xpath(".//*[@id='gridview-1028']/table/tbody/tr[2]/td[12]/div"));
		//审核的结果应该是最近的一条，即取第一条
		int state = 1;
		if(state == 0){
			System.out.println(seleniumUtil.getText(By.xpath(".//*[@id='gridview-1028']/table/tbody/tr[2]/td[12]/div")));
			seleniumUtil.assertTrue(seleniumUtil.findElementBy(By.xpath(".//*[@id='gridview-1028']/table/tbody/tr[2]/td[12]/div")), "");
		}
		else if(state == 1){
			System.out.println(seleniumUtil.getText(By.xpath(".//*[@id='gridview-1028']/table/tbody/tr[2]/td[12]/div")));
			seleniumUtil.assertTrue(seleniumUtil.findElementBy(By.xpath(".//*[@id='gridview-1028']/table/tbody/tr[2]/td[12]/div")), "含量超标");
		}
	}
}
