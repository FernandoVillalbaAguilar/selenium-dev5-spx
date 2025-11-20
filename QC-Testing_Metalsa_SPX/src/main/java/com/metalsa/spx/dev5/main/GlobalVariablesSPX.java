package com.metalsa.spx.dev5.main;

public class GlobalVariablesSPX {
	public static final String SPX_DEV5_URL = "http://gpmtest2-app6:9103/SPX/";
	public static final int DEFAULT_TIMEOUT = 10;
	public static final int SHORT_TIMEOUT = 3000;
	public static final String CURRENCY = SPXBase.getRandomValue(SPXBase.moneda);
	public static final String SPX_DEV5_PATH_SCREENSHOTS = System.getProperty("user.dir") + "/test-output/screenshots/";
	public static final String SPX_DEV5_PATH_FILES = "C:\\Users\\fernando.villalba\\Documents\\files\\DocumentoDePrueba.txt";
	public static final int PICTURE_TYPE_PNG = 6;

	// Data Logging
	public static final String PATH_JSON_DATA = "./src/test/resources/testDataSPX/json/";

	// Data Home
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

	public static final String SPX_DEV5_NUM_UEN = "300000871351009";
	public static final String SPX_DEV5_UEN_HOME = "//option[@value='number:" + GlobalVariablesSPX.SPX_DEV5_NUM_UEN
			+ "']";

	// Data Spot Buy Requisitions
	// Global Sourcing RFQ Header
	public static final String SPX_DEV5_GLOBAL_SOURCING_RFQ_SPOT_PAGE = "868 - Tooling";
	public static final String SPX_DEV5_SELECT_GLOBAL_SOURCING_RFQ_SPOT_PAGE = "//li[contains(.,'"
			+ GlobalVariablesSPX.SPX_DEV5_GLOBAL_SOURCING_RFQ_SPOT_PAGE + "')]";
	// First Section
	public static final String SPX_DEV5_DESCRIPTION_SPOT_PAGE = "PRUEBA AUTOMATIZADA SPOT - "
			+ SPXBase.getRandomValue(SPXBase.numRand);
	public static final String SPX_DEV5_MATERIAL_SPOT_PAGE = SPXBase.getRandomValue(SPXBase.material);
	public static final String SPX_DEV5_COLOR_SPOT_PAGE = SPXBase.getRandomValue(SPXBase.color);
	public static final String SPX_DEV5_BRAND_SPOT_PAGE = SPXBase.getRandomValue(SPXBase.marca);
	public static final String SPX_DEV5_MEASUREMENTS_SPOT_PAGE = SPXBase.getRandomValue(SPXBase.medidas);
	public static final String SPX_DEV5_MODELPARTNUMBER_SPOT_PAGE = "TEST - " + SPXBase.getRandomValue(SPXBase.numRand);
	public static final String SPX_DEV5_GENERICNAME_SPOT_PAGE = "ARTICULO DE PRUEBA - "
			+ SPXBase.getRandomValue(SPXBase.numRand);
	// Second Section
	// Español
	public static final String SPX_DEV5_CATEGORY_SPOT_PAGE_ESP = "Administrativo y Profesional";
	public static final String SPX_DEV5_FAMILY_SPOT_PAGE_ESP = "Publicidad y Mercadotecnia";
	public static final String SPX_DEV5_SUBFAMILY_SPOT_PAGE_ESP = "Medios impresos y Artículos promocionales";
	// Ingles
	public static final String SPX_DEV5_CATEGORY_SPOT_PAGE_ENG = "Administrative & Professional";
	public static final String SPX_DEV5_FAMILY_SPOT_PAGE_ENG = "Advertising & Marketing";
	public static final String SPX_DEV5_SUBFAMILY_SPOT_PAGE_ENG = "Printed Media & Promotional Items";

