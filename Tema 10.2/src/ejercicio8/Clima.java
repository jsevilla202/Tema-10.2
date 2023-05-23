package ejercicio8;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Clima {
	private String[][] tiempo = new String[0][3];

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
		for (int i = 0; i < tiempo.length && existe == false; i++) {
			if (tiempo[i][0].equals(fecha)) {
				existe = true;
			}
		}
		if (existe == false) {
			int filas = tiempo.length;
			int col = tiempo.length > 0 ? tiempo[0].length : 3;
			String[][] nuevo = new String[filas + 1][3];

			for (int i = 0; i < filas; i++) {
				System.arraycopy(tiempo[i], 0, nuevo[i], 0, col);
			}

			String[] lineaAñadir = { fecha, String.valueOf(max), String.valueOf(min) };

			nuevo[filas] = lineaAñadir;

			tiempo = nuevo;
		} else {
			System.out.println("ERROR: Fecha introducida anteriormente");
		}
	}

	public void mostrar() {
		int max = 0;
		int min = 0;
		System.out.println("Fecha,Temperatura máxima,Temperatura mínima");
		for (int i = 0; i < tiempo.length; i++) {
			for (int j = 0; j < tiempo[0].length; j++) {
				System.out.print(j == 1 || j == 0 ? tiempo[i][j] + "," : tiempo[i][j]);
				if(j == 1 && max<Integer.valueOf(tiempo[i][j])) {
					max = Integer.valueOf(tiempo[i][j]);
				}
				if(j == 2 && min>Integer.valueOf(tiempo[i][j])) {
					min = Integer.valueOf(tiempo[i][j]);
				}
			}
			System.out.println();
		}
		System.out.println("La temperatura maxima ha sido: " + max);
		System.out.println("La temperatura minima ha sido: " + min);
	}
	
	public void salir() {
		BufferedWriter fw= null;
		try {
			fw = new BufferedWriter(new FileWriter("Clima.csv"));
			fw.write("Fecha,Temperatura máxima,Temperatura mínima");
			fw.newLine();
			for (int i = 0; i < tiempo.length; i++) {
				for (int j = 0; j < tiempo[0].length; j++) {
					if(j==0||j==1) {
					fw.write(tiempo[i][j] + ",");
					}else {
						fw.write(tiempo[i][j]);
					}
				}
				fw.newLine();
			}
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
				System.out.println("ERROR: No se ha podido cerrar el archivo");
			}
		}
	}
}
