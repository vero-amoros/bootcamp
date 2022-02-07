package ejercicios1;

import java.util.Scanner;

/*EJERCICIO 4*/
public class Decodificar {

	public static void main(String[] args) {
		String[] cadena = decodifica();

		Calculadora c = new Calculadora();
		double resultado = 0;

		for (int i = 0; i < cadena.length; i++) {
			double operando = Double.parseDouble(cadena[i].substring(0, cadena[i].length() - 1));
			char operador = cadena[i].charAt(cadena[i].length() - 1);

			resultado = c.calcular(operando, operador);

		}
		System.out.println("resultado" + resultado);
		
		//PRUEBA
		
		System.out.println("----DIVIDIR " + c.dividir(6, 0));

	}


	public static String[] decodifica() {
		//System.out.println("Introduce una operación:");
		try (Scanner sc = new Scanner(System.in)) {
			// String str = sc.nextLine();
			String str = "3+4+3,4-7*1="; // prueba 3+4+3,4-7*1=

			str = str.replace(",", ".");

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
			return parts;

		}
	}

}
