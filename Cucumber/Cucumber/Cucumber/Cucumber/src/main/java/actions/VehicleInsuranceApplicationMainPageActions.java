package actions;

import org.openqa.selenium.WebDriver;
import actions.CommonActions;
import pageObjects.VehicleInsuranceApplicationMainPage;

public class VehicleInsuranceApplicationMainPageActions {
	WebDriver driver;
	VehicleInsuranceApplicationMainPage vehicleInsuranceApplicationMainPage;
	CommonActions commonActions;

	public VehicleInsuranceApplicationMainPageActions(WebDriver driver) {
		this.driver = driver;
		vehicleInsuranceApplicationMainPage = new VehicleInsuranceApplicationMainPage();
		commonActions = new CommonActions();
	}

	public void getHomeVehicleInsuranceApplication() {
		commonActions.OpenURL(driver, vehicleInsuranceApplicationMainPage.url);

	}

	public void clickButtonAutoMobile() {
		commonActions.click(driver, vehicleInsuranceApplicationMainPage.automobileBtn);

	}

	public void clickButtonTruck() {
		commonActions.click(driver, vehicleInsuranceApplicationMainPage.truckBtn);

	}

	public void clickButtonMotorcycle() {
		commonActions.click(driver, vehicleInsuranceApplicationMainPage.motorcycleBtn);

	}

	public void clickButtonCamper() {
		commonActions.click(driver, vehicleInsuranceApplicationMainPage.camperBtn);

	}

}
