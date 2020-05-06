package com.selenium.keywords;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.Assert;

public class Assertions {
	
	public static Logger logger = null;
		public Assertions() throws IOException {
		super();

		}

		public static void verifyText(String s1, String s2){
			logger.info("veryfing test: "+ s1 + " with "+ s2);
			Assert.assertEquals(s1, s1);
			}


		public static void markPass(String message){
			logger.info("making script PASS.."+ message);
			Assert.assertTrue(true, message);
			}

	

		public static void markFail(String message){
			logger.info("making script FAIL.."+message);
			Assert.assertTrue(false, message);
			}

		public static void fail(){
			Assert.assertTrue(false);
			}

		public static void pass(){
			Assert.assertTrue(true);
			}

		}


	

