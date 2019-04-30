package pageObjects;

import org.openqa.selenium.By;

public class SelectPriceOptionPage {
	
    public By selectSilverBtn = By.xpath("//*[@id=\"priceTable\"]/tfoot/tr/th[2]/label[1]/span");
    
    public By selectGoldBtn = By.xpath("//*[@id=\"priceTable\"]/tfoot/tr/th[2]/label[2]/span");
    
    public By selectPlatinumBtn = By.xpath("//*[@id=\"priceTable\"]/tfoot/tr/th[2]/label[3]/span");
    
    public By selectUltimateBtn = By.xpath("//*[@id=\"priceTable\"]/tfoot/tr/th[2]/label[4]/span");

    public By preventerProductDataBtn = By.id("preventerproductdata");
    
	public By nextSendQuoteBtn = By.id("nextsendquote");

}
