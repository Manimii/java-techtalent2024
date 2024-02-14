package t06;

import javax.swing.JOptionPane;

public class Ejercicio01App {

	public static void main(String[] args) {
		pedirFigura();
	}

	public static double areaCirculo(double radio) {
		return radio * radio * Math.PI;
	}

	public static double areaTriangulo(double base, double altura) {
		return (base * altura) / 2;
	}

	public static double areaCuadrado(double lado) {
		return lado * lado;
	}

	public static void pedirFigura() {
		double area = 0;
		String figura = JOptionPane
				.showInputDialog(
						"Introduce la figura de la que quieras calcular el area (Círculo, Triángulo, Cuadrado)")
				.toLowerCase();

		String resultado = "El area del " + figura + " es ";

		switch (figura) {
		case "círculo":
			double radio = Double.parseDouble(JOptionPane.showInputDialog("Introduce el radio del círculo"));
			area = areaCirculo(radio);
			resultado += area;
			break;
		case "triángulo":
			double base = Double.parseDouble(JOptionPane.showInputDialog("Introduce la base del triángulo"));
			double altura = Double.parseDouble(JOptionPane.showInputDialog("Introduce la altura del triángulo"));
			area = areaTriangulo(base, altura);
			resultado += area;
			break;
		case "cuadrado":
			double lado = Double.parseDouble(JOptionPane.showInputDialog("Introduce el lado del cuadrado"));
			area = areaCuadrado(lado);
			resultado += area;
			break;
		default:
			resultado = "Error";
			break;
		}

		JOptionPane.showMessageDialog(null, resultado);
	}
}