	public static final String SPX_DEV5_UNIT_OF_MEASURE_SPOT_PAGE = SPXBase.getRandomValue(SPXBase.unidadDeMedida);
	public static final String SPX_DEV5_GENERIC_ITEM_SPOT_PAGE = "GENERIC - " + SPXBase.getRandomValue(SPXBase.numRand);
	public static final String SPX_DEV5_QUANTITY_SPOT_PAGE = SPXBase.getRandomValue(SPXBase.quantity);
	public static final String SPX_DEV5_SELECT_MONTH_NEED_BY_DATE_SPOT_PAGE = "//select/option[@value='10']";
	public static final String SPX_DEV5_SELECT_YEAR_NEED_BY_DATE_SPOT_PAGE = "//select/option[@value='2024']";
	public static final String SPX_DEV5_SELECT_DAY_NEED_BY_DATE_SPOT_PAGE = "//a[@class='ui-state-default'][@href='#'][text()='28']";
	// Español
	public static final String SPX_DEV5_SELECT_CATEGORY_OPTION_SPOT_PAGE_ESP = "//li[contains(.,'"
			+ SPX_DEV5_CATEGORY_SPOT_PAGE_ESP + "')]";
	public static final String SPX_DEV5_SELECT_FAMILY_OPTION_SPOT_PAGE_ESP = "//li[contains(.,'"
			+ SPX_DEV5_FAMILY_SPOT_PAGE_ESP + "')]";
	public static final String SPX_DEV5_SELECT_FAMILY_OPTION__NEW_LINE_SPOT_PAGE_ESP = "//div[@id='formSpot:nwcboFamilias0_panel']//li[contains(.,'"
			+ SPX_DEV5_FAMILY_SPOT_PAGE_ESP + "')]";
	public static final String SPX_DEV5_SELECT_SUBFAMILY_OPTION_SPOT_PAGE_ESP = "//li[contains(.,'"
			+ SPX_DEV5_SUBFAMILY_SPOT_PAGE_ESP + "')]";
	public static final String SPX_DEV5_SELECT_SUBFAMILY_OPTION_NEW_LINE_SPOT_PAGE_ESP = "//div[@id='formSpot:nwcboSubFamilias0_panel']//li[contains(.,'"
			+ SPX_DEV5_SUBFAMILY_SPOT_PAGE_ESP + "')]";
	// Ingles
	public static final String SPX_DEV5_SELECT_CATEGORY_OPTION_SPOT_PAGE_ENG = "//li[contains(.,'"
			+ SPX_DEV5_CATEGORY_SPOT_PAGE_ENG + "')]";
	public static final String SPX_DEV5_SELECT_FAMILY_OPTION_SPOT_PAGE_ENG = "//li[contains(.,'"
			+ SPX_DEV5_FAMILY_SPOT_PAGE_ENG + "')]";
	public static final String SPX_DEV5_SELECT_FAMILY_OPTION__NEW_LINE_SPOT_PAGE_ENG = "//div[@id='formSpot:nwcboFamilias0_panel']//li[contains(.,'"
			+ SPX_DEV5_FAMILY_SPOT_PAGE_ENG + "')]";
	public static final String SPX_DEV5_SELECT_SUBFAMILY_OPTION_SPOT_PAGE_ENG = "//li[contains(.,'"
			+ SPX_DEV5_SUBFAMILY_SPOT_PAGE_ENG + "')]";
	public static final String SPX_DEV5_SELECT_SUBFAMILY_OPTION_NEW_LINE_SPOT_PAGE_ENG = "//div[@id='formSpot:nwcboSubFamilias0_panel']//li[contains(.,'"
			+ SPX_DEV5_SUBFAMILY_SPOT_PAGE_ENG + "')]";

	public static final String SPX_DEV5_SELECT_UNIT_OF_MEASURE_OPTION_SPOT_PAGE = "//li[contains(.,'"
			+ SPX_DEV5_UNIT_OF_MEASURE_SPOT_PAGE + "')]";
	// CheckUgent
	public static final String SPX_DEV5_REASON_UGENT_SPOT_PAGE = SPXBase.getRandomValue(SPXBase.razonUrgencia);
	public static final String SPX_DEV5_REASON_UGENT_SPOT_PAGE_ENG = SPXBase.getRandomValue(SPXBase.razonUrgenciaENG);
	public static final String SPX_DEV5_SELECT_REASON_URGENT_SPOT_PAGE = "//div[@id='formSpot:razonUrg_panel']//li[contains(.,'"
			+ SPX_DEV5_REASON_UGENT_SPOT_PAGE + "')]";
	public static final String SPX_DEV5_SELECT_REASON_URGENT_SPOT_PAGE_ENG = "//div[@id='formSpot:razonUrg_panel']//li[contains(.,'"
			+ SPX_DEV5_REASON_UGENT_SPOT_PAGE_ENG + "')]";
	// Third Section
	public static final String SPX_DEV5_COMMENTS_TO_BUYER_SPOT_PAGE = "COMENTARIOS DE PRUEBA  - "
			+ SPXBase.getRandomValue(SPXBase.numRand);

