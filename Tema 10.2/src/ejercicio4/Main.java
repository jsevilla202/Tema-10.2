package ejercicio4;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		FileWriter file = null;
		Scanner sc = new Scanner(System.in);
		String linea = "";

		try {
			file = new FileWriter("Texto.txt");
			while (!linea.equals("fin")) {
				System.out.print("Inserte la línea a introducir o inserte fin para terminar: ");
				linea = sc.nextLine();
				if (!linea.equals("fin")) {
					file.write(linea + "\n");
				}
			}
		} catch (IOException e) {
			System.out.println("ERROR: Archivo no encontrado");
		} finally {
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
			sc.close();
		}
	}

}
