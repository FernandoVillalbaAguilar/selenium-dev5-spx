package com.metalsa.spx.dev5.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;

import org.apache.poi.util.Units;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.testng.Reporter;

/**
 * ====================================================================================
 * Class Name: SPXWordReportGenerator
 * ====================================================================================
 *
 * @author Fernando Villalba Aguilar
 * @date 28/Ago/2026
 *
 * @description Clase encargada de generar el documento Word (.docx) con las
 *              evidencias de ejecucion del caso de prueba dentro del framework
 *              de automatizacion SPX.
 *
 *              Esta clase centraliza: - Armado del documento Word (titulo,
 *              pasos, valores, imagenes). - Insercion de imagenes de evidencia
 *              con su nombre de archivo. - Guardado del documento final en la
 *              ruta de screenshots del framework.
 *
 *              Objetivo: Aislar la dependencia de Apache POI (XWPFDocument) del
 *              resto del framework, de forma que solo esta clase conozca los
 *              detalles de generacion del reporte Word.
 *              ====================================================================================
 */
public class SPXWordReportGenerator {

	// =========================================================================
	// Dependencies
	// =========================================================================

	private final SPXLogger logger;
	private final SPXUtils utils;

	// =========================================================================
	// Constructor
	// =========================================================================

	/**
	 * Constructor principal de la clase.
	 *
	 * @param logger instancia de SPXLogger utilizada para registrar errores durante
	 *               la generacion del documento.
	 * @param utils  instancia de SPXUtils utilizada para obtener el nombre del caso
	 *               de prueba actual (getTestCaseName) y la fecha/hora (date)
	 *               usadas en el nombre del archivo final.
	 */
	public SPXWordReportGenerator(SPXLogger logger, SPXUtils utils) {
		this.logger = logger;
		this.utils = utils;
	}

	// =========================================================================
	// Word Document Generation
	// =========================================================================

	/*
	 * @name: saveWordDocument
	 * 
	 * @date: 02/Nov/2023
	 * 
	 * @param: TreeMap<String, TreeMap<String, String>> word, List<String> steps,
	 * List<String> values
	 * 
	 * @return: N/A
	 * 
	 * @author: Fernando Villalba Aguilar
	 * 
	 * @description: Este metodo permite guardar en un documento de Word las
	 * capturas de pantalla asociadas a cada paso del caso de prueba.
	 * 
	 * Flujo: 1. Escribe el titulo del caso de prueba (nombre del test). 2. Por cada
	 * paso, escribe el texto "paso: valor" en negrita. 3. Inserta cada imagen de
	 * evidencia asociada a ese paso, con su nombre de archivo debajo en cursiva. 4.
	 * Agrega un salto de pagina despues de cada imagen. 5. Guarda el documento
	 * final en la ruta de screenshots del framework, nombrado con el testcase y la
	 * fecha/hora actuales.
	 */
	public void saveWordDocument(TreeMap<String, TreeMap<String, String>> word, List<String> steps,
			List<String> values) {
		// Save screenshot in Word document
		XWPFDocument document = new XWPFDocument();
		XWPFParagraph paragraph = document.createParagraph();
		XWPFRun run = paragraph.createRun();
		String testCaseName = utils.getTestCaseName(Reporter.getCurrentTestResult());
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
					+ testCaseName + "-" + utils.date() + ".docx");

			document.write(out);
			out.close();
			document.close();

		} catch (Exception e) {
			logger.logFrameworkError("> I could not save Word Document... ", e);
		}
	}
}