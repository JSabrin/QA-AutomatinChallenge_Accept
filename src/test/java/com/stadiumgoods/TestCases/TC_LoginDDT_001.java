package com.stadiumgoods.TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;

public class TC_LoginDDT_001 {


	static WebDriver driver;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		
			System.setProperty("webdriver.chrome.driver",
					"C:\\All Drivers\\chromedriver.exe");
			driver = new ChromeDriver(); // launching chrome Browser
			
			driver.get("https://stadium:goods2018!@stage.stadiumgoods.cloud");
			driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			
			driver.findElement(By.xpath("//i[@class='icon-user svg-icon']")).click();
			
			 String path = "C://Users//sabrina//Desktop//TestData.xlsx";
			
			//String path = "C://Users//sabrina//workspace//stadiumGoods_DDT_Framework//src//test//java//com//stadiumgoods//TestCases//TestData.xlsx";
			
			int rows=XLUtils.getRowCount(path, "Sheet1");
			
			for(int i=1;i<=rows;i++){
				String username=XLUtils.getCellData(path, "Sheet1", i, 0);
				String password=XLUtils.getCellData(path, "Sheet1", i, 1);
				
				driver.findElement(By.xpath("//input[@id='email']")).sendKeys(username);
				driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(password);
			
				driver.findElement(By.id("send2")).click();
			
				if(driver.getTitle().equals("Customer Login"))
				{
					System.out.println("Test passed");
				    XLUtils.setCellData(path, "Sheet1", i, 2, "Passed"); 
				}
				else
				{
					System.out.println("Test failed");
					XLUtils.setCellData(path, "Sheet1", i, 2, "Failed");
				}
				
					Thread.sleep(2000);
					driver.findElement(By.xpath("//i[@class='icon-user svg-icon']")).click();
				}
			
			
			driver.close();
			
		}

		
	}


