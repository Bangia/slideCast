package test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pageObjects.contactPageObjects;
import pageObjects.loginApp;

public class fileUploadContact {
	
	@Test
	public void fileUploadTestCase() throws InterruptedException, IOException{
		
		//Back up script
		 System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Nitin Bangia\\\\Documents\\\\chromedriver_win32\\\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		
		driver.get("https://dev.slidecast.com/login");
		driver.manage().window().maximize();
		 
		
		
		loginApp lp = new loginApp(driver);

		//********* Login via phone code starts here ******************************************************
		lp.mobileRadioClick();
		
		
		driver.manage().timeouts().implicitlyWait(4000, TimeUnit.MILLISECONDS);
		
		
		
		lp.mobileNumbTxtField("2015550000");
		
		
		lp.mobilePwdTxtField("Fr33dom!");
		
		
		lp.mobileSbtBtn();
		
		Thread.sleep(8000);
      driver.findElement(By.xpath("//input[@formcontrolname='securityCode']")).sendKeys("579154");
      driver.findElement(By.xpath("//button[@class='btn btn-success']")).click();
//		lp.otpSubmit();
//	
		
		//********* Login done and above OTP code end here *************************************************
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		
		
		//Create contact link code starts here...
		contactPageObjects cpo = new contactPageObjects(driver);
		
		driver.manage().timeouts().implicitlyWait(10000, TimeUnit.MILLISECONDS);
		
		cpo.contactLink();
		
		Thread.sleep(3000);
		cpo.hamburgerIconClick();
		
		
		driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath("//span[normalize-space()='Import']")).click();
		
		driver.manage().timeouts().implicitlyWait(7000, TimeUnit.MILLISECONDS);
		driver.findElement(By.xpath("/html/body/app-root/body/app-contacts-v3/div/div[2]/div/div/div[2]/div/div/div/angular-file-uploader/div/label")).click();
		
		//driver.findElement(By.xpath("//label[normalize-space()='Select your File']")).sendKeys("/Users/rst/eclipse-workspace/slideCast/ImportContact.xlsx");
		
     //******************************************AUTO IT CODE STARTS HERE***************************************
		Thread.sleep(8000);
		//Runtime.getRuntime().exec("C://Users//Nitin Bangia//Desktop//fileUpload.exe"+" "+"C:\\Users\\Nitin Bangia\\Desktop\\slidecast_excel_template.xlsx");
		Runtime.getRuntime().exec("C://Users//Nitin Bangia//Desktop//fileUpload.exe");
		
		//Assertion
		
		String FileUploadedName = driver.findElement(By.xpath("//span[@class='text-primary']")).getText();
		System.out.println(FileUploadedName);
		
		String Expected_FileUploadedName = "slidecast_excel_template.xlsx";
		
		if(FileUploadedName.contains(Expected_FileUploadedName)) {
			driver.findElement(By.xpath("//button[@class='btn btn-success afu-upload-btn ng-star-inserted']")).click();
			System.out.println("File Uploaded");
			Thread.sleep(6000);
			driver.close();
		   
		}
		else {
			System.out.println("Unable to upload file");
			Thread.sleep(6000);
			driver.close();
		}
		
		
		
		
		//driver.findElement(By.xpath("//button[@class='btn btn-success afu-upload-btn ng-star-inserted']")).click();
		
		
	}
	
	
	

}
