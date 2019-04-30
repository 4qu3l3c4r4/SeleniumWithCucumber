package actions;

import org.openqa.selenium.WebDriver;

import pageObjects.SelectPriceOptionPage;

public class SelectPriceOptionPageActions {

	WebDriver driver;
	SelectPriceOptionPage selectPriceOptionPage;
	CommonActions commonActions;

	public SelectPriceOptionPageActions(WebDriver driver) {
		this.driver = driver;
		selectPriceOptionPage = new SelectPriceOptionPage();
		commonActions = new CommonActions();
	}

	public void clickPlatinumButton() {
		commonActions.click(driver, selectPriceOptionPage.selectPlatinumBtn);

	}

	public void clickNextSendQuoteButton() {
		commonActions.click(driver, selectPriceOptionPage.nextSendQuoteBtn);

	}
}
