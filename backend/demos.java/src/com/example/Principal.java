package com.example;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		String s = "Hola";
		s += " mundo";
		Dias dia = Dias.DOMINGO;
		
		System.out.println(s + dia);
	}

}


-------aqui-----
public static void ejercicio2() {
	Scanner sc = new Scanner(System.in);

	// entrada de una cadena
	String name = sc.nextLine();

	// String string = "123-654321";
	String[] parts = name.split("-");
	String part1 = parts[0]; // 123
	String part2 = parts[1]; // 654321
	System.out.println(part1 + part2);
}

/*
 * private static String[] ejercicio2(){ Scanner sc = new Scanner(System.in);
 * 
 * // entrada de una cadena String cadena = sc.nextLine();
 * System.out.println("Separator: " + separator); String[] parts = null;
 * if(separator.equals("-")||
 * separator.equals("*")||separator.equals("+")||separator.equals("=")){ //Es
 * metacaracter! parts = cadena.split("\\"+separator); }else{ //No es
 * metacaracter. parts = cadena.split(separator); } return parts; }
 */

}
/*
* while (!teclado.hasNextInt()) { teclado.next();
* System.err.print("That wasn't an int number. Try again: "); }
*/

//while (guess <= -1) {  // we do not want negative number
//try{
//        guess = keyboard.nextInt();
//    }catch (InputMismatchException e){
//        System.out.println("Invalid - try again.");
//        continue;
//    }
//
//if (guess >= 0) {
//    break;
//}
//System.out.println("We want between 0 and 9 - try again.");
//}