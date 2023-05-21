package ejercicio1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		FileWriter file = null;
		try {
			file = new FileWriter("NumerosReales.txt");
			for (int i = 1; i <= 10; i++) {
				file.write(i + " ");
			}
		} catch (IOException e) {
			System.out.println("ERROR: Archivo no encontrado");
		} finally {
			try {
				file.close();
			} catch (IOException e) {
				System.out.println("ERROR: No se pudo cerrar el archivo");
			}
		}

		BufferedReader reader = null;
		int suma = 0;
		try {
			reader = new BufferedReader(new FileReader("NumerosReales.txt"));
			String[] todo = reader.readLine().split(" ");
			for (int i = 0; i < todo.length; i++) {
				suma += Integer.parseInt(todo[i]);
			}
		} catch (IOException e) {
			System.out.println("ERROR: Archivo no encontrado");
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				System.out.println("ERROR: No se pudo cerrar el archivo");
			}
		}

		System.out.println("La suma de los números es: " + suma);
	}

}
