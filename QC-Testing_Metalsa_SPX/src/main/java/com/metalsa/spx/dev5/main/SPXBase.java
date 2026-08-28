package com.metalsa.spx.dev5.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import javax.imageio.ImageIO;
import org.apache.commons.codec.binary.Base64;
import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import org.openqa.selenium.interactions.Actions;

/**
 * ====================================================================================
 * Class Name: SPXBase
 * ====================================================================================
 *
 * @author Fernando Villalba Aguilar
 * @date 27/May/2026
 *
 * @description Clase base del framework de automatización SPX.
 *
 *              Esta clase centraliza: - Inicialización y configuración de
 *              WebDriver. - Métodos auxiliares para generación de datos
 *              aleatorios. - Utilidades reutilizables para pruebas
 *              automatizadas. - Acceso a catálogos globales de datos de prueba.
 *
 *              Objetivo: Reducir duplicidad de código y mantener una estructura
 *              reutilizable, mantenible y escalable para las suites de
 *              automatización Selenium.
 *
 *              Compatibilidad: - Selenium 4+ - Chrome moderno - Jenkins / CI-CD
 *              - Frameworks Page Object Model (POM)
 *              ====================================================================================
 */
public class SPXBase {

	// =========================================================================
	// WebDriver Instance
	// =========================================================================

	protected WebDriver driver;

	/**
	 * Estructura utilizada para almacenar la relación entre el nombre lógico de la
	 * captura y la ruta física del screenshot.
	 *
	 * Uso común: - Evidencias de ejecución - Reportes HTML/PDF - Integración con
	 * ExtentReports o Allure
	 */
	private TreeMap<String, String> listaScreenShots = new TreeMap<>();

	// =========================================================================
	// Random Generators
	// =========================================================================

	/**
	 * Generador aleatorio utilizado para selección de datos dinámicos durante la
	 * ejecución de pruebas automatizadas.
	 */
	private static final Random RANDOM = new Random();

	// =========================================================================
	// Dynamic XPath Collections
	// =========================================================================

	/**
	 * Colección de localizadores XPath utilizados para seleccionar de forma
	 * aleatoria distintas razones/formats disponibles en la interfaz.
	 *
	 * Este enfoque permite: - Variabilidad en ejecución de pruebas. - Simulación de
	 * comportamiento real del usuario. - Reducción de hardcodeo repetitivo.
	 */
	protected static final String[] SINGLE_SOURCE_FORMAT_REASON = {
			"//table[contains(@class,'radioFad')]/tbody/tr[1]//div[contains(@class,'ui-radiobutton-box')]",
			"//table[contains(@class,'radioFad')]/tbody/tr[2]//div[contains(@class,'ui-radiobutton-box')]",
			"//table[contains(@class,'radioFad')]/tbody/tr[3]//div[contains(@class,'ui-radiobutton-box')]",
			"//table[contains(@class,'radioFad')]/tbody/tr[4]//div[contains(@class,'ui-radiobutton-box')]",
			"//table[contains(@class,'radioFad')]/tbody/tr[5]//div[contains(@class,'ui-radiobutton-box')]",
			"//table[contains(@class,'radioFad')]/tbody/tr[6]//div[contains(@class,'ui-radiobutton-box')]" };
	// =========================================================================
	// Constructor
	// =========================================================================

	/**
	 * Constructor principal de la clase base.
	 *
	 * @param driver instancia activa del WebDriver utilizada durante la ejecución
	 *               de pruebas automatizadas.
	 */
	public SPXBase(WebDriver driver) {
		this.driver = driver;
	}

	// =========================================================================
	// Generic Random Utilities
	// =========================================================================

	/*
	 * @name: randomFrom
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: String[] values
	 * 
	 * @return: String
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Selecciona y retorna un elemento aleatorio desde un arreglo de
	 * cadenas especificadas; valida que el arreglo no sea nulo ni se encuentre
	 * vacio para evitar excepciones.
	 */
	public static String randomFrom(String[] values) {

		if (values == null || values.length == 0) {
			return "";
		}

		int randomIndex = ThreadLocalRandom.current().nextInt(values.length);

		return values[randomIndex];
	}

	/*
	 * @name: getRandomValue
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: String[] array
	 * 
	 * @return: String
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Retorna un valor aleatorio de un arreglo de cadenas utilizando
	 * la instancia global de Random.
	 */
	public static String getRandomValue(String[] array) {
		return array[RANDOM.nextInt(array.length)];
	}

	/*
	 * @name: generateNumbers
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: String[]
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Genera un arreglo de cadenas de texto con una secuencia
	 * numerica del 1 al 1000 para su uso en pruebas de datos masivos o iterativos.
	 */
	public static String[] generateNumbers() {

		String[] numbers = new String[1000];

		for (int i = 0; i < 1000; i++) {
			numbers[i] = String.valueOf(i + 1);
		}

		return numbers;
	}

	// =========================================================================
	// Random Test Data Methods
	// =========================================================================

	/*
	 * @name: randomMaterial
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: String
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Obtiene un valor aleatorio del catalogo de materiales definido
	 * en las variables globales.
	 */
	public static String randomMaterial() {
		return randomFrom(GlobalVariablesSPX.MATERIAL);
	}

	/*
	 * @name: randomColor
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: String
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Obtiene un valor aleatorio del catalogo de colores definido en
	 * las variables globales.
	 */
	public static String randomColor() {
		return randomFrom(GlobalVariablesSPX.COLOR);
	}

	/*
	 * @name: randomBrand
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: String
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Obtiene un valor aleatorio del catalogo de marcas definido en
	 * las variables globales.
	 */
	public static String randomBrand() {
		return randomFrom(GlobalVariablesSPX.MARCA);
	}

	/*
	 * @name: randomMeasurement
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: String
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Obtiene un valor aleatorio del catalogo de medidas definido en
	 * las variables globales.
	 */
	public static String randomMeasurement() {
		return randomFrom(GlobalVariablesSPX.MEDIDAS);
	}

	/*
	 * @name: randomSupplier
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: String
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Obtiene un valor aleatorio del catalogo de proveedores definido
	 * en las variables globales.
	 */
	public static String randomSupplier() {
		return randomFrom(GlobalVariablesSPX.PROVEEDORES);
	}

	/*
	 * @name: randomUnitOfMeasureES
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: String
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Obtiene una unidad de medida aleatoria en idioma espanol desde
	 * el catalogo global.
	 */
	public static String randomUnitOfMeasureES() {
		return randomFrom(GlobalVariablesSPX.UNIDAD_DE_MEDIDA_ES);
	}

	/*
	 * @name: randomUnitOfMeasureEN
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: String
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Obtiene una unidad de medida aleatoria en idioma ingles desde
	 * el catalogo global.
	 */
	public static String randomUnitOfMeasureEN() {
		return randomFrom(GlobalVariablesSPX.UNIDAD_DE_MEDIDA_EN);
	}

	/*
	 * @name: randomUnitOfMeasurePT
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: String
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Obtiene una unidad de medida aleatoria en idioma portugues
	 * desde el catalogo global.
	 */
	public static String randomUnitOfMeasurePT() {
		return randomFrom(GlobalVariablesSPX.UNIDAD_DE_MEDIDA_PT);
	}

	/*
	 * @name: randomNumber
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: String
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Obtiene un valor numerico aleatorio almacenado en el catalogo
	 * global de datos de prueba.
	 */
	public static String randomNumber() {
		return randomFrom(GlobalVariablesSPX.NUM_RAND);
	}

	/*
	 * @name: randomQuantity
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: String
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Obtiene una cantidad aleatoria almacenada en el catalogo global
	 * de datos de prueba.
	 */
	public static String randomQuantity() {
		return randomFrom(GlobalVariablesSPX.QUANTITY);
	}

	/*
	 * @name: randomCurrency
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: String
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Obtiene un tipo de moneda aleatorio almacenado en el catalogo
	 * global.
	 */
	public static String randomCurrency() {
		return randomFrom(GlobalVariablesSPX.MONEDA);
	}

	/*
	 * @name: randomCodeSuggested
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: String
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Genera una cadena formateada de codigo sugerido que incluye la
	 * etiqueta de prueba, un prefijo aleatorio del catalogo global y un sufijo
	 * numerico aleatorio entre 100 y 9999.
	 */
	public static String randomCodeSuggested() {
		String prefix = randomFrom(GlobalVariablesSPX.CODE_SUGGESTED_PREFIXES);
		int number = 100 + new Random().nextInt(9900); // rango 100–9999
		return String.format("[PRUEBA] %s-%04d", prefix, number);
	}

	/*
	 * @name: randomEquipementMachineTool
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: String
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Genera una descripcion aleatoria formateada para equipos o
	 * herramientas combinando tipo, numero correlativo aleatorio y ubicacion
	 * tomados de los catalogos globales.
	 */
	public static String randomEquipementMachineTool() {
		String type = randomFrom(GlobalVariablesSPX.EQUIPMENT_TYPES);
		String location = randomFrom(GlobalVariablesSPX.EQUIPMENT_LOCATIONS);
		int number = 100 + new Random().nextInt(9900); // rango 100–9999
		return String.format("%s Nuevo-%04d Uso-%s", type, number, location);
	}

	/*
	 * @name: randomMeasures
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: String
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Genera un valor aleatorio de medicion (rango 1 a 100)
	 * concatenado con su unidad correspondiente seleccionada del catalogo global.
	 */
	public static String randomMeasures() {
		String unit = randomFrom(GlobalVariablesSPX.MEASURE_UNITS);
		int value = 1 + new Random().nextInt(100); // rango 1–100
		return value + " " + unit;
	}

	/*
	 * @name: randomItem
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: String
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Genera un nombre de item dinamico concatenando nombre,
	 * identificador numerico de 4 digitos y ubicacion aleatoria desde catalogos
	 * globales.
	 */
	public static String randomItem() {
		String name = randomFrom(GlobalVariablesSPX.ITEM_NAMES);
		String location = randomFrom(GlobalVariablesSPX.ITEM_LOCATIONS);
		int number = 100 + new Random().nextInt(9900); // rango 100–9999
		return String.format("[PRUEBA] %s %04d %s", name, number, location);
	}

	/*
	 * @name: randomPhysicalChemical
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: String
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Genera una cadena que representa una propiedad fisico-quimica
	 * asignando un valor aleatorio entre 1 y 1000 junto con su unidad de medida y
	 * propiedad desde variables globales.
	 */
	public static String randomPhysicalChemical() {
		String property = randomFrom(GlobalVariablesSPX.PHYSICAL_PROPERTIES);
		String unit = randomFrom(GlobalVariablesSPX.PHYSICAL_UNITS);
		int value = 1 + new Random().nextInt(1000); // rango 1–1000
		return property + " = " + value + " " + unit;
	}

	/*
	 * @name: randomReference
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: String
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Genera una referencia dinamica de prueba concatenando un
	 * prefijo aleatorio, un numero de 4 digitos y una categoria obtenidos de las
	 * variables globales.
	 */
	public static String randomReference() {
		String prefix = randomFrom(GlobalVariablesSPX.REFERENCE_PREFIXES);
		String category = randomFrom(GlobalVariablesSPX.REFERENCE_CATEGORIES);
		int number = 1000 + new Random().nextInt(9000); // rango 1000–9999
		return String.format("%s%04d-%s", prefix, number, category);
	}

