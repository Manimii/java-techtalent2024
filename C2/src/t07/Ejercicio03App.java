package t07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Ejercicio03App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<HashMap> articulos = new ArrayList<HashMap>();

		addStarterArticles(articulos);

		String nombre = "";
		int cantidad = 0;
		double precio = 0, iva = 0.21;

		int choose = 0;
		while (choose != 4) {
			listaMenu();
			choose = sc.nextInt();
			switch (choose) {
			case 1:
				// Añadir artículo
				System.out.println("nombre del artículo:");
				nombre = sc.next();

				System.out.println("cantidad de artículos que hay:");
				cantidad = sc.nextInt();

				System.out.println("precio del artículo:");
				precio = sc.nextDouble();

				System.out.println("IVA del producto (0.04 o 0.21):");
				iva = sc.nextDouble();
				while (iva != 0.04 && iva != 0.21) {
					iva = sc.nextDouble();
				}

				addArticle(articulos, nombre, cantidad, precio, iva);
				break;
			case 2:
				// Consultar artículo
				System.out.println("nombre del producto que quieres consultar:");
				nombre = sc.next();
				getArticle(articulos, nombre);
				break;
			case 3:
				// Listar todo los artículos
				listArticles(articulos);
				break;
			case 4:
				break;
			default:
				System.out.println("Error. Debes introducir una opción válida.");
			}
		}
	}

	public static void addArticle(ArrayList<HashMap> articulos, String nombre, int cantidad, double precio,
			double iva) {
		HashMap<String, Object> articulo = new HashMap<String, Object>();
		articulo.put("nombre", nombre);
		articulo.put("cantidad", cantidad);
		articulo.put("precio", precio);
		articulo.put("IVA", iva);

		articulos.add(articulo);
	}

	public static void getArticle(ArrayList<HashMap> articulos, String nombre) {
		boolean found = false;
		for (int i = 0; i < articulos.size() && !found; i++) {
			if (articulos.get(i).get("nombre").equals(nombre)) {
				System.out.println(articulos.get(i).toString());
				found = true;
			}
		}

		if (!found) {
			System.out.println("No se ha encontrado el artículo " + nombre);
		}
	}

	public static void listArticles(ArrayList<HashMap> articulos) {
		System.out.println("ARTICULOS DISPONIBLES: ");
		for (int i = 0; i < articulos.size(); i++) {
			System.out.println(articulos.get(i).toString());
		}
	}

	public static void listaMenu() {
		System.out.println("	----------------------");
		System.out.println("	SELECCIONA UNA OPCIÓN");
		System.out.println("1. Añadir un nuevo artículo");
		System.out.println("2. Consultar información de un artículo");
		System.out.println("3. Listar todos los artículos");
		System.out.println("4. Salir del programa");
		System.out.println("	----------------------\n");
	}

	public static void addStarterArticles(ArrayList<HashMap> articulos) {
		HashMap<String, Object> articulo = new HashMap<String, Object>();
		articulo.put("nombre", "manzana");
		articulo.put("cantidad", 10);
		articulo.put("precio", 2.45);
		articulo.put("IVA", 0.21);
		articulos.add(articulo);

		articulo = new HashMap<String, Object>();
		articulo.put("nombre", "pera");
		articulo.put("cantidad", 10);
		articulo.put("precio", 1.85);
		articulo.put("IVA", 0.21);
		articulos.add(articulo);

		articulo = new HashMap<String, Object>();
		articulo.put("nombre", "naranja");
		articulo.put("cantidad", 10);
		articulo.put("precio", 1.60);
		articulo.put("IVA", 0.21);
		articulos.add(articulo);

		articulo = new HashMap<String, Object>();
		articulo.put("nombre", "tomate");
		articulo.put("cantidad", 10);
		articulo.put("precio", 1.80);
		articulo.put("IVA", 0.21);
		articulos.add(articulo);

		articulo = new HashMap<String, Object>();
		articulo.put("nombre", "platano");
		articulo.put("cantidad", 10);
		articulo.put("precio", 1.35);
		articulo.put("IVA", 0.21);
		articulos.add(articulo);

		articulo = new HashMap<String, Object>();
		articulo.put("nombre", "leche");
		articulo.put("cantidad", 10);
		articulo.put("precio", 0.90);
		articulo.put("IVA", 0.04);
		articulos.add(articulo);

		articulo = new HashMap<String, Object>();
		articulo.put("nombre", "agua");
		articulo.put("cantidad", 10);
		articulo.put("precio", 0.35);
		articulo.put("IVA", 0.04);
		articulos.add(articulo);

		articulo = new HashMap<String, Object>();
		articulo.put("nombre", "galletas");
		articulo.put("cantidad", 10);
		articulo.put("precio", 1.60);
		articulo.put("IVA", 0.21);
		articulos.add(articulo);

		articulo = new HashMap<String, Object>();
		articulo.put("nombre", "helado");
		articulo.put("cantidad", 10);
		articulo.put("precio", 2.30);
		articulo.put("IVA", 0.21);
		articulos.add(articulo);

		articulo = new HashMap<String, Object>();
		articulo.put("nombre", "cerveza");
		articulo.put("cantidad", 10);
		articulo.put("precio", 1.10);
		articulo.put("IVA", 0.21);
		articulos.add(articulo);
	}

}
