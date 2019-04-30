package actions;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonActions {

	/**
	 * Método responsável para a abertura de uma URL. Utiliza a url para abrir uma
	 * página web.
	 */
	public void OpenURL(WebDriver driver, String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	/**
	 * Método responsável pelo preenchimento de campos do tipo INPUT. Utiliza o By
	 * para localizar o componente.
	 * 
	 * @return Retorna o componente alterado.
	 */
	public WebElement fillInput(WebDriver driver, By by, String valor) {
		WebElement element = null;
		element = findElement(driver, by);
		element.click();
		element.clear();
		element.sendKeys(valor.trim());
		return element;
	}

	/**
	 * Método responsável pelo preenchimento de campos do tipo SELECT. Utiliza o By
	 * para localizar o componente.
	 * 
	 * @return Retorna o componente alterado.
	 */
	public Select fillInputSelect(WebDriver driver, By by, String opcao) {
		WebElement element = null;
		Select select = null;
		element = findElement(driver, by);
		select = new Select(element);
		select.selectByVisibleText(opcao);
		return select;
	}

	/**
	 * Método responsável pela execução do clique no componente. Utiliza o By
	 * informado para localizar o componente.
	 * 
	 * @return Retorna o componente clicado.
	 */
	public WebElement click(WebDriver driver, By by) {
		WebElement element = null;
		element = findElement(driver, by);
		element.click();
		return element;
	}

	/**
	 * Método responsável pela localização do componente. Utiliza o By informado
	 * para localizar o componente. Capaz de ignorar erros do tipo
	 * NoSuchElementException e StaleElementReferenceException
	 * 
	 * @return O Elemento buscado
	 */
	public WebElement findElement(WebDriver driver, final By by) {
		int i = 1;
		int Constantes_MAX_SEGUNDOS = 30;
		WebElement element = null;
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(5, TimeUnit.SECONDS)/*
																									 * Esperando 25
																									 * segundos para que
																									 * o elemento esteja
																									 * presente na
																									 * página
																									 */
				.pollingEvery(1, TimeUnit.SECONDS)/* Verificando por sua presença uma vez a cada 1 segundos */
				.ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class)
				.ignoring(TimeoutException.class);
		try {
			while (element == null && i < Constantes_MAX_SEGUNDOS) {
				try {
					if (null != ExpectedConditions.visibilityOfElementLocated(by)) {
						element = wait.until(new Function<WebDriver, WebElement>() {
							public WebElement apply(WebDriver driver) {
								return driver.findElement(by);
							}
						});
						if (element.getText().equals("Nenhum registro encontrado")) {
							element = null;
						}
					}
				} catch (Exception ex) {
					// ex.printStackTrace();
					// timeout(1);
					i++;
					element = null;
					continue;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			// Assert.assertNotNull("Elemento não foi encontrado", ex);
		}
		return element;
	}

	/**
	 * Método responsável por copiar para área de transaferência
	 * 
	 * @param texto a ser copiado
	 **/
	public static void copiaParaClipBoard(String text) {
		StringSelection ss = new StringSelection(text);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
	}

	public boolean selectDropdown(WebDriver driver, By xpath, String opcaoSelecionada) {
		click(driver, xpath);
		String opcao = xpath.toString();
		opcao.replaceAll("div[2]/span", "div[3]/div/ul/li");
		opcao.replaceAll("xpath", "");
		String descItem;
		int quantidadeDeItens = driver
				.findElements(By.xpath("//p-dropdown[@id='drpDwnProcessTypes']/div/div[3]/div/ul/li")).size();
		for (int item = 1; item <= quantidadeDeItens; item++) {
			descItem = findElement(driver, By.xpath(opcao + "[" + item + "]/span")).getText();
			if (opcaoSelecionada.toUpperCase().trim().equals(descItem.toUpperCase())) {
				// Assert.assertTrue(true);
				click(driver,
						By.xpath("//p-dropdown[@id='drpDwnProcessTypes']/div/div[3]/div/ul/li[" + item + "]/span"));
				return true;
			}
		}
		return false;
	}

	public boolean contemStatus(String elemento, String status) {
		return elemento.contains(status);
	}

	public void waitForLoad(final WebDriver driver) {
		final WebElement loading = findElement(driver, By.id("loading-login"));
		while (loading.getAttribute("ng-reflect-show") == "true") {
			// timeout(1);
		}
	}

	public boolean validarConteudo(WebDriver driver, String mensagem) throws InterruptedException {

		boolean result = false;

		Thread.sleep(5000);

		for (WebElement webElement : driver.findElements(By.tagName("h2"))) {
			String vld = webElement.getText();

			if (vld.contains(mensagem)) {
				Actions action = new Actions(driver);
//				action.moveToElement(webElement).build().perform();

				WebDriverWait aguardar = new WebDriverWait(driver, 15);
				aguardar.until(ExpectedConditions.elementToBeClickable(webElement));
				result = true;
				System.out.println(mensagem);
				break;
			}
		}
		if (!result) {
			System.out.println("....Not finished yet..." + " There is still some data missing!.....");
		}
		return result;

	}

	public void waitForPageLoad(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		try {
			WebElement loading = findElement(driver, By.className("backdrop"));
			if (loading != null) {
				// setLoading(true);
			}
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("backdrop")));
		} catch (TimeoutException ex) {
//			Assert.assertTrue("O load excedeu o tempo limite",null==ex);
		}
	}

	// Verifica se tem um alert na tela a cada 3 segundos durante 10 tentativas
	public boolean isAlertPresent(WebDriver driver, By by) {
		boolean result = false;
		for (int i = 1; i <= 10; i++) {
			try {
				WebElement dialog = findElement(driver, by);
				result = dialog.isDisplayed();
				if (result == true) {
					break;
				} else {
					// timeout(3);
					System.out.println("Nennhum alert encontrado - " + result + i);
				}
			} catch (final Exception e) {
			}
		}
		return result;
	}

	// Verifica se tem um modal na tela a cada 3 segundos durante 10 tentativas
	public boolean isModalPresent(WebDriver driver, By by) {
		boolean result = false;
		for (int i = 1; i <= 10; i++) {
			try {
				final WebElement dialog = findElement(driver, by);
				result = dialog.isDisplayed();
				if (result == true) {
					break;
				} else {
					// timeout(3);
					System.out.println("Nennhum modal encontrado - " + result + i);
				}
			} catch (final Exception e) {
			}
		}
		return result;
	}

	public static void radiobutton_Select(WebElement Radio) {
		boolean checkstatus;
		checkstatus = Radio.isSelected();
		if (checkstatus == true) {
			System.out.println("RadioButton is already checked");
		} else {
			Radio.click();
			System.out.println("Selected the Radiobutton");
		}
	}

	public static void checkbox_Unchecking(WebElement checkbox) {
		boolean checkstatus;
		checkstatus = checkbox.isSelected();
		if (checkstatus == true) {
			checkbox.click();
			System.out.println("Checkbox is unchecked");
		} else {
			System.out.println("Checkbox is already unchecked");
		}
	}

	public static void radioButton_Deselect(WebElement Radio) {
		boolean checkstatus;
		checkstatus = Radio.isSelected();
		if (checkstatus == true) {
			Radio.click();
			System.out.println("Radio Button is deselected");
		} else {
			System.out.println("Radio Button was already Deselected");
		}
	}

	public static void dragAndDrop(WebDriver driver, WebElement fromWebElement, WebElement toWebElement) {
		Actions builder = new Actions(driver);
		builder.dragAndDrop(fromWebElement, toWebElement);
	}

	public static void dragAndDrop_Method2(WebDriver driver, WebElement fromWebElement, WebElement toWebElement) {
		Actions builder = new Actions(driver);
		Action dragAndDrop = builder.clickAndHold(fromWebElement).moveToElement(toWebElement).release(toWebElement)
				.build();
		dragAndDrop.perform();
	}

	public static void dragAndDrop_Method3(WebDriver driver, WebElement fromWebElement, WebElement toWebElement)
			throws InterruptedException {
		Actions builder = new Actions(driver);
		builder.clickAndHold(fromWebElement).moveToElement(toWebElement).perform();
		Thread.sleep(2000);
		builder.release(toWebElement).build().perform();
	}

	public static void hoverWebelement(WebDriver driver, WebElement HovertoWebElement) throws InterruptedException {
		Actions builder = new Actions(driver);
		builder.moveToElement(HovertoWebElement).perform();
		Thread.sleep(2000);
	}

	public static void doubleClickWebelement(WebDriver driver, WebElement doubleclickonWebElement)
			throws InterruptedException {
		Actions builder = new Actions(driver);
		builder.doubleClick(doubleclickonWebElement).perform();
		Thread.sleep(2000);

	}

	public static String getToolTip(WebElement toolTipofWebElement) throws InterruptedException {
		String tooltip = toolTipofWebElement.getAttribute("title");
		System.out.println("Tool text : " + tooltip);
		return tooltip;
	}

	public static void selectElementByNameMethod(WebElement element, String Name) {
		Select selectitem = new Select(element);
		selectitem.selectByVisibleText(Name);
	}

	public static void selectElementByValueMethod(WebElement element, String value) {
		Select selectitem = new Select(element);
		selectitem.selectByValue(value);
	}

	public static void selectElementByIndexMethod(WebElement element, int index) {
		Select selectitem = new Select(element);
		selectitem.selectByIndex(index);
	}

	public static void clickCheckboxFromList(WebDriver driver, String xpathOfElement, String valueToSelect) {
		List<WebElement> lst = driver.findElements(By.xpath(xpathOfElement));
		for (int i = 0; i < lst.size(); i++) {
			List<WebElement> dr = lst.get(i).findElements(By.tagName("label"));
			for (WebElement f : dr) {
				System.out.println("value in the list : " + f.getText());
				if (valueToSelect.equals(f.getText())) {
					f.click();
					break;
				}
			}
		}
	}
}