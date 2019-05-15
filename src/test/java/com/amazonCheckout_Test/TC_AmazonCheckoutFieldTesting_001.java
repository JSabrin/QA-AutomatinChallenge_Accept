package com.amazonCheckout_Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_AmazonCheckoutFieldTesting_001 {

	static WebDriver driver;
	
		@BeforeMethod
		public void setUp(){
		System.setProperty("webdriver.chrome.driver",
				"C:\\All Drivers\\chromedriver.exe");
		driver = new ChromeDriver(); // launching chrome Browser
		
		driver.get("https://www.amazon.com/");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		}
		@Test
		public void testProductSearch() throws InterruptedException{
			driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Shoes");
			driver.findElement(By.cssSelector(".nav-input[type='submit']")).click();
			
			Thread.sleep(5000);
			
			((JavascriptExecutor)driver).executeScript("scroll(0,600)");
			
			driver.findElement(By.xpath("//*[@id='p_89/adidas']")).click();
			
			Thread.sleep(2000);
			
	        //driver.findElement(By.xpath("//*[@id='pdagDesktopSparkleAsinContainer1']")).click();
		
		    //driver.findElement(By.xpath("//*[@id='search']/div[1]/div[2]/div/span[3]/div[1]/div[1]/div/div/div/div[2]/div[2]/div/div[1]/h2/a/span")).click();
			
		    driver.findElement(By.xpath("//span[contains(text(),'BYD Running Shoe')]")).click();
		    
		    
		    if(driver.getPageSource().contains("BYD Running Shoe")) 
			{	
				System.out.println("Same item present in this page");	
		   }
		   else
		   {
			   System.out.println("Same item not Present in this page");
		   }
		   
		    Thread.sleep(2000);
		    
		   Select objselect = new Select(driver.findElement(By.name("dropdown_selected_size_name")));
		   objselect.selectByVisibleText("9 M US");
		   
		   Thread.sleep(2000);
		   
		   driver.findElement(By.name("submit.add-to-cart")).click();
		   
		   Thread.sleep(2000);
		   
		   driver.findElement(By.id("hlb-ptc-btn-native")).click();
		   
           Thread.sleep(2000);
		   
           //sorry no choice to Checkout without create a sign up
		   driver.findElement(By.name("email")).sendKeys("jsabrina955@gmail.com");
		   driver.findElement(By.name("password")).sendKeys("abcd123$");
		   driver.findElement(By.id("signInSubmit")).click();
		   
		   Thread.sleep(2000);
		  
		  //sorry invalid Address is not taking that's why I am using this address
		   
		  WebElement txtAddress = driver.findElement(By.name("enterAddressAddressLine1"));
		  txtAddress.sendKeys("47 Howard St.");
		  
		  WebElement txtCity = driver.findElement(By.name("enterAddressCity"));
		  txtCity.sendKeys("New York");
		  
		  WebElement txtState = driver.findElement(By.name("enterAddressStateOrRegion"));
		  txtState.sendKeys("NY"); 
		  
		  WebElement txtZipcode = driver.findElement(By.name("enterAddressPostalCode"));
		  txtZipcode.sendKeys("10013"); 
		  
		  WebElement txtPHNumber = driver.findElement(By.name("enterAddressPhoneNumber"));
		  txtPHNumber.sendKeys("111-222-3333");
		  
		  driver.findElement(By.name("shipToThisAddress")).click();
		  
		  Thread.sleep(3000);
		  
		  driver.findElement(By.xpath("//input[@type='submit'or value='Continue']")).click();
		  
		  Thread.sleep(5000);
		  
		  WebElement txtName = driver.findElement(By.name("name"));
		  txtName.sendKeys("Angel R");
		  
		  WebElement addCardNumber = driver.findElement(By.id("addCreditCardNumber"));
		  addCardNumber.sendKeys("4242424242424242");
		  
		  Thread.sleep(1000);
		  
		  //Bootstrap DropDown
		  
		/* driver.findElement(By.xpath("//button[contains(@class,'a-declarative']")).click();
		  
		 List<WebElement> list = driver.findElements(By.xpath("//div[@class='a-popover-inner']/following::ul[@id='5_dropdown_combobox']/li"));
		 System.out.println(list.size()); 
		 
		 for(int i=0; i<list.size(); i++){
			System.out.println(list.get(i).getText());
		 if(list.get(i).getText().contains("04")){
			 list.get(i).click();
			 break;
		 }
		 
		 }*/
		 
		driver.findElement(By.id("ccAddCard")).click();
		  
		}
		
		
		@AfterMethod
		public void tearDown(){
			driver.quit();
		}
		
		
		
		
		
		
		
		
		
		
			
		
	

}
