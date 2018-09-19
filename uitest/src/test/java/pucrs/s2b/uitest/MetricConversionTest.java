package pucrs.s2b.uitest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MetricConversionTest {
	@Test
	public void givenGooglePageWhenSearchingForWikipediaThenAWikipediaSearchBoxAppears() {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\teste\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		String initialPage = "https://www.metric-conversions.org/pt-br/comprimento/milhas-em-quilometros.htm";
		driver.get(initialPage);
		
		WebElement inputElement = driver.findElement(By.id("argumentConv1"));
		inputElement.sendKeys("10");
		inputElement.submit();
		
		WebElement outElement = driver.findElement(By.id("answer"));
		double actual = Double.parseDouble(outElement.getText().split("=")[1].replace("km",""));
		double expected = 16.09;
		
		assertEquals(expected, actual, .01);

		driver.close();
	}
}
