package pucrs.s2b.uitest.po;

import static org.junit.Assert.assertEquals;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @see https://github.com/s2b-teste-2018-2/webdrivermanager-examples/blob/master/src/test/java/io/github/bonigarcia/wdm/test/ChromeTest.java
 * @author teste
 *
 */
public class MetricConversionTest {

	private WebDriver driver;

	@BeforeClass
	public static void setupClass() {
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\teste\\chromedriver_win32\\chromedriver.exe");
	}	
	
	@Before
	public void setupTest() {
		driver = new ChromeDriver();
	}
	
    @After
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
	
	@Test
	public void givenGooglePageWhenSearchingForWikipediaThenAWikipediaSearchBoxAppears() {
		String initialPage = "https://www.metric-conversions.org/pt-br/comprimento/milhas-em-quilometros.htm";
		driver.get(initialPage);
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		
		By argumentConv1 = By.id("argumentConv1");
		wait.until(presenceOfElementLocated(argumentConv1));
		WebElement inputElement = driver.findElement(argumentConv1);
		
		inputElement.sendKeys("10");
		inputElement.submit();
		
		By answer = By.id("answer");
		wait.until(presenceOfElementLocated(answer));
		WebElement outElement = driver.findElement(answer);
		
		double actual = Double.parseDouble(outElement.getText().split("=")[1].replace("km",""));
		double expected = 16.09;
		
		assertEquals(expected, actual, .01);
	}



}
