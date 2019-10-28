package com.catalana.utils;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

public class TratamientoFicheros {

	private TratamientoFicheros() {
	    throw new IllegalStateException("Utility class");
	}
	
	
	/**
	 * 
	 * @param tipo - Indica si se realizará la prueba en Preproducción o en Desarrollo
	 * @return BuffereReader, listo para ir leyendo línea a línea.
	 * @throws ExceptionLPU 
	 */
	public static BufferedReader openTemplateLanzador (String tipo) throws ExceptionLPU {
		
		String file;
		
		if (("DESA").equals(tipo)) {
			file = Constantes.FILE_TEMPLATE_DESA;
		}else {
			file = Constantes.FILE_TEMPLATE_PRE;
		}
				
		return openReaderFile(file);
		
	}
	
	/**
	 * 
	 * @param tipo - Indica si se realizará la prueba en Preproducción o en Desarrollo
	 * @return BufferedWriter listo para ser escrito linea a linea
	 * @throws ExceptionLPU
	 */
	public static BufferedWriter createLanzador(String tipo) throws ExceptionLPU {
		
		BufferedWriter lanzador;
		FileWriter fileWriter;
		String fileName = ("DESA").equals(tipo) ? "LANZADOR.cbl" : "LANZ_PRE.cbl";
		
		
		try {
			fileWriter = new FileWriter(Constantes.RUTA_TEMPORAL + fileName);
			lanzador = new BufferedWriter(fileWriter);
		}catch (IOException e) {
			throw new ExceptionLPU(Constantes.ERROR, "Error al crear el archivo lanzador con las pruebas unitarias", "E");
		}
		
		return lanzador;
		
	}
	
	/**
	 * 
	 * @param file ruta de la fila
	 * @param append si es true escribe al final del archivo en vez de sobreescribir
	 * @return
	 * @throws ExceptionLPU
	 */
	public static BufferedWriter openWriterFile(String file, boolean append) throws ExceptionLPU {

		File filAux = new File(file);
		BufferedWriter writer;
		FileWriter fileWriter;
		try {
			fileWriter = new FileWriter(file, append);
			writer = new BufferedWriter(fileWriter);
		} catch (Exception e) {
			throw new ExceptionLPU(Constantes.ERROR, "Error al leer el archivo " + file, "E");
		}

		return writer;

	}
	
	/**
	 * 
	 * @param file - Ruta + nombre del fichero a abrir para leer
	 * @return BuffereReader, listo para ir leyendo línea a línea.
	 * @throws ExceptionLPU 
	 */
	public static BufferedReader openReaderFile(String file) throws ExceptionLPU {
		
		FileReader fileReader;
		BufferedReader bufferReader; 
				
		try {
			fileReader = new FileReader(file);
			bufferReader = new BufferedReader(fileReader);
		}catch (FileNotFoundException e) {
			throw new ExceptionLPU(Constantes.ERROR, "Fichero [" + file + "] no encontrado", "E");
		}
				
		return bufferReader;
		
	}
	
	
	public static ArrayList<String> getArrayFromFile(String file) throws ExceptionLPU {
		
		ArrayList<String> archivo = new ArrayList<String>();
		String linea;
		BufferedReader reader = openReaderFile(file);
		
		try {
			linea = reader.readLine();
			while(linea != null) {
				archivo.add(linea);
				linea = reader.readLine();
			}
			reader.close();
		} catch (IOException e) {
			throw new ExceptionLPU(Constantes.ERROR, "Se ha producido un error al leer el fichero [" + file + "]", "E");
		}
		
		return archivo;
	}
	
	public static ArrayList<String> getDisplaysFormatted(String file) throws ExceptionLPU {
		
		ArrayList<String> displays = new ArrayList<String>();
		String linea;
		BufferedReader reader = openReaderFile(file);
		
		try {
			linea = reader.readLine();
			reader.close();
		} catch (IOException e) {
			throw new ExceptionLPU(Constantes.ERROR, "Se ha producido un error al leer el fichero [" + file + "]", "E");
		}
		
		String[] aux = linea.split(Constantes.SPLIT_TEST_KEY);
		
		for (String displayTest : aux) {
			displays.add(displayTest);
		}
		
		return displays;
	}
	
	public static void moveDll(String modulo, String tipo) throws ExceptionLPU {
		Path origenPath;
		if("Before".equals(tipo)) {
			origenPath = FileSystems.getDefault().getPath(Constantes.RUTA_ORIGEN + modulo + "\\obj\\x64\\Debug\\" + modulo + ".dll");    
		}else {
			origenPath = FileSystems.getDefault().getPath(Constantes.RUTA_MODIFICADO + modulo + "\\obj\\x64\\Debug\\" + modulo + ".dll");
		}
		Path destinoPath = FileSystems.getDefault().getPath(Constantes.RUTA_BIN + modulo + ".dll");
		
		try {
			Files.copy(origenPath, destinoPath, StandardCopyOption.REPLACE_EXISTING);
		}catch (Exception e) {
			throw new ExceptionLPU(Constantes.ERROR, "Se ha producido un error al mover el archivo dll de origen a la carpeta temporal", "E");
		}
	}
	
	public static void moveFile(Path origen, Path destino) throws ExceptionLPU {
	
		try {
			Files.copy(origen, destino, StandardCopyOption.REPLACE_EXISTING);
		}catch (Exception e) {
			throw new ExceptionLPU(Constantes.ERROR, "Se ha producido un error al mover el archivo [" + origen.getFileName() + "]", "E");
		}
	}


	public static void bwClose(BufferedWriter lanzador) throws ExceptionLPU {

		try {
			lanzador.close();
		} catch (IOException e) {
			throw new ExceptionLPU(Constantes.ERROR, "Se ha producido un error al cerrar el fichero", "E");
		}
	}
	
	public static void deteleFile(Path file) throws ExceptionLPU {
		
		
		try {
			Files.deleteIfExists(file);
		} catch (IOException e) {
			throw new ExceptionLPU(Constantes.ERROR, "Se ha producido un error al eliminar el archivo de la carpeta temporal", "E");
		}
	}


	public static void openNotepad() throws ExceptionLPU {
		
		ProcessBuilder pb = new ProcessBuilder(Constantes.FILE_NOTEPAD, Constantes.FILE_RESULT_AFTER, Constantes.FILE_RESULT_BEFORE);
		try {
			pb.start();
		} catch (IOException e) {
			throw new ExceptionLPU(Constantes.ERROR, "Se ha producido un error al abrir el Notepad", "E");
		}
		
	}
	
	
	
	
	
	
}
