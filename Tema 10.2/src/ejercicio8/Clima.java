package ejercicio8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Clima {
	private String[][] tiempo = new String[0][3];
	private int max = -999999;
	private int min = 999999;

	public void start() {
		Scanner sc = null;
		try {
			sc = new Scanner(new FileReader("Clima.csv"));
			List<String> lineas = new ArrayList<>();
			// Leer todas las lineas menos la primera y la última
			while (sc.hasNextLine()) {
				String linea = sc.nextLine();
				lineas.add(linea);
			}
			if (lineas.size() > 1) {
				lineas.remove(0); // Quita la primera linea
				lineas.remove(lineas.size() - 1); // Quita la ultima linea
			}

			int numFilas = lineas.size();
			int numColumnas = 3; // Siempre hay 3 columnas
			String[][] nuevo = new String[numFilas][numColumnas];

			// Pasa la colección a un array
			for (int rowIndex = 0; rowIndex < numFilas; rowIndex++) {
				String line = lineas.get(rowIndex);
				String[] lineArray = line.split(",");
				nuevo[rowIndex] = lineArray;
			}

			this.tiempo = nuevo;
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: Archivo no encontrado");
		} finally {
			if (sc != null) {
				sc.close();
			}
		}
	}

	public void menu() {
		System.out.println("Clima");
		System.out.println("====================");
		System.out.println(" 1. Registra nueva temperatura.");
		System.out.println(" 2. Mostrar historial de registros.");
		System.out.println(" 3. Salir.");
		System.out.print("¿Qué desa hacer? ");
	}

	public void añadir(String fecha, int max, int min) {
		boolean existe = false;
		for (int i = 0; i < tiempo.length && !existe; i++) {
			if (tiempo[i][0].equals(fecha)) {
				existe = true;
			}
		}
		if (!existe) {
			int filas = tiempo.length;
			String[][] nuevo = new String[filas + 1][3];

			for (int i = 0; i < filas - 1; i++) {
				System.arraycopy(tiempo[i], 0, nuevo[i], 0, 3);
			}

			String[] lineaAñadir = { fecha, String.valueOf(max), String.valueOf(min) };

			nuevo[filas - 1] = lineaAñadir;

			tiempo = nuevo;
		} else {
			System.out.println("ERROR: Fecha introducida anteriormente");
		}
	}

	public void mostrar() {
		System.out.println("Fecha,Temperatura máxima,Temperatura mínima");
		for (int i = 0; i < tiempo.length; i++) {
			if (tiempo[i][0] != null) {
				for (int j = 0; j < tiempo[i].length; j++) {
					System.out.print(tiempo[i][j]);
					if (j < tiempo[i].length - 1) {
						System.out.print(",");
					}
					if (j == 1 && this.max < Integer.parseInt(tiempo[i][j])) {
						this.max = Integer.parseInt(tiempo[i][j]);
					}
					if (j == 2 && this.min > Integer.parseInt(tiempo[i][j])) {
						this.min = Integer.parseInt(tiempo[i][j]);
					}
				}
				System.out.println();
			}
		}
		System.out.println();
		System.out.println("La temperatura máxima ha sido: " + max);
		System.out.println("La temperatura mínima ha sido: " + min);
	}

	public void checkTemp() {
		BufferedReader fw = null;

		try {
			fw = new BufferedReader(new FileReader("Clima.csv"));
			String linea;
			fw.readLine();

			while ((linea = fw.readLine()) != null) {
				String[] partes = linea.split(",");
				int max = Integer.parseInt(partes[1]);
				int min = Integer.parseInt(partes[2]);

				if (max > this.max) {
					this.max = max;
				}
				if (min < this.min) {
					this.min = min;
				}
			}
		} catch (IOException e) {
			System.out.println("ERROR: No se ha podido encontrar el archivo");
		} finally {
			try {
				fw.close();
			} catch (IOException e) {
				System.out.println("ERROR: No se ha podido cerrar el archivo");
			}
		}
	}

	public void salir() {
		BufferedWriter fw = null;
		try {
			fw = new BufferedWriter(new FileWriter("Clima.csv"));
			fw.write("Fecha,Temperatura máxima,Temperatura mínima");
			fw.newLine();
			for (int i = 0; i < tiempo.length; i++) {
				if (tiempo[i][0] != null) {
					for (int j = 0; j < tiempo[i].length; j++) {
						fw.write(tiempo[i][j]);
						if (j < tiempo[i].length - 1) {
							fw.write(",");
						}
					}
					fw.newLine();
				}
			}

			fw.newLine();
			fw.write("Temp. Max: " + String.valueOf(max) + " Temp. Min: " + String.valueOf(min));
		} catch (IOException e) {
			System.out.println("ERROR: Archivo no encontrado");
		} finally {
			try {
				if (fw != null) {
					fw.flush();
					fw.close();
				}
			} catch (IOException e) {
				System.out.println("ERROR: No se ha podido cerrar el archivo");
			}
		}
	}

}
