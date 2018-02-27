package npu;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

public class EndToEndTest {
	
	private WebDriver driver;
	  private String baseUrl;
	  private StringBuffer verificationErrors = new StringBuffer();
	  String searchText1;
	  String searchText2;
	  String searchText3;
	  String searchText4;
	  
	  @BeforeClass
	  public static void initiate()
	  {
	  	System.out.println("**Begining**");
	  }

	  @BeforeMethod
	  public void setUp() throws Exception {
		  
		//Initiation Firefox browser.
		  
	    driver = new FirefoxDriver();
	    driver.manage().window().maximize();
	    baseUrl = "https://www.google.com/";
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	  }

	  @Test
	  public void testNpuNewAccount() throws Exception {
		
		/*Google search and click to open the search result &
		open NPU web page, go through the main home page*/
		  
	    driver.get(baseUrl);
		driver.findElement(By.id("lst-ib")).clear();
		driver.findElement(By.id("lst-ib")).sendKeys("NPU");
		driver.findElement(By.linkText("Northwestern Polytechnic University | Welcome to ... - Fremont")).click();
		Thread.sleep(2000);
	    
		//Open Admissions to check some quick links.
		
	    driver.findElement(By.linkText("Admissions")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.linkText("Application Guide")).click();
	    Thread.sleep(2000);
	    driver.navigate().back();
		Thread.sleep(2000);
	    driver.findElement(By.linkText("Graduate")).click();
	    Thread.sleep(2000);
	    driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		
		//Open Academics to learn more details.
		
		driver.findElement(By.linkText("Academics")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.linkText("School of Engineering")).click();
	    Thread.sleep(2000);
	    driver.navigate().back();
		Thread.sleep(2000);
	    driver.findElement(By.linkText("Scholarships")).click();
	    Thread.sleep(2000);
	    driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		
		//Open Campus and go through NPU Campus tour.
		
		driver.findElement(By.linkText("Campus")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.linkText("Club Facilities")).click();
	    Thread.sleep(2000);
	    driver.navigate().back();
		Thread.sleep(2000);
	    driver.findElement(By.linkText("Career Center")).click();
	    Thread.sleep(2000);
	    driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		
		//Open NPU News AND Blogs & Check more information. 
		
		driver.findElement(By.linkText("NPU News")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.linkText("Student Association Blog")).click();
	    Thread.sleep(2000);
	    driver.navigate().back();
		Thread.sleep(2000);
	    driver.findElement(By.linkText("NPU Globe")).click();
	    Thread.sleep(2000);
	    driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().back();
		Thread.sleep(1000);
		
		driver.findElement(By.linkText("Apply Online")).click();
	    Thread.sleep(2000);
	 	    
	    //Go to Online Application to register.
	    //Verify checkbox is not selected.
	    
		if(!driver.findElement(By.id("regcheck")).isSelected())
		{
			//Select checkbox "I understand and I would like to register a new account".
			
			driver.findElement(By.id("regcheck")).click();
		}
		
		  
		//Click Link Text "Register Account" to open Create a New Account
		
	    driver.findElement(By.linkText("Register Account")).click();
	    
	    try 
	    {
	    	  //Read data from xsls sheet.
	    	
			  FileInputStream file = new FileInputStream(new File("E:/Nikita NPU/4th sem at NPU/AutomationTesting/FinalProject/data.xlsx")); 
			  XSSFWorkbook workbook = new XSSFWorkbook(file);
			  XSSFSheet sheet = workbook.getSheetAt(0);
						    
			  searchText1 = sheet.getRow(1).getCell(0).getStringCellValue();				    
			  searchText2 = sheet.getRow(1).getCell(1).getStringCellValue();
			  searchText3 = sheet.getRow(1).getCell(2).getStringCellValue();			    
			  searchText4 = sheet.getRow(1).getCell(3).getStringCellValue();
	    
	    
			  /*Verify the default radio button should select in New Applicant,
	      		select it if has not selected.*/
	    
			  driver.findElement(By.id("new")).isSelected();
			  if(!driver.findElement(By.id("new")).isSelected())
			  {
				  driver.findElement(By.id("new")).click();
			  }
	    
			  //Select your gender
	    
			  new Select(driver.findElement(By.id("Gender"))).selectByVisibleText("Female");
	        
			  //Input Given Name/First Name, Surname/Primary Name, Email Address.
	    	    
			  driver.findElement(By.id("FirstName")).clear();
			  driver.findElement(By.id("FirstName")).sendKeys(searchText1);
	    
			  driver.findElement(By.id("LastName")).clear();
			  driver.findElement(By.id("LastName")).sendKeys(searchText2);
	    
			  driver.findElement(By.id("Email")).clear();
			  driver.findElement(By.id("Email")).sendKeys(searchText3);
	    
			  driver.findElement(By.id("Password")).clear();
			  driver.findElement(By.id("Password")).sendKeys(searchText4);
	    
			  driver.findElement(By.id("ConfirmPassword")).clear();
			  driver.findElement(By.id("ConfirmPassword")).sendKeys(searchText4);
	     
			  //Click Save button, check warning message(s)
	    	    
			  driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
			  Thread.sleep(2000);
	    
			  //Verify error message(s)
	    
			  String searchResult = "Invalid reCAPTCHA request. Missing response value.";
			  boolean b= driver.getPageSource().contains(searchResult);
			  if(b)
			  {
				  System.out.println("Error message is present.");
			  }
			  else
			  {
				  System.out.println("Error message is not present.");
			  }   
	    
			  // Capture screenshot.
			  
			  captureScreenshot(driver, "ErrorMessage");
	    
			  //Go back.
	    
			  driver.navigate().back();
			  Thread.sleep(1000);
			  driver.navigate().back();
			  Thread.sleep(1000);
		
			  //Go back to NPU main home page.
		
			  driver.navigate().to("http://npu.edu/");	
		
			  //Close window.
			  
			  driver.quit();
	    
			  //write data from xsls sheet.
	    
			  File src=new File("E:/Nikita NPU/4th sem at NPU/AutomationTesting/FinalProject/data.xlsx");
			  FileInputStream fis=new FileInputStream(src);
			  XSSFWorkbook wb=new XSSFWorkbook(fis);
			  XSSFSheet sh1= wb.getSheetAt(0);		
			  sh1.getRow(1).createCell(4).setCellValue("Pass");
			  
			  FileOutputStream fout=new FileOutputStream(new File("E:/Nikita NPU/4th sem at NPU/AutomationTesting/FinalProject/data.xlsx"));
			  wb.write(fout);
			  fout.close();
			  wb.close();			
			  
			  workbook.close();
			  file.close();
	    }
	    catch (FileNotFoundException e) 
	    {
	    	e.printStackTrace();
	    }
	    catch (IOException ioe) 
	    {
	    	ioe.printStackTrace();
	    }
	  }
	  
	  public static String captureScreenshot(WebDriver driver, String screenshotname) 
	  {
		try {
				TakesScreenshot ts = (TakesScreenshot)driver;
				File source = ts.getScreenshotAs(OutputType.FILE);
		    	String dest = "./screenshot/" + screenshotname + ".png";
			   	File destination = new File(dest);							
				FileUtils.copyFile(source, destination);
			    System.out.println("Screnshot has been taken.");
				return dest;
			}
			catch (Exception e) 
			{
				System.out.println("Exception while taking screenshot." + e.getMessage());
				return e.getMessage();
			}
		}

	  @AfterMethod
	  public void tearDown() throws Exception 
	  {
	    driver.quit();
	    String verificationErrorString = verificationErrors.toString();
	    if (!"".equals(verificationErrorString)) 
	    {
	      fail(verificationErrorString);
	    }
	  }
	  
	  @AfterClass
	  public static void teardown()
	  {
	  	System.out.println("**Ending**");
	  }
}
