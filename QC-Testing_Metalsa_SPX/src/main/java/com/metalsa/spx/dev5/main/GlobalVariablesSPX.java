package com.metalsa.spx.dev5.main;

/**
 * ====================================================================================
 * Class Name: GlobalVariablesSPX
 * ====================================================================================
 *
 * @author Fernando Villalba Aguilar
 * @date 09/Jun/2026
 *
 * @description Clase de configuración global del framework de automatización
 *              SPX.
 *
 *              Centraliza: - URLs de ambientes (TEST / DEV5). - Timeouts del
 *              framework. - Rutas de archivos y recursos. - Catálogos de datos
 *              de prueba aleatorios. - XPath dinámicos reutilizables. -
 *              Constantes de configuración por módulo.
 *
 *              Compatibilidad: - Selenium 4+ - PrimeFaces / JSF - TestNG -
 *              Jenkins / Azure DevOps
 *              ====================================================================================
 */
public class GlobalVariablesSPX {

	// =========================================================================
	// ENVIRONMENT — URLs
	// =========================================================================

	/** URL del ambiente de pruebas TEST. */
	public static final String SPX_DEV5_URL_TEST = "http://gpmtest2-app6:9103/SPX/";

	/** URL del ambiente de desarrollo DEV5. */
	public static final String SPX_DEV5_URL_DEV5 = "http://gpmtest2-app6:9203/SPX/";

	/** URL activa utilizada en la ejecución actual. Cambiar según ambiente. */
	public static final String SPX_DEV5_URL = SPX_DEV5_URL_TEST;

	// =========================================================================
	// TIMEOUTS
	// =========================================================================

	/**
	 * Timeout por defecto para WebDriverWait. Usado en:
	 * Duration.ofSeconds(DEFAULT_TIMEOUT) Unidad: SEGUNDOS Valor: 20s — razonable
	 * para AJAX PrimeFaces en red corporativa.
	 */
	public static final int DEFAULT_TIMEOUT = 70;

	/**
	 * Timeout corto para pausas generales de estabilización. Usado en:
	 * Thread.sleep(SHORT_TIMEOUT) Unidad: MILISEGUNDOS Valor: 2000ms — 2 segundos
	 * de pausa entre acciones.
	 */
	public static final int SHORT_TIMEOUT = 2000;

	/**
	 * Timeout para espera post-upload de archivos en PrimeFaces. Usado en:
	 * Thread.sleep(UPLOAD_TIMEOUT) Unidad: MILISEGUNDOS Valor: 10000ms — necesario
	 * para procesamiento del servidor PrimeFaces.
	 */
	public static final int UPLOAD_TIMEOUT = 10000;

	/**
	 * Timeout de estabilización inmediata después de sendKeys en upload. Usado en:
	 * Thread.sleep(UPLOAD_STABILIZATION) dentro de uploadFile(). Unidad:
	 * MILISEGUNDOS Valor: 300ms — pausa mínima para que PrimeFaces registre el
	 * archivo.
	 */
	public static final int UPLOAD_STABILIZATION = 300;

	/**
	 * Delay entre teclas para disparar el AutoComplete de PrimeFaces. Usado en:
	 * Thread.sleep(AUTOCOMPLETE_KEY_DELAY) en loops char-by-char. Unidad:
	 * MILISEGUNDOS Valor: 50ms — mínimo necesario para trigger de eventos JS en
	 * PrimeFaces.
	 */
	public static final int AUTOCOMPLETE_KEY_DELAY = 50;

	// =========================================================================
	// PATHS — Archivos y Recursos
	// =========================================================================

	/** Ruta base para almacenamiento de screenshots de evidencia. */
	public static final String SPX_DEV5_PATH_SCREENSHOTS = System.getProperty("user.dir") + "/test-output/screenshots/";

	/** Ruta base para archivos JSON de datos de prueba. */
	public static final String PATH_JSON_DATA = "./src/test/resources/testDataSPX/json/";

	/** Ruta del archivo de prueba para uploads. */
	public static final String SPX_DEV5_PATH_FILES = "C:\\Users\\fernando.villalba\\Documents\\files\\DocumentoDePrueba.txt";

	/** Tipo de imagen PNG para reportes Word. */
	public static final int PICTURE_TYPE_PNG = 6;

	// =========================================================================
	// UEN — Unidades de Negocio
	// =========================================================================

	public static final String SPX_DEV5_NUM_UEN_SAN_ANTONIO = "300000871351191";
	public static final String SPX_DEV5_NOM_UEN_SAN_ANTONIO = "Metalsa San Antonio";

	public static final String SPX_DEV5_NUM_UEN_SAC = "300000871351178";
	public static final String SPX_DEV5_NOM_UEN_SAC = "Metalsa SAC";

	public static final String SPX_DEV5_NUM_UEN_SALTILLO = "300000871351087";
	public static final String SPX_DEV5_NOM_UEN_SALTILLO = "Metalsa LV Saltillo";

	public static final String SPX_DEV5_NUM_UEN_GUANAJUATO = "300000871351074";
	public static final String SPX_DEV5_NOM_UEN_GUANAJUATO = "Metalsa LV Guanajuato";

	public static final String SPX_DEV5_NUM_UEN_APODACA = "300000871351061";
	public static final String SPX_DEV5_NOM_UEN_APODACA = "Metalsa LV Apodaca";

	public static final String SPX_DEV5_NUM_UEN_OWENSBORO = "300000871351139";
	public static final String SPX_DEV5_NOM_UEN_OWENSBORO = "Metalsa Owensboro";

	public static final String SPX_DEV5_NUM_UEN_ELIZABETHTOWN = "300000871351009";
	public static final String SPX_DEV5_NOM_UEN_ELIZABETHTOWN = "Metalsa Elizabethtown";

	public static final String SPX_DEV5_NUM_UEN_ROANOKE = "300000871351165";
	public static final String SPX_DEV5_NOM_UEN_ROANOKE = "Metalsa Roanoke";

	public static final String SPX_DEV5_NUM_UEN_NOVI = "300000871351113";
	public static final String SPX_DEV5_NOM_UEN_NOVI = "Metalsa Novi";

	public static final String SPX_DEV5_NUM_UEN_ARGENTINA = "300000871350983";
	public static final String SPX_DEV5_NOM_UEN_ARGENTINA = "Metalsa Argentina";

	public static final String SPX_DEV5_NUM_UEN_OSASCO = "300000871351126";
	public static final String SPX_DEV5_NOM_UEN_OSASCO = "Metalsa Osasco";

