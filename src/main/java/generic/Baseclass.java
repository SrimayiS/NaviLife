package generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Baseclass {
public WebDriver driver;
	
	
	
	
	public Baseclass(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
	}
	
	
	
	



	public void getText(WebElement ele, String expectedMessage) {

		try {
			String actualMessage = ele.getText();
			System.out.println("actual Message is " + actualMessage);
			Assert.assertEquals(actualMessage, expectedMessage);
		} catch (Exception e) {
			String actualMessage2 = ele.getText();
			System.out.println("actual Message is " + actualMessage2);
			Assert.fail();
		}
	}

}
