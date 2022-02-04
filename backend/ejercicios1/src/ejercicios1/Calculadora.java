package ejercicios1;

public class Calculadora {
	
	private double res = 0.0;
	private char pendiente = '+';


	public double calcular(double operando, char operador) {
		
		switch (pendiente) {
		case '+':
			res += operando;
			break;
		case '-':
			res -= operando;
			break;
		case '*':
			res *= operando;
			break;
		case '/':
			res /= operando;
			break;
		case '=':
			res += operando;
			System.out.println("resultado " + res);
		}
		pendiente = operador;
		return res;

	}
	
	public static double dividir(double n1, double n2) {
		return n1/n2;
	}
		
	

}
