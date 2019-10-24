package com.catalana.utils;

public class Constantes {
	public Constantes() {
	    throw new IllegalStateException("Utility class");
	  }

	//Archivos
	public static final String FILE_LANZADOR_DESA 	= "C:\\PruebasUnitarias\\Temporal\\plantillaDesa.cbl";
	public static final String FILE_LANZADOR_PRE  	= "C:\\PruebasUnitarias\\Temporal\\plantillaPRE.cbl";
	public static final String FILE_RAWDATA	   		= "C:\\PruebasUnitarias\\Temporal\\rawData.txt";
	public static final String FILE_SYSOUT			= "C:\\PruebasUnitarias\\SYSOUT"; 
	public static final String FILE_TEST_BEFORE  	= "C:\\PruebasUnitarias\\Temporal\\Before.txt";
	public static final String FILE_TEST_AFTER   	= "C:\\PruebasUnitarias\\Temporal\\After.txt";
	
	//Rutas
	public static final String RUTA_TEMPORAL      	= "C:\\PruebasUnitarias\\Temporal\\";
	public static final String RUTA_ORIGEN        	= "C:\\COBOL\\Origen\\";
	public static final String RUTA_MODIFICADO     	= "C:\\COBOL\\Modificado\\";
	public static final String RUTA_COBOL			= "C:\\COBOL\\";
	public static final String RUTA_BIN				= "C:\\COBOL\\bin\\";
	
	//Espacios
	public static final String SPACES_11 = "           ";
	public static final String SPACES_15 = "               ";
	public static final String SPACES_31 = "                               ";
	
	//Constantes Cobol
	public static final String FINAL_PRE = "       END PROGRAM LANZAPRE.";
	public static final String FINAL_DESA = "       END PROGRAM LANZADOR";
	public static final String GOBACK = "           GOBACK.";

	//Literales
	public static final String ERROR = "Error";
	public static final String NEW_TEST_COMMENT = "      * ---------- NUEVO TEST -------------*";
}
