package com.m2ost.Login;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class Login extends BaseClass {
	
	@Test(testName = "TestLogin", dataProvider = "file", dataProviderClass = DataPRividerClass.class)
	public void TestLogin (String username,String password) {
		ExtentTest test = extentReport.createTest("Login Page report");
		test.log(Status.PASS, "Enterd Login Page Module");
		//WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.get("https://www.m2ost.in/m2ost_console_prime/bata");
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//driver.findElement(By.xpath("//input[@id='user_name']")).click();

		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys(username);
		//driver.findElement(By.xpath("//input[@id='password']")).click();

		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
		
		driver.findElement(By.xpath("//div[@class='login']//button[@class='submit'][normalize-space()='Sign in']")).click();
		
		System.out.println(driver.getTitle());
		
		String ExpectedOutcome="M2OST";
		String ActualOutcome = driver.getTitle();
		Assert.assertEquals(ActualOutcome, ExpectedOutcome);
		//driver.close();
		
		}
	
	
	
     @Test(testName = "TestM2OST")
	public void TestM2OST() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.m2ost.in/m2ost_console_prime/bata");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@id='user_name']")).click();

		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("Bata506_BA");
		driver.findElement(By.xpath("//input[@id='password']")).click();

		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Welc0me@123");
		driver.findElement(By.xpath("//div[@class='login']//button[@class='submit'][normalize-space()='Sign in']")).click();
		
		System.out.println(driver.getTitle());
		String ExpectedOutcome="M2OST";
		String ActualOutcome = driver.getTitle();
		Assert.assertEquals(ActualOutcome, ExpectedOutcome);

	}

}
