package ejercicios1;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;

/*EJERCICIO 4*/
public class Decodificar {
	public static final int CONSTANTE = 1;

	public static void main(String[] args) throws IOException {
		String[] cadena = decodifica();

		Calculadora c = new Calculadora();
		double resultado = 0;
		
		FileWriter fichero = null;
		try {

			fichero = new FileWriter("Salida.txt");
			
			for (int i = 0; i < cadena.length; i++) {
				double operando = Double.parseDouble(cadena[i].substring(0, cadena[i].length() - 1));
				char operador = cadena[i].charAt(cadena[i].length() - 1);

				resultado = c.calcular(operando, operador);

			}
			
			for (String linea : cadena) {
				fichero.write(linea + "\n");
			}
			
			fichero.write(" ---------- " + "\n" +  new BigDecimal(resultado).setScale(16, CONSTANTE).doubleValue());
			System.out.println("el resul aqui " + new BigDecimal(resultado).setScale(16, CONSTANTE).doubleValue());
			fichero.close();

		} catch (Exception ex) {
			System.out.println("Mensaje de la excepción: " + ex.getMessage());
		}

		
		System.out.println("resultado " + resultado);

	}

	public static String[] decodifica() throws IOException {
		File fichero = new File("C://eclipse-jee-2021-12-R-win32-x86_64/Entrada.txt");
		Scanner sc = null;
		String str = "";
		
		try {
			System.out.println("Leemos el fichero");
			sc = new Scanner(fichero);

			while (sc.hasNextLine()) {
				str = sc.nextLine(); 
				System.out.println(str);
			}
		} catch (Exception ex) {
			System.out.println("Excepción: " + ex.getMessage());
		} finally {
			try {
				if (sc != null)
					sc.close();
			} catch (Exception ex2) {
				System.out.println("Excepción2: " + ex2.getMessage());
			}
		}

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
