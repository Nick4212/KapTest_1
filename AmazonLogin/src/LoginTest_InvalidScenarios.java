
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class LoginTest_InvalidScenarios {
	private WebDriver driver;
	private String UserID;
	private String Passwd;
	private String validationText;
	
	@Before
	public void setUp() throws Exception {
		driver = new FirefoxDriver();
	// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@Test
	
	public void TestingLoginPage() throws Exception {
		// Navigation and click the header to see the page
		driver.get(LoginPage.URL);
		driver.findElement(By.id(LoginPage.Sign_In_Link)).click();
		Thread.sleep(3000);
		
		// the location of Excel file
		ExcelUtility.setExcelFile(LoginPage.File_Path + LoginPage.File_Name, "Sheet1");
		//Clear the Result fields
		ExcelUtility.setCellData("No Run", 1, 4);
		ExcelUtility.setCellData("No Run", 2, 4);
		
		//*****Scenario Blank Username and Password
		
		//Read data from excel
		 UserID = ExcelUtility.getCellData(1, 1);
		 Passwd = ExcelUtility.getCellData(1, 2);
		 validationText = ExcelUtility.getCellData(1, 3);
		//System.out.println("Validation text is: " + validationText);
		
		//Enter data and login 
		LoginPage.loginSubmit(driver, UserID, Passwd);
		
		// Capture the error text
		String errText = null;
		errText = driver.findElement(By.xpath(LoginPage.Err_Text_Link)).getText();
		System.out.println("Error for blank Username and Password is: " + errText);
		
		// write the result in excel
		if (errText.matches(validationText) ){
			ExcelUtility.setCellData("Pass", 1, 4);
			System.out.println("Testing scenario - blank Username and Password is pass.");
			}else {
				ExcelUtility.setCellData("Fail", 1, 4);
				System.out.println("Testing scenario - blank Username and Password is fail.");
			}
		
		Thread.sleep(2000);
		
		//*****Scenario Wrong Username and Password
		
				//Read data from excel
				 UserID = ExcelUtility.getCellData(2, 1);
				 Passwd = ExcelUtility.getCellData(2, 2);
				 validationText = ExcelUtility.getCellData(2, 3);
				//System.out.println("Validation text is: " + validationText);
				
				//Enter data and login 
				LoginPage.loginSubmit(driver, UserID, Passwd);
				
				// Capture the error text
				String errText1 = null;
				errText1 = driver.findElement(By.xpath(LoginPage.Err_Text_Link)).getText();
				System.out.println("Error for Wrong Username and Password is: " + errText1);
				
				// write the result in excel
				if (errText1.matches(validationText) ){
					ExcelUtility.setCellData("Pass", 2, 4);
					System.out.println("Testing scenario - blank Username and Password is pass.");
					}else {
						ExcelUtility.setCellData("Fail", 2, 4);
						System.out.println("Testing scenario - blank Username and Password is fail.");
					}
		
	}	

	
	@After
	public void tearDown() throws Exception {
	    driver.quit();
	}
}
