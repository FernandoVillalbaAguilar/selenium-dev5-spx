package com.metalsa.spx.dev5.poc;

import java.util.TreeMap;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.metalsa.spx.dev5.main.GlobalVariablesSPX;
import com.metalsa.spx.dev5.main.SPXBase;

public class SingleSourceFormatSPXPage extends SPXBase {

	public SingleSourceFormatSPXPage(WebDriver driver) {
		super(driver);
	}

//Objects
	// =========================================================
	// HEADER OBJECTS
	// =========================================================
	By btnBack = By.xpath("//form[@id='formFAD']//button[.//span[contains(@class,'fa-arrow-left')]]");

	By btnSave = By.xpath("//form[@id='formFAD']//button[.//span[contains(@class,'fa-floppy-o')]]");

	By txtSingleScourseFormat = By.xpath("//form[@id='formFAD']//div[contains(@class,'spx-card-header__title')]/h3");

	By msgStatusFAD = By.id("formFAD:mensageStatus");

	// =========================================================
	// FIRST SECTION
	// =========================================================
	By txtDescription = By.id("formFAD:desc_1");

	By pnlSupplierName = By.id("formFAD:suppliers_panel");

	By txtSupplierName = By.id("formFAD:suppliers_input");

	By txtAmount = By.xpath("//form[@id='formFAD']//input[contains(@class,'pe-inputNumber')]");

	By containerCurrency = By.xpath("//div[contains(@class,'ui-selectonemenu-panel') and contains(@id,'formFAD')]");

	By lblCurrency = By.xpath("//form[@id='formFAD']//label[contains(@class,'ui-selectonemenu-label')]");

	By txtCurrency = By.xpath("//div[contains(@class,'ui-selectonemenu-panel') and contains(@id,'formFAD')]"
			+ "//input[contains(@class,'ui-selectonemenu-filter')]");

	By slctCurrency = By.xpath("//div[contains(@class,'ui-selectonemenu-panel') and contains(@id,'formFAD')]"
			+ "//li[@data-label='" + GlobalVariablesSPX.CURRENCY + "']");

	// =========================================================
	// SECOND SECTION
	// =========================================================
	By rdbtnSingleSourceFormatReason = By.xpath(GlobalVariablesSPX.SELECTED_SINGLE_SOURCE_REASON);

	By txtDetails = By.id("formFAD:fad_razon_otro");

	// =========================================================
	// THIRD SECTION
	// =========================================================
	By txtComments = By.xpath("//form[@id='formFAD']//textarea[contains(@name,'formFAD:j_id')]");

	By btnChooseFiles = By.id("formFAD:fileUpload_input");

	By btnDeleteFileUpload = By
			.xpath("//button[contains(@id,'formFAD:lineatable')" + " and .//span[contains(@class,'fa-trash-o')]]");

	/*
	 * @name: textSingleSourceFormatPageIsDisplayed
	 * 
	 * @date: 16/Nov/2023
	 * 
	 * @param: N/A
	 * 
	 * @return: isDisplayed(txtSingleScourseFormat);
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite verificar que el elemento est� disponible
	 */
	public boolean textSingleSourceFormatPageIsDisplayed() {
		reporterLog("Access to Single Source Format Page ...");
		waitForElementPresent(txtSingleScourseFormat);
		return isDisplayed(txtSingleScourseFormat);
	}