	/** UEN activa utilizada en la ejecución actual. */
	public static final String SPX_DEV5_NUM_UEN = SPX_DEV5_NUM_UEN_OSASCO;
	public static final String SPX_DEV5_NAME_UEN = SPX_DEV5_NOM_UEN_OSASCO;

	/** XPath para selección de UEN en el Home. */
	public static final String SPX_DEV5_UEN_HOME = "//option[@value='number:" + SPX_DEV5_NUM_UEN + "']";

	// =========================================================================
	// TEST DATA CATALOGS — Datos de prueba generales
	// =========================================================================
	public static final String[] MATERIAL = { "Oro", "Plata", "Cobre", "Mercurio", "Platino", "Cobalto", "Aluminio",
			"Hierro", "Zinc", "Níquel", "Tungsteno", "Cromo", "Magnesio", "Titanio", "Manganeso", "Cadmio", "Boro",
			"Silicio", "Rubidio", "Litio", "Vanadio" };

	public static final String[] COLOR = { "Rojo", "Azul", "Verde", "Amarillo", "Naranja", "Rosa", "Morado", "Cián",
			"Gris", "Marrón", "Negro", "Blanco", "Beige", "Violeta", "Turquesa", "Aqua", "Coral", "Oro", "Plateado",
			"Lila" };

	public static final String[] MARCA = { "Bose", "Sony", "JBL", "Harman Kardon", "Beats", "Harman", "Kenwood",
			"Pioneer", "Alpine", "Clarion", "Focal", "JL Audio", "Rockford Fosgate", "Infinity", "Kicker", "Polk Audio",
			"Cerwin-Vega", "MB Quart", "Audison", "Soundstream", "Bang & Olufsen", "Sennheiser", "Marshall", "AKG",
			"Bowers & Wilkins" };

	public static final String[] MEDIDAS = { "12 Pulgadas", "10 Centímetros", "8 Centímetros", "10 Pulgadas",
			"12 Centímetros", "15 Pies", "18 Pies", "20 Metros", "55 Centímetros", "98 Pulgadas", "145 Centímetros",
			"54 Pies", "45 Centímetros", "1 Yarda", "2 Yardas", "3 Yardas", "1 Centímetro", "2 Pulgadas", "3 Pies" };

	public static final String[] PROVEEDORES = {
			"SINDICATO NACIONAL DA INDUSTRIA DE COMPONENTES PARA VEICULOS AUTOMOTORES" };

	public static final String[] UNIDAD_DE_MEDIDA_ES = { "HECTOLITRO", "PINT", "TONELADA", "METRO CUBICO", "ONZA",
			"QUINCENAL", "MENSUAL", "B10", "CAJA", "CILINDRO" };

	public static final String[] UNIDAD_DE_MEDIDA_EN = { "HECTOLITER", "PINT", "QUAART US LIQUID", "CUBIC METER", "B10",
			"BAG", "BOOK", "BOX", "DRUM", "KIT", "CASE", "KILOGRAM" };

	public static final String[] UNIDAD_DE_MEDIDA_PT = { "BOX OF TEN", "BAG", "BOOK", "BOX", "CYLINDER", "DRUM", "KIT",
			"DOZEN", "PACKAGE", "PAIL", "PIECE", "ROLL", "SACK", "SERVICE" };

	public static final String[] NUM_RAND = { "001", "002", "003", "004", "005", "006", "007", "008", "009", "010",
			"011", "012", "013", "014", "015", "016", "017", "018", "019", "020" };

	public static final String[] QUANTITY = SPXBase.generateNumbers();

	public static final String[] MONEDA = { "MXN", "USD", "EUR", "ZAR", "BRL", "THB", "NOK" };

	public static final String[] RAZON_URGENCIA = { "Seguridad del Personal", "Paro de línea",
			"Afectación de calidad directa al cliente" };

	public static final String[] RAZON_URGENCIA_ENG = { "Personal security", "Production line stops",
			"Direct quality affectation to client" };
	public static final String[] RAZON_URGENCIA_PT = { "Segurança pessoal", "Parada de linha",
			"Impacto da qualidade direta para o cliente" };

	public static final String[] GENERIC_NAME = { "Chasis atlas", "Soporte titán", "Placa fortaleza", "Viga orión",
			"Panel magnum", "Eje centauro", "Bastidor prime", "Marco sólido", "Engranaje delta", "Bracket omega",
			"Refuerzo stratus", "Perfil vector", "Cople nexus", "Flecha torque", "Cuna industrial", "Soporte lateral",
			"Tubo dural", "Placa base", "Anclaje rapid", "Sello metálic" };

	public static final String[] GENERIC_ITEM = { "Conector de placa", "Soporte de montaje", "Junta de union",
			"Aro de ajuste", "Casquillo guia", "Tornillo estructural", "Brida de sujecion", "Platina refuerzo",
			"Cobertor protector", "Soporte articulado", "Pasador de anclaje", "Tuerca de seguridad",
			"Bloque de fijacion", "Manija industrial", "Placa de cierre", "Modulo portante", "Pasador tensor",
			"Guia de deslizado", "Refuerzo lateral", "Conjunto bisagra" };

