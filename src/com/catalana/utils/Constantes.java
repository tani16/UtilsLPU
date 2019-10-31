package com.catalana.utils;

public class Constantes {
	private Constantes() {
	    throw new IllegalStateException("Utility class");
	  }

	//Archivos
	public static final String FILE_TEMPLATE_DESA 	= "C:\\PruebasUnitarias\\Temporal\\plantillaDesa.cbl";
	public static final String FILE_TEMPLATE_PRE  	= "C:\\PruebasUnitarias\\Temporal\\plantillaPRE.cbl";
	public static final String FILE_RAWDATA	   		= "C:\\PruebasUnitarias\\Temporal\\rawData.txt";
	public static final String FILE_SYSOUT			= "C:\\PruebasUnitarias\\SYSOUT"; 
	public static final String FILE_TEST_BEFORE  	= "C:\\PruebasUnitarias\\Temporal\\Before.txt";
	public static final String FILE_TEST_AFTER   	= "C:\\PruebasUnitarias\\Temporal\\After.txt";
	public static final String FILE_LANZADOR_DESA   = "C:\\PruebasUnitarias\\Temporal\\LANZADOR.cbl";
	public static final String FILE_LANZADOR_PRE    = "C:\\PruebasUnitarias\\Temporal\\LANZ_PRE.cbl";
	public static final String FILE_DEST_DESA       = "C:\\COBOL\\LANZADOR\\LANZADOR\\LANZADOR.cbl";
	public static final String FILE_DEST_PRE        = "C:\\COBOL\\LANZADOR_PRE\\LANZADOR_PRE\\LANZ_PRE.cbl";
	public static final String FILE_RESULT_AFTER    = "C:\\PruebasUnitarias\\Temporal\\ResultAfter.txt";
	public static final String FILE_RESULT_BEFORE   = "C:\\PruebasUnitarias\\Temporal\\ResultBefore.txt";
	public static final String FILE_NOTEPAD         = "C:\\Program Files (x86)\\Notepad++\\notepad++.exe";
	
	//Rutas
	public static final String RUTA_TEMPORAL      	= "C:\\PruebasUnitarias\\Temporal\\";
	public static final String RUTA_ORIGEN        	= "C:\\COBOL\\Origen\\";
	public static final String RUTA_MODIFICADO     	= "C:\\COBOL\\Modificado\\";
	public static final String RUTA_COBOL			= "C:\\COBOL\\";
	public static final String RUTA_BIN				= "C:\\COBOL\\bin\\";
	
	//Espacios
	public static final String SPACES_7 			= "       ";
	public static final String SPACES_11 			= "           ";
	public static final String SPACES_15 			= "               ";
	public static final String SPACES_18			= "                  ";
	public static final String SPACES_31 			= "                               ";
	
	//Constantes Cobol
	public static final String FINAL_PRE 			= "       END PROGRAM LANZAPRE.";
	public static final String FINAL_DESA			= "       END PROGRAM LANZADOR";
	public static final String GOBACK 				= "           GOBACK.";
	public static final String NEW_TEST_COMMENT 	= "      * ---------- NUEVO TEST -------------*";
	public static final String DISPLAY_TEST     	= "           DISPLAY '#LPU - NEW TEST CASE'.";
	public static final String COPY_GENRETSP        = "       COPY GENRETSP.";
	public static final String COPY_GENRETOR        = "       COPY GENRETOR.";
	public static final String ROLLBACK				= "           EXEC SQL ROLLBACK END-EXEC.";


	//Literales
	public static final String ERROR = "Error";
	public static final String WARNING = "Error";

	public static final String SPLIT_TEST_KEY   	= "#LPU - NEW TEST CASE";
	public static final String SPLIT_LINE_KEY   	= "#";
}
