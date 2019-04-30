package testcases;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
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
import enums.DriverType;
import managers.WebDriverManager;

public class VehicleInsuranceApplicationTestCase {

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
	public void setUp() throws Exception {
		driver = WebDriverManager.getDriver(DriverType.CHROME);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);

		insuranceDataPage = new InsuranceDataPageActions(driver);
		productDataPage = new ProductDataPageActions(driver);
		selectPriceOptionPage = new SelectPriceOptionPageActions(driver);
		sendQuotePage = new SendQuotePageActions(driver);
		vehicleDataPage = new VehicleDataPageActions(driver);
		vehicleInsuranceApplicationMainPage = new VehicleInsuranceApplicationMainPageActions(driver);
		commonActions = new CommonActions();
	}

	@Test
	public void testUntitledTestCase() throws Exception {
		// MainPage
		vehicleInsuranceApplicationMainPage.getHomeVehicleInsuranceApplication();
		vehicleInsuranceApplicationMainPage.clickButtonAutoMobile();

		// VehicleData
		vehicleDataPage.makeSelect("Volvo");
		vehicleDataPage.enginePerformanceInput("412");
		vehicleDataPage.dateOfManufactureInput("02/11/2018");
		vehicleDataPage.numberOfSeatsSelect("4");
		vehicleDataPage.fuelSelect("Diesel");
		vehicleDataPage.listPriceInput("12500");
		vehicleDataPage.licensePlateNumberInput("ALN2019");
		vehicleDataPage.anualMileageInput("6000");
		vehicleDataPage.clickNextEnterInsurantDataButton();
		Thread.sleep(1000);

		// InsuranceData
		insuranceDataPage.firstNameInput("John");
		insuranceDataPage.lastNameInput("Doe");
		insuranceDataPage.birthDateInput("10/06/1982");
		insuranceDataPage.genderButtonClick();
		insuranceDataPage.streetAddressInput("North Avenue, 2832");
		insuranceDataPage.countrySelect("Portugal");
		insuranceDataPage.zipCodeInput("52041080");
		insuranceDataPage.cityInput("Porto");
		insuranceDataPage.occupationSelect("Employee");
		insuranceDataPage.hobbiesButtonClick();
		insuranceDataPage.websiteInput("www.youtube.com");
		// Carregar uma foto do windows
		insuranceDataPage.openPictureUploadButtonClick();
		Robot robot = new Robot();
		robot.delay(3000);
		Thread.sleep(3000);
		insuranceDataPage.clickNextEnterProductDataButtonClick();
		uploadFileWithRobot(filePath);

		// ProductData
		productDataPage.startDateInput("01/16/2019");
		productDataPage.insuranceSumSelect("20.000.000,00");
		productDataPage.meritRatingSelect("Bonus 9");
		productDataPage.damageInsuranceSelect("Full Coverage");
		productDataPage.optionalProductsBtn1Click();
		productDataPage.optionalProductsBtn2Click();
		productDataPage.courtesyCarSelect("Yes");
		productDataPage.clicknextselectpriceoptionButton();
		Thread.sleep(1000);

		// Select Price Option
		selectPriceOptionPage.clickPlatinumButton();
		Thread.sleep(1000);
		selectPriceOptionPage.clickNextSendQuoteButton();
		Thread.sleep(1000);

		// SendQuote
		sendQuotePage.emailInput("mail@mail.com");
		sendQuotePage.phoneInput("558199394959697");
		sendQuotePage.usernameInput("admin");
		sendQuotePage.passwordInput("!Abcd1234");
		sendQuotePage.confirmPasswordInput("!Abcd1234");
		sendQuotePage.commentsInput("Prova de Automação em Selenium");
		sendQuotePage.clicksendQuoteFormButton();
		Thread.sleep(1000);
		sendQuotePage.clickSendEmailButton();
		Thread.sleep(15000);
		commonActions.validarConteudo(driver, "Sending e-mail success!");
		Thread.sleep(1000);
		sendQuotePage.clickOkButton();

	}

	@After
	public void tearDownAfterClass() throws Exception {
		driver.close();

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