	public static final String[] COMENTARIOS = {
			"Implementacion detallada de un sistema de requisiciones automaticas que optimiza el flujo de trabajo empresarial mediante la integracion de Selenium WebDriver.",
			"Automatizacion avanzada en la creacion de requisiciones, utilizando Selenium WebDriver para mejorar significativamente la eficiencia operativa en la empresa.",
			"Desarrollo de una plataforma robusta para la gestion automatizada de requisiciones, integrando funcionalidades de Selenium WebDriver para asegurar precision y rapidez.",
			"Configuracion personalizada de Selenium WebDriver para la automatizacion integral de requisiciones, mejorando la capacidad de respuesta del sistema ante cambios operativos.",
			"Optimizacion del proceso completo de gestion de requisiciones a traves de la automatizacion con Selenium WebDriver, asegurando una reduccion en los tiempos de procesamiento y errores humanos.",
			"Integracion eficiente de Selenium WebDriver dentro del ecosistema de gestion empresarial para automatizar y agilizar la creacion y aprobacion de requisiciones.",
			"Mejora continua en la generacion automatica de requisiciones mediante el uso avanzado de las capacidades de Selenium WebDriver, optimizando recursos y reduciendo costos.",
			"Sistema de requisiciones automaticas completamente optimizado con Selenium WebDriver, disenado para maximizar la eficiencia y la precision en el entorno empresarial.",
			"Implementacion efectiva y detallada de Selenium WebDriver en la automatizacion de requisiciones, enfocada en aumentar la productividad y reducir la carga manual del personal.",
			"Soluciones tecnicas avanzadas para la gestion automatica de requisiciones, aprovechando al maximo las herramientas proporcionadas por Selenium WebDriver.",
			"Configuracion avanzada y personalizada de Selenium WebDriver para optimizar la creacion y aprobacion de requisiciones en un entorno empresarial dinamico.",
			"Automatizacion completa del proceso de requisiciones utilizando Selenium WebDriver para maximizar la eficiencia y minimizar los tiempos de espera en la cadena de suministro.",
			"Mejoras significativas en el proceso de requisiciones automaticas, empleando Selenium WebDriver para asegurar una gestion mas efectiva y menos propensa a errores.",
			"Selenium WebDriver como herramienta clave en la gestion automatica de requisiciones, proporcionando soluciones escalables y eficientes para la empresa moderna.",
			"Desarrollo de procesos automatizados de requisiciones mediante la implementacion avanzada de Selenium WebDriver, enfocada en la adaptabilidad y la eficiencia.",
			"Optimizacion de la gestion de requisiciones automaticas con Selenium WebDriver, asegurando un flujo de trabajo continuo y sin interrupciones dentro de la organizacion.",
			"Implementacion de Selenium WebDriver para mejorar el proceso completo de gestion de requisiciones automaticas, con un enfoque en la mejora continua y la eficiencia operativa.",
			"Soluciones de automatizacion empresarial centradas en el uso de Selenium WebDriver para gestionar de manera efectiva y automatica las requisiciones, reduciendo tiempos y costos.",
			"Mejoras estrategicas en la gestion de requisiciones automaticas utilizando las capacidades de Selenium WebDriver, garantizando una mayor precision y rapidez en los procesos.",
			"Implementacion de soluciones de automatizacion para la gestion de requisiciones, optimizando recursos y procesos mediante el uso avanzado de Selenium WebDriver." };

	public static final String[] DESC_FAD = {
			"Registro de prueba automatizada para la validacion del flujo funcional en el Formato de Asignacion Directa mediante script de Selenium",
			"Descripcion generada por herramienta de automatizacion para verificar la persistencia de datos en el modulo de Asignacion Directa",
			"Data de test automatizado cargada para comprobar la correcta visualizacion del campo Descripcion en el entorno de pruebas",
			"Prueba funcional automatizada ejecutada por Selenium Webdriver para validar la estabilidad de la pantalla de Formato de Asignacion Directa",
			"Texto de prueba generado de forma automatica para el analisis de comportamiento de la interfaz de usuario en el flujo de asignacion" };

	public static final String[] RAZON_ASIGNACION_DIRECTA = {
			"Validacion tecnica del campo detalle de razon mediante pruebas automatizadas de Selenium para simular la seleccion de proveedor directo",
			"Justificacion generada por script de QA Automation con la finalidad de comprobar las reglas de negocio y restricciones del formulario",
			"Motivo de prueba automatizada ingresado para validar el correcto almacenamiento de la justificacion en el Formato de Asignacion Directa",
			"Script de Selenium ejecuta la carga de esta razon de asignacion para verificar la respuesta del servidor en ambiente de testing",
			"Detalle de simulacion automatizada requerido para completar el flujo feliz de la pantalla de asignacion directa sin datos reales" };

	public static final String[] COMENTARIOS_FAD = {
			"Comentario de seguimiento automatizado por Selenium para comprobar la adicion dinamica de notas en el historial del formato",
			"Observacion de QA generada por script de automatizacion para verificar que el campo Comentarios soporta la carga de texto de prueba",
			"Nota automatizada creada durante la ejecucion de la suite de pruebas funcionales para el Formato de Asignacion Directa",
			"Registro dummy generado por herramienta de testing con el fin de auditar la seccion de comentarios en el ciclo de pruebas actual",
			"Comentario tecnico de prueba ejecutado por robot de Selenium para la validacion de campos de texto libre en el formulario" };

