package ejercicios1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Baraja deck = new BarajaFrancesa();
		List<Carta> jugador1 = new ArrayList<>();
		List<Carta> jugador2 = new ArrayList<>();
		deck.barajar();
		//deck.pintar();
		System.out.println("---JUGADOR 1---");
		jugador1 = deck.repartir();
		jugador2 = deck.repartir();
		for (int i = 0; i < jugador1.size(); i++) {
			System.out.println(jugador1.get(i).getNumero() + " de " + jugador1.get(i).getValor());
		}
		System.out.println("---JUGADOR 2---");
		for (int i = 0; i < jugador2.size(); i++) {
			System.out.println(jugador2.get(i).getNumero() + " de " + jugador2.get(i).getValor());
		}
		//PINTA TODA LA BARAJA
		/*
		for (int i = 0; i < deck.getBaraja().size(); i++) {
			System.out.println(deck.getBaraja().get(i).getNumero() + " de " + deck.getBaraja().get(i).getValor() );
		}*/
		System.out.println("------");
		//deck.pintar();
		

	}

	/* EJERCICIO 1 */
	public static void ejercicio1() { // revisar que no es string y que es menor o igual que 0
		int num, aleatorio, intentos = 0;
		String cad;
		aleatorio = (int) (Math.random() * 100) + 1;
		System.out.println("Aleatorio: " + aleatorio);

		System.out.println("Introduzca un n?mero del 0 al 100: ");
		Scanner teclado = new Scanner(System.in);
		cad = teclado.nextLine();
		try {
			num = Integer.parseInt(cad);
			for (int i = 0; i < 9; i++) {
				if (num < aleatorio) {
					System.out.println("El n?mero que estoy pensando es mayor, dime otro n?mero: ");
					intentos++;
					System.out.println("Intentos restantes: " + (10 - intentos));
					// }
				}
				if (num > aleatorio) {
					System.out.println("El n?mero que estoy pensando es menor, dime otro n?mero: ");
					intentos++;
					System.out.println("Intentos restantes: " + (10 - intentos));

				}
				num = teclado.nextInt();
				if (num == aleatorio) {
					System.out.println("?Muy bien!");
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
		System.out.println("Introduce una operaci?n:");
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
