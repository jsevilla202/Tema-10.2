package ejercicio1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
			try {
				FileWriter file = new FileWriter("NumerosReales.txt");
				for(int i = 1; i<=10; i++) {
					file.write(i + " ");
				}
				file.close();
			} catch (IOException e) {
				System.out.println("ERROR: Archivo no encontrado");
			}
			BufferedReader file = new BufferedReader(new FileReader("NumerosReales.txt"));
			int suma = 0;
			String[] todo = file.readLine().split(" ");
			for(int i=0; i<todo.length; i++) {
				suma += Integer.parseInt(todo[i]);
			}
			file.close();
			System.out.println("La suma de los numeros es: " + suma);
	}

}
