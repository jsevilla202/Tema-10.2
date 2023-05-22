package ejercicio7;

import java.io.BufferedWriter;
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
		int aux = numero;
		while (aux != 0) {
			aux = aux / 10;
			i++;
		}
		
		if (i == 9 && agenda.size() < 20 && agenda.containsKey(nombre) == false) {
			agenda.put(nombre, numero);
		} else if (i != 9) {
			System.out.println("ERROR: Numero no valido");
		} else if(agenda.size() >= 20){
			System.out.println("ERROR: Limite de la capacidad de la agenda usada");
		}
		else {
			System.out.println("ERROR: Contacto ya añadido");
		}
	}
	
	public void buscar(String nombre) {
		if(agenda.containsKey(nombre)) {
			System.out.println("El numero de " + nombre + " es " + agenda.get(nombre));
		}
		else {
			System.out.println("ERROR: No existe ese nombre en la agenda");
		}
	}
	
	public void mostrarTodos() {
		 for (Map.Entry<String, Integer> agenda : agenda.entrySet()) {
	            System.out.println(agenda.getKey() + " " + agenda.getValue());
	        }
	}

	public void escribir(BufferedWriter fw) {
		try {
			for (Map.Entry<String, Integer> agenda : agenda.entrySet()) {
	            fw.write(agenda.getKey() + " " + agenda.getValue());
	            fw.newLine();
	        }
		} catch (IOException e) {
			System.out.println("ERROR: Archivo no encontrado");
		}
	}
}
