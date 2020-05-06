package com.selenium.testcases;

import java.io.IOException;

import javax.sound.sampled.Port.Info;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.selenium.keywords.Generickeywords;

public class LoginTest extends Generickeywords {
	
	private Generickeywords keyword;
	public static Logger logger = null;
	
	
	
	public LoginTest(Logger logger) throws IOException {
		super();
		LoginTest.logger = logger;
		//Logger.getLogger(LoginTest.class.getName());
	}

	
	@BeforeClass
	public void setUp() throws Throwable {
//		String log4jpath = System.getProperty("user.dir") + "/log4j.properties";
//		PropertyConfigurator.configure(log4jpath);
		
		keyword = new Generickeywords();		
		keyword.launchBrowser("Chrome");
	}
	
	
	@BeforeMethod
	public void beforeEveryTestcase() throws Throwable{

	}
	
	@Test
	public void sellerLogin(){
		keyword.navigate("url");	
		logger.info("User has navigated to the url");
	
		input(prop.getProperty("username"),"jacob");
		
		
	}
	
}
