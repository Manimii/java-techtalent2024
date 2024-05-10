package t10.ejercicio04;

public class calculadora {

	private int a;
	private int b;
	
	/*
	 * Constructor para operaciones con 2 operadores
	 */
	public calculadora(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	/*
	 * Constructor para operaciones de un único operador (Como las raíces)
	 */
	public calculadora(int a) {
		this.a = a;
	}

	public int suma() {
		return a + b;
	}
	
	public int resta() {
		return a - b;
	}
	
	public int multiplicacion() {
		return a * b;
	}
	
	public int potencia() {
		return (int) Math.pow(a, b);
	}
	
	public double raizCuadrada() {
		return (double) Math.sqrt(a);
	}
	
	public double raizCubica() {
		return (double) Math.cbrt(a);
	}
	
	public int division() {
		return a / b;
	}
}
