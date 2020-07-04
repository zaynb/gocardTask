package gocardTask;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestRegistrationwithbefore {
	
	WebDriver driver;


	@BeforeTest
	public void Setup() {
		
	    driver = new ChromeDriver ();
		driver.get("https://www.gocardi.com");
		driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

}
		@Test (priority=1)
		public void TestregistrationWithvalidinput () {	
			

WebElement login =driver.findElement(By.xpath("//*[@id='page-content-wrapper']/header/nav[1]/div/div[1]/ul/li[1]/a"));
login.click();
// locate firstname and enter data 
WebDriverWait wait = new WebDriverWait(driver, 20);
WebElement firstname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstname")));
firstname.click();
firstname.sendKeys("Zaynab"); 

//locate lastname and enter data 

WebElement lastname = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastname")));
lastname.click();
lastname.sendKeys("Ragab");

//locate email and enter data 
WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
email.click();
email.sendKeys("newzaynabtes7@mailinator.com");

//locate password and enter data 

WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
password.click();
password.sendKeys("password@card");


//locate checkbox privacy and enter data 

WebElement chexbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='signupForm']/div[5]")));
chexbox.click();
      		

//locate checkbox for mail notification and make a right tick  

WebElement chexbox2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='signupForm']/div[6]/div/label")));
chexbox2.click();

//locate checkbox privacy and enter data 
WebElement register = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='signupForm']/div[7]")));
register.click();

// locate success message 
wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='page-content-wrapper']/div[2]/div/div/div/div/div[1]/h2")));

String successmessage = driver.findElement(By.xpath("//*[@id='page-content-wrapper']/div[2]/div/div/div/div/div[1]/h2")).getText();
assertEquals(successmessage, "التسجيل اكتمل!");
		}   
		
		

		 @Test (priority=2)
		public void zTestregistrationWithemailalreadyexist () {	
			

WebElement login =driver.findElement(By.xpath("//*[@id='page-content-wrapper']/header/nav[1]/div/div[1]/ul/li[1]/a"));
login.click();
// locate firstname and enter data 
WebDriverWait wait1 = new WebDriverWait(driver, 40);
WebElement firstname = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstname")));
firstname.click();
firstname.sendKeys("Zaynab"); 

//locate lasttname and enter data 
WebElement lastname = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastname")));
lastname.click();
lastname.sendKeys("Ragab");

//locate email and enter data 
WebElement email = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
email.click();
email.sendKeys("zragabagab@mailinator.com");

//locate password and enter data 
WebElement password = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.id("password")));
password.click();
password.sendKeys("password@card");


//locate checkbox privacy and enter data 
WebElement chexbox = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='signupForm']/div[5]")));
chexbox.click();
      		

//locate checkbox for mail notification and make a right tick  
WebElement chexbox2 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='signupForm']/div[6]/div/label")));
chexbox2.click();

//locate Register and Click on it 
WebElement register = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='signupForm']/div[7]")));
register.click();

// locate error message 
wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='signupForm']/div[1]/p")));
String errormessage = driver.findElement(By.xpath("//*[@id='signupForm']/div[1]/p")).getText();
assertEquals(errormessage , "عنوان البريد الإلكتروني مستعمل");
		}   

			@AfterTest
			public void tearDown() throws Exception{
				
			driver.quit();
			}
			
}