	// Data Shopping Cart
	public static final String SPX_DEV5_COMMENTS_SHOPPING_CART = "COMENTARIOS EN EL CARRITO DE COMPRAS";

	// Data Account Configuration
	public static final String SPX_DEV5_PROJECT_ACCOUNT_CONFIGURATION_PAGE = "100075 - UAT GTO OPEX";
	public static final String SPX_DEV5_TASK_ACCOUNT_CONFIGURATION_PAGE = "Travel expenses";
	public static final String SPX_DEV5_RESOURSE_ACCOUNT_CONFIGURATION_PAGE = "Travel Expenses";
	public static final String SPX_DEV5_BUYER_ACCOUNT_CONFIGURATION_PAGE = "Revillas Contreras Ana María";
	// Project
	public static final String SPX_DEV5_SELECT_PROJECT_ACCOUNT_CONFIGURATION_PAGE = "//li[contains(.,'"
			+ SPX_DEV5_PROJECT_ACCOUNT_CONFIGURATION_PAGE + "')]";
	public static final String SPX_DEV5_SELECT_TASK_ACCOUNT_CONFIGURATION_PAGE = "//li[contains(.,'"
			+ SPX_DEV5_TASK_ACCOUNT_CONFIGURATION_PAGE + "')]";
	public static final String SPX_DEV5_SELECT_RESOURSE_ACCOUNT_CONFIGURATION_PAGE = "//li[contains(.,'"
			+ SPX_DEV5_RESOURSE_ACCOUNT_CONFIGURATION_PAGE + "')]";
	public static final String SPX_DEV5_SELECT_BUYER_ACCOUNT_CONFIGURATION_PAGE = "//li[contains(.,'"
			+ SPX_DEV5_BUYER_ACCOUNT_CONFIGURATION_PAGE + "')]";
	// Second Line Project
	public static final String SPX_DEV5_SELECT_PROJECT_NEW_LINE_ACCOUNT_CONFIGURATION_PAGE = "(//li[@data-label='"
			+ SPX_DEV5_PROJECT_ACCOUNT_CONFIGURATION_PAGE + "'][normalize-space()='"
			+ SPX_DEV5_PROJECT_ACCOUNT_CONFIGURATION_PAGE + "'])[2]";
	public static final String SPX_DEV5_SELECT_TASK_NEW_LINE_ACCOUNT_CONFIGURATION_PAGE = "(//li[@data-label='"
			+ SPX_DEV5_TASK_ACCOUNT_CONFIGURATION_PAGE + "'][normalize-space()='"
			+ SPX_DEV5_TASK_ACCOUNT_CONFIGURATION_PAGE + "'])[2]";
	public static final String SPX_DEV5_SELECT_RESOURSE_NEW_LINE_ACCOUNT_CONFIGURATION_PAGE = "(//li[@data-label='"
			+ SPX_DEV5_RESOURSE_ACCOUNT_CONFIGURATION_PAGE + "'][normalize-space()='"
			+ SPX_DEV5_RESOURSE_ACCOUNT_CONFIGURATION_PAGE + "'])[2]";
	public static final String SPX_DEV5_SELECT_BUYER_NEW_LINE_ACCOUNT_CONFIGURATION_PAGE = "(//li[@data-label='"
			+ SPX_DEV5_BUYER_ACCOUNT_CONFIGURATION_PAGE + "'][normalize-space()='"
			+ SPX_DEV5_BUYER_ACCOUNT_CONFIGURATION_PAGE + "'])[2]";
	// CC
	public static final String SPX_DEV5_COST_CENTER_ACCOUNT_CONFIGURATION_PAGE = "F044 - CV - Global Procurement / Supplier Development";
	public static final String SPX_DEV5_ACCOUNT_CC_ACCOUNT_CONFIGURATION_PAGE = "097 - F044 - 620400000001 / Costos y Gastos InterUens (Cuenta Puente) - 0000 - 000";