	/*
	 * @name: captureDataSingleSourceFormat
	 * 
	 * @date: 16/Nov/2023 (refactor: 29/May/2026)
	 *
	 * @description: Este método captura la información del formulario Single Source
	 * Format, incluyendo manejo robusto de PrimeFaces AutoComplete (supplier),
	 * sincronización AJAX y validaciones de UI dinámica.
	 *
	 * FIX PRINCIPAL: - Se asegura disparo real de eventos JS (input + blur + focus)
	 * - Se agrega espera activa del panel de sugerencias - Se mejora estabilidad en
	 * ambientes lentos
	 */
	public TreeMap<String, String> captureDataSingleSourceFormat(String description, String supplierName, String amount,
			String details, String comments, String pathFileSpot) throws InterruptedException {

		clearScreenshotList();
		TreeMap<String, String> evidence = new TreeMap<>();
		reporterLog("Capture Data Single Source Format");

		// =========================================================
		// DESCRIPTION
		// =========================================================
		type(txtDescription, description);
		evidence.putAll(safeEvidence(txtDescription, "Description"));

		// =========================================================
		// SUPPLIER NAME - PRIMEFACES AUTOCOMPLETE (ROBUSTO)
		// =========================================================

		By optSupplierName = By
				.xpath("//*[@id='formFAD:suppliers_panel']//li[@data-item-label='" + supplierName + "']");

		WebElement input = getElement(txtSupplierName);

		// 1. Asegurar foco real (MUY IMPORTANTE en PrimeFaces)
		click(txtSupplierName);

		// 2. Limpiar correctamente disparando eventos JS
		input.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		input.sendKeys(Keys.DELETE);

		waitForPrimefacesAjax();

		// 3. Escribir carácter por carácter (mejora disparo de autocomplete)
		for (char c : supplierName.toCharArray()) {
			input.sendKeys(String.valueOf(c));
			Thread.sleep(GlobalVariablesSPX.AUTOCOMPLETE_KEY_DELAY); // pequeño delay para trigger JS
		}

		// 4. Forzar evento input/blur (clave en PrimeFaces)
		input.sendKeys(Keys.SPACE);
		input.sendKeys(Keys.BACK_SPACE);
		waitForPrimefacesAjax();

		// 5. Espera activa del panel (no confiar solo en visibility simple)
		boolean panelVisible = waitForElementVisible(pnlSupplierName, 15);

		// 6. Reintento inteligente si no aparece el panel
		if (!panelVisible) {
			reporterLog("[WARNING] Panel no visible. Forzando evento TAB...");
			input.sendKeys(Keys.TAB);
			waitForPrimefacesAjax();
			panelVisible = waitForElementVisible(pnlSupplierName, 8);
		}

		// 7. Validación final estricta
		if (!panelVisible) {
			logFrameworkError("Supplier suggestion panel did not appear: " + txtSupplierName, null);
			throw new RuntimeException("Supplier suggestion panel did not appear after typing: " + supplierName);
		}

		// 8. Selección segura de opción
		waitForElementVisible(optSupplierName, 10);
		click(optSupplierName);
		waitForPrimefacesAjax();
		evidence.putAll(safeEvidence(txtSupplierName, "Supplier Name"));

		// =========================================================
		// AMOUNT
		// =========================================================
		type(txtAmount, amount);
		getElement(txtAmount).sendKeys(Keys.TAB);
		waitForPrimefacesAjax();
		evidence.putAll(returnSaveImage(txtAmount));
		evidence.putAll(safeEvidence(txtAmount, "Amount"));

		// =========================================================
		// CURRENCY
		// =========================================================
		click(lblCurrency);
		waitForPrimefacesAjax();
		scrollIntoDropdownAndClick(containerCurrency, slctCurrency);
		waitForPrimefacesAjax();
		evidence.putAll(safeEvidence(lblCurrency, "Currency"));

		// =========================================================
		// RADIO BUTTON
		// =========================================================
		click(rdbtnSingleSourceFormatReason);
		waitForPrimefacesAjax();
		evidence.putAll(safeEvidence(rdbtnSingleSourceFormatReason, "Radio Button Single Source Format Reason"));

		// =========================================================
		// DETAILS / COMMENTS / FILE
		// =========================================================
		type(txtDetails, details);
		type(txtComments, comments);
		reporterLog("Uploading file...");
		uploadFile(pathFileSpot, btnChooseFiles);
		reporterLog("File upload command sent.");

		// =========================================================
		// VALIDACIÓN POST-UPLOAD
		// =========================================================
		if (!elementExistsAndVisible(btnDeleteFileUpload)) {
			reporterLog("[WARNING] btnDeleteFileUpload no visible en primera revisión. Esperando 10s...");
			Thread.sleep(10000);

			if (!elementExistsAndVisible(btnDeleteFileUpload)) {
				reporterLog("[INFO] Archivo no visible tras espera adicional. "
						+ "El guardado será manejado por clickSaveWithRetry() "
						+ "si se detecta msgStatusFAD al intentar guardar.");
			} else {
				reporterLog("[SUCCESS] Archivo cargado correctamente tras espera adicional.");
			}
		} else {
			reporterLog("[SUCCESS] Archivo cargado correctamente.");
		}
		evidence.putAll(safeEvidence(txtComments, "Comentarios"));

		// =========================================================
		// REQUIRED FIELDS VALIDATION
		// =========================================================
		requiredFields(txtDescription);
		requiredFields(txtSupplierName);
		requiredFields(txtAmount);
		requiredFields(lblCurrency);
		requiredFields(txtComments);
		return evidence;
	}

