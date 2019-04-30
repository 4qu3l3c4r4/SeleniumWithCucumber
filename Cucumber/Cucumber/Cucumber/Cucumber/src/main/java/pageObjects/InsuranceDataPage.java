package pageObjects;

import org.openqa.selenium.By;

public class InsuranceDataPage {

	public By firstNameField = By.id("firstname");

	public By lastNameField = By.id("lastname");

	public By birthDate = By.id("birthdate");

	public By genderBtn = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Gender'])[1]/following::span[1]");
	
	public By streetAdreessField = By.id("streetaddress");

	public By countryField = By.id("country");

	public By zipcodeField = By.id("zipcode");

	public By cityField = By.id("city");

	public By occupationField = By.id("occupation");

	public By hobbiesBtn = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Select at least 1 options'])[1]/preceding::span[1]");
			
	public By websiteField = By.id("website");

	// Carregar uma foto do windows
	public By openBtn = By.id("open");
	
	public By preventerVehicleDataBtn = By.id("preventervehicledata");
	
	public By nextEnterProductDataBtn = By.id("nextenterproductdata");

}
