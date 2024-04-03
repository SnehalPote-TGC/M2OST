package com.m2ost.Login;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContentCheck {
	
	WebDriver driver;
	@Test
	public void loginForAplication() {
		
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.m2ost.in/m2ost_console_prime/bata");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//input[@id='user_name']")).click();

		driver.findElement(By.xpath("//input[@id='user_name']")).sendKeys("Bata505_BA");
		driver.findElement(By.xpath("//input[@id='password']")).click();

		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Welc0me@123");
		driver.findElement(By.xpath("//div[@class='login']//button[@class='submit'][normalize-space()='Sign in']")).click();
		
	}
	@Test
	public void checkContent() {
					
		driver.findElement(By.xpath("//img[@name='Learning Corner']")).click();
		driver.findElement(By.xpath("//a[@id='4']")).click();
		
		String str = driver.findElement(By.xpath("//div[@class='item']//div[2]//div[1]//h3[1]")).getText();
		//System.out.println("String for percentage " +str);
		String str1="Completion Status: 0 %";
		if(str.equalsIgnoreCase(str1)) {
			driver.findElement(By.xpath("//div[@id='tab_4']//div[1]//a[1]//img[1]")).click();
			driver.findElement(By.xpath("//td[@class='listclr2']//a[@id='lnk_486']")).click();
			Alert alert = driver.switchTo().alert();
			String str3 = alert.getText();
			alert.accept();
			String str4 = "Please read the complete content to attempt the Assessment!!";
			//System.out.println("Alert Message  " +str4);
			if(str3.equalsIgnoreCase(str4)) {
				System.out.println("Content Check is working");
			}
			else {
				System.out.println("Content Check is not working");
			}
			
		}else {
			System.out.println("Completion percentage is not 0 so can not check the content logic");
		}
		
		
		
	}
	@Test
	public void feedbackFormCheck() {
		driver.findElement(By.xpath("//strong[normalize-space()='Feedback Form']")).click();
		driver.findElement(By.xpath("//textarea[@id='FeedBackText']")).sendKeys("You  have nice test in content");
		driver.findElement(By.xpath("//button[@class='feedbackSubmitBtn']")).click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
	}
	
	@Test
	public void closeTheWindow() {
		driver.close();
	}

}
