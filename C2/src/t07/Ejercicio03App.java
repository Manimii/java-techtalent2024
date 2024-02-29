package t07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Ejercicio03App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<HashMap> articulos = new ArrayList<HashMap>();
		String nombre = "";
		int cantidad = 0;
		double precio = 0;

		int choose = 0;
		do {
			System.out.println("----------------------");
			System.out.println("SELECCIONA UNA OPCIÓN");
			System.out.println("1. Añadir un nuevo artículo");
			System.out.println("2. Consultar información de un artículo");
			System.out.println("3. Listar todos los artículos");
			System.out.println("4. Salir del programa");
			System.out.println("----------------------\n");
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

				addArticle(articulos, nombre, cantidad, precio);
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
		} while (choose != 4);
	}

	public static void addArticle(ArrayList<HashMap> articulos, String nombre, int cantidad, double precio) {
		HashMap<String, Object> articulo = new HashMap<String, Object>();
		articulo.put("nombre", nombre);
		articulo.put("cantidad", cantidad);
		articulo.put("precio", precio);

		articulos.add(articulo);
	}

	public static void getArticle(ArrayList<HashMap> articulos, String nombre) {
		for (int i = 0; i < articulos.size(); i++) {
			if (articulos.get(i).get("nombre").equals(nombre)) {
				System.out.println(articulos.get(i).toString());
			}
		}
	}
	
	public static void listArticles(ArrayList<HashMap> articulos) {
		System.out.println("ARTICULOS DISPONIBLES: ");
		for (int i = 0; i < articulos.size(); i++) {
			System.out.println(articulos.get(i).toString());
		}
	}

}
