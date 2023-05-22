package ejercicio7;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int opcion = 0;
		String nombre;
		int numero;
		Scanner sc = new Scanner(System.in);
		FileWriter fw = null;
		Agenda ag = new Agenda();
		while (opcion != 4) {
			ag.menu();
			opcion = sc.nextInt();
			switch (opcion) {
			case 1: //Nuevo contacto
				System.out.println("Inserte el nombre de su contacto: ");
				nombre = sc.nextLine();
				System.out.println("Inserte el número de su contacto: ");
				numero = sc.nextInt();
				ag.añadir(nombre, numero);
				break;
			case 2: //Buscar por nombre
				break;
			case 3://Mostrar todos
				break;
			case 4: //salir
				System.out.println("Saliendo.....");
				try {
					fw = new FileWriter("agenda.txt");
					ag.escribir(fw);
				} catch (IOException e) {
					System.out.println("ERROR: Archivo no encontrado");
				} finally {
					try {
						fw.flush();
					} catch (IOException e1) {
						System.out.println("ERROR: No se ha podido realizar el flush");
					}
					try {
						fw.close();
					} catch (IOException e) {
						System.out.println("ERROR: El archivo no se pudo cerrar");
					}
				}
				break;
			}
			System.out.println();
		}
		sc.close();
	}

}
