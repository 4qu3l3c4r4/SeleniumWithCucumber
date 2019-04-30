package actions;

import org.openqa.selenium.WebDriver;

import pageObjects.ProductDataPage;

public class ProductDataPageActions {

	WebDriver driver;
	ProductDataPage productDataPage;
	CommonActions commonActions;

	public ProductDataPageActions(WebDriver driver) {
		this.driver = driver;
		productDataPage = new ProductDataPage();
		commonActions = new CommonActions();
	}

	public void startDateInput(String inicio) {
		commonActions.fillInput(driver, productDataPage.startDateField, inicio);

	}

	public void insuranceSumSelect(String valor) {
		commonActions.fillInputSelect(driver, productDataPage.insuranceSumFiled, valor);

	}

	public void meritRatingSelect(String bonus) {
		commonActions.fillInputSelect(driver, productDataPage.meritRatingField, bonus);

	}

	public void damageInsuranceSelect(String dano) {
		commonActions.fillInputSelect(driver, productDataPage.damageInsuranceField, dano);

	}

	public void optionalProductsBtn1Click() {
		commonActions.click(driver, productDataPage.optionalProductsBtn1);

	}

	public void optionalProductsBtn2Click() {
		commonActions.click(driver, productDataPage.optionalProductsBtn2);

	}

	public void courtesyCarSelect(String cortesia) {
		commonActions.fillInputSelect(driver, productDataPage.courtesyCarField, cortesia);

	}

	public void clicknextselectpriceoptionButton() {
		commonActions.click(driver, productDataPage.nextSelectPriceOptionBtn);

	}

}
