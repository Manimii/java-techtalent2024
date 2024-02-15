package t06;

import javax.swing.JOptionPane;

public class Ejercicio07App {

	public static void main(String[] args) {

		double euros = Double.parseDouble(JOptionPane.showInputDialog("Introduce una cantidad de euros"));
		String moneda = JOptionPane
				.showInputDialog("Introduce la moneda a la que quieres convertir los euros (libras, dolares o yenes)")
				.toLowerCase();
		cambioEuros(euros, moneda);
	}

	public static void cambioEuros(double euros, String moneda) {
		String resultado = euros + " euros equivalen a ";

		switch (moneda) {
		case "libras":
			double libras = euros * 0.86;
			resultado += libras + " " + moneda;
			break;
		case "dolares":
			double dolares = euros * 1.28611;
			resultado += dolares + " " + moneda;
			break;
		case "yenes":
			double yenes = euros * 129.852;
			resultado += yenes + " " + moneda;
			break;
		default:
			resultado = "Error al introducir la moneda";
			break;
		}

		JOptionPane.showMessageDialog(null, resultado);
	}
}
