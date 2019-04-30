package actions;

import org.openqa.selenium.WebDriver;

import pageObjects.VehicleDataPage;

public class VehicleDataPageActions {

	WebDriver driver;
	VehicleDataPage vehicleDataPage;
	CommonActions commonActions;

	public VehicleDataPageActions(WebDriver driver) {
		this.driver = driver;
		vehicleDataPage = new VehicleDataPage();
		commonActions = new CommonActions();

	}

	public void makeSelect(String marca) {
		commonActions.fillInputSelect(driver, vehicleDataPage.makeField, marca);

	}

	public void enginePerformanceInput(String perfomance) {
		commonActions.fillInput(driver, vehicleDataPage.enginePerformanceField, perfomance);

	}

	public void dateOfManufactureInput(String data) {
		commonActions.fillInput(driver, vehicleDataPage.dateOfManufacture, data);

	}

	public void numberOfSeatsSelect(String assento) {
		commonActions.fillInputSelect(driver, vehicleDataPage.numberofSeatsField, assento);

	}

	public void fuelSelect(String combustivel) {
		commonActions.fillInputSelect(driver, vehicleDataPage.fuelField, combustivel);

	}

	public void listPriceInput(String preco) {
		commonActions.fillInput(driver, vehicleDataPage.listPriceField, preco);

	}

	public void licensePlateNumberInput(String placa) {
		commonActions.fillInput(driver, vehicleDataPage.licensePlateNumberField, placa);

	}

	public void anualMileageInput(String quilometragem) {
		commonActions.fillInput(driver, vehicleDataPage.annualMileageField, quilometragem);

	}

	public void clickNextEnterInsurantDataButton() {
		commonActions.click(driver, vehicleDataPage.nextEnterInsuranceDataBtn);

	}

}
