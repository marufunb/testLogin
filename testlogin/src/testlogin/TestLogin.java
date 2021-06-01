package testlogin;

//import java.util.logging.FileHandler;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//comment the above line and uncomment below line to use Firefox
//import org.openqa.selenium.firefox.FirefoxDriver;

public class TestLogin {

	public void login(String username_input, String password_input){
		// declaration and instantiation of objects/variables
		System.setProperty("webdriver.chrome.driver","C:\\users\\Maruf\\chromedriver.exe");
		ChromeDriver driver =  new ChromeDriver();
		//comment the above 2 lines and uncomment below 2 lines to use Firefox
		//System.setProperty("webdriver.gecko.driver","C:\\users\\Maruf\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
		
		//switching to full window mode of Chrome
		driver.manage().window().maximize();
		
		// launch Chrome and direct it to the URL
		driver.get("https://www.saucedemo.com/");
			//getting the element username, password, and login button
			WebElement username=driver.findElement(By.id("user-name"));
			WebElement password=driver.findElement(By.id("password"));
			WebElement login = driver.findElement(By.xpath("//*[@id=\'login-button\']"));
			username.sendKeys(username_input);
			password.sendKeys(password_input);
			login.click();
			
			/*
	         * compare the actual url of the page with the expected one and print
	         * the result as "Passed" or "Failed"
	         */
			String actualUrl="https://www.saucedemo.com/inventory.html";
			String expectedUrl= driver.getCurrentUrl();
			
			if(actualUrl.equalsIgnoreCase(expectedUrl)) { 
				System.out.println("Test passed");
			} 
			else{ 
				System.out.println("Test failed");
			}
				
				//I have tried to take screenshot using the code below but could not resolve the issue with FileHandler copy method
				/*
				 try {
		            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		            //The below method will save the screen shot in destination directory with name "screenshot.png"
		             FileHandler.copy(scrFile, new File("C://screenshot.png"));
		         } catch (IOException e) {
		             e.printStackTrace();
		            }
				}
				*/
			
			//I have tried generating report using TestNG but also could not solve this
			
			//close Chrome
			driver.close();
			
	}

	public static void main(String[] args){
		TestLogin loginTest = new TestLogin();
		loginTest.login("", "");
		loginTest.login("", "secret_sauce");
		loginTest.login("standard_user", "");
		loginTest.login("105 or 1=1", "105 or 1=1");
		loginTest.login("' or ''='", "' or ''='");
		loginTest.login("standard_user", "secret_sauce");
	}

}
