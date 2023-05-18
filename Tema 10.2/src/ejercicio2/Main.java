package ejercicio2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		FileWriter file = null;
		try {
			file = new FileWriter("Enteros.txt");
			for (int i = 1; i <= 10; i++) {
				for (int j = 0; j < 2; j++) {
					file.write(String.valueOf((int) (Math.random() * 100)));
					file.write("\t");
					file.write(String.valueOf((int) (Math.random() * 100)));
					file.write(" ");
				}
				file.write("\n");
				file.write(" ");
			}
		} catch (

		IOException e) {
			System.out.println("ERROR: IOException");
		} finally {
			try {
				file.flush();
			} catch (IOException e) {
				System.out.println("ERROR: No se pudo realizar el flush");
			}
			try {
				file.close();
			} catch (IOException e) {
				System.out.println("ERROR: El archivo no pudo ser cerrado");
			}
		}
		
		Scanner sc = null;
		try {
			int suma = 0;
			int i = 0;
			sc = new Scanner(new FileReader("Enteros.txt"));
			while(sc.hasNextInt()) {
				i++;
				suma += sc.nextInt();
			}
			System.out.println("La suma total de los numeros es: " + suma + " y la media es: " + suma/i);
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: Archivo no encontrado");
		}
		finally {
			sc.close();
		}
	}

}
