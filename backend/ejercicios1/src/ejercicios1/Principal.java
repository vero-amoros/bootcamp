package ejercicios1;


import java.util.Scanner;

public class Principal { 

	public static void main(String[] args) {
		ejercicio2();

	}

	/* EJERCICIO 1 */
	public static void ejercicio1() { // revisar que no es string y que es menor o igual que 0
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
					System.out.println("Intentos restantes: " + (10 - intentos));
					// }
				}
				if (num > aleatorio) {
					System.out.println("El número que estoy pensando es menor, dime otro número: ");
					intentos++;
					System.out.println("Intentos restantes: " + (10 - intentos));

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

	/* EJERCICIO 2 */
	public static void ejercicio2() {
		System.out.println("Introduce una operación:");
		try (Scanner sc = new Scanner(System.in)) {
			String str = sc.nextLine();

			String str2 = str.replaceAll("\\+", " \\+");
			String str3 = str2.replaceAll("\\-", " \\-");
			String str4 = str3.replaceAll("\\*", " \\*");
			String str5 = str4.replaceAll("\\/", " \\/");
			String strfinal = str5.replaceAll("\\=", " \\=");

			String regex = "(?<=[-+*/()])";

			String[] parts = strfinal.split(regex);

			for (int i = 0; i < parts.length; i++) {
				System.out.println(parts[i]);
			}
		}
	}

}