	public static final String SPX_DEV5_SELECT_COST_CENTER_ACCOUNT_CONFIGURATION_PAGE = "//li[contains(.,'"
			+ SPX_DEV5_COST_CENTER_ACCOUNT_CONFIGURATION_PAGE + "')]";
	public static final String SPX_DEV5_SELECT_ACCOUNT_CC_ACCOUNT_CONFIGURATION_PAGE = "//li[contains(.,'"
			+ SPX_DEV5_ACCOUNT_CC_ACCOUNT_CONFIGURATION_PAGE + "')]";
	// Second Line CC
	public static final String SPX_DEV5_SELECT_COST_CENTER_NEW_LINE_ACCOUNT_CONFIGURATION_PAGE = "//div[@id='formCarroCompras:carroCompra0:1:j_idt248:0:cbmCC_panel']//li[contains(.,'"
			+ SPX_DEV5_COST_CENTER_ACCOUNT_CONFIGURATION_PAGE + "')]";
	public static final String SPX_DEV5_SELECT_ACCOUNT_CC_NEW_LINE_ACCOUNT_CONFIGURATION_PAGE = "//li[contains(.,'"
			+ SPX_DEV5_ACCOUNT_CC_ACCOUNT_CONFIGURATION_PAGE + "')]";

	// Data Single Source Format
	public static final String DESCRIPTION_FAD = "PRUEBA TEST CON FAD - " + SPXBase.getRandomValue(SPXBase.numRand);
	public static final String SUPPLIER_NAME_FAD = SPXBase.getRandomValue(SPXBase.proveedores);
	public static final String AMOUNT_FAD = SPXBase.getRandomValue(SPXBase.quantity);
	public static final String DETAILS_FAD = "DETALLES DEL SERVICIO DE PRUEBA - "
			+ SPXBase.getRandomValue(SPXBase.numRand);
	public static final String COMMENTS_FAD = "COMENTARIOS DE PRUEBA CON FAD - "
			+ SPXBase.getRandomValue(SPXBase.numRand);
	public static final String SINGLE_SOURCE_FORMAT_REASON = SPXBase.getRandomValue(SPXBase.singleSourceFormatReason);
	public static final String SELECT_CURRENCY = "//div[@class='ui-selectonemenu-items-wrapper']//li[contains(.,'"
			+ CURRENCY + "')]";

	// Administration Roles Menu
	public static final String SPX_DEV5_MENU_NAME_ADMINISTRATION_ROLES_MENU_PAGE = "Req. Rechazadas";
	public static final String SPX_DEV5_URL_PATH_ADMINISTRATION_ROLES_MENU_PAGE = "pages/internas/motor.jsf";

