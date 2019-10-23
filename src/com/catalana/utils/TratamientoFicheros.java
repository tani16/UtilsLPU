package com.catalana.utils;


import java.awt.Container;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class TratamientoFicheros {

	private TratamientoFicheros() {
	    throw new IllegalStateException("Utility class");
	}
	
	
	/**
	 * 
	 * @param tipo - Indica si se realizar� la prueba en Preproducci�n o en Desarrollo
	 * @return BuffereReader, listo para ir leyendo l�nea a l�nea.
	 * @throws FileNotFoundException
	 */
	public static BufferedReader openTemplateLanzador (String tipo) throws FileNotFoundException {
		
		String file;
		
		if (("PRE").equals(tipo)) {
			file = Constantes.FILE_LANZADOR_DESA;
		}else {
			file = Constantes.FILE_LANZADOR_PRE;
		}
				
		return openReaderFile(file);
		
	}
	
	/**
	 * 
	 * @param tipo - Indica si se realizar� la prueba en Preproducci�n o en Desarrollo
	 * @return BufferedWriter listo para ser escrito linea a linea
	 * @throws Exception
	 */
	public static BufferedWriter createLanzador(String tipo) throws Exception {
		
		BufferedWriter lanzador;
		FileWriter fileWriter;
		String fileName = ("PRE").equals(tipo) ? "LANZADOR.cbl" : "LANZ_PRE.cbl";
		
		
		try {
			fileWriter = new FileWriter(Constantes.RUTA_TEMPORAL + fileName);
			lanzador = new BufferedWriter(fileWriter);
		}catch (Exception e) {
			throw new Exception();
		}
		
		return lanzador;
		
	}
	
	/**
	 * 
	 * @param file - Ruta + nombre del fichero a abrir para leer
	 * @return BuffereReader, listo para ir leyendo l�nea a l�nea.
	 * @throws FileNotFoundException
	 */
	public static BufferedReader openReaderFile(String file) throws FileNotFoundException {
		
		FileReader fileReader;
		BufferedReader bufferReader; 
				
		try {
			fileReader = new FileReader(file);
			bufferReader = new BufferedReader(fileReader);
		}catch (FileNotFoundException e) {
			throw new FileNotFoundException();
		}
				
		return bufferReader;
		
	}
	
	public static ArrayList<String> getArrayFromFile(String file) throws FileNotFoundException {
		
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return archivo;
	}
	
	public static void moveDllAfter(String modulo) throws ExceptionLPU {
		Path origenPath = FileSystems.getDefault().getPath(Constantes.RUTA_ORIGEN + modulo + "\\" + modulo + ".CBL");
		Path destinoPath = FileSystems.getDefault().getPath(Constantes.RUTA_BIN + modulo + ".CBL");
		
		try {
			Files.move(origenPath, destinoPath, StandardCopyOption.REPLACE_EXISTING);
		}catch (Exception e) {
			throw new ExceptionLPU(Constantes.ERROR, "Se ha producido un error al mover el archivo dll de origen a la carpeta temporal", "E");
		}
	}
	
}
