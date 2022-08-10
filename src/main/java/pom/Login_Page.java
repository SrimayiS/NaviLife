package pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import generic.Baseclass;

public class Login_Page extends Baseclass {

	@FindBy(id = "email")
	private WebElement emailTextField;

	@FindBy(id = "pass")
	private WebElement passwordTextField;

	@FindBy(xpath = "(//div[contains(.,' connected to an account')])[9]")
	private WebElement enterEmailErrorMessage;

	@FindBy(name ="login")
	private WebElement loginButton;

	public Login_Page(WebDriver driver) {
		super(driver);
	}

	public void setEmail(String enterEmail) {
		emailTextField.sendKeys(enterEmail);
	}

	public void setPassword(String enterPassword) {
		passwordTextField.sendKeys(enterPassword);
	}

	public void clickLogin() {
		loginButton.click();
	}

	public void verifyEnterEmailErrorMessage(String actualErrorMessage) {
		getText(enterEmailErrorMessage, actualErrorMessage);
	}
}