	// Administration Menu
	public static final String SPX_DEV5_MENU_NAME_ADMINISTRATION_MENU_PAGE = "Req. Rechazadas";
	public static final String SPX_DEV5_URL_PATH_ADMINISTRATION_MENU_PAGE = "pages/internas/motor.jsf";
	// Edit Menus
	public static final String SPX_DEV5_NAME_MENU_ADMINISTRATION_MENU_PAGE = "Prueba Menu";
	public static final String SPX_DEV5_DESCRIPTION_ESA_ADMINISTRATION_MENU_PAGE = "Item Prueba ESA";
	public static final String SPX_DEV5_DESCRIPTION_US_ADMINISTRATION_MENU_PAGE = "Item Prueba US";
	public static final String SPX_DEV5_DESCRIPTION_PTB_ADMINISTRATION_MENU_PAGE = "Item Prueba PTB";
	public static final String SPX_DEV5_ORDER_ADMINISTRATION_MENU_PAGE = "1";
	public static final String SPX_DEV5_CSSCLASS_ADMINISTRATION_MENU_PAGE = "CssClass Test";
	public static final String SPX_DEV5_FACES_ADMINISTRATION_MENU_PAGE = "pages/internas/motor.jsf";
	public static final String SPX_DEV5_CATEGORY_ADMINISTRATION_MENU_PAGE = "Motor de busqueda";
	public static final String SPX_DEV5_SELECT_CATEGORY_ADMINISTRATION_MENU_PAGE = "//div[@id='fList:j_idt81:0:j_idt113_panel']//li[contains(text(),'"
			+ SPX_DEV5_CATEGORY_ADMINISTRATION_MENU_PAGE + "')]";
	public static final String SPX_DEV5_PARENT_ADMINISTRATION_MENU_PAGE = "Vending Machine";
	public static final String SPX_DEV5_SELECT_PARENT_ADMINISTRATION_MENU_PAGE = "//div[@id='fList:j_idt81:0:j_idt131_panel']//li[contains(.,'"
			+ SPX_DEV5_PARENT_ADMINISTRATION_MENU_PAGE + "')]";
	public static final String SPX_DEV5_ACTIVE_ADMINISTRATION_MENU_PAGE = "Active";
	public static final String SPX_DEV5_SELECT_ACTIVE_ADMINISTRATION_MENU_PAGE = "(//li[@data-label='"
			+ SPX_DEV5_ACTIVE_ADMINISTRATION_MENU_PAGE + "'][normalize-space()='"
			+ SPX_DEV5_ACTIVE_ADMINISTRATION_MENU_PAGE + "'])[1]";
	public static final String SPX_DEV5_INACTIVE_ADMINISTRATION_MENU_PAGE = "Inactive";
	public static final String SPX_DEV5_SELECT_INACTIVE_ADMINISTRATION_MENU_PAGE = "(//li[@data-label='"
			+ SPX_DEV5_INACTIVE_ADMINISTRATION_MENU_PAGE + "'][normalize-space()='"
			+ SPX_DEV5_INACTIVE_ADMINISTRATION_MENU_PAGE + "'])[1]";
	public static final String SPX_DEV5_MENU_ROOT_ADMINISTRATION_MENU_PAGE = "Menu Root";
	public static final String SPX_DEV5_SELECT_MENU_ROOT_ADMINISTRATION_MENU_PAGE = "(//li[@data-label='"
			+ SPX_DEV5_MENU_ROOT_ADMINISTRATION_MENU_PAGE + "'][normalize-space()='"
			+ SPX_DEV5_MENU_ROOT_ADMINISTRATION_MENU_PAGE + "'])[1]";
	public static final String SPX_DEV5_MENU_SIMPLE_ADMINISTRATION_MENU_PAGE = "Menu Simple";
	public static final String SPX_DEV5_SELECT_MENU_SIMPLE_ADMINISTRATION_MENU_PAGE = "(//li[@data-label='"
			+ SPX_DEV5_MENU_SIMPLE_ADMINISTRATION_MENU_PAGE + "'][normalize-space()='"
			+ SPX_DEV5_MENU_SIMPLE_ADMINISTRATION_MENU_PAGE + "'])[1]";

	// Articulos Controlados
	public static final String SPX_DEV5_UEN_ARTICULOS_CONTROLADOS_PAGE = SPXBase.assignUEN();
	public static final String SPX_DEV5_LOCALIZACION_ARTICULOS_CONTROLADOS_PAGE = "Sterling Heights Plant - Sterling Heights";
	public static final String SPX_DEV5_CODIGO_PRODUCTO_ARTICULOS_CONTROLADOS_PAGE = "101004";
	public static final String SPX_DEV5_NOMBRE_FABRICANTE_ARTICULOS_CONTROLADOS_PAGE = "FABRICANTE DE PRUEBA - "
			+ SPXBase.getRandomValue(SPXBase.numRand);
	public static final String SPX_DEV5_NUM_PARTE_FABRICANTE_ARTICULOS_CONTROLADOS_PAGE = "101004";
	public static final String SPX_DEV5_NUM_PARTE_PROVEEDOR_ARTICULOS_CONTROLADOS_PAGE = "101004";
	public static final String SPX_DEV5_DESCRIPCION_ARTICULOS_CONTROLADOS_PAGE = "Abrazadera";
	public static final String SPX_DEV5_PICKLIST_SOURCE_ARTICULOS_CONTROLADOS_PAGE = "10105";
	public static final String SPX_DEV5_PICKLIST_TARGET_ARTICULOS_CONTROLADOS_PAGE = "Stopper";