	public static final String[] DESCRIPTION_NEW_ITEM = {
			"[DATO DE PRUEBA] Prueba automatizada de software completada sin errores críticos.",
			"[DATO DE PRUEBA] El caso de prueba se ejecutó correctamente, sin incidencias registradas.",
			"[DATO DE PRUEBA] No se detectaron defectos en la validación automatizada del módulo.",
			"[DATO DE PRUEBA] Ejecución del script de prueba finalizada con éxito y sin fallos.",
			"[DATO DE PRUEBA] Entorno de pruebas estable, sin impactos en la funcionalidad.",
			"[DATO DE PRUEBA] Se aplicaron verificaciones de seguridad, sin vulnerabilidades expuestas.",
			"[DATO DE PRUEBA] El componente mostró comportamiento esperado bajo carga simulada.",
			"[DATO DE PRUEBA] Prueba finalizada sin necesidad de intervención manual.",
			"[DATO DE PRUEBA] Automatización ejecutada sin requerir supervisión constante.",
			"[DATO DE PRUEBA] Simulación exitosa, errores de rendimiento mitigados.",
			"[DATO DE PRUEBA] El entorno virtual fue seguro, sin filtraciones de datos.",
			"[DATO DE PRUEBA] No se generaron excepciones no controladas durante la prueba.",
			"[DATO DE PRUEBA] Prueba de estrés completada, sin bloqueos ni caídas.",
			"[DATO DE PRUEBA] La integridad del sistema se preservó gracias a los controles automáticos.",
			"[DATO DE PRUEBA] Validación sin incidentes gracias al aislamiento del entorno.",
			"[DATO DE PRUEBA] El módulo funcionó de manera predecible, sin errores inesperados.",
			"[DATO DE PRUEBA] Impacto nulo sobre la configuración de usuario durante la prueba.",
			"[DATO DE PRUEBA] Medidas preventivas aplicadas, sin pérdida de datos.",
			"[DATO DE PRUEBA] La prueba no expuso información sensible en los logs.",
			"[DATO DE PRUEBA] El sistema de monitoreo detectó y evitó condiciones anómalas.",
			"[DATO DE PRUEBA] Condiciones de carga controladas, sin degradación de servicio.",
			"[DATO DE PRUEBA] Los tests de regresión pasaron sin fallos.",
			"[DATO DE PRUEBA] No se requirió intervención humana ante errores.",
			"[DATO DE PRUEBA] La automatización permitió cobertura completa de escenarios.",
			"[DATO DE PRUEBA] El script interrumpió la prueba ante desviaciones críticas.",
			"[DATO DE PRUEBA] El personal permaneció fuera del entorno de prueba en vivo.",
			"[DATO DE PRUEBA] No se observaron fallas que comprometan la estabilidad del software.",
			"[DATO DE PRUEBA] La evaluación incluyó verificación de puntos de control.",
			"[DATO DE PRUEBA] Los mecanismos de rollback funcionaron correctamente.",
			"[DATO DE PRUEBA] No se presentó aumento indebido de tiempos de respuesta.",
			"[DATO DE PRUEBA] Las métricas de rendimiento se mantuvieron dentro de los límites.",
			"[DATO DE PRUEBA] Ensayo realizado bajo estándares de calidad de software.",
			"[DATO DE PRUEBA] La latencia se mantuvo estable y dentro de parámetros seguros.",
			"[DATO DE PRUEBA] No se activaron alertas de error durante la ejecución.",
			"[DATO DE PRUEBA] La configuración de red fue adecuada para la prueba.",
			"[DATO DE PRUEBA] No hubo necesidad de restablecer el entorno tras la ejecución.",
			"[DATO DE PRUEBA] Protocolos de recuperación no fueron necesarios.",
			"[DATO DE PRUEBA] El personal no requirió ajustes manuales al código.",
			"[DATO DE PRUEBA] La interfaz de usuario respondió dentro de parámetros seguros.",
			"[DATO DE PRUEBA] Los resultados confirman estabilidad en el entorno de pruebas.",
			"[DATO DE PRUEBA] El módulo no generó errores de memoria durante la simulación." };
	public static final String[] CODE_SUGGESTED_PREFIXES = { "ART", "PRO", "INV", "MAT", "EQU", "SUP", "HERR", "REP",
			"COMP", "SEC" };
	public static final String[] EQUIPMENT_TYPES = { "Equipo", "Maquinaria", "Herramienta" };
	public static final String[] EQUIPMENT_LOCATIONS = { "Planta", "Taller", "Almacen", "Sitio", "Deposito", "Fabrica",
			"Estacion", "Bodega", "Instalacion", "Campo" };
	public static final String[] MEASURE_UNITS = { "yardas", "centímetros", "metros", "pulgadas", "milímetros" };
	public static final String[] ITEM_NAMES = { "Tornillo", "Pieza", "Componente", "Accesorio", "Repuesto", "Material",
			"Soporte", "Conector", "Engranaje", "Filtro", "Manguera", "Válvula", "Motor", "Sello", "Interruptor",
			"Rodamiento", "Cinta", "Cable", "Perno", "Polea" };

	public static final String[] ITEM_LOCATIONS = { "Almacen Principal", "Almacen Secundario", "Seccion A", "Seccion B",
			"Seccion C", "Planta", "Taller", "Sitio", "Bodega", "Deposito" };
	public static final String[] PHYSICAL_PROPERTIES = { "Densidad", "Punto de fusión", "Punto de ebullición",
			"Viscosidad", "Conductividad térmica", "Resistencia a la tracción", "Dureza", "Elasticidad",
			"Capacidad calorífica", "Expansión térmica", "Absorción de agua", "Solubilidad", "Conductividad eléctrica",
			"Toxicidad", "Inflamabilidad", "Tensión superficial", "Porosidad", "Peso específico",
			"Fuerza de compresión", "Resistencia química" };

	public static final String[] PHYSICAL_UNITS = { "g/cm³", "°C", "°F", "Pa·s", "W/m·K", "MPa", "HRC", "GPa", "J/kg·K",
			"µm/m·°C", "%", "g/L", "S/m", "mg/L", "kJ/mol", "mN/m", "% vol", "kg/m³", "kN", "% res" };
	public static final String[] REFERENCE_PREFIXES = { "REF-", "ART-", "ITEM-", "COD-", "ALM-" };

	public static final String[] REFERENCE_CATEGORIES = { "Herramientas", "Maquinaria", "Equipo", "Materiales",
			"Accesorios", "Suministros", "Componentes", "Piezas", "Repuestos", "Consumibles", "Seguridad",
			"Electricidad", "Neumática", "Mecánica", "Hidráulica", "Estructuras", "Muebles", "Plásticos", "Metales",
			"Conexiones" };
	public static final String[] MANUFACTURER = { "Siemens", "ABB", "Schneider Electric", "Rockwell Automation",
			"Mitsubishi Electric", "Omron", "General Electric", "Bosch Rexroth", "Yaskawa", "Keyence",
			"Phoenix Contact", "National Instruments", "Fanuc", "Delta Electronics", "Emerson", "Festo", "Cerwin-Vega",
			"Pioneer", "Yokogawa", "Honeywell" };

	// =========================================================================
	// RANDOM VALUES — Valores aleatorios generados al iniciar la clase
	// =========================================================================

	/** Moneda aleatoria seleccionada para la ejecución actual. */
	public static final String CURRENCY = SPXBase.randomCurrency();

	/** Razón de urgencia aleatoria seleccionada para la ejecución actual. */
//	public static final String SPX_DEV5_REASON_UGENT_SPOT_PAGE = SPXBase.randomUrgencyReason();

	// =========================================================================
	// SPOT BUY REQUISITIONS — Global Sourcing RFQ
	// =========================================================================

	public static final String SPX_DEV5_GLOBAL_SOURCING_RFQ_SPOT_PAGE = "868 - Tooling";

	public static final String SPX_DEV5_SELECT_GLOBAL_SOURCING_RFQ_SPOT_PAGE = "//li[contains(.,'"
			+ SPX_DEV5_GLOBAL_SOURCING_RFQ_SPOT_PAGE + "')]";

	// =========================================================================
	// SPOT BUY REQUISITIONS — First Section
	// =========================================================================

	public static final String SPX_DEV5_DESCRIPTION_SPOT_PAGE = "REQUI-TEST-AUTO-" + SPXBase.generateRandomId(8);

	public static final String SPX_DEV5_MATERIAL_SPOT_PAGE = SPXBase.randomMaterial();
	public static final String SPX_DEV5_COLOR_SPOT_PAGE = SPXBase.randomColor();
	public static final String SPX_DEV5_BRAND_SPOT_PAGE = SPXBase.randomBrand();
	public static final String SPX_DEV5_MEASUREMENTS_SPOT_PAGE = SPXBase.randomMeasurement();

