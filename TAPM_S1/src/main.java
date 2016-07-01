import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;


public class main {
	
	public static void main(String args[]){
		TestNG testNg = new TestNG();
		List<String> suites = new ArrayList<String>();
		suites.add("testng.xml");
		testNg.setTestSuites(suites);
		File file = new File("result/log/login/reporter.html");
		if(!file.exists())
		{
			file.mkdirs();
		}
		testNg.setOutputDirectory(file.getAbsolutePath());
		testNg.run();
	}
	

}

























































