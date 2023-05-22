package ejercicio7;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Agenda {
	Map<String, Integer> agenda = new TreeMap<String, Integer>();
	
	public void menu() {
		System.out.println("Agenda Pesonal");
		System.out.println("====================");
		System.out.println(" 1. Nuevo contacto.");
		System.out.println(" 2. Buscar por nombre.");
		System.out.println(" 3. Mostrar todos.");
		System.out.println(" 4. Salir.");
		System.out.print("¿Qué desa hacer? ");
	}
	
	public void añadir(String nombre, int numero) {
		int i = 0;
		while(numero!=0) {
			numero = numero/10;
			i++;
		}
		if(i)
	}
	
	public void escribir(FileWriter fw) {
		try {
			fw.write(agenda.toString());
		} catch (IOException e) {
			System.out.println("ERROR: Archivo no encontrado");
		}finally {
			try {
				fw.flush();
			} catch (IOException e) {
				System.out.println("ERROR: No se ha podido realizar el flush");
			}
			try {
				fw.close();
			} catch (IOException e) {
				System.out.println("ERROR: El archivo no se pudo cerrar");
			}
		}
	}
}
