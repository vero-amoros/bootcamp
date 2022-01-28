package ejercicios1;

import java.util.Random;
import java.util.Scanner;

public class Principal { // revisar que no es string y que es menor o igual que 0

	public static void main(String[] args) {
		ejercicio1();

	}

	public static void ejercicio1() {
		int num, aleatorio, intentos = 0;
		String cad;
		aleatorio = (int) (Math.random() * 100) + 1;
		System.out.println("Aleatorio: " + aleatorio);

		System.out.println("Introduzca un número del 0 al 100: ");
		Scanner teclado = new Scanner(System.in);
		cad = teclado.nextLine();
		try {
			num = Integer.parseInt(cad);
			for (int i = 0; i < 9; i++) {
					if (num < aleatorio) {
						System.out.println("El número que estoy pensando es mayor, dime otro número: ");
						intentos++;
						System.out.println("Intentos restantes: " + (10-intentos));
						// }
					}
					if (num > aleatorio) {
						System.out.println("El número que estoy pensando es menor, dime otro número: ");
						intentos++;
						System.out.println("Intentos restantes: " + (10-intentos));
						
					}
					num = teclado.nextInt();
					if (num == aleatorio) {
						System.out.println("¡Muy bien!");
						break;
					}

					if (intentos == 9) {
						System.out.println("Lo siento, se han acabado los intentos");
						break;

					}
				

			}
		} finally {
			teclado.close();
		}
	}
}
