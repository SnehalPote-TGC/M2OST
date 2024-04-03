package com.m2ost.Login;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {
	public static WebDriver driver;
	public static ExtentReports extentReport;
	/*@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}*/
	@AfterMethod
	public void teardown() {
		driver.quit();		
	}
	public void captureScreenshot(String fileName) throws IOException {
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./Screenshots/"+fileName);
		FileUtils.copyFile(sourceFile, destFile);
		System.out.println("Screenshot saved successfully");
	}
	@BeforeSuite
	public  void intializeExtendReport() {
		ExtentSparkReporter sparkReporter_all = new ExtentSparkReporter("AllTests.html");
		extentReport = new ExtentReports();
		extentReport.attachReporter(sparkReporter_all);
		
		extentReport.setSystemInfo("OS", System.getProperty("os.name"));
	}
	
	@AfterSuite
	public void genrateReport() {
		extentReport.flush();
		try {
			Desktop.getDesktop().browse(new File("AllTests.html").toURI());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
