package info.catarc.webdriver.pageshelper;

import org.apache.log4j.Logger;

import info.catarc.webdriver.pages.LoginPage;
import info.catarc.webdriver.utils.SeleniumUtil;



/**
 * @author Guojs
 * @description 登录页面帮助类：提供在这个页面上做的操作的方法封装
 * */
public class LoginPageHelper {
		//提供本类中日志输出对象
		public static Logger logger = Logger.getLogger(LoginPageHelper.class);
		
		/**
		 * @author Young
		 * @description 等待登录页面元素加载
		 * @param seleniumUtil selenium api封装引用对象
		 * @param timeOut 等待元素超时的时间
		 * */
		public static void waitLoginPageLoad(SeleniumUtil seleniumUtil,int timeOut){
			logger.info("开始检查登录页面元素");
			seleniumUtil.waitForElementToLoad(timeOut, LoginPage.LP_INPUT_USERNAME);
			seleniumUtil.waitForElementToLoad(timeOut, LoginPage.LP_INPUT_PASSWORD);
			seleniumUtil.waitForElementToLoad(timeOut, LoginPage.LP_BUTTON_LOGIN);
			logger.info("检查登录页面元素完毕");
		}
		
		
		
		/**
		 * @author Guojs
		 * @description 登录操作封装
		 * @param seleniumUtil selenium api封装引用对象
		 * @param username 用户名值
		 * @param password 用户密码值 
		 * */
		public static void typeLoginInfo(SeleniumUtil seleniumUtil,String username,String password){
		
			logger.info("开始输入登录信息");
			//清空用户名输入框
			seleniumUtil.clear(LoginPage.LP_INPUT_USERNAME);
			//输入用户名到用户名输入框
			seleniumUtil.type(LoginPage.LP_INPUT_USERNAME,username);
			//清空密码输入框
			seleniumUtil.clear(LoginPage.LP_INPUT_PASSWORD);
			//输入密码到密码输入框
			seleniumUtil.type(LoginPage.LP_INPUT_PASSWORD, password);
			logger.info("输入登录信息完毕");
			//点击登录按钮
			seleniumUtil.click(LoginPage.LP_BUTTON_LOGIN);
			
			

			
		}
		


}