	/*
	 * @name: clickSave
	 *
	 * @date: 29/May/2026
	 *
	 * @param: description - Texto para txtDescription
	 * 
	 * @param: supplierName - Texto para txtSupplierName (PrimeFaces AutoComplete)
	 * 
	 * @param: amount - Texto para txtAmount
	 * 
	 * @param: details - Texto para txtDetails
	 * 
	 * @param: comments - Texto para txtComments
	 * 
	 * @param: pathFileSpot - Ruta absoluta del archivo a cargar
	 *
	 * @return: TreeMap<String, String> evidence
	 *
	 * @author: Fernando Villalba Aguilar
	 *
	 * @description: Caso alternativo. Intenta guardar el FAD y, si aparece
	 * msgStatusFAD, detecta campo por campo cuáles están vacíos o sin selección y
	 * los rellena con los parámetros recibidos antes de reintentar el guardado UNA
	 * sola vez.
	 *
	 * Campos validados en el reintento: - txtDescription - txtSupplierName
	 * (PrimeFaces AutoComplete) - txtAmount - slctCurrency (dropdown PrimeFaces) -
	 * rdbtnSingleSourceFormatReason (radio button) - txtComments - btnChooseFiles
	 * (archivo adjunto — detectado via btnDeleteFileUpload)
	 *
	 * IMPORTANTE: txtDetails NO es campo obligatorio según validación del sistema,
	 * por lo que no se evalúa en el reintento.
	 *
	 * Lanza RuntimeException si tras el reintento el mensaje persiste.
	 */
	public TreeMap<String, String> clickSave(String description, String supplierName, String amount, String details,
			String comments, String pathFileSpot) throws InterruptedException {

		reporterLog("Iniciando proceso de guardado FAD con reintento...");
		waitForElementPresent(btnSave);
		TreeMap<String, String> evidence = returnSaveImage(btnSave);
		click(btnSave);
		waitForPrimefacesAjax();

		// =========================================================
		// PRIMER INTENTO: verificar si el sistema reportó error
		// =========================================================
		if (!elementExistsAndVisible(msgStatusFAD)) {
			reporterLog("[SUCCESS] Guardado exitoso en primer intento. No se detectó mensaje de error.");
			return evidence;
		}

		// =========================================================
		// REINTENTO: msgStatusFAD visible — detectar y rellenar
		// campos vacíos antes de reintentar
		// =========================================================
		String msgError = getText(msgStatusFAD);
		reporterLog("[WARNING] Mensaje de validación detectado: [" + msgError + "]. "
				+ "Iniciando detección de campos vacíos para reintento...");

		// --- txtDescription ---
		if (isFieldEmpty(txtDescription)) {
			reporterLog("[RETRY] txtDescription vacío. Rellenando...");
			type(txtDescription, description);
			evidence.putAll(safeEvidence(txtDescription, "Retry - Description"));
		}

		// --- txtSupplierName (PrimeFaces AutoComplete) ---
		if (isFieldEmpty(txtSupplierName)) {
			reporterLog("[RETRY] txtSupplierName vacío. Rellenando con AutoComplete...");
			evidence.putAll(retrySupplierAutocomplete(supplierName));
		}

		// --- txtAmount ---
		if (isFieldEmpty(txtAmount)) {
			reporterLog("[RETRY] txtAmount vacío. Rellenando...");
			type(txtAmount, amount);
			getElement(txtAmount).sendKeys(Keys.TAB);
			waitForPrimefacesAjax();
			evidence.putAll(safeEvidence(txtAmount, "Retry - Amount"));
		}

		// --- slctCurrency (dropdown PrimeFaces) ---
		// Se valida intentando obtener el elemento slctCurrency directamente.
		// Si no es visible (panel cerrado) significa que no fue seleccionada.
		if (!isCurrencySelected()) {
			reporterLog("[RETRY] Currency no seleccionada. Seleccionando...");
			click(lblCurrency);
			waitForElementVisible(txtCurrency, 10);
			click(slctCurrency);
			waitForPrimefacesAjax();
			evidence.putAll(safeEvidence(slctCurrency, "Retry - Currency"));
		}

		// --- rdbtnSingleSourceFormatReason (radio button) ---
		if (!isRadioButtonSelected(rdbtnSingleSourceFormatReason)) {
			reporterLog("[RETRY] Radio button no seleccionado. Seleccionando...");
			click(rdbtnSingleSourceFormatReason);
			waitForPrimefacesAjax();
			evidence.putAll(safeEvidence(rdbtnSingleSourceFormatReason, "Retry - Radio Button Reason"));
		}

		// --- txtComments ---
		if (isFieldEmpty(txtComments)) {
			reporterLog("[RETRY] txtComments vacío. Rellenando...");
			type(txtComments, comments);
			evidence.putAll(safeEvidence(txtComments, "Retry - Comments"));
		}

		// --- Archivo adjunto (detectado via btnDeleteFileUpload) ---
		// btnDeleteFileUpload solo es visible cuando hay un archivo cargado.
		if (!elementExistsAndVisible(btnDeleteFileUpload)) {
			reporterLog("[RETRY] Archivo no cargado. Ejecutando upload...");
			uploadFile(pathFileSpot, btnChooseFiles);
			Thread.sleep(GlobalVariablesSPX.UPLOAD_TIMEOUT);
			if (!elementExistsAndVisible(btnDeleteFileUpload)) {
				reporterLog("[WARNING] Archivo aún no visible tras 10s. Esperando 10s adicionales...");
				Thread.sleep(GlobalVariablesSPX.UPLOAD_TIMEOUT);
			}
			evidence.putAll(safeEvidence(txtComments, "Retry - File Upload"));
		}

		// =========================================================
		// SEGUNDO INTENTO: guardar tras rellenar campos faltantes
		// =========================================================
		reporterLog("[RETRY] Campos corregidos. Ejecutando segundo intento de guardado...");
		waitForElementPresent(btnSave);
		evidence.putAll(returnSaveImage(btnSave));
		click(btnSave);
		waitForPrimefacesAjax();

		if (elementExistsAndVisible(msgStatusFAD)) {
			String msgRetry = getText(msgStatusFAD);
			logFrameworkErrorSimple("[ERROR] Guardado fallido tras reintento. Mensaje: " + msgRetry);
			throw new RuntimeException(
					"clickSaveWithRetry() - Guardado fallido tras reintento. " + "Mensaje del sistema: [" + msgRetry
							+ "]. " + "Revise los locators de los campos obligatorios o los datos de prueba.");
		}

		reporterLog("[SUCCESS] Guardado exitoso tras reintento.");
		return evidence;
	}

