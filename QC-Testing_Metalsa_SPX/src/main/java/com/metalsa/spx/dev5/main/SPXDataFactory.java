package com.metalsa.spx.dev5.main;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * ====================================================================================
 * Class Name: SPXDataFactory
 * ====================================================================================
 *
 * @author Fernando Villalba Aguilar
 * @date 28/Ago/2026
 *
 * @description Clase encargada de la generación de datos de prueba aleatorios
 *              (data factory) para el framework de automatización SPX.
 *
 *              Esta clase centraliza: - Selección aleatoria de valores desde
 *              catálogos definidos en GlobalVariablesSPX. - Generación de
 *              cadenas dinámicas (códigos, referencias, IDs, part numbers,
 *              etc). - Generación de valores numéricos aleatorios con rangos y
 *              formatos controlados.
 *
 *              Objetivo: Aislar la lógica de generación de datos de prueba del
 *              resto del framework (WebDriver, sincronización, evidencias,
 *              etc), permitiendo su reutilización en cualquier Page Object sin
 *              necesidad de heredar de SPXBase.
 *
 *              Compatibilidad: - Selenium 4+ - Frameworks Page Object Model
 *              (POM) - TestNG
 *              ====================================================================================
 */
public class SPXDataFactory {

	// =========================================================================
	// Random Generators
	// =========================================================================

	/**
	 * Generador aleatorio utilizado para selección de datos dinámicos durante la
	 * ejecución de pruebas automatizadas.
	 */
	private static final Random RANDOM = new Random();

	/**
	 * Almacena el último valor mínimo sugerido generado, con el fin de garantizar
	 * consistencia matemática al generar posteriormente el valor máximo sugerido
	 * (randomSuggestedMax debe ser siempre mayor a randomSuggestedMin).
	 */
	private static int lastSuggestedMin = 0;

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

	// =========================================================================
	// Random Test Data Methods (Catalogos Globales)
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
	// Random Test Data Methods (Cadenas Dinamicas Compuestas)
	// =========================================================================

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

	// =========================================================================
	// Random Test Data Methods (Valores Numericos con Digitos Controlados)
	// =========================================================================

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
	 * 
	 * IMPORTANTE: Debe invocarse siempre despues de randomSuggestedMin(), ya que
	 * depende del estado interno (lastSuggestedMin) generado por dicho metodo.
	 */
	public static String randomSuggestedMax() {
		int max = lastSuggestedMin + 1 + RANDOM.nextInt(999 - lastSuggestedMin);
		return String.valueOf(max);
	}

	// =========================================================================
	// Random Identifiers
	// =========================================================================

	/*
	 * @name: generateRandomId
	 * 
	 * @date: 28/Ago/2026
	 * 
	 * @param: int length
	 * 
	 * @return: String
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite generar un ID Random a partir de UUIDs
	 * concatenados (sin guiones), recortado a la longitud exacta solicitada.
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
}