	public static final String SPX_DEV5_MODELPARTNUMBER_SPOT_PAGE = "Modelo-" + SPXBase.generateRandomId(6);

	public static final String SPX_DEV5_GENERICNAME_SPOT_PAGE = SPXBase.randomGenericName() + "-"
			+ SPXBase.randomNumber();

	// =========================================================================
	// SPOT BUY REQUISITIONS — Second Section — Category / Family / SubFamily
	// =========================================================================

	// Español
	public static final String SPX_DEV5_CATEGORY_SPOT_PAGE_ESP = "Administrativo y Profesional";
	public static final String SPX_DEV5_FAMILY_SPOT_PAGE_ESP = "Consultoría";
	public static final String SPX_DEV5_SUBFAMILY_SPOT_PAGE_ESP = "Consultoría";

	// Ingles
	public static final String SPX_DEV5_CATEGORY_SPOT_PAGE_ENG = "Administrative & Professional";
	public static final String SPX_DEV5_FAMILY_SPOT_PAGE_ENG = "Consulting";
	public static final String SPX_DEV5_SUBFAMILY_SPOT_PAGE_ENG = "Consulting";

	// Portugues
	public static final String SPX_DEV5_CATEGORY_SPOT_PAGE_PT = "Administrativo e Profissional";
	public static final String SPX_DEV5_FAMILY_SPOT_PAGE_PT = "Consultoria";
	public static final String SPX_DEV5_SUBFAMILY_SPOT_PAGE_PT = "Consultoria";

	public static final String SPX_DEV5_GENERIC_ITEM_SPOT_PAGE = SPXBase.randomGenericItem() + "-"
			+ SPXBase.randomNumber();

	public static final String SPX_GENERIC_ITEM_SPOT_PAGE = "NBS_112030000 - Serviços de pesquisa e desenvolvimento interdisciplinar";

	public static final String SPX_DEV5_QUANTITY_SPOT_PAGE = SPXBase.randomQuantity();

	// Need By Date
	public static final String SPX_DEV5_SELECT_MONTH_NEED_BY_DATE_SPOT_PAGE = "//select/option[@value='11']";
	public static final String SPX_DEV5_SELECT_YEAR_NEED_BY_DATE_SPOT_PAGE = "//select/option[@value='2034']";
	public static final String SPX_DEV5_SELECT_DAY_NEED_BY_DATE_SPOT_PAGE = "//a[@class='ui-state-default'][@href='#'][text()='28']";

	// XPath de selección — Category, Family, SubFamily (multilenguaje ES/EN)
	public static final String SPX_DEV5_SELECT_CATEGORY_OPTION_SPOT_PAGE = "//li[contains(.,'"
			+ SPX_DEV5_CATEGORY_SPOT_PAGE_ESP + "') or contains(.,'" + SPX_DEV5_CATEGORY_SPOT_PAGE_ENG
			+ "') or contains(.,'" + SPX_DEV5_CATEGORY_SPOT_PAGE_PT + "')]";

	public static final String SPX_DEV5_SELECT_FAMILY_OPTION_SPOT_PAGE = "//div[contains(@id,'nwcboFamilias0') and contains(@class,'ui-selectonemenu-panel')]"
			+ "//li[contains(.,'" + SPX_DEV5_FAMILY_SPOT_PAGE_ESP + "') or contains(.,'" + SPX_DEV5_FAMILY_SPOT_PAGE_ENG
			+ "') or contains(.,'" + SPX_DEV5_FAMILY_SPOT_PAGE_PT + "')]";

	public static final String SPX_DEV5_SELECT_FAMILY_OPTION_NEW_LINE_SPOT_PAGE = "//div[contains(@id,'nwcboFamilias') and contains(@class,'ui-selectonemenu-panel')]"
			+ "//li[contains(.,'" + SPX_DEV5_FAMILY_SPOT_PAGE_ESP + "') or contains(.,'" + SPX_DEV5_FAMILY_SPOT_PAGE_ENG
			+ "') or contains(.,'" + SPX_DEV5_FAMILY_SPOT_PAGE_PT + "')]";

	public static final String SPX_DEV5_SELECT_SUBFAMILY_OPTION_SPOT_PAGE = "//div[contains(@id,'nwcboSubFamilias0') and contains(@class,'ui-selectonemenu-panel')]"
			+ "//li[contains(.,'" + SPX_DEV5_SUBFAMILY_SPOT_PAGE_ESP + "') or contains(.,'"
			+ SPX_DEV5_SUBFAMILY_SPOT_PAGE_ENG + "') or contains(.,'" + SPX_DEV5_SUBFAMILY_SPOT_PAGE_PT + "')]";

	public static final String SPX_DEV5_SELECT_SUBFAMILY_OPTION_NEW_LINE_SPOT_PAGE = "//div[@id='formSpot:nwcboSubFamilias0_panel']"
			+ "//li[contains(.,'" + SPX_DEV5_SUBFAMILY_SPOT_PAGE_ESP + "') or contains(.,'"
			+ SPX_DEV5_SUBFAMILY_SPOT_PAGE_ENG + "') or contains(.,'" + SPX_DEV5_SUBFAMILY_SPOT_PAGE_PT + "')]";

	/** XPath dinámico para selección de unidad de medida por valor exacto. */
	public static final String getUnitOfMeasureXpath(String unitOfMeasure) {
		return "//div[@id='formSpot:comboUDM0_panel']" + "//li[contains(normalize-space(.),'" + unitOfMeasure + "')]";
	}

	// =========================================================================
	// SPOT BUY REQUISITIONS — Urgency
	// =========================================================================

//	public static final String SPX_DEV5_SELECT_REASON_URGENT_SPOT_PAGE = "//div[@id='formSpot:razonUrg_panel']"
//			+ "//li[contains(.,'" + SPX_DEV5_REASON_UGENT_SPOT_PAGE + "') " + "or contains(.,'"
//			+ SPX_DEV5_SUBFAMILY_SPOT_PAGE_ENG + "')]";

	// =========================================================================
	// SPOT BUY REQUISITIONS — Third Section
	// =========================================================================

	public static final String SPX_DEV5_COMMENTS_TO_BUYER_SPOT_PAGE = SPXBase.randomComments();

	// =========================================================================
	// SHOPPING CART
	// =========================================================================

	public static final String SPX_DEV5_COMMENTS_SHOPPING_CART = "COMENTARIOS EN EL CARRITO DE COMPRAS";

	// =========================================================================
	// ACCOUNT CONFIGURATION — Project
	// =========================================================================

