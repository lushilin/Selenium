package info.catarc.webdriver.pages;



	import org.openqa.selenium.By;
	/**
	 * @author Guojs
	 * @description 登录页面元素定位声明
	 * */
	public class LoginPage {
		/**用户名输入框*/
		public static final By LP_INPUT_USERNAME = By.id("userName");
		
		/**密码输入框*/
		public static final By LP_INPUT_PASSWORD = By.id("password");
		
		/**登录按钮*/
		public static final By LP_BUTTON_LOGIN = By.xpath("//form[@id='login_form']/div/div[3]/div/div[4]");
		
		

		
		
	}
