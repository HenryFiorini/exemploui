package pucrs.s2b.uitest;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AppTest {
	@Test
	public void givenGooglePageWhenSearchingForWikipediaThenAWikipediaSearchBoxAppears() {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\teste\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("wikipedia");
		element.submit();
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement messageElement = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.id("nqsbq"))
				);
		
		assertNotNull(messageElement);

		driver.close();
	}
}
