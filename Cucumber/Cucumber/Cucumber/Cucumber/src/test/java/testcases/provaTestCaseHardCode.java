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
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import actions.CommonActions;
import actions.SendQuotePageActions;
import enums.DriverType;
import managers.WebDriverManager;

public class provaTestCaseHardCode {

	private WebDriver driver;
	public WebElement element;
	public WebDriverWait wait;
	private static String filePath = System.getProperty("user.dir") + "\\images\\image.jpg";

	SendQuotePageActions sendQuotePage;
	CommonActions commonActions;

	@Before
	public void setUp() throws Exception {
		driver = WebDriverManager.getDriver(DriverType.CHROME);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		sendQuotePage = new SendQuotePageActions(driver);
		commonActions = new CommonActions();
	}

	@Test
	public void testUntitledTestCase() throws Exception {
		// MainPage
		driver.get("http://sampleapp.tricentis.com/101/index.php");
		driver.findElement(By.id("nav_automobile")).click();

		// VehicleData
		driver.findElement(By.id("make")).click();
		new Select(driver.findElement(By.id("make"))).selectByVisibleText("Volvo");
		driver.findElement(By.id("make")).click();
		driver.findElement(By.id("engineperformance")).click();
		driver.findElement(By.id("engineperformance")).clear();
		driver.findElement(By.id("engineperformance")).sendKeys("412");
		driver.findElement(By.id("dateofmanufacture")).click();
		driver.findElement(By.id("dateofmanufacture")).clear();
		driver.findElement(By.id("dateofmanufacture")).sendKeys("02/11/2018");
		driver.findElement(By.id("numberofseats")).click();
		new Select(driver.findElement(By.id("numberofseats"))).selectByVisibleText("4");
		driver.findElement(By.id("numberofseats")).click();
		driver.findElement(By.id("fuel")).click();
		new Select(driver.findElement(By.id("fuel"))).selectByVisibleText("Diesel");
		driver.findElement(By.id("fuel")).click();
		driver.findElement(By.id("listprice")).click();
		driver.findElement(By.id("listprice")).clear();
		driver.findElement(By.id("listprice")).sendKeys("12500");
		driver.findElement(By.id("licenseplatenumber")).click();
		driver.findElement(By.id("licenseplatenumber")).clear();
		driver.findElement(By.id("licenseplatenumber")).sendKeys("ALN2019");
		driver.findElement(By.id("annualmileage")).click();
		driver.findElement(By.id("annualmileage")).clear();
		driver.findElement(By.id("annualmileage")).sendKeys("6000");
		driver.findElement(By.id("nextenterinsurantdata")).click();
		Thread.sleep(1000);

		// InsuranceData
		driver.findElement(By.id("firstname")).click();
		driver.findElement(By.id("firstname")).clear();
		driver.findElement(By.id("firstname")).sendKeys("John");
		driver.findElement(By.id("lastname")).click();
		driver.findElement(By.id("lastname")).clear();
		driver.findElement(By.id("lastname")).sendKeys("Doe");
		driver.findElement(By.id("birthdate")).click();
		driver.findElement(By.id("birthdate")).clear();
		driver.findElement(By.id("birthdate")).sendKeys("10/06/1982");
		driver.findElement(
				By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Gender'])[1]/following::span[1]"))
				.click();
		driver.findElement(By.id("streetaddress")).click();
		driver.findElement(By.id("streetaddress")).clear();
		driver.findElement(By.id("streetaddress")).sendKeys("North Avenue, 2832");
		driver.findElement(By.id("country")).click();
		new Select(driver.findElement(By.id("country"))).selectByVisibleText("Portugal");
		driver.findElement(By.id("country")).click();
		driver.findElement(By.id("zipcode")).click();
		driver.findElement(By.id("zipcode")).clear();
		driver.findElement(By.id("zipcode")).sendKeys("52041080");
		driver.findElement(By.id("city")).click();
		driver.findElement(By.id("city")).clear();
		driver.findElement(By.id("city")).sendKeys("Porto");
		driver.findElement(By.id("occupation")).click();
		driver.findElement(By.id("occupation")).click();
		new Select(driver.findElement(By.id("occupation"))).selectByVisibleText("Employee");
		driver.findElement(By.id("occupation")).click();
		driver.findElement(By.xpath(
				"(.//*[normalize-space(text()) and normalize-space(.)='Select at least 1 options'])[1]/preceding::span[1]"))
				.click();
		driver.findElement(By.id("website")).click();
		driver.findElement(By.id("website")).clear();
		driver.findElement(By.id("website")).sendKeys("www.youtube.com");

		// Carregar uma foto do windows
		driver.findElement(By.id("open")).click();
//		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		Robot robot = new Robot();
		robot.delay(3000);
		Thread.sleep(3000);
		driver.findElement(By.id("nextenterproductdata")).click();
		uploadFileWithRobot(filePath);
		Thread.sleep(1000);
		
		// ProductData
		driver.findElement(By.id("startdate")).click();
		driver.findElement(By.id("startdate")).clear();
		driver.findElement(By.id("startdate")).sendKeys("01/16/2019");
		driver.findElement(By.id("insurancesum")).click();
		new Select(driver.findElement(By.id("insurancesum"))).selectByVisibleText("20.000.000,00");
		driver.findElement(By.id("insurancesum")).click();
		driver.findElement(By.id("meritrating")).click();
		new Select(driver.findElement(By.id("meritrating"))).selectByVisibleText("Bonus 9");
		driver.findElement(By.id("meritrating")).click();
		driver.findElement(By.id("damageinsurance")).click();
		new Select(driver.findElement(By.id("damageinsurance"))).selectByVisibleText("Full Coverage");
		driver.findElement(By.id("damageinsurance")).click();
		driver.findElement(By.xpath(
				"(.//*[normalize-space(text()) and normalize-space(.)='Optional Products'])[1]/following::span[1]"))
				.click();
		driver.findElement(By.xpath(
				"(.//*[normalize-space(text()) and normalize-space(.)='Select no more than 2 options'])[1]/preceding::span[1]"))
				.click();
		driver.findElement(By.id("courtesycar")).click();
		new Select(driver.findElement(By.id("courtesycar"))).selectByVisibleText("Yes");
		driver.findElement(By.id("courtesycar")).click();
		driver.findElement(By.id("nextselectpriceoption")).click();

		// Select Price Option
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"priceTable\"]/tfoot/tr/th[2]/label[3]/span")).click();
		// Id "selectplatinum"
		Thread.sleep(1000);
		driver.findElement(By.id("nextsendquote")).click();
		Thread.sleep(1000);

		// SendQuote
		driver.findElement(By.id("email")).click();
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("email")).sendKeys("mail@mail.com");
		driver.findElement(By.id("phone")).click();
		driver.findElement(By.id("phone")).clear();
		driver.findElement(By.id("phone")).sendKeys("558199394959697");
		driver.findElement(By.id("username")).click();
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("!1234password");
		driver.findElement(By.id("confirmpassword")).click();
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("!Abcd1234");
		driver.findElement(By.id("confirmpassword")).click();
		driver.findElement(By.id("confirmpassword")).clear();
		driver.findElement(By.id("confirmpassword")).sendKeys("!Abcd1234");
		driver.findElement(By.id("Comments")).clear();
		driver.findElement(By.id("Comments")).sendKeys("Prova de Automação em Selenium");
		driver.findElement(By.id("sendQuoteForm")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("sendemail")).click();
		Thread.sleep(3000);

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
