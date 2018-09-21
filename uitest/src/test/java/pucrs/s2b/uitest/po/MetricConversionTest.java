package pucrs.s2b.uitest.po;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * @see https://github.com/s2b-teste-2018-2/webdrivermanager-examples/blob/master/src/test/java/io/github/bonigarcia/wdm/test/ChromeTest.java
 * @author teste
 *
 */
public class MetricConversionTest {

	private WebDriver driver;
	private MetricConversionPage page;

	@BeforeClass
	public static void setupClass() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\teste\\chromedriver_win32\\chromedriver.exe");
	}

	@Before
	public void setupTest() {
		driver = new ChromeDriver();

		String initialPage = "https://www.metric-conversions.org/pt-br/comprimento/milhas-em-quilometros.htm";
		driver.get(initialPage);

		page = PageFactory.initElements(driver, MetricConversionPage.class);

	}

	@After
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Test
	public void givenXMilesWhenConvertingToKilometersThenAnswerIsYKilometers() {
		double x = 10.0; // X
		page.fillMiles(x);

		String output = page.answer.getText();
		
		double actual = Double.parseDouble(output.split("=")[1].replace("km", ""));
		double expected = 16.09; // Y

		assertEquals(expected, actual, .01);
	}
	
	@Test
	public void givenXMilesWhenConvertingToKilometersThenAnswerIsYKilometersAgain() {
		double x = 0.0; // X
		page.fillMiles(x);

		String output = page.answer.getText();
		
		double actual = Double.parseDouble(output.split("=")[1].replace("km", ""));
		double expected = 0.0; // Y

		assertEquals(expected, actual, .01);
	}	

}
