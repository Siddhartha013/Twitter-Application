package action.Twitter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class reportTweetTest {

	public static void main(String[] args) {
		
		String baseUrl = "https://twitter.com/login";					
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Siddhartha\\Desktop\\chromedriver\\chromedriver.exe");	
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(baseUrl);
		try {
			Thread.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//span[contains(text(),'Log in to Twitter')]//following::input[6]")).sendKeys("");
		driver.findElement(By.xpath("//span[contains(text(),'Log in to Twitter')]//following::input[7]")).sendKeys("");
		driver.findElement(By.xpath("//span[contains(text(),'Log in to Twitter')]//following::span[3]")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		driver.navigate().to("https://twitter.com/justinbieber/status/1403801365365862403?s=19"); 
		driver.get("https://twitter.com/justinbieber/status/1403801365365862403?s=19");
		 try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
	     
	     Actions builderOne = new Actions(driver);
		 WebElement more = driver.findElement(By.xpath("//div[@aria-haspopup='menu' and @aria-label='More']"));
	     builderOne.click(more).perform();
	     try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
	     
	     Actions builderTwo = new Actions(driver);
		 WebElement report = driver.findElement(By.xpath("//span[contains(text(),'Report Tweet')]"));
		 builderTwo.click(report).perform();
		 
		 try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}

		 driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@allow='autoplay; fullscreen']")));
		 try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		 Actions builderThree = new Actions(driver);
		 WebElement selectIssue = driver.findElement(By.xpath("//div[contains(text(),'abusive or harmful')]"));
		 builderThree.moveToElement(selectIssue).perform();
		 builderThree.click(selectIssue).perform();
		 
		 try {
				Thread.sleep(3000);
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
		 
		 Actions builderFour = new Actions(driver);
		 WebElement moreIssue = driver.findElement(By.xpath("//div[contains(text(),'disrespectful or offensive')]"));
		 builderFour.click(moreIssue).perform();
		 System.out.println("Item has been reported successfully");
		 driver.quit();
	}

}
