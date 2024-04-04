package t09.ejercicio04;

public class Raices {

	private double a;
	private double b;
	private double c;

	public Raices(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	private double getDiscriminante() {
		return (b * b) - (4 * a * c);
	}

	private boolean tieneRaices() {
		return getDiscriminante() > 0;
	}

	private boolean tieneRaiz() {
		return getDiscriminante() == 0;
	}

	public void calcular() {
		if (tieneRaices()) {
			obtenerRaices();
		} else if (tieneRaiz()) {
			obtenerRaiz();
		} else {
			System.out.println("La ecuación no tiene solución real.");
		}
	}

	private void obtenerRaices() {
		double resultado1 = 0, resultado2 = 0;

		resultado1 = (-b + Math.sqrt(getDiscriminante())) / (2 * a);
		resultado2 = (-b - Math.sqrt(getDiscriminante())) / (2 * a);

		System.out.println("Resultado 1: " + resultado1);
		System.out.println("Resultado 2: " + resultado2);
	}

	private void obtenerRaiz() {
		double resultado = (-b + Math.sqrt(getDiscriminante())) / (2 * a);
		System.out.println("Resultado: " + resultado);
	}
}
