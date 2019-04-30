package pageObjects;

import org.openqa.selenium.By;

public class ProductDataPage {

	public By startDateField = By.id("startdate");
	
	public By insuranceSumFiled = By.id("insurancesum");

	public By meritRatingField = By.id("meritrating");

	public By damageInsuranceField = By.id("damageinsurance");

	public By optionalProductsBtn1 = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Optional Products'])[1]/following::span[1]");
	
	public By optionalProductsBtn2 = By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Select no more than 2 options'])[1]/preceding::span[1]");
	
	public By courtesyCarField = By.id("courtesycar");
	
	public By preventerInsuranceDataBtn = By.id("preventerinsurancedata");
	  

	public By nextSelectPriceOptionBtn = By.id("nextselectpriceoption");

}