	public static final String SPX_DEV5_PROJECT_ACCOUNT_CONFIGURATION_PAGE = "027445 - STLA INVESTMENT STAMPING";
	public static final String SPX_DEV5_TASK_ACCOUNT_CONFIGURATION_PAGE = "01 Transfer Fingers";
	public static final String SPX_DEV5_RESOURSE_ACCOUNT_CONFIGURATION_PAGE = "Machinery & Equipment";
	public static final String SPX_DEV5_BUYER_ACCOUNT_CONFIGURATION_PAGE = "Cortés-Hernández, Sr. Jesús Angel";

	public static final String SPX_DEV5_SELECT_PROJECT_ACCOUNT_CONFIGURATION_PAGE = "//li[contains(.,'"
			+ SPX_DEV5_PROJECT_ACCOUNT_CONFIGURATION_PAGE + "')]";

	public static final String SPX_DEV5_SELECT_TASK_ACCOUNT_CONFIGURATION_PAGE = "//li[@data-label='"
			+ SPX_DEV5_TASK_ACCOUNT_CONFIGURATION_PAGE + "'" + " and contains(@class,'ui-selectonemenu-item')"
			+ " and normalize-space()='" + SPX_DEV5_TASK_ACCOUNT_CONFIGURATION_PAGE + "']";

	public static final String SPX_DEV5_SELECT_RESOURSE_ACCOUNT_CONFIGURATION_PAGE = "//label[contains(@class,'ui-selectonemenu-label')"
			+ " and normalize-space(text())='" + SPX_DEV5_RESOURSE_ACCOUNT_CONFIGURATION_PAGE + "']";

	public static final String SPX_DEV5_SELECT_BUYER_ACCOUNT_CONFIGURATION_PAGE = "//label[contains(@class,'ui-selectonemenu-label')"
			+ " and contains(text(),'" + SPX_DEV5_BUYER_ACCOUNT_CONFIGURATION_PAGE + "')]";

	// Second Line — Project
	public static final String SPX_DEV5_SELECT_PROJECT_NEW_LINE_ACCOUNT_CONFIGURATION_PAGE = "(//li[@data-label='"
			+ SPX_DEV5_PROJECT_ACCOUNT_CONFIGURATION_PAGE + "']" + "[normalize-space()='"
			+ SPX_DEV5_PROJECT_ACCOUNT_CONFIGURATION_PAGE + "'])[2]";

	public static final String SPX_DEV5_SELECT_TASK_NEW_LINE_ACCOUNT_CONFIGURATION_PAGE = "(//li[@data-label='"
			+ SPX_DEV5_TASK_ACCOUNT_CONFIGURATION_PAGE + "']" + "[normalize-space()='"
			+ SPX_DEV5_TASK_ACCOUNT_CONFIGURATION_PAGE + "'])[2]";

	public static final String SPX_DEV5_SELECT_RESOURSE_NEW_LINE_ACCOUNT_CONFIGURATION_PAGE = "(//li[@data-label='"
			+ SPX_DEV5_RESOURSE_ACCOUNT_CONFIGURATION_PAGE + "']" + "[normalize-space()='"
			+ SPX_DEV5_RESOURSE_ACCOUNT_CONFIGURATION_PAGE + "'])[2]";

	public static final String SPX_DEV5_SELECT_BUYER_NEW_LINE_ACCOUNT_CONFIGURATION_PAGE = "(//li[@data-label='"
			+ SPX_DEV5_BUYER_ACCOUNT_CONFIGURATION_PAGE + "']" + "[normalize-space()='"
			+ SPX_DEV5_BUYER_ACCOUNT_CONFIGURATION_PAGE + "'])[2]";

	// =========================================================================
	// ACCOUNT CONFIGURATION — Cost Center (CC)
	// =========================================================================

	public static final String SPX_DEV5_COST_CENTER_ACCOUNT_CONFIGURATION_PAGE = "A004 - CD e Financiamento - Custos";
	public static final String SPX_DEV5_ACCOUNT_CC_ACCOUNT_CONFIGURATION_PAGE = "047 - A004 - 620120000014 / Aluguel - Copiadora/Fax/Telefones - 0000 - 000";

	public static final String SPX_DEV5_SELECT_COST_CENTER_ACCOUNT_CONFIGURATION_PAGE = "//li[contains(.,'"
			+ SPX_DEV5_COST_CENTER_ACCOUNT_CONFIGURATION_PAGE + "')]";

	public static final String SPX_DEV5_SELECT_ACCOUNT_CC_ACCOUNT_CONFIGURATION_PAGE = "//li[contains(.,'"
			+ SPX_DEV5_ACCOUNT_CC_ACCOUNT_CONFIGURATION_PAGE + "')]";

	// Second Line — CC
	public static final String SPX_DEV5_SELECT_COST_CENTER_NEW_LINE_ACCOUNT_CONFIGURATION_PAGE = "//div[contains(@class,'ui-selectonemenu-panel') and contains(@style,'display: block')]"
			+ "//li[@data-label='" + SPX_DEV5_COST_CENTER_ACCOUNT_CONFIGURATION_PAGE + "'"
			+ " and not(contains(@style,'none'))]";

	public static final String SPX_DEV5_SELECT_ACCOUNT_CC_NEW_LINE_ACCOUNT_CONFIGURATION_PAGE = "//li[contains(.,'"
			+ SPX_DEV5_ACCOUNT_CC_ACCOUNT_CONFIGURATION_PAGE + "')]";

	// =========================================================================
	// SINGLE SOURCE FORMAT (FAD) — Datos de prueba
	// =========================================================================

	public static final String DESCRIPTION_FAD = SPXBase.randomDescFAD();
	public static final String SUPPLIER_NAME_FAD = SPXBase.randomSupplier();
	public static final String AMOUNT_FAD = SPXBase.randomQuantity();
	public static final String DETAILS_FAD = SPXBase.randomRAD();
	public static final String COMMENTS_FAD = SPXBase.randomCommentsFad();

	/**
	 * XPath de la razón seleccionada aleatoriamente para el formulario FAD.
	 * Selecciona uno de los 6 radio buttons disponibles por su value de negocio.
	 * Independiente del idioma y del ID dinámico de PrimeFaces.
	 */
	public static final String SELECTED_SINGLE_SOURCE_REASON = SPXBase
			.getRandomValue(SPXBase.SINGLE_SOURCE_FORMAT_REASON);