	// Articulos por Procesar
	public static final String SPX_DEV5_UEN_ARTICULOS_POR_PROCESAR_PAGE = SPXBase.assignUEN();
	public static final String SPX_DEV5_REQUISICION_ARTICULOS_POR_PROCESAR_PAGE = "5";
	public static final String SPX_DEV5_REQUISITOR_ARTICULOS_POR_PROCESAR_PAGE = "Garza Cantu Edna Melissa";
	public static final String SPX_DEV5_COMPRADOR_ARTICULOS_POR_PROCESAR_PAGE = "Garza Cantu Edna Melissa";
	public static final String SPX_DEV5_ESTATUS_ARTICULOS_POR_PROCESAR_PAGE = "EN PROCESO";
	public static final String SPX_DEV5_FECHA_INICIO_ARTICULOS_POR_PROCESAR_PAGE = "26/oct/2023";
	public static final String SPX_DEV5_FECHA_FIN_ARTICULOS_POR_PROCESAR_PAGE = "23/dic/2025";
	// Busqueda Avanzada - Articulos por Procesar
	public static final String SPX_DEV5_PROCESO_ARTICULOS_POR_PROCESAR_PAGE = "VL APO.- PAINTING 1";
	public static final String SPX_DEV5_CENTRO_COSTOS_ARTICULOS_POR_PROCESAR_PAGE = "F002 - CV - Global Purchasing Process Development";
	public static final String SPX_DEV5_CATEGORIA_ARTICULOS_POR_PROCESAR_PAGE = "50 - Administrativo y Profesional";
	public static final String SPX_DEV5_FAMILIA_ARTICULOS_POR_PROCESAR_PAGE = "01 - Publicidad y Mercadotecnia";
	public static final String SPX_DEV5_SUBFAMILIA_ARTICULOS_POR_PROCESAR_PAGE = "03 - Medios impresos y Artículos promocionales";
	public static final String SPX_DEV5_TIPO_ARTICULOS_POR_PROCESAR_PAGE = "Refacción ";
	public static final String SPX_DEV5_PRIORIDAD_ARTICULOS_POR_PROCESAR_PAGE = "Refacción Normal";
	public static final String SPX_DEV5_JUSTIFICACION_ARTICULOS_POR_PROCESAR_PAGE = "Paro de línea";
	public static final String SPX_DEV5_BUSQUEDA_POR_PALABRA_ARTICULOS_POR_PROCESAR_PAGE = "F3F4F43F";

	// Captura de cotizaciones
	public static final String SPX_DEV5_UEN_CAPTURA_DE_COTIZACIONES_PAGE = SPXBase.assignUEN();
	public static final String SPX_DEV5_RFQ_CAPTURA_DE_COTIZACIONES_PAGE = "4";
	public static final String SPX_DEV5_PROCESO_CAPTURA_DE_COTIZACIONES_PAGE = "VL APO.- PAINTING 1";
	public static final String SPX_DEV5_REQUISICION_CAPTURA_DE_COTIZACIONES_PAGE = "2";
	public static final String SPX_DEV5_PROVEEDOR_CAPTURA_DE_COTIZACIONES_PAGE = SPXBase
			.getRandomValue(SPXBase.proveedores);
	public static final String SPX_DEV5_COTIZACION_CAPTURA_DE_COTIZACIONES_PAGE = "2";
	public static final String SPX_DEV5_CENTRO_COSTOS_CAPTURA_DE_COTIZACIONES_PAGE = "F002 - CV - Global Purchasing Process Development";
	public static final String SPX_DEV5_FECHA_INICIO_CAPTURA_DE_COTIZACIONES_PAGE = "26/feb/2024";
	public static final String SPX_DEV5_FECHA_FIN_CAPTURA_DE_COTIZACIONES_PAGE = "05/may/2024";
	public static final String SPX_DEV5_REQUISITOR_CAPTURA_DE_COTIZACIONES_PAGE = "Buyatti Carlos Javier";
	public static final String SPX_DEV5_COMPRADOR_CAPTURA_DE_COTIZACIONES_PAGE = "SPX Cloud Dev";
	public static final String SPX_DEV5_BUSQUEDA_POR_PALABRA_CAPTURA_DE_COTIZACIONES_PAGE = "ART - 4549 EKJERE E";
}
