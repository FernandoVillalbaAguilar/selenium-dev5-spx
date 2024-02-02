package com.metalsa.spx.dev5.main;

public class GlobalVariablesSPX {
	public static final int DEFAULT_TIMEOUT = 10;
	public static final int SHORT_TIMEOUT = 3000;
	public static final String CURRENCY = "MXN";
	public static final String SPX_DEV5_PATH_SCREENSHOTS = System.getProperty("user.dir") + "/test-output/screenshots/";
	public static final String SPX_DEV5_PATH_FILES = "C:\\Users\\fernando.villalba\\Documents\\files\\DocumentoDePrueba.txt";
	public static final int PICTURE_TYPE_PNG = 6;

	// Data Logging
	public static final String PATH_JSON_DATA = "./src/test/resources/testDataSPX/json/";

	// Data Home
	public static final String SPX_DEV5_UEN_HOME = "//option[@value='number:300000871351061']";

	// Data Spot Buy Requisitions
	// Global Sourcing RFQ Header
	public static final String SPX_DEV5_GLOBAL_SOURCING_RFQ_SPOT_PAGE = "868 - Tooling";
	public static final String SPX_DEV5_SELECT_GLOBAL_SOURCING_RFQ_SPOT_PAGE = "//li[contains(.,'"
			+ GlobalVariablesSPX.SPX_DEV5_GLOBAL_SOURCING_RFQ_SPOT_PAGE + "')]";
	// First Section
	public static final String SPX_DEV5_DESCRIPTION_SPOT_PAGE = "PRUEBA AUTOMATIZADA SPOT";
	public static final String SPX_DEV5_MATERIAL_SPOT_PAGE = "ORO";
	public static final String SPX_DEV5_COLOR_SPOT_PAGE = "DORADO";
	public static final String SPX_DEV5_BRAND_SPOT_PAGE = "STEREN";
	public static final String SPX_DEV5_MEASUREMENTS_SPOT_PAGE = "12 CM";
	public static final String SPX_DEV5_MODELPARTNUMBER_SPOT_PAGE = "TEST";
	public static final String SPX_DEV5_GENERICNAME_SPOT_PAGE = "ARTICULO DE PRUEBA";
	// Second Section
	public static final String SPX_DEV5_CATEGORY_SPOT_PAGE = "Administrativo y Profesional";
	public static final String SPX_DEV5_FAMILY_SPOT_PAGE = "Publicidad y Mercadotecnia";
	public static final String SPX_DEV5_SUBFAMILY_SPOT_PAGE = "Servicios de mercadotecnia";
	public static final String SPX_DEV5_UNIT_OF_MEASURE_SPOT_PAGE = "PINT";
	public static final String SPX_DEV5_GENERIC_ITEM_SPOT_PAGE = "GENERIC";
	public static final String SPX_DEV5_QUANTITY_SPOT_PAGE = "10";
	public static final String SPX_DEV5_SELECT_MONTH_NEED_BY_DATE_SPOT_PAGE = "//select/option[@value='10']";
	public static final String SPX_DEV5_SELECT_YEAR_NEED_BY_DATE_SPOT_PAGE = "//select/option[@value='2024']";
	public static final String SPX_DEV5_SELECT_DAY_NEED_BY_DATE_SPOT_PAGE = "//a[@class='ui-state-default'][@href='#'][text()='28']";
	public static final String SPX_DEV5_SELECT_CATEGORY_OPTION_SPOT_PAGE = "//li[contains(.,'"
			+ SPX_DEV5_CATEGORY_SPOT_PAGE + "')]";
	public static final String SPX_DEV5_SELECT_FAMILY_OPTION_SPOT_PAGE = "//li[contains(.,'" + SPX_DEV5_FAMILY_SPOT_PAGE
			+ "')]";
	public static final String SPX_DEV5_SELECT_FAMILY_OPTION__NEW_LINE_SPOT_PAGE = "//div[@id='formSpot:nwcboFamilias0_panel']//li[contains(.,'"
			+ SPX_DEV5_FAMILY_SPOT_PAGE + "')]";
	public static final String SPX_DEV5_SELECT_SUBFAMILY_OPTION_SPOT_PAGE = "//li[contains(.,'"
			+ SPX_DEV5_SUBFAMILY_SPOT_PAGE + "')]";
	public static final String SPX_DEV5_SELECT_SUBFAMILY_OPTION_NEW_LINE_SPOT_PAGE = "//div[@id='formSpot:nwcboSubFamilias0_panel']//li[contains(.,'"
			+ SPX_DEV5_SUBFAMILY_SPOT_PAGE + "')]";
	public static final String SPX_DEV5_SELECT_UNIT_OF_MEASURE_OPTION_SPOT_PAGE = "//li[contains(.,'"
			+ SPX_DEV5_UNIT_OF_MEASURE_SPOT_PAGE + "')]";
	// CheckUgent
	public static final String SPX_DEV5_REASON_UGENT_SPOT_PAGE = "Afectación de calidad directa al cliente";
	public static final String SPX_DEV5_SELECT_REASON_URGENT_SPOT_PAGE = "//div[@id='formSpot:razonUrg_panel']//li[contains(.,'"
			+ SPX_DEV5_REASON_UGENT_SPOT_PAGE + "')]";
	// Third Section
	public static final String SPX_DEV5_COMMENTS_TO_BUYER_SPOT_PAGE = "COMENTARIOS DE PRUEBA 001";