	/**
	 * XPath para selección de moneda en el dropdown FAD. Anclado al panel formFAD
	 * para evitar colisiones con otros dropdowns. Usa data-label para match exacto
	 * independiente del idioma.
	 */
	public static final String SELECT_CURRENCY = "//div[contains(@class,'ui-selectonemenu-panel') and contains(@id,'formFAD')]"
			+ "//li[@data-label='" + CURRENCY + "']";

	// =========================================================================
	// ADMINISTRATION — Roles Menu
	// =========================================================================

	public static final String SPX_DEV5_MENU_NAME_ADMINISTRATION_ROLES_MENU_PAGE = "Req. Rechazadas";
	public static final String SPX_DEV5_URL_PATH_ADMINISTRATION_ROLES_MENU_PAGE = "pages/internas/motor.jsf";

	// =========================================================================
	// ADMINISTRATION — Menu
	// =========================================================================

	public static final String SPX_DEV5_MENU_NAME_ADMINISTRATION_MENU_PAGE = "Req. Rechazadas";
	public static final String SPX_DEV5_URL_PATH_ADMINISTRATION_MENU_PAGE = "pages/internas/motor.jsf";

	public static final String SPX_DEV5_NAME_MENU_ADMINISTRATION_MENU_PAGE = "Prueba Menu";
	public static final String SPX_DEV5_DESCRIPTION_ESA_ADMINISTRATION_MENU_PAGE = "Item Prueba ESA";
	public static final String SPX_DEV5_DESCRIPTION_US_ADMINISTRATION_MENU_PAGE = "Item Prueba US";
	public static final String SPX_DEV5_DESCRIPTION_PTB_ADMINISTRATION_MENU_PAGE = "Item Prueba PTB";
	public static final String SPX_DEV5_ORDER_ADMINISTRATION_MENU_PAGE = "1";
	public static final String SPX_DEV5_CSSCLASS_ADMINISTRATION_MENU_PAGE = "CssClass Test";
	public static final String SPX_DEV5_FACES_ADMINISTRATION_MENU_PAGE = "pages/internas/motor.jsf";
	public static final String SPX_DEV5_CATEGORY_ADMINISTRATION_MENU_PAGE = "Motor de busqueda";

	public static final String SPX_DEV5_SELECT_CATEGORY_ADMINISTRATION_MENU_PAGE = "//div[@id='fList:j_idt81:0:j_idt113_panel']"
			+ "//li[contains(text(),'" + SPX_DEV5_CATEGORY_ADMINISTRATION_MENU_PAGE + "')]";

	public static final String SPX_DEV5_PARENT_ADMINISTRATION_MENU_PAGE = "Vending Machine";
	public static final String SPX_DEV5_SELECT_PARENT_ADMINISTRATION_MENU_PAGE = "//div[@id='fList:j_idt81:0:j_idt131_panel']"
			+ "//li[contains(.,'" + SPX_DEV5_PARENT_ADMINISTRATION_MENU_PAGE + "')]";

	public static final String SPX_DEV5_ACTIVE_ADMINISTRATION_MENU_PAGE = "Active";
	public static final String SPX_DEV5_SELECT_ACTIVE_ADMINISTRATION_MENU_PAGE = "(//li[@data-label='"
			+ SPX_DEV5_ACTIVE_ADMINISTRATION_MENU_PAGE + "']" + "[normalize-space()='"
			+ SPX_DEV5_ACTIVE_ADMINISTRATION_MENU_PAGE + "'])[1]";

	public static final String SPX_DEV5_INACTIVE_ADMINISTRATION_MENU_PAGE = "Inactive";
	public static final String SPX_DEV5_SELECT_INACTIVE_ADMINISTRATION_MENU_PAGE = "(//li[@data-label='"
			+ SPX_DEV5_INACTIVE_ADMINISTRATION_MENU_PAGE + "']" + "[normalize-space()='"
			+ SPX_DEV5_INACTIVE_ADMINISTRATION_MENU_PAGE + "'])[1]";

	public static final String SPX_DEV5_MENU_ROOT_ADMINISTRATION_MENU_PAGE = "Menu Root";
	public static final String SPX_DEV5_SELECT_MENU_ROOT_ADMINISTRATION_MENU_PAGE = "(//li[@data-label='"
			+ SPX_DEV5_MENU_ROOT_ADMINISTRATION_MENU_PAGE + "']" + "[normalize-space()='"
			+ SPX_DEV5_MENU_ROOT_ADMINISTRATION_MENU_PAGE + "'])[1]";

	public static final String SPX_DEV5_MENU_SIMPLE_ADMINISTRATION_MENU_PAGE = "Menu Simple";
	public static final String SPX_DEV5_SELECT_MENU_SIMPLE_ADMINISTRATION_MENU_PAGE = "(//li[@data-label='"
			+ SPX_DEV5_MENU_SIMPLE_ADMINISTRATION_MENU_PAGE + "']" + "[normalize-space()='"
			+ SPX_DEV5_MENU_SIMPLE_ADMINISTRATION_MENU_PAGE + "'])[1]";

	// =========================================================================
	// ARTICULOS CONTROLADOS
	// =========================================================================

	public static final String SPX_DEV5_UEN_ARTICULOS_CONTROLADOS_PAGE = SPXBase.assignUEN();
	public static final String SPX_DEV5_LOCALIZACION_ARTICULOS_CONTROLADOS_PAGE = "Metalsa Argentina El Talar - El Talar";
	public static final String SPX_DEV5_CODIGO_PRODUCTO_ARTICULOS_CONTROLADOS_PAGE = "00400196";
	public static final String SPX_DEV5_NOMBRE_FABRICANTE_ARTICULOS_CONTROLADOS_PAGE = "FABRICANTE DE PRUEBA - "
			+ SPXBase.randomNumber();
	public static final String SPX_DEV5_NUM_PARTE_FABRICANTE_ARTICULOS_CONTROLADOS_PAGE = "101004";
	public static final String SPX_DEV5_NUM_PARTE_PROVEEDOR_ARTICULOS_CONTROLADOS_PAGE = "101004";
	public static final String SPX_DEV5_DESCRIPCION_ARTICULOS_CONTROLADOS_PAGE = "00400196 - Bulonería-2-13-2 |Abrazadera ajustable sin fin de 14 a 20mm";
	public static final String SPX_DEV5_PICKLIST_SOURCE_ARTICULOS_CONTROLADOS_PAGE = "10105";
	public static final String SPX_DEV5_PICKLIST_TARGET_ARTICULOS_CONTROLADOS_PAGE = "Stopper";

