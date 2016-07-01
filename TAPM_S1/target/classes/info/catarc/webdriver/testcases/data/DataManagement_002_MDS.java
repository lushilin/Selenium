package info.catarc.webdriver.testcases.data;

import java.util.Map;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import info.catarc.webdriver.base.BaseParpare;
import info.catarc.webdriver.pageshelper.LoginPageHelper;

public class DataManagement_002_MDS extends BaseParpare{
	@Test(dataProvider="testData")
	public void audit(Map<String, String> data) {		
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
		//选中"未审核"
		seleniumUtil.click(By.xpath(".//*[@id='boundlist-1049-listEl']/ul/li[3]"));
		seleniumUtil.click(By.id("button-1014-btnEl"));
		seleniumUtil.waitForPageLoading(3000);
		seleniumUtil.click(By.xpath(".//*[@id='gridview-1028']/table/tbody/tr[2]/td[1]/div/div"));
		//点击"审核"
		//seleniumUtil.click(By.id("button-1043-btnEl"));
		//seleniumUtil.waitForPageLoading(3000);
		//切换到新窗口
		//seleniumUtil.switchToNewWindow();
		String mdsID = seleniumUtil.getText(By.xpath(".//*[@id='gridview-1028']/table/tbody/tr[2]/td[3]/div"));
		mdsID = mdsID.split(" ")[0];
		System.out.println(mdsID);
		String url = "http://60.30.69.61:8290/CESEMDMS/auditManager/auditManager/mdsvalidate.action?mdsId=" +  mdsID + "&mdsIdArray=" + mdsID + "&type=audit";
		seleniumUtil.switchToNewPage(url);
		seleniumUtil.waitForPageLoading(3000);
		seleniumUtil.click(By.xpath(".//*[@id='gridview-1015']/table/tbody/tr[2]/td[1]/div/div"));
		int state = 0;
		seleniumUtil.waitForElementToLoad(3000, By.xpath(".//*[@id='gridview-1015']/table/tbody/tr[2]/td[5]/div"));
		//对于审核通过的点击审核，对于审核不通过的点击拒绝
		//if(seleniumUtil.getText(By.xpath(".//*[@id='gridview-1015']/table/tbody/tr[2]/td[5]/div")).equals("通过"))
		//	System.out.println(seleniumUtil.getText(By.xpath(".//*[@id='gridview-1015']/table/tbody/tr[2]/td[5]/div")));
		if(seleniumUtil.getText(By.xpath(".//*[@id='gridview-1015']/table/tbody/tr[2]/td[5]/div")).equals("通过")){
			//点击审批
			seleniumUtil.click(By.id("auditButton-btnEl"));
			//点击是
			seleniumUtil.click(By.id("button-1006-btnEl"));
			state = 0;
		}
		else{
			//点击拒绝
			seleniumUtil.click(By.id("refuseButton-btnEl"));
			//填写拒绝理由
			seleniumUtil.type(By.id("refuseReation-inputEl"), "含量超标");
			//点击提交
			seleniumUtil.click(By.id("button-1040-btnInnerEl"));
			state = 1;
		}
		
		/*//验证是否审核或者拒绝操作是否成功
		//等待登录页面加载
		seleniumUtil.switchToNewPage("http://60.30.69.61:8290/CESEMDMS/login/welcomeAction.action");
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
		if(state == 0){
			System.out.println(seleniumUtil.getText(By.xpath(".//*[@id='gridview-1028']/table/tbody/tr[2]/td[12]/div")));
			seleniumUtil.assertTrue(seleniumUtil.findElementBy(By.xpath(".//*[@id='gridview-1028']/table/tbody/tr[2]/td[12]/div")), "");
		}
		else if(state == 1){
			System.out.println(seleniumUtil.getText(By.xpath(".//*[@id='gridview-1028']/table/tbody/tr[2]/td[12]/div")));
			seleniumUtil.assertTrue(seleniumUtil.findElementBy(By.xpath(".//*[@id='gridview-1028']/table/tbody/tr[2]/td[12]/div")), "含量超标");
		}*/
	}
}
