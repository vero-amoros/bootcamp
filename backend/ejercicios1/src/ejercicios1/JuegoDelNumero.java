package ejercicios1;

import javax.swing.JOptionPane;

/* EJERCICIO 3 */
public class JuegoDelNumero {

	public static void main(String[] args) {
		int numusu = 0, numant = -1;
		int buscado = inicializar();
		int intentos = 1;

		do {
			// try {
			if (numant == -1) {
				numusu = Integer.parseInt(JOptionPane.showInputDialog("Introduzca un número del 0 al 100: "));
				numant = numusu;

			} else {
				numusu = Integer.parseInt(JOptionPane.showInputDialog(
						"Introduzca un número del 0 al 100: " + "\n" + "Acabas de probar el " + numant));
				numant = numusu;
			}
			intentos = jugada(buscado, numusu, intentos);
			// }
			// catch (NumberFormatException nfe) {
			// JOptionPane.showMessageDialog(null,"Tienes que introducir un número del 0 al
			// 100", "Error", JOptionPane.ERROR_MESSAGE);
			// }

			if (intentos == 10) {
				JOptionPane.showMessageDialog(null, "Lo siento, se han acabado los intentos");
				break;
			}

		} while (buscado != numusu);

		if (buscado == numusu)
			JOptionPane.showMessageDialog(null, "¡Muy bien! El número que estaba pensando era " + buscado);

	}

	public static int inicializar() {
		int aleatorio;
		aleatorio = (int) (Math.random() * 100) + 1;
		System.out.println("Aleatorio: " + aleatorio);
		return aleatorio;
	}

	public static int jugada(int aleatorio, int usu, int intentos) {
		int ale = aleatorio;
		int numusu = usu;

		if (ale > numusu) {
			JOptionPane.showMessageDialog(null,
					"El número que estoy pensando es MAYOR " + "\n" + "Intentos restantes: " + (10 - intentos));
			intentos++;
		}
		if (ale < numusu) {
			JOptionPane.showMessageDialog(null,
					"El número que estoy pensando es MENOR " + "\n" + "Intentos restantes: " + (10 - intentos));
			intentos++;
		}

		return intentos;
	}

}
