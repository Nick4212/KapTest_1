import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;

public class LoginPage {
	      public static final String URL = "http://www.amazon.com";
	      public static final String File_Path = "\\C:\\SeleniumAutomation\\";
	      public static final String File_Name = "TestData.xlsx";
	     
	      // Login links id or xpath
	      public static final String Sign_In_Link = "nav-link-yourAccount";
	      public static final String UserID_Input = "ap_email";
	      public static final String Password = "ap_password";
	      public static final String Sign_In_Submit = "signInSubmit";
	      public static final String Err_Text_Link = "//*[@id='auth-error-message-box']/div/div/ul/li/span";
	      
	      
	  	// enter credentials and submit
			public static void loginSubmit(WebDriver driver, String UserID, String Passwd){
			driver.findElement(By.id(UserID_Input)).clear();
			driver.findElement(By.id(UserID_Input)).sendKeys(UserID);
			driver.findElement(By.id(Password)).clear();
			driver.findElement(By.id(Password)).sendKeys(Passwd);
			driver.findElement(By.id(Sign_In_Submit)).click();
			}
			
		
	
}
	