	// Data Shopping Cart
	public static final String SPX_DEV5_COMMENTS_SHOPPING_CART = "COMENTARIOS EN EL CARRITO DE COMPRAS";

	// Data Account Configuration
	public static final String SPX_DEV5_PROJECT_ACCOUNT_CONFIGURATION_PAGE = "100087 - TEST LEASING";
	public static final String SPX_DEV5_TASK_ACCOUNT_CONFIGURATION_PAGE = "01 Leasing";
	public static final String SPX_DEV5_RESOURSE_ACCOUNT_CONFIGURATION_PAGE = "Leasing";
	public static final String SPX_DEV5_BUYER_ACCOUNT_CONFIGURATION_PAGE = "Garza Gonzalez Erik Eduardo";
	//Project
	public static final String SPX_DEV5_SELECT_PROJECT_ACCOUNT_CONFIGURATION_PAGE = "//li[contains(.,'"
			+ SPX_DEV5_PROJECT_ACCOUNT_CONFIGURATION_PAGE + "')]";
	public static final String SPX_DEV5_SELECT_TASK_ACCOUNT_CONFIGURATION_PAGE = "//li[contains(.,'"
			+ SPX_DEV5_TASK_ACCOUNT_CONFIGURATION_PAGE + "')]";
	public static final String SPX_DEV5_SELECT_RESOURSE_ACCOUNT_CONFIGURATION_PAGE = "//li[contains(.,'"
			+ SPX_DEV5_RESOURSE_ACCOUNT_CONFIGURATION_PAGE + "')]";
	public static final String SPX_DEV5_SELECT_BUYER_ACCOUNT_CONFIGURATION_PAGE = "//li[contains(.,'"
			+ SPX_DEV5_BUYER_ACCOUNT_CONFIGURATION_PAGE + "')]";
	//Second Line Project
	public static final String SPX_DEV5_SELECT_PROJECT_NEW_LINE_ACCOUNT_CONFIGURATION_PAGE = "//li[contains(.,'"
			+ SPX_DEV5_PROJECT_ACCOUNT_CONFIGURATION_PAGE + "')]";
	public static final String SPX_DEV5_SELECT_TASK_NEW_LINE_ACCOUNT_CONFIGURATION_PAGE = "//li[contains(.,'"
			+ SPX_DEV5_TASK_ACCOUNT_CONFIGURATION_PAGE + "')]";
	public static final String SPX_DEV5_SELECT_RESOURSE_NEW_LINE_ACCOUNT_CONFIGURATION_PAGE = "//li[contains(.,'"
			+ SPX_DEV5_RESOURSE_ACCOUNT_CONFIGURATION_PAGE + "')]";
	public static final String SPX_DEV5_SELECT_BUYER_NEW_LINE_ACCOUNT_CONFIGURATION_PAGE = "//li[contains(.,'"
			+ SPX_DEV5_BUYER_ACCOUNT_CONFIGURATION_PAGE + "')]";
	//CC
	public static final String SPX_DEV5_COST_CENTER_ACCOUNT_CONFIGURATION_PAGE = "A047 - HD - Labor & Compliance";
	public static final String SPX_DEV5_ACCOUNT_CC_ACCOUNT_CONFIGURATION_PAGE = "002 - A047 - 620100000001 / Cuotas y Subscripciones - 0000";
	
	public static final String SPX_DEV5_SELECT_COST_CENTER_ACCOUNT_CONFIGURATION_PAGE = "//li[contains(.,'"
			+ SPX_DEV5_COST_CENTER_ACCOUNT_CONFIGURATION_PAGE + "')]";
	public static final String SPX_DEV5_SELECT_ACCOUNT_CC_ACCOUNT_CONFIGURATION_PAGE = "//li[contains(.,'"
			+ SPX_DEV5_ACCOUNT_CC_ACCOUNT_CONFIGURATION_PAGE + "')]";
	//Second Line CC
	public static final String SPX_DEV5_SELECT_COST_CENTER_NEW_LINE_ACCOUNT_CONFIGURATION_PAGE = "//div[@id='formCarroCompras:carroCompra0:1:j_idt248:0:cbmCC_panel']//li[contains(.,'"
			+ SPX_DEV5_COST_CENTER_ACCOUNT_CONFIGURATION_PAGE + "')]";
	public static final String SPX_DEV5_SELECT_ACCOUNT_CC_NEW_LINE_ACCOUNT_CONFIGURATION_PAGE = "//li[contains(.,'"
			+ SPX_DEV5_ACCOUNT_CC_ACCOUNT_CONFIGURATION_PAGE + "')]";

	// Data Single Source Format
	public static final String DESCRIPTION_FAD = "PRUEBA TEST CON FAD";
	public static final String SUPPLIER_NAME_FAD = "ORBI LOGISTIC";
	public static final String AMOUNT_FAD = "100";
	public static final String DETAILS_FAD = "DETALLES DEL SERVICIO DE PRUEBA";
	public static final String COMMENTS_FAD = "COMENTARIOS DE PRUEBA CON FAD";
	public static final String SELECT_CURRENCY = "//div[@class='ui-selectonemenu-items-wrapper']//li[contains(.,'"
			+ CURRENCY + "')]";
}
