package t07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Ejercicio02App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Object> carritos = new ArrayList<Object>();
		HashMap<String, Double> carrito = new HashMap<String, Double>();
		System.out.println("Introduce el número de carritos");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println("IVA que se tiene que aplicar (4% o 21%):");
			double iva = sc.nextDouble();
			carrito.put("IVA", iva);

			System.out.println("Precio total bruto:");
			double precio = sc.nextDouble();
			double precioIva = precio + (precio * iva / 100);
			carrito.put("precio", precio);
			carrito.put("precio con iva", precioIva);

			System.out.println("Número de artículos comprados:");
			double nArticulos = sc.nextDouble();
			carrito.put("número de artículos", nArticulos);

			System.out.println("Cantidad pagada:");
			double cPagada = sc.nextDouble();
			carrito.put("cantidad pagada", cPagada);
			carrito.put("cambio", cPagada - precioIva);

			carritos.add(carrito);

		}

		System.out.println(carritos.toString());
		
		sc.close();

	}

}