	/*
	 * @name: randomManufacturer
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: String
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Obtiene un fabricante aleatorio desde el catalogo global de
	 * datos de prueba.
	 */
	public static String randomManufacturer() {
		return randomFrom(GlobalVariablesSPX.MANUFACTURER);
	}

	/*
	 * @name: randomPurchaseSpotID
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: String
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Genera un ID aleatorio para un punto de compra con una longitud
	 * que varia entre 1 y 5 digitos.
	 */
	public static String randomPurchaseSpotID() {
		return String.valueOf(randomNumberWithDigits(1, 5));
	}

	/*
	 * @name: randomEstimated
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: String
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Genera un valor estimado aleatorio representado en formato de
	 * texto con una longitud de 1 a 3 digitos.
	 */
	public static String randomEstimated() {
		return String.valueOf(randomNumberWithDigits(1, 3));
	}

	private static int lastSuggestedMin = 0;

	/*
	 * @name: randomSuggestedMin
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: String
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Genera y almacena un valor minimo sugerido aleatorio de 1 a 3
	 * digitos, asegurando un techo maximo de 998 para garantizar consistencia en la
	 * relacion min/max.
	 */
	public static String randomSuggestedMin() {
		lastSuggestedMin = randomNumberWithDigits(1, 3);
		// Evita que el min ya ocupe el techo (999), para que siempre quepa un max mayor
		if (lastSuggestedMin >= 999) {
			lastSuggestedMin = 998;
		}
		return String.valueOf(lastSuggestedMin);
	}

	/*
	 * @name: randomSuggestedMax
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: String
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Genera un valor maximo sugerido aleatorio garantizando
	 * matematicamente que sea superior al ultimo valor minimo sugerido generado.
	 */
	public static String randomSuggestedMax() {
		int max = lastSuggestedMin + 1 + RANDOM.nextInt(999 - lastSuggestedMin);
		return String.valueOf(max);
	}

	/*
	 * @name: randomPartNumber
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: String
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Genera un numero de parte aleatorio bajo el patron formateado
	 * "PN-XXXX-Y", utilizando un numero entre 1000 y 9999 y una letra mayuscula
	 * aleatoria (A-Z).
	 */
	public static String randomPartNumber() {
		int number = 1000 + new Random().nextInt(9000); // rango 1000–9999
		char letter = (char) ('A' + new Random().nextInt(26)); // A–Z aleatoria
		return String.format("PN-%04d-%c", number, letter);
	}

	/*
	 * @name: randomDescriptionItem
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: String
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Obtiene una descripcion aleatoria para la creacion de nuevos
	 * articulos desde el catalogo global.
	 */
	public static String randomDescriptionItem() {
		return randomFrom(GlobalVariablesSPX.DESCRIPTION_NEW_ITEM);
	}

	/*
	 * @name: randomUrgencyReason
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: String lang
	 * 
	 * @return: String
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Selecciona y retorna una razon de urgencia aleatoria basada en
	 * el idioma proporcionado ("PT", "EN" o por defecto "ES").
	 */
	public static String randomUrgencyReason(String lang) {

		String[] source;

		switch (lang) {
		case "PT":
			source = GlobalVariablesSPX.RAZON_URGENCIA_PT;
			break;
		case "EN":
			source = GlobalVariablesSPX.RAZON_URGENCIA_ENG;
			break;
		default:
			source = GlobalVariablesSPX.RAZON_URGENCIA;
			break;
		}

		return randomFrom(source);
	}

	/*
	 * @name: randomGenericName
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: String
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Obtiene un nombre generico aleatorio desde el catalogo global
	 * para su uso en formularios de prueba.
	 */
	public static String randomGenericName() {
		return randomFrom(GlobalVariablesSPX.GENERIC_NAME);
	}

	/*
	 * @name: randomGenericItem
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: String
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Obtiene un item generico aleatorio desde el catalogo global
	 * para escenarios de prueba automatizados.
	 */
	public static String randomGenericItem() {
		return randomFrom(GlobalVariablesSPX.GENERIC_ITEM);
	}

	/*
	 * @name: randomComments
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: String
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Obtiene un texto de comentario u observacion aleatorio desde el
	 * catalogo global para el llenado de notas o bitacoras.
	 */
	public static String randomComments() {
		return randomFrom(GlobalVariablesSPX.COMENTARIOS);
	}

	/*
	 * @name: randomDescFAD
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: String
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Obtiene una descripcion aleatoria asociada al flujo FAD desde
	 * el catalogo global de datos.
	 */
	public static String randomDescFAD() {
		return randomFrom(GlobalVariablesSPX.DESC_FAD);
	}

	/*
	 * @name: randomRAD
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: String
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Obtiene una razon de asignacion directa aleatoria desde las
	 * variables globales del sistema.
	 */
	public static String randomRAD() {
		return randomFrom(GlobalVariablesSPX.RAZON_ASIGNACION_DIRECTA);
	}

	/*
	 * @name: randomCommentsFad
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: String
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Obtiene un comentario aleatorio especifico para procesos FAD
	 * desde el catalogo global de variables.
	 */
	public static String randomCommentsFad() {
		return randomFrom(GlobalVariablesSPX.COMENTARIOS_FAD);
	}
	// =========================================================================
	// WebDriver Initialization
	// =========================================================================

