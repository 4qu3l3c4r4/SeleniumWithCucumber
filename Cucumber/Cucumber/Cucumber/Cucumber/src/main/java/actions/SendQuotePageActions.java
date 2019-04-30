package actions;

import org.openqa.selenium.WebDriver;

import pageObjects.SendQuotePage;

public class SendQuotePageActions {
	WebDriver driver;
	SendQuotePage sendQuotePage;
	CommonActions commonActions;

	public SendQuotePageActions(WebDriver driver) {
		this.driver = driver;
		sendQuotePage = new SendQuotePage();
		commonActions = new CommonActions();
	}

	public void emailInput(String email) {
		commonActions.fillInput(driver, sendQuotePage.emailField, email);

	}

	public void phoneInput(String telefone) {
		commonActions.fillInput(driver, sendQuotePage.phoneField, telefone);

	}

	public void usernameInput(String user) {
		commonActions.fillInput(driver, sendQuotePage.usernameField, user);

	}

	public void passwordInput(String password) {
		commonActions.fillInput(driver, sendQuotePage.passwordField, password);

	}

	public void confirmPasswordInput(String confirmacao) {
		commonActions.fillInput(driver, sendQuotePage.confirmPasswordField, confirmacao);

	}

	public void commentsInput(String comentario) {
		commonActions.fillInput(driver, sendQuotePage.commentsField, comentario);

	}

	public void clicksendQuoteFormButton() {
		commonActions.click(driver, sendQuotePage.sendQuoteFormBtn);

	}

	public void clickSendEmailButton() {
		commonActions.click(driver, sendQuotePage.sendEmailBtn);

	}

	public void clickOkButton() {

		commonActions.click(driver, sendQuotePage.okBtn);

	}

}
