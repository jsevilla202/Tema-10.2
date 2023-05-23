package ejercicio8;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int max = 0;
		int min = 0;
		int opcion = 0;
		int año;
		int mes;
		int dia;
		String fecha;
		Scanner sc = new Scanner(System.in);
		Clima clima = new Clima();
		while (opcion != 3) {
			clima.menu();
			opcion = sc.nextInt();
			switch (opcion) {
			case 1:
				System.out.println("Inserte los datos que se le pediran a continuacio: ");
				System.out.print("Año: ");
				año = sc.nextInt();
				System.out.print("Mes: ");
				mes = sc.nextInt();
				if (mes > 0 && mes < 13) {
					System.out.print("Día: ");
					dia = sc.nextInt();
					if (dia > 0 && dia < 32) {
						fecha = año + "-" + String.format("%02d", mes) + "-" + String.format("%02d", dia);
						System.out.print("Inserte la temperatura maxima: ");
						max = sc.nextInt();
						System.out.print("Inserte la temperatura minima: ");
						min = sc.nextInt();
						if (max >= min) {
							clima.añadir(fecha, max, min);
						} else {
							System.out.println("ERROR: La temperatura minima no puede ser mayor a la maxima");
						}
					} else {
						System.out.println("ERROR: Día introducido no valido");
					}
				} else {
					System.out.println("ERROR: Mes introducido no valido");
				}
				break;
			case 2:
				clima.mostrar();
				break;
			case 3:
				System.out.println("Saliendo....");
				clima.salir();
				break;
			}
			System.out.println();
		}
		sc.close();
	}

}