	/**
	 * Inicializa una instancia de Google Chrome utilizando Selenium WebDriver.
	 *
	 * Configuración aplicada: - Maximización automática de ventana. - Desactivación
	 * de notificaciones. - Desactivación de popups. - Compatibilidad con ambientes
	 * CI/CD. - Configuración estable para Selenium 4.
	 *
	 * Timeouts configurados: - Page Load Timeout: 60 segundos. - Script Timeout: 30
	 * segundos.
	 *
	 * Compatibilidad: - Chrome moderno. - Jenkins. - Docker/Linux. - Selenium Grid.
	 *
	 * @return instancia inicializada de WebDriver.
	 */
	public WebDriver chromeDriverConnection() {

		try {

			ChromeOptions chromeOptions = new ChromeOptions();

			// Permite compatibilidad entre Selenium y versiones recientes de Chrome.
			chromeOptions.addArguments("--remote-allow-origins=*");

			// Inicia el navegador maximizado.
			chromeOptions.addArguments("--start-maximized");

			// Deshabilita notificaciones del navegador.
			chromeOptions.addArguments("--disable-notifications");

			// Deshabilita ventanas emergentes.
			chromeOptions.addArguments("--disable-popup-blocking");

			// Oculta mensajes informativos de automatización.
			chromeOptions.addArguments("--disable-infobars");

			// Mejora estabilidad en ambientes Linux/CI.
			chromeOptions.addArguments("--disable-dev-shm-usage");

			// Requerido comúnmente en Docker/Linux.
			chromeOptions.addArguments("--no-sandbox");

			// Configura automáticamente la versión compatible de ChromeDriver.
			WebDriverManager.chromedriver().setup();

			// Inicializa navegador Chrome.
			driver = new ChromeDriver(chromeOptions);

			// Timeout máximo para carga completa de páginas.
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(70));

			// Timeout máximo para ejecución de scripts.
			driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));

			reporterLog("ChromeDriver initialized successfully.");

			return driver;

		} catch (Exception exception) {

			logFrameworkError("> Error initializing ChromeDriver connection.", exception);

			exception.printStackTrace();

			return null;
		}
	}

	/*
	 * @name: launchBrowser
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: String url
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Inicializa la navegacion hacia la URL desencriptada
	 * especificada y maximiza la ventana del navegador, capturando y registrando
	 * posibles excepciones de tiempo de espera o ejecucion de WebDriver.
	 */
	public void launchBrowser(String url) {
		try {
			reporterLog("Launching ... " + url);
			driver.get(getEncrypted(url));
			driver.manage().window().maximize();
		} catch (TimeoutException e) {
			logFrameworkError("> Timeout while loading the URL: " + url, e);
			e.printStackTrace();
		} catch (WebDriverException e) {
			logFrameworkError("> WebDriver encountered an error while launching the browser: ", e);
			e.printStackTrace();
		}
	}

	/*
	 * @name: reporterLog
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: String log
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Agrega un mensaje o traza personalizada en el reporte de
	 * ejecucion del caso de prueba (TestNG Reporter) manejando posibles excepciones
	 * durante el registro.
	 */
	public void reporterLog(String log) {
		try {
			Reporter.log(log);
		} catch (TimeoutException e) {
			logFrameworkError("> The report was not made correctly...", e);
			e.printStackTrace();
		}
	}

	/*
	 * @name: waitForElementPresent
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: By locator
	 * 
	 * @return: WebElement
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Ejecuta una espera explicita hasta que el elemento especificado
	 * por el localizador se encuentre presente en el DOM, utilizando el tiempo de
	 * espera predeterminado del framework.
	 */
	public WebElement waitForElementPresent(By locator) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVariablesSPX.DEFAULT_TIMEOUT));

		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/*
	 * @name: waitForElementVisible
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: By locator, int seconds
	 * 
	 * @return: boolean
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Evalua la visibilidad de un elemento en el DOM dentro de un
	 * tiempo limite personalizado en segundos, retornando verdadero si se muestra o
	 * falso en caso de timeout o excepcion.
	 */
	public boolean waitForElementVisible(By locator, int seconds) {
		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));

			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

			return true;

		} catch (Exception e) {

			return false;
		}
	}

	/*
	 * @name: waitForElementPresent
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: By locator, int seconds
	 * 
	 * @return: WebElement
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Ejecuta una espera explicita configurada con un tiempo dinamico
	 * en segundos hasta confirmar la presencia del elemento en el DOM; registra
	 * errores en el reporte si expira el tiempo.
	 */
	public WebElement waitForElementPresent(By locator, int seconds) {
		try {

			reporterLog("Waiting for element presence: " + locator);
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
			return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		} catch (TimeoutException e) {
			logFrameworkError("> Element NOT present in DOM: " + locator, e);
			reporterLog("[ERROR] Timeout waiting for element presence.");
			throw e;
		}
	}

	/*
	 * @name: type
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: By locator, String inputText
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Ingresa una cadena de texto en un campo de entrada tras limpiar
	 * su contenido previo, implementando hasta 3 reintentos automaticos ante
	 * excepciones de elementos obsoletos (StaleElementReferenceException).
	 */
	public void type(By locator, String inputText) {
		int attempts = 0;
		while (attempts < 3) {
			try {
				reporterLog("Typing text into field: " + locator);
				WebElement element = getElement(locator);
				element.clear();
				element.sendKeys(inputText);
				return;
			} catch (StaleElementReferenceException e) {
				attempts++;
				reporterLog("[WARNING] Retrying type(): " + attempts);
			} catch (Exception e) {
				logFrameworkError("> Unable to type into element: " + locator, e);
				throw e;
			}
		}
	}

	/*
	 * @name: typeClear
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: By locator
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Realiza la limpieza forzada del contenido de un campo de texto
	 * enviando la combinacion de teclas CONTROL + A y DELETE, finalizando con la
	 * captura de evidencia visual.
	 */
	public void typeClear(By locator) {
		try {
			WebElement element = getElement(locator);
			element.click();
			element.sendKeys(Keys.CONTROL + "a");
			element.sendKeys(Keys.DELETE);
			takeScreenshot();
		} catch (Exception e) {
			logFrameworkError("> Unable to clear element: " + locator, e);
			throw e;
		}
	}

	/*
	 * @name: getElement
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: By locator
	 * 
	 * @return: WebElement
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Metodo centralizado para la obtencion de elementos
	 * interactuables que sincroniza peticiones AJAX y overlays de PrimeFaces,
	 * aplica desplazamiento centrado al elemento y gestiona reintentos por
	 * elementos obsoletos.
	 */
	public WebElement getElement(By locator) {
		int attempts = 0;
		Exception lastException = null;
		while (attempts < 3) {
			try {
				reporterLog("Getting element: " + locator);
				waitForBlockUIToDisappear();
				waitForPrimefacesAjax();
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GlobalVariablesSPX.DEFAULT_TIMEOUT));
				WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", element);
				reporterLog("[SUCCESS] Element obtained successfully.");
				return element;
			} catch (StaleElementReferenceException e) {
				attempts++;
				lastException = e;
				reporterLog("[WARNING] Stale element detected. Retry: " + attempts);
			} catch (TimeoutException e) {
				logFrameworkError("> Element not visible: " + locator, e);
				reporterLog("[ERROR] Timeout waiting for element: " + locator);
				throw e;
			} catch (Exception e) {
				logFrameworkError("> Unable to obtain element: " + locator, e);
				reporterLog("[ERROR] Unexpected error obtaining element.");
				throw e;
			}
		}
		throw new RuntimeException("Unable to obtain element after retries: " + locator, lastException);
	}

	/*
	 * @name: click
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: By locator
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Executa una accion de clic sobre un elemento interactuable tras
	 * verificar su estado; incluye manejo de reintentos por elementos obsoletos y
	 * respaldo (fallback) con JavaScript si el clic nativo falla.
	 */
	public void click(By locator) {
		int attempts = 0;
		while (attempts < 3) {
			try {
				reporterLog("Clicking element: " + locator);
				WebElement element = waitForElementClickable(locator);
				try {
					element.click();
					reporterLog("[SUCCESS] Normal click executed.");
				} catch (Exception clickException) {
					reporterLog("[WARNING] Normal click failed. Trying JS click.");
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
					reporterLog("[SUCCESS] JS click executed.");
				}
				return;
			} catch (StaleElementReferenceException e) {
				attempts++;
				reporterLog("[WARNING] Stale element detected. Retry: " + attempts);
			} catch (Exception e) {
				logFrameworkError("Unable to click element: " + locator, e);
				reporterLog("[ERROR] Click failed.");
				throw e;
			}
		}
		throw new RuntimeException("Unable to click element after retries: " + locator);
	}

	/*
	 * @name: elementExistsAndVisible
	 * 
	 * @date: 27/May/2026
	 * 
	 * @param: By locator
	 * 
	 * @return: boolean
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este método permite validar de forma segura si un elemento:
	 * 
	 * 1. Existe dentro del DOM. 2. Está visible en pantalla.
	 * 
	 * A diferencia de findElement(), este método utiliza findElements() para evitar
	 * NoSuchElementException cuando el elemento no existe.
	 * 
	 * Casos posibles: - El elemento NO existe -> retorna false - El elemento existe
	 * pero está oculto -> retorna false - El elemento existe y es visible ->
	 * retorna true - Error inesperado -> retorna false
	 */
	public boolean elementExistsAndVisible(By locator) {
		try {

			/*
			 * Busca TODOS los elementos que coincidan con el locator.
			 * 
			 * IMPORTANTE: findElements() NO lanza excepción si el elemento no existe.
			 * Simplemente devuelve una lista vacía.
			 */
			List<WebElement> elements = driver.findElements(locator);

			/*
			 * Validación 1: Si la lista está vacía, significa que el elemento NO existe
			 * dentro del DOM.
			 */
			if (elements.isEmpty()) {
				reporterLog("[INFO] Element NOT present in DOM: " + locator);
				return false;
			}

			/*
			 * Obtiene el primer elemento encontrado.
			 * 
			 * En la mayoría de los casos el locator debería devolver un único elemento.
			 */
			WebElement element = elements.get(0);

			/*
			 * Validación 2: Verifica si el elemento existe pero está oculto.
			 * 
			 * isDisplayed() valida: - visibility - display - tamaño visible
			 */
			if (!element.isDisplayed()) {
				reporterLog("[INFO] Element present but NOT visible: " + locator);
				return false;
			}

			/*
			 * Si llegó hasta aquí: - El elemento existe - El elemento es visible
			 */
			reporterLog("[INFO] Element exists and is visible: " + locator);
			return true;
		} catch (StaleElementReferenceException e) {

			/*
			 * Ocurre cuando el DOM cambia mientras Selenium intenta usar el elemento.
			 */
			reporterLog("[WARNING] Stale element detected: " + locator);
			return false;
		} catch (Exception e) {

			/*
			 * Captura cualquier error inesperado para evitar que el framework se rompa
			 * durante validaciones.
			 */
			logFrameworkError("[ERROR] Unexpected error checking element: " + locator, e);
			return false;
		}
	}

	/*
	 * @name: returnSaveImage
	 * 
	 * @date: 21/Nov/2023
	 * 
	 * @param: By locator
	 * 
	 * @return: takeScreenshot("QC-Testing_SaveImage_" + date());
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite guardar las imagenes mediante un return
	 * hacia un word
	 */

	public TreeMap<String, String> returnSaveImage(By locator) {

		try {
			reporterLog("Taking Screenshot (element may or may not exist): " + locator);

			if (!driver.findElements(locator).isEmpty()) {
				// System.out.println("Element exists: " + locator);
			} else {
				logFrameworkErrorSimple("Element does not exist: " + locator);
			}

		} catch (Exception e) {
			logFrameworkError("Error validating locator: " + locator, e);
			e.printStackTrace();
		}

		// SIEMPRE toma screenshot, exista o no el elemento
		return takeScreenshot();
	}

	/*
	 * @name: date
	 * 
	 * @date: 28/Oct/2023
	 * 
	 * @param: N/A
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite dar la fecha y hora actuales
	 */
	public String date() {
		try {
			String dateTime = DateTimeFormatter.ofPattern("MMM dd yyyy, hh mm ss a").format(LocalDateTime.now());
			return dateTime;
		} catch (NoSuchElementException e) {
			logFrameworkError("> It was not possible to generate the date...", e);
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * @name: isDisplayed
	 * 
	 * @date: 28/Oct/2023
	 * 
	 * @param: By locator
	 * 
	 * @return: driver.findElement(locator).isDisplayed(); / false
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite verificar si el elemento se encuentra
	 * disponible
	 */
	public boolean isDisplayed(By locator) {
		try {
			// Buscar el elemento en la p�gina usando el locator proporcionado
			WebElement element = getElement(locator);

			// Verificar si el elemento est� visible en la pantalla
			boolean visible = element.isDisplayed();

			// Si el elemento es visible
			if (visible) {
				// Registrar en el reporte que el elemento est� visible
				reporterLog("Element displayed: " + locator);
			} else {
				// Aviso en consola si el elemento existe pero no es visible
				logFrameworkErrorSimple("[INFO] Element found but NOT visible: " + locator);
			}

			// Devolver el estado de visibilidad (true si es visible, false si no)
			return visible;

		} catch (NoSuchElementException e) {
			logFrameworkError("[INFO] Element NOT present in DOM: " + locator, e);
			return false;

		} catch (Exception e) {
			logFrameworkError("[ERROR] Unexpected error checking visibility of: " + locator, e);
			return false;

		} finally {
			// Tomar una captura de pantalla siempre, independientemente del resultado
			takeScreenshot();
		}
	}

	/*
	 * @name: uploadFile
	 * 
	 * @description: Upload robusto para PrimeFaces usando presenceOfElementLocated
	 * + validación de estabilización post-upload.
	 */
	public void uploadFile(String path, By locator) {

		try {
			reporterLog("Uploading file: " + path);

			File file = new File(path);
			String absolutePath = file.getAbsolutePath();

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			// 1. Obtener input aunque esté oculto
			WebElement uploadElement = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

			// 2. Enviar archivo
			uploadElement.sendKeys(absolutePath);
			reporterLog("[SUCCESS] File sent to input.");

			// 3. Espera corta de estabilización (NO AJAX genérico)
			Thread.sleep(GlobalVariablesSPX.UPLOAD_STABILIZATION);

			// 5. Evidencia del upload

		} catch (TimeoutException e) {
			logFrameworkError("> Upload input NOT present: " + locator, e);
			throw e;

		} catch (Exception e) {
			logFrameworkError("> Unable to upload file.", e);
			throw new RuntimeException(e);
		}
	}

	public void safeWaitForPrimefacesAjaxAfterUpload() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

			wait.until(driver -> {
				try {
					JavascriptExecutor js = (JavascriptExecutor) driver;

					Object result = js.executeScript(
							"return (window.PrimeFaces && PrimeFaces.ajax && PrimeFaces.ajax.Queue.isEmpty());");

					return result instanceof Boolean && (Boolean) result;
				} catch (Exception e) {
					return true; // 👈 IMPORTANTE: no bloquear upload
				}
			});

		} catch (TimeoutException e) {
			reporterLog("[WARNING] AJAX after upload not stable, continuing test...");
		}
	}

	/*
	 * @name: getJSONValue
	 * 
	 * @date: 23/Feb/2023
	 * 
	 * @param: String jsonFileObj, String jsonKey
	 * 
	 * @return: jsonValue / null
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite leer la informaci�n de un archivo JSON
	 */
	public String getJSONValue(String jsonFileObj, String jsonKey) {
		try {

			// JSON Data
			InputStream inputStream = new FileInputStream(GlobalVariablesSPX.PATH_JSON_DATA + jsonFileObj + ".json");
			JSONObject jsonObject = new JSONObject(new JSONTokener(inputStream));

			// Get Data
			String jsonValueString = (String) jsonObject.get(jsonKey);
			return jsonValueString;
		} catch (FileNotFoundException e) {
			Assert.fail("***** ERROR *****");
			Assert.fail("> JSON file is not found ");
			Assert.fail("> Because: " + e.getMessage());
			return null;
		}
	}

	/*
	 * @name: getEncrypted
	 * 
	 * @date: 23/Feb/2023
	 * 
	 * @param: String encrypted
	 * 
	 * @return: String(decodedBytes)
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite decodificar un dato almacenado en el JSON
	 */
	public String getEncrypted(String encrypted) {
		try {
			byte[] decodedBytes = Base64.decodeBase64(encrypted);
			return new String(decodedBytes);
		} catch (IllegalArgumentException e) {
			logFrameworkError("> It was not possible to obtain the encryption...", e);
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * @name: getText
	 * 
	 * @date: 02/Nov/2023
	 * 
	 * @param: By locator
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite obtener el texto de un elemento
	 */
	public String getText(By locator) {
		try {
			WebElement element = getElement(locator);
			String text = element.getText();
			reporterLog("Text obtained: " + text);
			return text;
		} catch (Exception e) {
			logFrameworkError("> Unable to obtain text from: " + locator, e);
			return "";
		}
	}

	/*
	 * @name: waitForPrimefacesAjax
	 * 
	 * @date: 27/May/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: void
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este método permite esperar de forma explícita a que finalicen
	 * todas las peticiones AJAX ejecutadas por PrimeFaces antes de continuar con la
	 * automatización.
	 * 
	 * Objetivo: - Evitar uso de Thread.sleep(). - Mejorar sincronización Selenium +
	 * PrimeFaces. - Reducir errores intermitentes. - Esperar correctamente recargas
	 * parciales AJAX.
	 * 
	 * Funcionamiento: Selenium ejecuta continuamente un script JavaScript que
	 * valida:
	 * 
	 * PrimeFaces.ajax.Queue.isEmpty()
	 * 
	 * Cuando la cola AJAX queda vacía: -> retorna TRUE -> Selenium continúa la
	 * ejecución.
	 * 
	 * Si AJAX sigue trabajando: -> retorna FALSE -> Selenium continúa esperando.
	 */

	public void waitForPrimefacesAjax() {
		try {

			/*
			 * Explicit Wait: Esperará máximo 20 segundos antes de lanzar TimeoutException.
			 */
			WebDriverWait localWait = new WebDriverWait(driver, Duration.ofSeconds(20));

			/*
			 * until(): Ejecuta repetidamente la función lambda hasta que ésta retorne TRUE.
			 */
			localWait.until(driver -> {
				try {

					/*
					 * Permite ejecutar JavaScript directamente en el navegador.
					 */
					JavascriptExecutor js = (JavascriptExecutor) driver;

					/*
					 * JavaScript ejecutado:
					 * 
					 * window.PrimeFaces -> valida que PrimeFaces exista.
					 * 
					 * PrimeFaces.ajax -> valida que exista el manejador AJAX.
					 * 
					 * PrimeFaces.ajax.Queue.isEmpty() -> retorna TRUE cuando NO existen peticiones
					 * AJAX pendientes.
					 */
					Object ajaxComplete = js.executeScript("return (window.PrimeFaces " + "&& PrimeFaces.ajax "
							+ "&& PrimeFaces.ajax.Queue.isEmpty());");

					/*
					 * Validación segura: Confirmamos que JavaScript realmente retornó un Boolean.
					 */
					if (ajaxComplete instanceof Boolean) {

						/*
						 * TRUE -> AJAX finalizó FALSE -> AJAX sigue ejecutándose
						 */
						return (Boolean) ajaxComplete;
					}

					/*
					 * Si el resultado no es Boolean, continuar esperando.
					 * 
					 * Esto evita falsos positivos de sincronización.
					 */
					return false;
				} catch (Exception ex) {

					/*
					 * Si ocurre error: - DOM reconstruyéndose - PrimeFaces aún cargando - AJAX
					 * actualizando componentes - Página parcialmente renderizada
					 * 
					 * Selenium debe seguir esperando.
					 */
					reporterLog("[INFO] Waiting PrimeFaces AJAX...");
					return false;
				}
			});

			/*
			 * Log exitoso: Todas las peticiones AJAX finalizaron.
			 */
			reporterLog("PrimeFaces AJAX requests completed successfully.");
		} catch (TimeoutException e) {

			/*
			 * Si después de 20 segundos AJAX sigue ejecutándose:
			 * 
			 * - No se detiene la prueba - Solo se registra advertencia
			 */
			reporterLog("[WARNING] Timeout waiting for PrimeFaces AJAX queue.");
		} catch (Exception e) {

			/*
			 * Captura cualquier error inesperado durante el proceso de sincronización.
			 */
			logFrameworkError("> Unexpected error waiting for PrimeFaces AJAX.", e);
			e.printStackTrace();
		}
	}

	/*
	 * @name: waitForDropdownToLoad
	 * 
	 * @date: 25/Nov/2025
	 * 
	 * @param: By optionLocator
	 * 
	 * @return: void
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este m�todo espera a que un men� desplegable termine de cargar
	 * sus opciones. Primero sincroniza con las operaciones AJAX de PrimeFaces y
	 * luego verifica que el elemento indicado se encuentre visible en la p�gina.
	 */
	public void waitForDropdownToLoad(By optionLocator) {
		waitForPrimefacesAjax();
		waitForElementVisible(optionLocator, 20);
	}

	/*
	 * @name: getText
	 * 
	 * @date: 02/Nov/2023
	 * 
	 * @param: By locator
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite obtener el texto de un elemento
	 */
	public static String assignUEN() {
		String uenNumber = GlobalVariablesSPX.SPX_DEV5_NUM_UEN; // Obtener el n�mero de UEN de UENData
		String uenName = "Valor por defecto";

		if (uenNumber.equals(GlobalVariablesSPX.SPX_DEV5_NUM_UEN_SAN_ANTONIO)) {
			uenName = GlobalVariablesSPX.SPX_DEV5_NOM_UEN_SAN_ANTONIO;
		} else if (uenNumber.equals(GlobalVariablesSPX.SPX_DEV5_NUM_UEN_SAC)) {
			uenName = GlobalVariablesSPX.SPX_DEV5_NOM_UEN_SAC;
		} else if (uenNumber.equals(GlobalVariablesSPX.SPX_DEV5_NUM_UEN_SALTILLO)) {
			uenName = GlobalVariablesSPX.SPX_DEV5_NOM_UEN_SALTILLO;
		} else if (uenNumber.equals(GlobalVariablesSPX.SPX_DEV5_NUM_UEN_GUANAJUATO)) {
			uenName = GlobalVariablesSPX.SPX_DEV5_NOM_UEN_GUANAJUATO;
		} else if (uenNumber.equals(GlobalVariablesSPX.SPX_DEV5_NUM_UEN_APODACA)) {
			uenName = GlobalVariablesSPX.SPX_DEV5_NOM_UEN_APODACA;
		} else if (uenNumber.equals(GlobalVariablesSPX.SPX_DEV5_NUM_UEN_ARGENTINA)) {
			uenName = GlobalVariablesSPX.SPX_DEV5_NOM_UEN_ARGENTINA;
		} else if (uenNumber.equals(GlobalVariablesSPX.SPX_DEV5_NUM_UEN_OWENSBORO)) {
			uenName = GlobalVariablesSPX.SPX_DEV5_NOM_UEN_OWENSBORO;
		} else if (uenNumber.equals(GlobalVariablesSPX.SPX_DEV5_NUM_UEN_NOVI)) {
			uenName = GlobalVariablesSPX.SPX_DEV5_NOM_UEN_NOVI;
		} else if (uenNumber.equals(GlobalVariablesSPX.SPX_DEV5_NUM_UEN_ROANOKE)) {
			uenName = GlobalVariablesSPX.SPX_DEV5_NOM_UEN_ROANOKE;
		} else if (uenNumber.equals(GlobalVariablesSPX.SPX_DEV5_NUM_UEN_ELIZABETHTOWN)) {
			uenName = GlobalVariablesSPX.SPX_DEV5_NOM_UEN_ELIZABETHTOWN;
		}
		return uenName;
	}

	/*
	 * @name: requiredFields
	 * 
	 * @date: 02/Nov/2023
	 * 
	 * @param: By locator
	 * 
	 * @return: void
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description:
	 * 
	 * Este método valida que un campo obligatorio:
	 * 
	 * 1. Exista en el DOM. 2. Sea visible. 3. Contenga información válida.
	 * 
	 * Compatible con:
	 * 
	 * - Inputs - Textareas - Labels - Spans - PrimeFaces SelectOneMenu - Dropdowns
	 * dinámicos
	 * 
	 * El método detecta automáticamente el tipo de componente y obtiene el valor
	 * correctamente:
	 * 
	 * - Inputs/Textarea -> atributo "value" - Labels/Dropdowns -> texto visible
	 * 
	 * Si el campo está vacío o sin selección válida:
	 * 
	 * - Registra evidencia - Muestra el nombre del elemento - Lanza
	 * RuntimeException
	 * 
	 * Esto detiene el flujo de la prueba automáticamente.
	 */
	public void requiredFields(By locator) {

		try {
			reporterLog("Validate Required Field...");

			// =========================================================
			// VALIDAR EXISTENCIA EN DOM
			// =========================================================
			if (!isElementPresent(locator)) {
				reporterLog("[INFO] Element NOT present in DOM: " + locator);
				return;
			}

			// =========================================================
			// VALIDAR VISIBILIDAD
			// =========================================================
			if (!elementExistsAndVisible(locator)) {
				reporterLog("[INFO] Element present but NOT visible: " + locator);
				return;
			}

			// =========================================================
			// OBTENER ELEMENTO
			// =========================================================
			WebElement element = getElement(locator);

			// =========================================================
			// OBTENER INFORMACIÓN DEL ELEMENTO
			// =========================================================
			String tagName = element.getTagName().toLowerCase();
			String className = element.getAttribute("class");
			if (className == null) {
				className = "";
			}
			String value = "";

			// =========================================================
			// INPUTS / TEXTAREAS
			// =========================================================
			if (tagName.equals("input") || tagName.equals("textarea")) {
				value = element.getAttribute("value");
			}

			// =========================================================
			// LABELS / SPANS / DROPDOWNS PRIMEFACES
			// =========================================================
			else {
				value = element.getText();
			}

			// =========================================================
			// NORMALIZAR VALOR
			// =========================================================
			if (value == null) {
				value = "";
			}
			value = value.trim();

			// =========================================================
			// VALIDAR CAMPOS VACÍOS
			// =========================================================
			if (value.isEmpty()) {
				logFrameworkErrorSimple("> Required field is EMPTY: " + locator);
				displayElementName(driver, locator);
				reporterLog("[ERROR] Required field is empty: " + locator);
				throw new RuntimeException("Required field is empty: " + locator);
			}

			// =========================================================
			// VALIDAR DROPDOWNS SIN SELECCIÓN
			// =========================================================
			boolean isPrimefacesDropdown = className.contains("ui-selectonemenu-label") || tagName.equals("label")
					|| tagName.equals("span");
			if (isPrimefacesDropdown && isDropdownWithoutSelection(locator)) {
				logFrameworkErrorSimple("> Dropdown has NO valid selection: " + locator);
				displayElementName(driver, locator);
				reporterLog("[ERROR] Dropdown without valid selection: " + locator);
				throw new RuntimeException("Dropdown without valid selection: " + locator);
			}

			// =========================================================
			// VALIDACIÓN EXITOSA
			// =========================================================
			reporterLog("[SUCCESS] Required field contains information");
		} catch (TimeoutException e) {
			logFrameworkError("> Timeout validating required field: " + locator, e);
			reporterLog("[ERROR] Timeout validating required field");
			throw e;
		} catch (RuntimeException e) {

			// =========================================================
			// RE-LANZAR ERRORES CONTROLADOS
			// =========================================================
			throw e;
		} catch (Exception e) {
			logFrameworkError("> Unexpected error validating required field", e);
			reporterLog("[ERROR] Unexpected error validating required field");
			throw new RuntimeException("Unexpected error validating required field: " + locator, e);
		}
	}

	/*
	 * @name: saveWordDocument
	 * 
	 * @date: 02/Nov/2023
	 * 
	 * @param: Map<String, String> word
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permita guardar en un documento de word una captura
	 * de pantalla
	 */
	public void saveWordDocument(TreeMap<String, TreeMap<String, String>> word, List<String> steps,
			List<String> values) {
		// Save screenshot in Word document
		XWPFDocument document = new XWPFDocument();
		XWPFParagraph paragraph = document.createParagraph();
		XWPFRun run = paragraph.createRun();
		String testCaseName = getTestCaseName(Reporter.getCurrentTestResult());
		run.setBold(true);
		run.setFontSize(14);
		run.setText("Test Case: " + testCaseName);
		int count = 0;
		FileInputStream in;
		File image;

		try {

			Iterator<String> itr = word.keySet().iterator();

			while (itr.hasNext()) {
				// Add steps and values
				paragraph = document.createParagraph();
				run = paragraph.createRun();
				run.setBold(true);
				run.setFontSize(12);
				run.setText(steps.get(count) + ": " + values.get(count));
				String key = itr.next();
				TreeMap<String, String> value = word.get(key);

				Iterator<String> itrAux = value.keySet().iterator();

				while (itrAux.hasNext()) {

					String keyAux = itrAux.next();
					String valueAux = value.get(keyAux);
					image = new File(valueAux);
					in = new FileInputStream(image);
					int imageType = XWPFDocument.PICTURE_TYPE_JPEG;
					String imageFileName = keyAux;
					int width = 450;
					int height = 400;

					// add picture
					paragraph = document.createParagraph();
					run = paragraph.createRun();
					run.addPicture(in, imageType, imageFileName, Units.toEMU(width), Units.toEMU(height));

					// add text below the picture
					run.setItalic(true);
					run.setFontSize(8);
					run.setText("Image file-name: " + imageFileName);
					paragraph = document.createParagraph();
					run = paragraph.createRun();

					// add page break
					paragraph = document.createParagraph();
					run = paragraph.createRun();
					run.addBreak(BreakType.PAGE);
				}
				count++;
			}

			FileOutputStream out = new FileOutputStream(GlobalVariablesSPX.SPX_DEV5_PATH_SCREENSHOTS + "Test Case-"
					+ testCaseName + "-" + date() + ".docx");

			document.write(out);
			out.close();
			document.close();

		} catch (Exception e) {
			logFrameworkError("> I could not save Word Document... ", e);
		}
	}

	/*
	 * @name: takeScreenshot
	 * 
	 * @date: 27/May/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: TreeMap<String, String>
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este método permite tomar una captura de pantalla utilizando la
	 * librería AShot y almacenarla:
	 * 
	 * - físicamente en disco (.png) - lógicamente en un TreeMap
	 * 
	 * El TreeMap almacena: key -> nombre imagen value -> ruta imagen
	 * 
	 * Beneficios: - Evidencia automática de ejecución - Integración con Word/PDF -
	 * Soporte para reportes QA
	 */

	public TreeMap<String, String> takeScreenshot() {
		try {
			Screenshot screenshot = new AShot().takeScreenshot(driver);

			/*
			 * Obtiene nombre actual del testcase.
			 */
			String testCaseName = getTestCaseName(Reporter.getCurrentTestResult());

			/*
			 * Genera nombre único para evitar: - overwrite - colisiones - duplicados
			 */
			String uniqueId = String.valueOf(System.currentTimeMillis());
			String fileName = "QC_Testing-" + testCaseName + "-" + uniqueId;
			String pathFileName = GlobalVariablesSPX.SPX_DEV5_PATH_SCREENSHOTS + fileName + ".png";
			ImageIO.write(screenshot.getImage(), "PNG", new File(pathFileName));
			listaScreenShots.put(fileName, pathFileName);
			reporterLog("Screenshot captured successfully: " + fileName);
		} catch (Exception e) {
			logFrameworkError("> I could not take the screenshot...", e);
			e.printStackTrace();
		}
		return listaScreenShots;
	}

	/*
	 * @name: clearScreenshotList
	 * 
	 * @date: 27/May/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: void
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este método permite limpiar la colección de screenshots
	 * almacenados en memoria durante la ejecución del testcase.
	 * 
	 * Recomendado usar: - Antes de iniciar un nuevo Test Case. - Después de generar
	 * evidencias Word/PDF. - Para liberar memoria.
	 * 
	 * Beneficios: - Evita acumulación innecesaria de imágenes. - Reduce consumo de
	 * memoria. - Evita mezclar screenshots entre testcases.
	 */

	public void clearScreenshotList() {
		try {

			/*
			 * Limpia completamente el TreeMap donde se almacenan:
			 * 
			 * key -> nombre imagen value -> ruta imagen
			 */
			listaScreenShots.clear();
			reporterLog("Screenshot list cleared successfully.");
		} catch (Exception e) {
			logFrameworkError("> Unable to clear screenshot list.", e);
			e.printStackTrace();
		}
	}

	/*
	 * @name: displayElementName
	 * 
	 * @date: 03/Nov/2023
	 * 
	 * @param: WebDriver driver, By locator
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite mostrar el nombre de un elemento
	 */
	public static void displayElementName(WebDriver driver, By locator) {
		try {
			WebElement element = driver.findElement(locator);
			String elementName = element.getAttribute("name");

			if (elementName != null && !elementName.isEmpty()) {
				System.out.println("Element Name: " + elementName);
			} else {
				System.out.println("***** ERROR *****");
				System.out.println("> Element: " + locator + " does not have a name attribute.");
			}
		} catch (org.openqa.selenium.NoSuchElementException e) {
			System.out.println("***** ERROR *****");
			System.out.println("> Element: " + locator + " not found. ");
			System.out.println("> Because: " + e.getMessage());
		}
	}

	/*
	 * @name: generateRandomId
	 * 
	 * @date: 06/Nov/2023
	 * 
	 * @param:N/A
	 * 
	 * @return:randomId
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite generar un ID Random
	 */
	public static String generateRandomId(int length) {
		// Genera un UUID y remueve guiones
		String randomId = UUID.randomUUID().toString().replace("-", "");

		// Si la longitud solicitada es mayor a 32, generamos UUID extra hasta completar
		while (randomId.length() < length) {
			randomId += UUID.randomUUID().toString().replace("-", "");
		}

		// Recorta exactamente a la longitud pedida
		return randomId.substring(0, length);
	}

	/*
	 * @name: scrollDown
	 * 
	 * @date: 07/Nov/2023
	 * 
	 * @param:int pixels
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Scroll down the webpage to a specified pixel position
	 */
	public void scrollDown(By locator) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement flag = getElement(locator);
			js.executeScript("arguments[0].scrollIntoView();", flag);
		} catch (Exception e) {
			logFrameworkError("> No realice Scroll. ", e);
		}
	}

	/*
	 * @name: scrollUp
	 * 
	 * @date: 07/Nov/2023
	 * 
	 * @param:int pixels
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Scroll down the webpage to a specified locator
	 */
	public void scrollUp(By locator) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebElement flag = getElement(locator);
			js.executeScript("arguments[0].scrollIntoView(true);", flag);
		} catch (Exception e) {
			logFrameworkError("> No realice Scroll. ", e);
		}
	}

	/*
	 * @name: getTestCaseName
	 * 
	 * @date: 21/Nov/2023
	 * 
	 * @param: ITestResult result
	 * 
	 * @return: methodName
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Metodo que permite obtener el nombre de un caso de prueba
	 */
	public String getTestCaseName(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		return methodName;
	}

	/*
	 * @name: driverClose
	 * 
	 * @date: 22/Nov/2023
	 * 
	 * @param:N/A
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Metodo que permite cerrar la ventana
	 */
	public void driverClose() {

		if (driver != null) {

			driver.quit();
		}
	}

	/*
	 * @name: isElementContainingText
	 * 
	 * @date: 28/May/2026
	 * 
	 * @param: By locator
	 * 
	 * @return: boolean
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Metodo que permite validar si un input, textarea o elemento
	 * contiene información.
	 */
	public boolean isElementContainingText(By locator) {
		try {

			WebElement element = getElement(locator);

			String tagName = element.getTagName();

			String elementText = "";

			// VALIDACIÓN PARA INPUTS Y TEXTAREA
			if (tagName.equalsIgnoreCase("input") || tagName.equalsIgnoreCase("textarea")) {

				elementText = element.getAttribute("value");

			} else {

				elementText = element.getText();
			}

			return elementText != null && !elementText.trim().isEmpty();

		} catch (Exception e) {

			logFrameworkErrorSimple("> El elemento no se encontró o ocurrió un error: ");

			return false;
		}
	}

	/*
	 * @name: isElementDisabled
	 * 
	 * @date: 27/Abr/2026
	 * 
	 * @param: By locator
	 * 
	 * @return: boolean
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este método permite validar si un elemento está deshabilitado
	 * considerando múltiples condiciones: atributo HTML 'disabled', propiedad
	 * Selenium 'isEnabled()' y clase CSS 'ui-state-disabled' utilizada por
	 * PrimeFaces.
	 */
	public boolean isElementDisabled(By locator) {
		try {

			// 🔹 Espera a que el elemento exista en el DOM (no necesariamente visible o
			// clickable aún)
			WebElement element = new WebDriverWait(driver, Duration.ofSeconds(15))
					.until(ExpectedConditions.presenceOfElementLocated(locator));

			// 🔹 Obtiene el atributo "class" del elemento (útil para detectar estados
			// visuales como disabled en PrimeFaces)
			String classAttr = element.getAttribute("class");

			// 🔹 Obtiene el atributo "disabled" del HTML (si existe, el elemento está
			// deshabilitado)
			String disabledAttr = element.getAttribute("disabled");

			// 🔹 Validación 1: PrimeFaces usa la clase 'ui-state-disabled' para indicar que
			// está deshabilitado
			boolean isDisabledByClass = classAttr != null && classAttr.contains("ui-state-disabled");

			// 🔹 Validación 2: Si el atributo 'disabled' existe en el HTML, el elemento
			// está deshabilitado
			boolean isDisabledByAttr = disabledAttr != null;

			// 🔹 Validación 3: Selenium indica si el elemento está habilitado o no
			// (fallback general)
			boolean isDisabledBySelenium = !element.isEnabled();

			// 🔹 Resultado final: si cualquiera de las condiciones indica deshabilitado, se
			// considera como tal
			boolean isDisabled = isDisabledByClass || isDisabledByAttr || isDisabledBySelenium;

			// 🔹 Log para debugging: muestra el estado final del elemento
			reporterLog("Validando estado del elemento: " + locator + " | disabled=" + isDisabled);

			// 🔹 Evidencia visual para debugging o reportes
			takeScreenshot();

			// 🔹 Retorna true si está deshabilitado, false si está habilitado
			return isDisabled;

		} catch (Exception e) {

			// 🔹 Identificación de la clase donde ocurrió el error
			logFrameworkError("> No se pudo validar el estado del elemento: %s. Error: %s" + locator, e);

			// 🔹 Construcción de mensaje de error detallado
			String errorMessage = String.format("> No se pudo validar el estado del elemento: %s. Error: %s", locator,
					e.getMessage());

			// 🔹 Impresión en consola
			System.out.println(errorMessage);

			// 🔹 Registro en logs del framework
			reporterLog(errorMessage);

			// 🔥 Decisión importante:
			// Si ocurre un error (elemento no encontrado, timeout, etc.),
			// se asume como DESHABILITADO para evitar falsos positivos en la automatización
			return true;
		}
	}

	/*
	 * @name: selectPrimefacesOption
	 * 
	 * @date: 21/Nov/2025
	 * 
	 * @param: By lblDropdown -> Elemento que abre el listado de opciones
	 * 
	 * @param: By panel -> Panel flotante del Primefaces SelectOneMenu
	 * 
	 * @param: By... options -> Opciones posibles que se intentar�n seleccionar (en
	 * orden)
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando
	 * 
	 * @description: Este m�todo abre un dropdown de PrimeFaces y selecciona la
	 * primera opci�n disponible entre las enviadas, validando visibilidad,
	 * presencia y manejando errores controlados.
	 */
	public void selectPrimefacesOption(By lblDropdown, By panel, By... options) {
		try {
			reporterLog("Select Primefaces Option...");

			// 1. Click en el label para abrir el dropdown
			click(lblDropdown);

			// 2. Esperar el panel visible
			waitForElementVisible(panel, 30);

			// 3. Buscar la primera opci�n disponible
			for (By option : options) {

				if (isElementPresent(option)) {

					waitForElementVisible(option, 30);
					click(option);

					reporterLog("Opci�n seleccionada: " + option.toString());
					return; // Selecci�n exitosa
				}
			}

			// Si lleg� aqu�, no encontr� ninguna opci�n
			logFrameworkErrorSimple("> Ninguna de las opciones enviadas existe en el dropdown.");

		} catch (TimeoutException te) {
			logFrameworkError("> No fue posible encontrar el panel o las opciones del dropdown.", te);
			te.printStackTrace();

		} catch (Exception e) {
			logFrameworkError("> Ocurrió un error inesperado en selectPrimefacesOption.", e);
			e.printStackTrace();
		}
	}

	/*
	 * @name: isElementPresent
	 * 
	 * @date: 27/May/2026
	 * 
	 * @param: By locator
	 * 
	 * @return: boolean
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Método que permite validar si un elemento existe dentro del DOM
	 * sin lanzar excepciones.
	 * 
	 * IMPORTANTE:
	 * 
	 * - NO utiliza Explicit Wait. - NO utiliza Implicit Wait. - La validación es
	 * inmediata.
	 * 
	 * Este método es ideal para:
	 * 
	 * - Validaciones rápidas - Elementos opcionales - Dropdowns dinámicos -
	 * Mensajes condicionales - Componentes PrimeFaces
	 * 
	 * Funcionamiento:
	 * 
	 * findElements() devuelve:
	 * 
	 * - Lista vacía -> elemento NO existe - Lista con elementos -> elemento existe
	 * 
	 * A diferencia de findElement():
	 * 
	 * - NO lanza NoSuchElementException - Es más estable - Más rápido para
	 * validaciones
	 */
	public boolean isElementPresent(By locator) {
		try {
			List<WebElement> elements = driver.findElements(locator);
			return !elements.isEmpty();
		} catch (Exception e) {
			logFrameworkError("El elemento no se encontró presente...", e);
			return false;
		}
	}

	/*
	 * @name: waitForElementClickable
	 * 
	 * @date: 27/May/2026
	 * 
	 * @param: By locator
	 * 
	 * @return: WebElement
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Método robusto que espera hasta que un elemento:
	 * 
	 * 1. Exista en el DOM. 2. Sea visible. 3. Sea clickeable. 4. No esté bloqueado
	 * por PrimeFaces BlockUI.
	 * 
	 * Incluye: - Reintentos automáticos. - Manejo de
	 * StaleElementReferenceException. - Soporte para páginas dinámicas AJAX. -
	 * Logging para debugging.
	 */
	public WebElement waitForElementClickable(By locator) {
		int attempts = 0;
		while (attempts < 3) {
			try {

				/*
				 * Espera a que desaparezca cualquier overlay de PrimeFaces o carga AJAX.
				 */
				waitForBlockUIToDisappear();

				/*
				 * Espera explícita para elemento clickeable.
				 */
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
				reporterLog("Waiting for clickable element: " + locator);

				/*
				 * Selenium valida: - visible - enabled - interactuable
				 */
				WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

				/*
				 * Scroll automático al elemento. Muy útil en PrimeFaces.
				 */
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block:'center'});", element);

				/*
				 * Validación adicional: evitar elementos ocultos por render dinámico.
				 */
				if (!element.isDisplayed()) {
					reporterLog("[WARNING] Element found but not visible yet.");
					attempts++;
					continue;
				}
				reporterLog("[SUCCESS] Element clickable: " + locator);
				return element;
			} catch (StaleElementReferenceException e) {

				/*
				 * Ocurre cuando PrimeFaces reconstruye parcialmente el DOM vía AJAX.
				 */
				attempts++;
				reporterLog("[WARNING] Stale element detected. Retry: " + attempts);
				logFrameworkError("[WARNING] Stale element detected. Retry: ", e);
			} catch (TimeoutException e) {
				logFrameworkError("> Element was not clickable: " + locator, e);
				reporterLog("[ERROR] Timeout waiting clickable element.");
				throw e;
			}
		}

		/*
		 * Si después de varios intentos no fue posible obtener el elemento.
		 */
		throw new RuntimeException("Unable to obtain clickable element after retries: " + locator);
	}

	/*
	 * @name: scrollIntoDropdownAndClick
	 *
	 * @date: 08/Jun/2026
	 *
	 * @param: containerLocator - By del contenedor con scroll interno itemLocator -
	 * By del <li> a seleccionar dentro del contenedor
	 *
	 * @return: void
	 *
	 * @author: Fernando Villalba Aguilar
	 *
	 * @description: Resuelve el problema de dropdowns PrimeFaces (ui-selectonemenu)
	 * donde el elemento destino está fuera del viewport interno del contenedor.
	 *
	 * El problema raíz: - scrollIntoView() hace scroll de la PÁGINA, no del
	 * contenedor interno. - waitForElementClickable() falla porque el <li> nunca es
	 * visible dentro del contenedor aunque exista en el DOM.
	 *
	 * Solución: 1. Espera que el contenedor sea visible (dropdown abierto). 2.
	 * Localiza el <li> via presenceOfElementLocated (no visibilityOf). 3. Hace
	 * scroll INTERNO del contenedor hasta el <li> usando JS. 4. Ejecuta JS click
	 * directo — evita re-validación de clickability que volvería a fallar por el
	 * mismo problema de viewport.
	 *
	 * Uso típico: PrimeFaces SelectOneMenu con listas largas donde la opción
	 * deseada queda fuera del área visible del dropdown.
	 */
	public void scrollIntoDropdownAndClick(By containerLocator, By itemLocator) {
		try {
			reporterLog("scrollIntoDropdownAndClick -> container: " + containerLocator);
			reporterLog("scrollIntoDropdownAndClick -> item: " + itemLocator);

			JavascriptExecutor js = (JavascriptExecutor) driver;
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

			// 1. Esperar que el contenedor del dropdown esté visible (panel abierto)
			WebElement container = wait.until(ExpectedConditions.visibilityOfElementLocated(containerLocator));
			reporterLog("[SUCCESS] Contenedor del dropdown visible.");

			// 2. Localizar el <li> por presencia en DOM — NO por visibilidad,
			// ya que puede estar fuera del viewport interno del contenedor.
			WebElement item = wait.until(ExpectedConditions.presenceOfElementLocated(itemLocator));
			reporterLog("[SUCCESS] Item localizado en DOM: " + itemLocator);

			// 3. Scroll INTERNO: desplaza el contenedor hasta que el <li> sea visible
			// scrollTop del contenedor = offsetTop del item relativo al contenedor.
			// Esto mueve el scroll del contenedor, NO el de la página.
			js.executeScript("arguments[0].scrollTop = arguments[1].offsetTop;", container, item);
			reporterLog("[SUCCESS] Scroll interno ejecutado sobre el contenedor.");

			// 4. Pequeña pausa para que PrimeFaces estabilice el render tras el scroll
			// No usar Thread.sleep — usar wait explícito sobre visibilidad del item
			wait.until(ExpectedConditions.visibilityOf(item));
			reporterLog("[SUCCESS] Item visible tras scroll interno.");

			// 5. JS click directo — evita que waitForElementClickable vuelva a
			// ejecutar scrollIntoView sobre la página y pierda el scroll interno
			js.executeScript("arguments[0].click();", item);
			reporterLog("[SUCCESS] JS click ejecutado sobre item: " + itemLocator);

			takeScreenshot();

		} catch (TimeoutException e) {
			logFrameworkError("> Timeout en scrollIntoDropdownAndClick. Item: " + itemLocator, e);
			throw e;
		} catch (Exception e) {
			logFrameworkError("> Error en scrollIntoDropdownAndClick. Item: " + itemLocator, e);
			throw new RuntimeException("scrollIntoDropdownAndClick failed for: " + itemLocator, e);
		}
	}

	/*
	 * @name: waitForBlockUIToDisappear
	 * 
	 * @date: 27/Abr/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este método permite esperar a que desaparezca el overlay de
	 * bloqueo (BlockUI) generado por PrimeFaces, asegurando que los elementos de la
	 * pantalla estén disponibles para interacción antes de ejecutar cualquier
	 * acción como click o escritura.
	 */
	By blockUI = By.cssSelector(".pe-blockui-content");

	public void waitForBlockUIToDisappear() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(blockUI));
	}

	/*
	 * @name: clickSupr
	 * 
	 * @date: 22/Nov/2023
	 * 
	 * @param:N/A
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Metodo que permite cerrar la ventana
	 */
	public void clickSupr(By locator) {
		try {
			WebElement element = getElement(locator);
			Actions actions = new Actions(driver);
			actions.moveToElement(element).sendKeys("\u007F").perform(); // \u007F es el c�digo de la tecla Supr
		} catch (Exception e) {
			logFrameworkError("> Element was not clickable: " + locator, e);
			e.printStackTrace();
		}
	}

	/*
	 * @name: logFrameworkError
	 * 
	 * @date: 28/May/2026
	 * 
	 * @param: String message, Exception e
	 * 
	 * @return: void
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Método centralizado para registrar errores críticos del
	 * framework de automatización.
	 * 
	 * Este método imprime información detallada del error ocurrido durante la
	 * ejecución de pruebas automatizadas, facilitando el análisis, debugging y
	 * trazabilidad de fallos.
	 * 
	 * Incluye:
	 * 
	 * 1. Clase donde ocurrió el error. 2. Método que originó la excepción. 3. Línea
	 * aproximada del fallo. 4. Mensaje personalizado del framework. 5. URL actual
	 * del navegador. 6. Título actual de la página. 7. Tipo de excepción
	 * Selenium/Java. 8. Detalle técnico del error. 9. Método y línea origen de la
	 * excepción.
	 * 
	 * Beneficios:
	 * 
	 * - Centralización de logs del framework. - Facilita debugging en Jenkins/Azure
	 * DevOps. - Ayuda en análisis de fallos automatizados. - Mejora trazabilidad de
	 * ejecución QA. - Compatible con Selenium y PrimeFaces. - Reduce tiempo de
	 * análisis de incidencias.
	 */
	public void logFrameworkError(String message, Exception e) {

		System.out.println("\n=================================================");

		try {

			/*
			 * Obtiene información del método que invocó el logger.
			 */
			StackTraceElement stackTrace = getCallerMethod();

			System.out.println("CLASS: " + this.getClass().getName());
			System.out.println("METHOD: " + stackTrace.getMethodName());
			System.out.println("LINE: " + stackTrace.getLineNumber());

		} catch (Exception stackException) {

			System.out.println("Unable to get method information.");
		}

		/*
		 * Mensaje personalizado enviado desde el framework.
		 */
		System.out.println("ERROR: " + message);

		try {

			/*
			 * Obtiene información actual del navegador.
			 */
			System.out.println("URL: " + driver.getCurrentUrl());
			System.out.println("TITLE: " + driver.getTitle());

		} catch (Exception driverException) {

			System.out.println("Unable to get URL/TITLE");
		}

		/*
		 * Información detallada de excepción.
		 */
		if (e != null) {

			System.out.println("CAUSE: " + e.getClass().getSimpleName());
			System.out.println("DETAIL: " + e.getMessage());

			/*
			 * Obtiene el punto exacto donde se originó la excepción.
			 */
			if (e.getStackTrace().length > 0) {

				StackTraceElement rootError = e.getStackTrace()[0];

				System.out.println("ERROR CLASS: " + rootError.getClassName());
				System.out.println("ERROR METHOD: " + rootError.getMethodName());
				System.out.println("ERROR LINE: " + rootError.getLineNumber());
			}
		}

		System.out.println("=================================================\n");
	}

	/*
	 * @name: logFrameworkErrorSimple
	 * 
	 * @date: 28/May/2026
	 * 
	 * @param: String message
	 * 
	 * @return: void
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Método centralizado para registrar mensajes de error simples
	 * dentro del framework de automatización.
	 * 
	 * Este método se utiliza principalmente para:
	 * 
	 * - Validaciones controladas. - Advertencias funcionales. - Mensajes de
	 * debugging. - Errores sin excepción Java/Selenium.
	 * 
	 * Incluye:
	 * 
	 * 1. Clase donde ocurrió el evento. 2. Método que ejecutó el logger. 3. Línea
	 * aproximada de ejecución. 4. Mensaje personalizado. 5. URL actual del
	 * navegador. 6. Título actual de la página.
	 * 
	 * Beneficios:
	 * 
	 * - Estandarización de logs QA. - Mejor trazabilidad de ejecución. - Soporte
	 * para debugging rápido. - Facilita análisis funcional. - Compatible con
	 * ambientes CI/CD.
	 */
	public void logFrameworkErrorSimple(String message) {

		System.out.println("\n=================================================");

		try {

			/*
			 * Obtiene información del método que invocó el logger.
			 */
			StackTraceElement stackTrace = getCallerMethod();

			System.out.println("CLASS: " + this.getClass().getName());
			System.out.println("METHOD: " + stackTrace.getMethodName());
			System.out.println("LINE: " + stackTrace.getLineNumber());

		} catch (Exception stackException) {

			System.out.println("Unable to get method information.");
		}

		/*
		 * Mensaje personalizado enviado desde el framework.
		 */
		System.out.println("ERROR: " + message);

		try {

			/*
			 * Obtiene información actual del navegador.
			 */
			System.out.println("URL: " + driver.getCurrentUrl());
			System.out.println("TITLE: " + driver.getTitle());

		} catch (Exception ex) {

			System.out.println("Unable to get URL/TITLE");
		}

		System.out.println("=================================================\n");
	}

	/*
	 * @name: jsClick
	 * 
	 * @date: 27/May/2026
	 * 
	 * @param: locator - By del elemento a hacer click mediante JavaScript
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Metodo que permite realizar click sobre un elemento utilizando
	 * JavaScriptExecutor. Es útil cuando el click tradicional de Selenium no
	 * funciona debido a overlays, elementos no interactuables o problemas de
	 * renderizado (ej. PrimeFaces / AJAX).
	 */
	public void jsClick(By locator) {
		try {
			WebElement el = getElement(locator);

			((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);

		} catch (Exception e) {
			logFrameworkError("> jsClick was not clickable: " + locator, e);
			e.printStackTrace();
		}
	}

	/**
	 * @name waitForTextInAnyError
	 *
	 * @description Espera rápida para validar si existe algún mensaje de error en
	 *              pantalla, sin depender de visibilidad ni de texto exacto.
	 *
	 *              Útil para validaciones multi-idioma (ES / EN / PT).
	 *
	 * @param locators Lista de posibles contenedores de error
	 * @param keywords Palabras clave a buscar dentro del error
	 * @return true si encuentra el mensaje esperado
	 *
	 * @author QA Automation
	 */
	public boolean waitForTextInAnyError(List<By> locators, String... keywords) {
		Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofMillis(200)).ignoring(Exception.class);
		return wait.until(d -> {
			for (By locator : locators) {
				List<WebElement> elements = d.findElements(locator);
				for (WebElement el : elements) {
					String text = el.getText().toLowerCase();
					for (String keyword : keywords) {
						if (text.contains(keyword.toLowerCase())) {
							return true;
						}
					}
				}
			}
			return false;
		});
	}

	/*
	 * @name: hasInputValue
	 * 
	 * @date: 28/May/2026
	 * 
	 * @param: By locator
	 * 
	 * @return: boolean
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description:
	 * 
	 * Este método valida si un elemento tipo input o textarea contiene información
	 * capturada.
	 * 
	 * La validación se realiza sobre el atributo:
	 * 
	 * - value
	 * 
	 * Retorna:
	 * 
	 * - true -> si contiene información válida - false -> si está vacío, no existe
	 * o ocurre un error
	 * 
	 * Compatible con:
	 * 
	 * - input - textarea - componentes PrimeFaces basados en input
	 * 
	 * Uso recomendado:
	 * 
	 * - Validaciones previas antes de capturar información - Evitar sobrescribir
	 * datos existentes - Validaciones rápidas de formularios
	 * 
	 * Ejemplo:
	 * 
	 * if (!hasInputValue(txtUserName)) { type(txtUserName, "Fernando"); }
	 */
	public boolean hasInputValue(By locator) {
		try {

			// =========================================================
			// VALIDAR EXISTENCIA EN DOM
			// =========================================================
			if (!isElementPresent(locator)) {
				logFrameworkErrorSimple("[INFO] Element NOT present in DOM: " + locator);
				return false;
			}

			// =========================================================
			// VALIDAR VISIBILIDAD
			// =========================================================
			if (!elementExistsAndVisible(locator)) {
				logFrameworkErrorSimple("[INFO] Element present but NOT visible: " + locator);
				return false;
			}

			// =========================================================
			// OBTENER ELEMENTO
			// =========================================================
			WebElement element = getElement(locator);

			// =========================================================
			// VALIDAR TIPO DE ELEMENTO
			// =========================================================
			String tagName = element.getTagName().toLowerCase();
			if (!tagName.equals("input") && !tagName.equals("textarea")) {
				logFrameworkErrorSimple("[WARNING] Element is not an input/textarea: " + locator);
				return false;
			}

			// =========================================================
			// OBTENER VALOR DEL INPUT
			// =========================================================
			String value = element.getAttribute("value");

			// =========================================================
			// VALIDAR VALOR
			// =========================================================
			return value != null && !value.trim().isEmpty();
		} catch (Exception e) {
			logFrameworkErrorSimple("[WARNING] Error validating input value: " + locator);
			return false;
		}
	}

	/*
	 * @name: isDropdownWithoutSelection
	 * 
	 * @date: 28/May/2026
	 * 
	 * @param: By locator
	 * 
	 * @return: boolean
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description:
	 * 
	 * Este método valida si un dropdown de PrimeFaces continúa mostrando un valor
	 * por defecto y aún NO tiene una selección válida.
	 * 
	 * Se utiliza principalmente para:
	 * 
	 * 1. Validaciones previas antes de capturar información. 2. Evitar
	 * re-seleccionar valores ya capturados. 3. Detectar placeholders multilenguaje.
	 * 4. Validaciones de campos obligatorios.
	 * 
	 * Ejemplos de valores default:
	 * 
	 * - "Seleccione" - "Select One" - "Selecione" - "Categorías" - "Categories" -
	 * "Familias" - "Subfamilias"
	 * 
	 * Compatible con:
	 * 
	 * - PrimeFaces SelectOneMenu - Labels - Spans - Dropdowns renderizados
	 * dinámicamente
	 */
	public boolean isDropdownWithoutSelection(By locator) {
		try {

			// =========================================================
			// VALIDAR EXISTENCIA
			// =========================================================
			if (!isElementPresent(locator)) {
				return true;
			}

			// =========================================================
			// OBTENER TEXTO ACTUAL DEL DROPDOWN
			// =========================================================
			String value = getText(locator).trim().toLowerCase();

			// =========================================================
			// VALIDAR TEXTO VACÍO
			// =========================================================
			if (value.isEmpty()) {
				return true;
			}

			// =========================================================
			// LISTA DE PLACEHOLDERS / VALORES DEFAULT
			// =========================================================
			Set<String> defaultValues = Set.of("subfamilias", "subfamilies", "subfamílias", "familias", "families",
					"famílias", "categorías", "categories", "categorias", "seleccione", "select one", "selecione",
					"seleccionar", "select", "selecionar");

			// =========================================================
			// VALIDAR SI EL TEXTO ES UN PLACEHOLDER
			// =========================================================
			return defaultValues.contains(value);
		} catch (Exception e) {
			logFrameworkErrorSimple("[WARNING] Error validating dropdown selection state: " + locator);
			return true;
		}
	}

	/*
	 * @name: exists
	 * 
	 * @date: 28/May/2026
	 * 
	 * @param: By locator
	 * 
	 * @return: boolean
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Método auxiliar utilizado para validar si un elemento existe
	 * actualmente dentro del DOM de la página.
	 * 
	 * La validación se realiza utilizando:
	 * 
	 * driver.findElements(locator)
	 * 
	 * evitando lanzar excepciones como:
	 * 
	 * - NoSuchElementException
	 * 
	 * Este enfoque permite realizar validaciones rápidas y seguras sobre elementos
	 * dinámicos en Selenium WebDriver.
	 * 
	 * Comportamiento:
	 * 
	 * 1. Busca todos los elementos que coincidan con el locator. 2. Evalúa si la
	 * colección retornada contiene elementos. 3. Retorna:
	 * 
	 * - true -> Si existe al menos un elemento. - false -> Si no existen
	 * coincidencias.
	 * 
	 * Beneficios:
	 * 
	 * - Validaciones rápidas de existencia. - Evita excepciones innecesarias. -
	 * Compatible con páginas dinámicas AJAX. - Facilita lógica condicional en
	 * automatización. - Mejora estabilidad del framework.
	 * 
	 * Uso común:
	 * 
	 * - Validar labels dinámicos. - Detectar mensajes de error. - Identificar
	 * elementos opcionales. - Flujos multi-idioma. - Validaciones previas antes de
	 * interactuar.
	 */
	public boolean exists(By locator) {

		return !driver.findElements(locator).isEmpty();
	}

	/*
	 * @name: getCallerMethod
	 * 
	 * @date: 28/May/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: StackTraceElement
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Método auxiliar utilizado para obtener información del método
	 * que invocó internamente al logger del framework.
	 * 
	 * Este método analiza el stacktrace actual del hilo de ejecución para
	 * identificar el origen real de la llamada.
	 * 
	 * El objetivo principal es mejorar la trazabilidad y debugging de errores
	 * durante la ejecución de pruebas automatizadas.
	 * 
	 * El método filtra automáticamente:
	 * 
	 * - Métodos internos del logger. - Métodos auxiliares del framework. - Clases
	 * internas del sistema Thread.
	 * 
	 * Información obtenida:
	 * 
	 * 1. Nombre de la clase. 2. Nombre del método. 3. Línea aproximada de
	 * ejecución.
	 * 
	 * Beneficios:
	 * 
	 * - Mayor precisión en logs QA. - Evita dependencias de índices fijos del
	 * stacktrace. - Compatible con múltiples niveles de llamadas. - Mejora análisis
	 * de errores en CI/CD. - Facilita debugging avanzado en Selenium. - Permite
	 * generar logs más profesionales.
	 * 
	 * Uso principal:
	 * 
	 * - logFrameworkError() - logFrameworkErrorSimple() - Framework logging
	 * utilities
	 */
	private StackTraceElement getCallerMethod() {

		/*
		 * Obtiene el stacktrace actual del hilo en ejecución.
		 */
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

		/*
		 * Recorre todos los elementos del stacktrace para identificar el método
		 * llamador real.
		 */
		for (StackTraceElement element : stackTrace) {

			/*
			 * Ignora métodos internos del framework y clases del sistema.
			 */
			if (!element.getMethodName().contains("logFrameworkError")
					&& !element.getMethodName().contains("getCallerMethod")
					&& !element.getClassName().equals(Thread.class.getName())) {

				return element;
			}
		}

		/*
		 * Retorna el último elemento disponible como fallback en caso de no encontrar
		 * coincidencias válidas.
		 */
		return stackTrace[stackTrace.length - 1];
	}

	public TreeMap<String, String> safeEvidence(By locator, String stepName) {
		TreeMap<String, String> map = new TreeMap<>();
		try {
			reporterLog("Evidence: " + stepName);
			map.putAll(returnSaveImage(locator));
		} catch (Exception e) {
			reporterLog("[WARNING] Evidence failed for: " + stepName);
		}
		return map;
	}

	/**
	 * @name: clickWithEvidence
	 *
	 * @date: 12/Jun/2026
	 *
	 * @param: By     locator
	 * @param: String businessAction
	 *
	 * @return: TreeMap<String,String>
	 *
	 * @author: Fernando Villalba Aguilar
	 *
	 * @description:
	 *
	 *               Método corporativo para ejecutar clics documentados.
	 *
	 *               Flujo QA:
	 *
	 *               1. Espera presencia del elemento. 2. Captura evidencia PREVIA.
	 *               3. Ejecuta click robusto. 4. Espera finalización AJAX
	 *               PrimeFaces. 5. Captura evidencia POSTERIOR.
	 *
	 *               Beneficios:
	 *
	 *               - Trazabilidad uniforme. - Evidencia antes/después. -
	 *               Reutilizable en todos los PageObjects. - Menor duplicidad.
	 */
	protected TreeMap<String, String> clickWithEvidence(By locator, String businessAction) throws InterruptedException {

		TreeMap<String, String> evidence = new TreeMap<>();

		reporterLog("[ACTION] " + businessAction);

		waitForElementPresent(locator);

		// Estado inicial
		evidence.putAll(safeEvidence(locator, businessAction + " - Before"));

		// Acción
		click(locator);

		// Sincronización
		waitForPrimefacesAjax();

//		// Estado final
//		evidence.putAll(safeEvidence(locator, businessAction + " - After"));

		reporterLog("[SUCCESS] " + businessAction);

		return evidence;
	}

	/*
	 * @name: typeWithEvidence
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: By locator, String value, String businessAction
	 * 
	 * @return: TreeMap<String, String>
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Ingresa texto en un campo objetivo registrando el flujo en la
	 * bitacora y recopilando captura de evidencia visual antes y despues de la
	 * interaccion.
	 */
	protected TreeMap<String, String> typeWithEvidence(By locator, String value, String businessAction) {

		TreeMap<String, String> evidence = new TreeMap<>();

		reporterLog("[ACTION] " + businessAction);

		waitForElementPresent(locator);

		evidence.putAll(safeEvidence(locator, businessAction + " - Before"));

		type(locator, value);

		evidence.putAll(safeEvidence(locator, businessAction + " - After"));

		reporterLog("[SUCCESS] " + businessAction);

		return evidence;
	}

	/*
	 * @name: uploadWithEvidence
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: String filePath, By uploadLocator, By validationLocator, String
	 * businessAction
	 * 
	 * @return: TreeMap<String, String>
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Realiza la carga de un archivo en el sistema recopilando
	 * evidencia previa, verificando la visibilidad del elemento de validacion
	 * posterior al envio y capturando evidencia del resultado exitoso.
	 */
	protected TreeMap<String, String> uploadWithEvidence(String filePath, By uploadLocator, By validationLocator,
			String businessAction) {

		TreeMap<String, String> evidence = new TreeMap<>();

		reporterLog("[ACTION] " + businessAction);

		evidence.putAll(safeEvidence(uploadLocator, businessAction + " - Before Upload"));

		uploadFile(filePath, uploadLocator);

		if (!elementExistsAndVisible(validationLocator)) {

			throw new RuntimeException(businessAction + " - Upload completed but validation element not found.");
		}

		evidence.putAll(safeEvidence(validationLocator, businessAction + " - After Upload"));

		reporterLog("[SUCCESS] " + businessAction);

		return evidence;
	}

	/*
	 * @name: clickJS
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: By locator
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Fuerza la ejecucion de un clic directo en el DOM mediante
	 * JavaScript utilizando un localizador By; util para omitir bloqueos por
	 * overlays o componentes nativos de PrimeFaces no interactuables directamente
	 * por Selenium.
	 */
	protected void clickJS(By locator) {

		WebElement element = driver.findElement(locator);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", element);
	}

	/*
	 * @name: clickJS
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: WebElement element
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Fuerza la ejecucion de un clic directo en el DOM mediante
	 * JavaScript sobre una instancia WebElement previamente localizada.
	 */
	protected void clickJS(WebElement element) {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", element);
	}

	/*
	 * @name: detectLanguage
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: WebDriver driver
	 * 
	 * @return: String
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Consulta el idioma configurado en el navegador o en la etiqueta
	 * HTML raiz mediante JavaScript y retorna el codigo estandarizado del idioma
	 * ("PT", "EN" o "ES").
	 */
	public static String detectLanguage(WebDriver driver) {
		String lang = (String) ((JavascriptExecutor) driver).executeScript(
				"return document.documentElement.lang || navigator.language || navigator.userLanguage || '';");

		lang = lang.toLowerCase();

		if (lang.startsWith("pt"))
			return "PT";
		if (lang.startsWith("en"))
			return "EN";
		return "ES";
	}

	/*
	 * @name: waitForAjaxAndBlockUiToFinish
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: N/A
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Sincroniza la ejecucion esperando la finalizacion de peticiones
	 * asincronas de PrimeFaces y la desaparicion de capas de bloqueo (blockUI);
	 * incluye monitoreo e impresion de metricas si el tiempo de espera excede el
	 * umbral de rendimiento aceptable.
	 */
	protected void waitForAjaxAndBlockUiToFinish() throws InterruptedException {
		long start = System.currentTimeMillis();
		waitForPrimefacesAjax();
		waitForBlockUIToDisappear();
		long elapsed = System.currentTimeMillis() - start;
		if (elapsed > 3000) {
			reporterLog("[PERF] waitForAjaxAndBlockUiToFinish tardo " + elapsed + "ms");
		}
	}

	/*
	 * @name: selectRandomPrimefacesOption
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: By label, By panel, By options, String fieldName
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Despliega un componente desplegable de PrimeFaces, omite la
	 * opcion inicial por defecto, selecciona una de las opciones validas restantes
	 * al azar de forma dinamica y reporta la seleccion realizada.
	 */
	public void selectRandomPrimefacesOption(By label, By panel, By options, String fieldName) {
		click(label);
		WebElement panelElement = waitForVisibility(panel);
		waitForPrimefacesAjax();

		List<WebElement> optionElements = driver.findElements(options);
		List<String> optionLabels = new ArrayList<>();

		// Comenzamos en i = 1 para omitir la primera opción (default)
		for (int i = 1; i < optionElements.size(); i++) {
			optionLabels.add(optionElements.get(i).getAttribute("data-label"));
		}

		// Validación por si la lista solo tenía la opción por defecto
		if (optionLabels.isEmpty()) {
			throw new RuntimeException("No hay opciones válidas para seleccionar en: " + fieldName);
		}

		String randomLabel = optionLabels.get(new Random().nextInt(optionLabels.size()));

		String panelId = panelElement.getAttribute("id");
		By optSelected = By.xpath("//div[@id='" + panelId + "']//li[@data-label='" + randomLabel + "']");
		WebElement optionToClick = driver.findElement(optSelected);
		scrollIntoView(optionToClick);
		optionToClick.click();

		reporterLog(fieldName + " seleccionado aleatoriamente: " + randomLabel);
	}

	/*
	 * @name: waitForVisibility
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: By locator
	 * 
	 * @return: WebElement
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Aplica una espera explicita de hasta 20 segundos hasta que el
	 * elemento especificado por el localizador sea plenamente visible e
	 * interactuable en el DOM.
	 */
	public WebElement waitForVisibility(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	/*
	 * @name: scrollIntoView
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: WebElement element
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Desplaza la vista de la ventana del navegador mediante
	 * JavaScript para centrar el elemento objetivo dentro del viewport.
	 */
	public void scrollIntoView(WebElement element) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
	}

	/*
	 * @name: randomNumberWithDigits
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: int minDigits, int maxDigits
	 * 
	 * @return: int
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Genera un numero entero aleatorio cuyo total de digitos se
	 * encuentra delimitado dentro de un rango especifico (minimo y maximo de
	 * digitos).
	 */
	private static int randomNumberWithDigits(int minDigits, int maxDigits) {
		int digits = minDigits + RANDOM.nextInt(maxDigits - minDigits + 1);
		int min = (digits == 1) ? 0 : (int) Math.pow(10, digits - 1);
		int max = (int) Math.pow(10, digits) - 1;
		return min + RANDOM.nextInt(max - min + 1);
	}
}