	/*
	 * @name: clickBack
	 * 
	 * @date: 16/Nov/2023
	 * 
	 * @param: N/A
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite dar clic en el bot�n "Back"
	 */
	public TreeMap<String, String> clickBack() throws InterruptedException {
		waitForElementPresent(btnBack);
		click(btnBack);
		Thread.sleep(GlobalVariablesSPX.SHORT_TIMEOUT);
		return returnSaveImage(btnBack);
	}

	// =========================================================
	// MÉTODOS PRIVADOS DE SOPORTE
	// =========================================================

	/*
	 * @name: isFieldEmpty
	 *
	 * @description: Valida si un campo input/textarea está vacío. Usa
	 * getAttribute("value") para leer el valor real del DOM, ya que getText() en
	 * inputs siempre retorna cadena vacía en Selenium. Si el elemento no existe o
	 * no es visible retorna true (considera vacío).
	 */
	private boolean isFieldEmpty(By locator) {
		try {
			List<WebElement> elements = driver.findElements(locator);
			if (elements.isEmpty()) {
				reporterLog("[isFieldEmpty] Elemento no encontrado en DOM: " + locator);
				return true;
			}
			String value = elements.get(0).getAttribute("value");
			boolean empty = (value == null || value.trim().isEmpty());
			reporterLog("[isFieldEmpty] " + locator + " -> vacío: " + empty + " | valor: [" + value + "]");
			return empty;
		} catch (StaleElementReferenceException e) {
			reporterLog("[isFieldEmpty] StaleElement en: " + locator + ". Considerando vacío.");
			return true;
		} catch (Exception e) {
			logFrameworkError("[isFieldEmpty] Error evaluando campo: " + locator, e);
			return true;
		}
	}