	// =========================================================================
	// ARTICULOS POR PROCESAR
	// =========================================================================

	public static final String SPX_DEV5_UEN_ARTICULOS_POR_PROCESAR_PAGE = SPXBase.assignUEN();
	public static final String SPX_DEV5_REQUISICION_ARTICULOS_POR_PROCESAR_PAGE = "5";
	public static final String SPX_DEV5_REQUISITOR_ARTICULOS_POR_PROCESAR_PAGE = "Garza Cantu Edna Melissa";
	public static final String SPX_DEV5_COMPRADOR_ARTICULOS_POR_PROCESAR_PAGE = "Garza Cantu Edna Melissa";
	public static final String SPX_DEV5_ESTATUS_ARTICULOS_POR_PROCESAR_PAGE = "EN PROCESO";
	public static final String SPX_DEV5_FECHA_INICIO_ARTICULOS_POR_PROCESAR_PAGE = "26/oct/2023";
	public static final String SPX_DEV5_FECHA_FIN_ARTICULOS_POR_PROCESAR_PAGE = "23/dic/2025";
	public static final String SPX_DEV5_PROCESO_ARTICULOS_POR_PROCESAR_PAGE = "VL APO.- PAINTING 1";
	public static final String SPX_DEV5_CENTRO_COSTOS_ARTICULOS_POR_PROCESAR_PAGE = "F002 - CV - Global Purchasing Process Development";
	public static final String SPX_DEV5_CATEGORIA_ARTICULOS_POR_PROCESAR_PAGE = "50 - Administrativo y Profesional";
	public static final String SPX_DEV5_FAMILIA_ARTICULOS_POR_PROCESAR_PAGE = "01 - Publicidad y Mercadotecnia";
	public static final String SPX_DEV5_SUBFAMILIA_ARTICULOS_POR_PROCESAR_PAGE = "03 - Medios impresos y Artículos promocionales";
	public static final String SPX_DEV5_TIPO_ARTICULOS_POR_PROCESAR_PAGE = "Refacción";
	public static final String SPX_DEV5_PRIORIDAD_ARTICULOS_POR_PROCESAR_PAGE = "Refacción Normal";
	public static final String SPX_DEV5_JUSTIFICACION_ARTICULOS_POR_PROCESAR_PAGE = "Paro de línea";
	public static final String SPX_DEV5_BUSQUEDA_POR_PALABRA_ARTICULOS_POR_PROCESAR_PAGE = "F3F4F43F";

	// =========================================================================
	// CAPTURA DE COTIZACIONES
	// =========================================================================

	public static final String SPX_DEV5_UEN_CAPTURA_DE_COTIZACIONES_PAGE = SPXBase.assignUEN();
	public static final String SPX_DEV5_RFQ_CAPTURA_DE_COTIZACIONES_PAGE = "4";
	public static final String SPX_DEV5_PROCESO_CAPTURA_DE_COTIZACIONES_PAGE = "VL APO.- PAINTING 1";
	public static final String SPX_DEV5_REQUISICION_CAPTURA_DE_COTIZACIONES_PAGE = "2";
	public static final String SPX_DEV5_PROVEEDOR_CAPTURA_DE_COTIZACIONES_PAGE = SPXBase.randomSupplier();
	public static final String SPX_DEV5_COTIZACION_CAPTURA_DE_COTIZACIONES_PAGE = "2";
	public static final String SPX_DEV5_CENTRO_COSTOS_CAPTURA_DE_COTIZACIONES_PAGE = "F002 - CV - Global Purchasing Process Development";
	public static final String SPX_DEV5_FECHA_INICIO_CAPTURA_DE_COTIZACIONES_PAGE = "26/feb/2024";
	public static final String SPX_DEV5_FECHA_FIN_CAPTURA_DE_COTIZACIONES_PAGE = "05/may/2024";
	public static final String SPX_DEV5_REQUISITOR_CAPTURA_DE_COTIZACIONES_PAGE = "Buyatti Carlos Javier";
	public static final String SPX_DEV5_COMPRADOR_CAPTURA_DE_COTIZACIONES_PAGE = "SPX Cloud Dev";
	public static final String SPX_DEV5_BUSQUEDA_POR_PALABRA_CAPTURA_DE_COTIZACIONES_PAGE = "ART - 4549 EKJERE E";

	// =========================================================================
	// ADMINISTRACION DE ACCESOS
	// =========================================================================

	public static final String SPX_DEV5_DELEGADO = "SPX Cloud Dev";

	// =========================================================================
	// TEST DATA CATALOGS — Datos de prueba generales
	// =========================================================================
	public static final String SPX_DEV5_DESCRIPTION_NEW_ITEM_PAGE = SPXBase.randomDescriptionItem();
	public static final String SPX_DEV5_COST_CENTER_NEW_ITEM_PAGE = "A003-Finance Plant Controllers / Adm";
	public static final String SPX_DEV5_CODE_SUGGESTED_NEW_ITEM_PAGE = SPXBase.randomCodeSuggested();
	public static final String SPX_DEV5_EQUIPEMENT_MACHINE_TOOL_NEW_ITEM_PAGE = SPXBase.randomEquipementMachineTool();
	public static final String SPX_DEV5_MEASURES_NEW_ITEM_PAGE = SPXBase.randomMeasures();
	public static final String SPX_DEV5_ITEM_NEW_ITEM_PAGE = SPXBase.randomItem();
	public static final String SPX_DEV5_PHYSICAL_CHEMICAL_NEW_ITEM_PAGE = SPXBase.randomPhysicalChemical();
	public static final String SPX_DEV5_REFERENSE_NEW_ITEM_PAGE = SPXBase.randomReference();
	public static final String SPX_DEV5_MANUFACTURER_NEW_ITEM_PAGE = SPXBase.randomManufacturer();
	public static final String SPX_DEV5_PART_NUMBER_NEW_ITEM_PAGE = SPXBase.randomPartNumber();
	public static final String SPX_DEV5_PURCHASE_SPOT_ID_NEW_ITEM_PAGE = SPXBase.randomPurchaseSpotID();
	public static final String SPX_DEV5_ESTIMATED_NEW_ITEM_PAGE = SPXBase.randomEstimated();
	public static final String SPX_DEV5_SUGGESTED_MIN_NEW_ITEM_PAGE = SPXBase.randomSuggestedMin();
	public static final String SPX_DEV5_SUGGESTED_MAX_NEW_ITEM_PAGE = SPXBase.randomSuggestedMax();
}
