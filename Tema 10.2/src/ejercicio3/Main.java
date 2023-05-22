package ejercicio3;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String nombre = "";
		int edad = 1;
		double altura = 1;

		Scanner sc = new Scanner(System.in);
		BufferedWriter file = null;

		try {
			file = new BufferedWriter(new FileWriter("Alumnos.txt"));
			while (!nombre.equals("fin")) {
				System.out.print("Inserte el nombre del alumno: ");
				nombre = sc.next();
				if (!nombre.equals("fin")) {
					System.out.print("Inserte la edad del alumno: ");
					edad = sc.nextInt();
					if (edad > 0) {
						System.out.print("Inserte la altura del alumno: ");
						altura = sc.nextDouble();
						if (altura > 0) {
							file.write(nombre + " ");
							file.write(edad + " ");
							file.write(String.valueOf(altura));
							file.newLine();
						} else {
							System.out.println("ERROR: La altura no puede ser negativa");
						}
					} else {
						System.out.println("ERROR: La edad no puede ser negativa");
					}
				}
				System.out.println("================");
			}
		} catch (IOException e) {
			System.out.println("ERROR: Archivo no encontrado");
		} finally {
			sc.close();
			try {
				try {
					file.flush();
				} catch (IOException e1) {
					System.out.println("ERROR: No se ha podido realizar el flush");
				}
				file.close();
			} catch (IOException e) {
				System.out.println("ERROR: El archivo no se ha podido cerrar");
			}
		}
		Scanner reader = null;
		try {
			int sumaEdad = 0;
			double sumaAltura = 0;
			int i = 0;
			reader = new Scanner(new FileReader("Alumnos.txt"));
			while (reader.hasNext()) {
			    String valor = reader.next();
			    if (reader.hasNextInt()) {
			        sumaEdad += reader.nextInt();
			    } else if (valor.matches("\\d+\\.\\d+")) {
			        sumaAltura += Double.parseDouble(valor);
			    }
			    i++;
			}
			System.out.println();
			System.out
					.println("Las estadisticas son:\n Suma total de edades: " + sumaEdad + "\n Suma total de alturas: "
							+ sumaAltura + "\n Media Edad: " + sumaEdad / i + "\n Media Altura: " + sumaAltura / i);
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: Archivo no encontrado");
		} finally {
			reader.close();
		}
	}
}