	/*
	 * @name: isRadioButtonSelected
	 *
	 * @description: Valida si un radio button de PrimeFaces está seleccionado. NO
	 * usa getElement() ni visibilityOfElementLocated porque los radio buttons de
	 * PrimeFaces están ocultos en el DOM (display:none). Usa
	 * presenceOfElementLocated + isSelected() para evaluación correcta.
	 */
	private boolean isRadioButtonSelected(By locator) {
		try {
			List<WebElement> elements = driver.findElements(locator);
			if (elements.isEmpty()) {
				reporterLog("[isRadioButtonSelected] Radio button no encontrado: " + locator);
				return false;
			}
			boolean selected = elements.get(0).isSelected();
			reporterLog("[isRadioButtonSelected] " + locator + " -> seleccionado: " + selected);
			return selected;
		} catch (StaleElementReferenceException e) {
			reporterLog("[isRadioButtonSelected] StaleElement en: " + locator + ". Considerando no seleccionado.");
			return false;
		} catch (Exception e) {
			logFrameworkError("[isRadioButtonSelected] Error evaluando radio: " + locator, e);
			return false;
		}
	}

	/*
	 * @name: isCurrencySelected
	 *
	 * @description: Valida si el campo Currency tiene un valor seleccionado. En
	 * PrimeFaces, el label de currency (lblCurrency) muestra el valor seleccionado
	 * como texto. Si el texto está vacío o es el placeholder por defecto, se
	 * considera no seleccionado. Usa findElements() para evitar excepción si el
	 * elemento no existe.
	 */
	private boolean isCurrencySelected() {
		try {
			List<WebElement> elements = driver.findElements(lblCurrency);
			if (elements.isEmpty()) {
				reporterLog("[isCurrencySelected] lblCurrency no encontrado. Considerando no seleccionado.");
				return false;
			}
			String labelText = elements.get(0).getText();
			boolean selected = (labelText != null && !labelText.trim().isEmpty());
			reporterLog("[isCurrencySelected] lblCurrency texto: [" + labelText + "] -> seleccionado: " + selected);
			return selected;
		} catch (StaleElementReferenceException e) {
			reporterLog("[isCurrencySelected] StaleElement en lblCurrency. Considerando no seleccionado.");
			return false;
		} catch (Exception e) {
			logFrameworkError("[isCurrencySelected] Error evaluando currency.", e);
			return false;
		}
	}

	/*
	 * @name: retrySupplierAutocomplete
	 *
	 * @description: Rellena el campo PrimeFaces AutoComplete de Supplier durante el
	 * reintento. Replica el flujo robusto de captureDataSingleSourceFormat para
	 * garantizar que el panel aparezca y la opción sea seleccionada.
	 */
	private TreeMap<String, String> retrySupplierAutocomplete(String supplierName) throws InterruptedException {
		By optSupplierName = By
				.xpath("//*[@id='formFAD:suppliers_panel']//li[@data-item-label='" + supplierName + "']");

		WebElement input = getElement(txtSupplierName);
		click(txtSupplierName);

		input.sendKeys(Keys.chord(Keys.CONTROL, "a"));
		input.sendKeys(Keys.DELETE);
		waitForPrimefacesAjax();

		for (char c : supplierName.toCharArray()) {
			input.sendKeys(String.valueOf(c));
			Thread.sleep(50);
		}

		input.sendKeys(Keys.SPACE);
		input.sendKeys(Keys.BACK_SPACE);
		waitForPrimefacesAjax();

		boolean panelVisible = waitForElementVisible(pnlSupplierName, 15);

		if (!panelVisible) {
			reporterLog("[RETRY][WARNING] Panel Supplier no visible. Forzando TAB...");
			input.sendKeys(Keys.TAB);
			waitForPrimefacesAjax();
			panelVisible = waitForElementVisible(pnlSupplierName, 8);
		}

		if (!panelVisible) {
			logFrameworkError("Supplier panel no apareció en reintento: " + supplierName, null);
			throw new RuntimeException(
					"retrySupplierAutocomplete() - Panel de sugerencias no apareció para: " + supplierName);
		}

		waitForElementVisible(optSupplierName, 10);
		click(optSupplierName);
		waitForPrimefacesAjax();

		return safeEvidence(txtSupplierName, "Retry - Supplier Name");
	}
}
