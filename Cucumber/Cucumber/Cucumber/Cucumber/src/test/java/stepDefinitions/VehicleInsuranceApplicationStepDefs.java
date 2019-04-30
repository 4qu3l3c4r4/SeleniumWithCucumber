package stepDefinitions;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import actions.CommonActions;
import actions.InsuranceDataPageActions;
import actions.ProductDataPageActions;
import actions.SelectPriceOptionPageActions;
import actions.SendQuotePageActions;
import actions.VehicleDataPageActions;
import actions.VehicleInsuranceApplicationMainPageActions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import enums.DriverType;
import managers.WebDriverManager;

public class VehicleInsuranceApplicationStepDefs {

	private static final String clickNextSendQuoteButton = null;
	private static final String clicksendQuoteFormButton = null;
	private static final String clickSendEmailButton = null;
	private static final String clickOkButton = null;
	private WebDriver driver;
	public WebElement element;
	public WebDriverWait wait;
	private static String filePath = System.getProperty("user.dir") + "\\images\\image.jpg";

	InsuranceDataPageActions insuranceDataPage;
	ProductDataPageActions productDataPage;
	SelectPriceOptionPageActions selectPriceOptionPage;
	SendQuotePageActions sendQuotePage;
	VehicleDataPageActions vehicleDataPage;
	VehicleInsuranceApplicationMainPageActions vehicleInsuranceApplicationMainPage;
	CommonActions commonActions;

	@Before
	public void setUp() throws IOException, AWTException {
		driver = WebDriverManager.getDriver(DriverType.CHROME);
		insuranceDataPage = new InsuranceDataPageActions(driver);
		productDataPage = new ProductDataPageActions(driver);
		selectPriceOptionPage = new SelectPriceOptionPageActions(driver);
		sendQuotePage = new SendQuotePageActions(driver);
		vehicleDataPage = new VehicleDataPageActions(driver);
		vehicleInsuranceApplicationMainPage = new VehicleInsuranceApplicationMainPageActions(driver);
		commonActions = new CommonActions();

	}

	@Given("^que o usuario acesse a pagina principal e selecione automobile$")
	public void que_o_usuario_acesse_a_pagina_principal_e_selecione_automobile() throws IOException, AWTException {

		vehicleInsuranceApplicationMainPage.getHomeVehicleInsuranceApplication();
		vehicleInsuranceApplicationMainPage.clickButtonAutoMobile();

	}

	@And("^o usuario preencha \"([^\\\"]*)\\\" \"([^\\\"]*)\\\" \"([^\\\"]*)\\\" \"([^\\\"]*)\\\" \"([^\\\"]*)\\\" \"([^\\\"]*)\\\" \"([^\\\"]*)\\\" \"([^\\\"]*)\\\" no questionario VehicleData$")
	public void E_o_usuario_preencha_noquestionario_VehicleData(String marca, String perfomance, String data,
			String assento, String combustivel, String preco, String placa, String quilometragem)
			throws IOException, AWTException {

		vehicleDataPage.makeSelect(marca);
		vehicleDataPage.enginePerformanceInput(perfomance);
		vehicleDataPage.dateOfManufactureInput(data);
		vehicleDataPage.numberOfSeatsSelect(assento);
		vehicleDataPage.fuelSelect(combustivel);
		vehicleDataPage.listPriceInput(preco);
		vehicleDataPage.licensePlateNumberInput(placa);
		vehicleDataPage.anualMileageInput(quilometragem);

	}

	@And("^o usuario pressione o botao proximo em VehicleData$")
	public void o_usuario_pressione_o_botao_proximo_em_VehicleData() throws IOException, AWTException, Throwable {

		vehicleDataPage.clickNextEnterInsurantDataButton();
	}

	@And("^o usuario preencha \"([^\\\"]*)\\\" \"([^\\\"]*)\\\" \"([^\\\"]*)\\\" \"([^\\\"]*)\\\" \"([^\\\"]*)\\\" \"([^\\\"]*)\\\" \"([^\\\"]*)\\\" \"([^\\\"]*)\\\" \"([^\\\"]*)\\\" no questionario InsuranceData$")
	public void o_usuario_preencha_no_questionario_InsuranceData(String nome, String sobrenome, String datanascimento,
			String endereco, String pais, String CEP, String cidade, String situacao, String website)
			throws IOException, AWTException, InterruptedException {

		insuranceDataPage.firstNameInput(nome);
		insuranceDataPage.lastNameInput(sobrenome);
		insuranceDataPage.birthDateInput(datanascimento);
		insuranceDataPage.genderButtonClick();
		insuranceDataPage.streetAddressInput(endereco);
		insuranceDataPage.countrySelect(pais);
		insuranceDataPage.zipCodeInput(CEP);
		insuranceDataPage.cityInput(cidade);
		insuranceDataPage.occupationSelect(situacao);
		insuranceDataPage.hobbiesButtonClick();
		insuranceDataPage.websiteInput(website);
		// Carregar uma foto do windows
		insuranceDataPage.openPictureUploadButtonClick();
//		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot = new Robot();
		robot.delay(3000);
		Thread.sleep(3000);
		uploadFileWithRobot(filePath);

	}

