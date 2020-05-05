package TestScripts;

import org.testng.annotations.Test;

import config.StartBrowser;
import reusableClasses.BusinessFunction;

public class TC_001 extends StartBrowser{
	
	
	@Test
	public void testLogin() throws Exception {
		
		BusinessFunction fns =new BusinessFunction();
		fns.goToApplication();
		fns.login();
		
	}
	
}
