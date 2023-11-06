package com.metalsa.spx.dev5.main;

public class GlobalVariablesSPX {
	public static final int DEFAULT_TIMEOUT = 10;
	public static final int SHORT_TIMEOUT = 3000;
	public static final String SPX_DEV5_PATH_SCREENSHOTS = System.getProperty("user.dir")+"/test-output/screenshots/";
	public static final String SPX_DEV5_PATH_FILES = "C:\\Users\\fernando.villalba\\Documents\\files\\DocumentoDePrueba.txt";

	// Data Logging
	public static final String PATH_JSON_DATA = "./src/test/resources/testDataSPX/json/";

	// Data Home
	public static final String SPX_DEV5_UEN_HOME = "//option[@value='number:300000871351061']";

	// Data Spot Buy Requisitions
	public static final String SPX_DEV5_DESCRIPTION_SPOT_PAGE = "PRUEBA AUTOMATIZADA SPOT";
	public static final String SPX_DEV5_MATERIAL_SPOT_PAGE = "ORO";
	public static final String SPX_DEV5_COLOR_SPOT_PAGE = "DORADO";
	public static final String SPX_DEV5_BRAND_SPOT_PAGE = "STEREN";
	public static final String SPX_DEV5_MEASUREMENTS_SPOT_PAGE = "12 CM";
	public static final String SPX_DEV5_MODELPARTNUMBER_SPOT_PAGE = "TEST001";
	public static final String SPX_DEV5_GENERICNAME_SPOT_PAGE = "ARTICULO DE PRUEBA";
	public static final String SPX_DEV5_CATEGORY_SPOT_PAGE = "Administrativo y Profesional";
	public static final String SPX_DEV5_FAMILY_SPOT_PAGE = "Publicidad y Mercadotecnia";
	public static final String SPX_DEV5_SUBFAMILY_SPOT_PAGE = "Servicios de mercadotecnia";
	public static final String SPX_DEV5_UNIT_OF_MEASURE_SPOT_PAGE = "PINT";
	public static final String SPX_DEV5_GENERIC_ITEM_SPOT_PAGE = "GENERIC001";
	public static final String SPX_DEV5_QUANTITY_SPOT_PAGE = "10";
	public static final String SPX_DEV5_COMMENTS_TO_BUYER_SPOT_PAGE = "COMENTARIOS DE PRUEBA 001";
	public static final String SPX_DEV5_SELECT_MONTH_NEED_BY_DATE_SPOT_PAGE = "//select/option[@value='10']";
	public static final String SPX_DEV5_SELECT_YEAR_NEED_BY_DATE_SPOT_PAGE = "//select/option[@value='2023']";
	public static final String SPX_DEV5_SELECT_DAY_NEED_BY_DATE_SPOT_PAGE = "//a[@class='ui-state-default'][@href='#'][text()='28']";
	public static final String SPX_DEV5_SELECT_CATEGORY_OPTION_SPOT_PAGE = "//li[contains(.,'"
			+ GlobalVariablesSPX.SPX_DEV5_CATEGORY_SPOT_PAGE + "')]";
	public static final String SPX_DEV5_SELECT_FAMILY_OPTION_SPOT_PAGE = "//li[contains(.,'"
			+ GlobalVariablesSPX.SPX_DEV5_FAMILY_SPOT_PAGE + "')]";
	public static final String SPX_DEV5_SELECT_SUBFAMILY_OPTION_SPOT_PAGE = "//li[contains(.,'"
			+ GlobalVariablesSPX.SPX_DEV5_SUBFAMILY_SPOT_PAGE + "')]";
	public static final String SPX_DEV5_SELECT_UNIT_OF_MEASURE_OPTION_SPOT_PAGE = "//li[contains(.,'"
			+ GlobalVariablesSPX.SPX_DEV5_UNIT_OF_MEASURE_SPOT_PAGE + "')]";

	// Data Shopping Cart
	public static final String SPX_DEV5_COMMENTS_SHOPPING_CART = "COMENTARIOS EN EL CARRITO DE COMPRAS";

	// Data Account Configuration
	public static final String SPX_DEV5_PROJECT_ACCOUNT_CONFIGURATION_PAGE = "027463 - REPLACEMENT ROBOTIC ARNESS";
	public static final String SPX_DEV5_TASK_ACCOUNT_CONFIGURATION_PAGE = "02 Transportation";
	public static final String SPX_DEV5_RESOURSE_ACCOUNT_CONFIGURATION_PAGE = "Import Freight";
	public static final String SPX_DEV5_BUYER_ACCOUNT_CONFIGURATION_PAGE = "García Martínez Carlos Israel";
	public static final String SPX_DEV5_COST_CENTER_ACCOUNT_CONFIGURATION_PAGE = "A047 - HD - Labor & Compliance";
	public static final String SPX_DEV5_ACCOUNT_CC_ACCOUNT_CONFIGURATION_PAGE = "002 - A047 - 620100000001 / Cuotas y Subscripciones - 0000";
	public static final String SPX_DEV5_SELECT_PROJECT_ACCOUNT_CONFIGURATION_PAGE = "//li[contains(.,'"
			+ SPX_DEV5_PROJECT_ACCOUNT_CONFIGURATION_PAGE + "')]";
	public static final String SPX_DEV5_SELECT_TASK_ACCOUNT_CONFIGURATION_PAGE = "//li[contains(.,'"
			+ SPX_DEV5_TASK_ACCOUNT_CONFIGURATION_PAGE + "')]";
	public static final String SPX_DEV5_SELECT_RESOURSE_ACCOUNT_CONFIGURATION_PAGE = "//li[contains(.,'"
			+ SPX_DEV5_RESOURSE_ACCOUNT_CONFIGURATION_PAGE + "')]";
	public static final String SPX_DEV5_SELECT_BUYER_ACCOUNT_CONFIGURATION_PAGE = "//li[contains(.,'"
			+ SPX_DEV5_BUYER_ACCOUNT_CONFIGURATION_PAGE + "')]";
	public static final String SPX_DEV5_SELECT_COST_CENTER_ACCOUNT_CONFIGURATION_PAGE = "//li[contains(.,'"
			+ SPX_DEV5_COST_CENTER_ACCOUNT_CONFIGURATION_PAGE + "')]";
	public static final String SPX_DEV5_SELECT_ACCOUNT_CC_ACCOUNT_CONFIGURATION_PAGE = "//li[contains(.,'"
			+ SPX_DEV5_ACCOUNT_CC_ACCOUNT_CONFIGURATION_PAGE + "')]";
}
