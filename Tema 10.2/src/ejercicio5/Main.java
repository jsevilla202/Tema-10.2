package ejercicio5;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String nombre = "";
		int edad;
		FileWriter file = null;
		Scanner sc = new Scanner(System.in);
		try {
			file = new FileWriter("datos.txt", true);
			while (!nombre.equals("fin")) {
				System.out.print("Inserte el nombre: ");
				nombre = sc.next();
				if (!nombre.equals("fin")) {
					System.out.print("Inserte la edad: ");
					edad = sc.nextInt();
					if(edad>0) {
						file.write(nombre + " " + edad + "\n");
					}
				}
				System.out.println("========================");
			}
		} catch (IOException e) {
			System.out.println("ERROR: Archivo no encontrado");
		}finally {
			try {
				file.flush();
			} catch (IOException e1) {
				System.out.println("ERROR: No se ha podido realizar el flush");
			}
			try {
				file.close();
			} catch (IOException e) {
				System.out.println("ERROR: El archivo no se pudo cerrar");
			}
		}
		sc.close();
	}

}
