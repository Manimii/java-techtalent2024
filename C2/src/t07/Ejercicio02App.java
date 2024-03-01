package t07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Ejercicio02App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<HashMap> productos = new ArrayList<HashMap>();

		introducirProductos(productos);
		listarResultados(productos);
		
		sc.close();

	}

	public static void introducirProductos(ArrayList<HashMap> productos) {
		HashMap<String, Object> producto = new HashMap<String, Object>();
		producto.put("nombre", "pan");
		producto.put("precio", 0.50);
		producto.put("IVA", 0.04);
		productos.add(producto);

		producto = new HashMap<String, Object>();
		producto.put("nombre", "galletas");
		producto.put("precio", 2.50);
		producto.put("IVA", 0.21);
		productos.add(producto);

		producto = new HashMap<String, Object>();
		producto.put("nombre", "queso");
		producto.put("precio", 4.50);
		producto.put("IVA", 0.21);
		productos.add(producto);

	}

	public static void listarResultados(ArrayList<HashMap> productos) {
		int countIVA4 = 0;
		int countIVA21 = 0;

		for (int i = 0; i < productos.size(); i++) {
			double iva = (double) productos.get(i).get("IVA");

			if (iva == 0.04) {
				countIVA4++;
			} else if (iva == 0.21) {
				countIVA21++;
			}
		}

		System.out.println("IVA de los productos:");
		System.out.println("Productos con IVA del 4%: " + countIVA4);
		System.out.println("Productos con IVA del 21%: " + countIVA21 + "\n");

		System.out.println("Precio total: ");
		System.out.println("Bruto: " + precioTotalBruto(productos));
		System.out.println("Con IVA: " + precioTotalIVA(productos) + "\n");
		
		System.out.println("Número de artículos comprados: " + productos.size() + "\n");
		
		double efectivo = Double.parseDouble(JOptionPane.showInputDialog("Paga"));
		while (efectivo < precioTotalIVA(productos)) {
			efectivo = Double.parseDouble(JOptionPane.showInputDialog("Dinero insuficiente. Paga"));
		}
		System.out.println("Cantidad pagada: " + efectivo);
		System.out.println("Cambio a devolver: " + (efectivo - precioTotalIVA(productos)));
		

	}

	public static double precioTotalBruto(ArrayList<HashMap> productos) {
		double precio = 0;

		for (int i = 0; i < productos.size(); i++) {
			precio += (double) productos.get(i).get("precio");
		}

		return precio;
	}

	public static double precioTotalIVA(ArrayList<HashMap> productos) {
		double precio = 0;

		for (int i = 0; i < productos.size(); i++) {
			precio += (double) productos.get(i).get("precio")
					+ ((double) productos.get(i).get("precio") * (double) productos.get(i).get("IVA"));
		}

		return precio;
	}
	

}
