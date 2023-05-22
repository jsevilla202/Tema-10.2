package ejercicio6;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		FileWriter writer1 = null;
		Scanner sc = null;
		FileWriter writer2 = null;

		int numeros[] = new int[0];
		
		try {
			writer1 = new FileWriter("ejercicio6.1.txt");
			for(int i = 0; i< (int) (Math.random()*20); i++) {
				writer1.write((int) (Math.random()*100) + "\n");
			}
		} catch (IOException e) {
			System.out.println("ERROR: Archivo no encontrado");
		}finally {
			try {
				writer1.flush();
			} catch (IOException e1) {
				System.out.println("ERROR: No se ha podido realizar el flush");
			}
			try {
				writer1.close();
			} catch (IOException e) {
				System.out.println("ERROR: El archivo no se pudo cerrar");
			}
		}
		
		try {
			sc = new Scanner(new FileReader("ejercicio6.1.txt"));
			while(sc.hasNext()) {
				numeros = Arrays.copyOf(numeros, numeros.length+1);
				numeros[numeros.length-1] = sc.nextInt();
			}
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: Archivo no encontrado");
		}finally {
			sc.close();
		}
		
		Arrays.sort(numeros);
		
		try {
			writer2 = new FileWriter("ejercicio6.2.txt");
			for(int i = 0; i<numeros.length; i++) {
				writer2.write(numeros[i] + "\n");
			}
		} catch (IOException e) {
			System.out.println("ERROR: Archivo no encontrado");
		}finally {
			try {
				writer2.flush();
			} catch (IOException e1) {
				System.out.println("ERROR: No se ha podido realizar el flush");
			}
			try {
				writer2.close();
			} catch (IOException e) {
				System.out.println("ERROR: El archivo no se pudo cerrar");
			}
		}
	}

}
