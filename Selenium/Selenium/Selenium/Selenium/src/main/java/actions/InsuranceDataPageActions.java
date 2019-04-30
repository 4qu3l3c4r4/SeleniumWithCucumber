package actions;

import org.openqa.selenium.WebDriver;

import pageObjects.InsuranceDataPage;

public class InsuranceDataPageActions {

	WebDriver driver;
	InsuranceDataPage insuranceDataPage;
	CommonActions commonActions;

	public InsuranceDataPageActions(WebDriver driver) {
		this.driver = driver;
		insuranceDataPage = new InsuranceDataPage();
		commonActions = new CommonActions();
	}

	public void firstNameInput(String nome) {
		commonActions.fillInput(driver, insuranceDataPage.firstNameField, nome);

	}

	public void lastNameInput(String sobrenome) {
		commonActions.fillInput(driver, insuranceDataPage.lastNameField, sobrenome);

	}

	public void birthDateInput(String nascimento) {
		commonActions.fillInput(driver, insuranceDataPage.birthDate, nascimento);

	}

	public void genderButtonClick() {
		commonActions.click(driver, insuranceDataPage.genderBtn);

	}

	public void streetAddressInput(String endereco) {
		commonActions.fillInput(driver, insuranceDataPage.streetAdreessField, endereco);

	}

	public void countrySelect(String pais) {
		commonActions.fillInputSelect(driver, insuranceDataPage.countryField, pais);

	}

	public void zipCodeInput(String cep) {
		commonActions.fillInput(driver, insuranceDataPage.zipcodeField, cep);

	}

	public void cityInput(String cidade) {
		commonActions.fillInput(driver, insuranceDataPage.cityField, cidade);

	}

	public void occupationSelect(String ocupacao) {
		commonActions.fillInputSelect(driver, insuranceDataPage.occupationField, ocupacao);

	}

	public void hobbiesButtonClick() {
		commonActions.click(driver, insuranceDataPage.hobbiesBtn);

	}

	public void websiteInput(String site) {
		commonActions.fillInput(driver, insuranceDataPage.websiteField, site);

	}

	public void openPictureUploadButtonClick() {
		commonActions.click(driver, insuranceDataPage.openBtn);

	}

	public void clickNextEnterProductDataButtonClick() {
		commonActions.click(driver, insuranceDataPage.nextEnterProductDataBtn);

	}

}

// Carregar uma foto do windows
//driver.findElement(By.id("open")).click();
// element.sendKeys("C:\\EABZ7815.jpg");
//StringSelection ss = new StringSelection("C:\\Users\\Public\\Pictures\\imagem.jpg");
//Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
//Robot robot = new Robot();
//robot.delay(1000);
