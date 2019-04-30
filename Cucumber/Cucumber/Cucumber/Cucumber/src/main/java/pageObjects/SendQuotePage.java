package pageObjects;

import org.openqa.selenium.By;

public class SendQuotePage {

	public By emailField = By.id("email");

	public By phoneField = By.id("phone");

	public By usernameField = By.id("username");

	public By passwordField = By.id("password");

	public By confirmPasswordField = By.id("confirmpassword");

	public By commentsField = By.id("Comments");

	public By sendQuoteFormBtn = By.id("sendQuoteForm");

	public By sendEmailBtn = By.id("sendemail");

	public By sendingEmailSuccessMessage = By.xpath("/html/body/div[4]/h2");

	public By sendingEmailSuccessIcon = By.xpath("/html/body/div[4]/div[4]/div[1]");

	public By okBtn = By.xpath("/html/body/div[4]/div[7]/div/button"); 

}
