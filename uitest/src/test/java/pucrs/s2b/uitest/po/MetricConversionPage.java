package pucrs.s2b.uitest.po;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class MetricConversionPage {

	@FindBy(id = "argumentConv1")
	@CacheLookup
	WebElement argumentConv1;

	@FindBy(id = "answer")
	@CacheLookup
	WebElement answer;

	void fillMiles(double x) {
		argumentConv1.sendKeys(String.valueOf(x));
		argumentConv1.submit();
	}

}
