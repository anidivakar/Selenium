package com.selenium.keywords;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Generickeywords {

	static WebDriver driver;
	public Properties prop;
	public static Logger logger = null;
	public Generickeywords() throws IOException {
			FileReader fs=new FileReader("Auction.properties");
			
			prop= new Properties();
			prop.load(fs);

	}
	
	public void launchBrowser(String browsertype) throws Throwable							
    {		
       	try{
 		if (browsertype.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver", "D:\\Java-SW\\BrowserDrivers\\chromedriver.exe");
 			//System.setProperty("webdriver.chrome.driver", "D:\\Training\\UST - TT batches\\9 - 6\\workspace\\selenium\\drivers\\chromedriver.exe");
 			
 			driver = new ChromeDriver();
 			logger.info("Successfully loaded the Chrome browser");
 			}else
 				
	 			if (browsertype.equals("Mozilla")){
//	 				System.setProperty("webdriver.gecko.driver", "D:\\Browserdriver\\New folder\\geckodriver.exe");
//	 				System.setProperty("webdriver.gecko.driver", "D:\\Training\\UST - TT batches\\9 - 6\\workspace\\selenium\\drivers\\geckodriver.exe");
	 					
	 				driver = new FirefoxDriver();
	 				logger.info("Successfully loaded the Firfox browser");
	 					}else
	 		 				
	 			 			if (browsertype.equals("IE")){
	 			 				System.setProperty("webdriver.ie.driver", "D:\\Java-SW\\BrowserDrivers\\IEDriverServer.exe");
	 			 					
	 			 				driver = new InternetExplorerDriver();
	 			 				logger.info("Successfully loaded the IE browser");
	 			 					}
 			
 			driver.manage().window().maximize();
 			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); 			
 			logger.info("Successfully maximized");
       	}catch(Exception e){
 			e.printStackTrace();
 			logger.error("Error while launching Browser");
 			}
 			
       	
       	}
	
	public void navigate(String url){
		try{
			driver.get(prop.getProperty(url));
			logger.info("Successfully entered the url in the browser launched");
		}catch(Exception e){
 			e.printStackTrace();
 			logger.error("Error while navigating");
 			}
		}
	
	public void click(String locator){
		
		try{
			getObject(locator).click();
			logger.info("Successfully clicked");
		}catch(Exception e){
 			e.printStackTrace();
 			logger.error("Error while click");
 			}
	}
	
	public void input(String locator,String data){
		try{
		getObject(locator).sendKeys(data);
		logger.info("Successfully entered the values");
		}catch(Exception e){
			e.printStackTrace();
			logger.error("Error while entering values");
			}
	}
	
	public WebElement getObject(String locator){
		WebElement e=null;
		
		try{
		
		if(locator.endsWith("_xpath")){	
			e=driver.findElement(By.xpath(prop.getProperty(locator)));
			logger.info("Successfully identified the element with the given xpath as locator");
		}else if(locator.endsWith("_id")){
			e=driver.findElement(By.id(prop.getProperty(locator)));
			logger.info("Successfully identified the element with the given id as locator");
		}else if(locator.endsWith("_name")){
			e=driver.findElement(By.name(prop.getProperty(locator)));
			logger.info("Successfully identified the element with the given name as locator");
		}else if(locator.endsWith("_linkText")){
			e=driver.findElement(By.linkText(prop.getProperty(locator)));
			logger.info("Successfully identified the element with the given linktext as locator");
		}else if(locator.endsWith("_tagName")){
			e=driver.findElement(By.tagName(prop.getProperty(locator)));
			logger.info("Successfully identified the element with the given tagname as locator");
		}
		}catch(Exception x){
			//report error
			x.printStackTrace();
			logger.error("Error while identifying the Element values");
		}
		return e;
	}

}
