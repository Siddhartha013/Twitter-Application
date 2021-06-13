package action.Twitter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class follow {

	public static void followMain(String url, String userName, String userPassword) {

		String baseUrl = url;					
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Siddhartha\\Desktop\\chromedriver\\chromedriver.exe");	
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://twitter.com/login");
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//span[contains(text(),'Log in to Twitter')]//following::input[6]")).sendKeys(userName);
		driver.findElement(By.xpath("//span[contains(text(),'Log in to Twitter')]//following::input[7]")).sendKeys(userPassword);
		driver.findElement(By.xpath("//span[contains(text(),'Log in to Twitter')]//following::span[3]")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(driver.getTitle());
		driver.navigate().to(baseUrl); 
		driver.get(baseUrl);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	
		Actions actions = new Actions(driver);
		WebElement follow = driver.findElement(By.xpath("//div[@data-testid='primaryColumn']//span[text()='Follow']"));
	    actions.moveToElement(follow).perform();
	   
	    try {
			Thread.sleep(3000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	    
	    actions.click(follow).perform();
	    System.out.println("Item has been Followed Successfully");
	    driver.quit();

	}

}
