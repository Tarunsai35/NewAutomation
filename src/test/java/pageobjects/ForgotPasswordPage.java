package pageobjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ForgotPasswordPage {

	WebDriver driver;
	WebDriverWait wait;

	// Constructor
	public ForgotPasswordPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	// WebElement using @Findby
	@FindBy(xpath = "//h1[normalize-space()='Forgot Your Password?']")
	WebElement msgForgot;

	// Methods to interact with elements using explicit waits
	public boolean isForgotPasswordPageExist() {
		try {
			wait.until(ExpectedConditions.visibilityOf(msgForgot));
			return msgForgot.isDisplayed();
		} catch (Exception e) {
			System.out.println("Forgot Your Password not Found:" + e.getMessage());
			return false;
		}
	}

}