	@And("^o usuario pressione o botao proximo em InsuranceData$")
	public void o_suario_pressione_o_botao_proximo_em_InsuranceData() throws IOException, AWTException {

		insuranceDataPage.clickNextEnterProductDataButtonClick();

	}

	@And("^o usuario preencha \"([^\\\"]*)\\\" \"([^\\\"]*)\\\" \"([^\\\"]*)\\\" \"([^\\\"]*)\\\" \"([^\\\"]*)\\\" no questionario ProductData")
	public void o_usuario_preencha_no_questionario_ProductData(String datainicio, String valor, String bonus,
			String cobertura, String carrocortesia) throws IOException, AWTException {

		productDataPage.startDateInput(datainicio);
		productDataPage.insuranceSumSelect(valor);
		productDataPage.meritRatingSelect(bonus);
		productDataPage.damageInsuranceSelect(cobertura);
		productDataPage.optionalProductsBtn1Click();
		productDataPage.optionalProductsBtn2Click();
		productDataPage.courtesyCarSelect(carrocortesia);

	}

	@And("^o usuario pressione o botao proximo em ProductData$")
	public void o_usuario_pressione_o_botao_proximo_em_ProductData() throws IOException, AWTException {

		productDataPage.clicknextselectpriceoptionButton();

	}

	@And("^o usuario aguarda a proxima tela carregar$")
	public void o_usuario_aguarda_a_proxima_tela_carregar() throws IOException, AWTException, InterruptedException {

		Thread.sleep(1000);
	}

	@And("^o usuario Select o PriceOption Platinum$")
	public void o_usuario_Select_o_PriceOption_Platinum() throws IOException, AWTException {

		selectPriceOptionPage.clickPlatinumButton();

	}

	@And("^o usuario pressione o botao proximo em Select Price Option$")
	public void o_usuario_pressione_o_botao_proximo_em_Select_Price_Option()
			throws IOException, AWTException, Throwable {
		commonActions.validarConteudo(driver, clickNextSendQuoteButton);
		selectPriceOptionPage.clickNextSendQuoteButton();
	}

	@And("^o usuario preencha \"([^\\\"]*)\\\" \"([^\\\"]*)\\\" \"([^\\\"]*)\\\" \"([^\\\"]*)\\\" \"([^\\\"]*)\\\" \"([^\\\"]*)\\\" no questionario SendQuote")
	public void o_usuario_preencha_no_questionario_SendQuote(String email, String telefone, String username,
			String password, String passwordconfirmation, String comentario) throws IOException, AWTException {

		sendQuotePage.emailInput(email);
		sendQuotePage.phoneInput(telefone);
		sendQuotePage.usernameInput(username);
		sendQuotePage.passwordInput(password);
		sendQuotePage.confirmPasswordInput(passwordconfirmation);
		sendQuotePage.commentsInput(comentario);

	}

	@And("^o usuario clica no botão de enviar questionario$")
	public void o_usuario_clica_no_botão_de_enviar_questionario() throws IOException, AWTException, Throwable {
		
		commonActions.validarConteudo(driver, clicksendQuoteFormButton);
		sendQuotePage.clicksendQuoteFormButton();
	}

	@And("^o usuario clica no botão de enviar email$")
	public void o_usuario_clica_no_botão_de_enviar_email() throws IOException, AWTException, Throwable {
		
		commonActions.validarConteudo(driver, clickSendEmailButton);
		sendQuotePage.clickSendEmailButton();

	}

	@And("^o usuario aguarda a proxima tela carregar longamente$")
	public void o_usuario_aguarda_a_proxima_tela_carregar_longamente()
			throws IOException, AWTException, InterruptedException {

		Thread.sleep(15000);

	}

	@And("^o usuario valida a mensagem de sucesso \"([^\\\"]*)\\\"$")
	public void o_usuario_presione_o_botao_proximo(String mensagem) throws IOException, AWTException, Throwable{

		commonActions.validarConteudo(driver, mensagem);

	}

	@Then("^o usuario clica no botão Ok$")
	public void o_usuario_clica_no_botão_Ok() throws IOException, AWTException {
		
		sendQuotePage.clickOkButton();

	}

	@After
	public void afterScenario() throws Exception {
		driver.close();
		driver.quit();

	}

	// File upload by Robot Class
	public void uploadFileWithRobot(String imagePath) {
		StringSelection stringSelection = new StringSelection(imagePath);
		Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		clipboard.setContents(stringSelection, null);

		Robot robot = null;

		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}

		robot.delay(250);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.delay(150);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}

}
