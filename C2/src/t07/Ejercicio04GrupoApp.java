package t07;

import java.util.HashMap;
import java.util.Scanner;

public class Ejercicio04GrupoApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		HashMap<String, HashMap> baseDeDatos = new HashMap<String, HashMap>();
		HashMap<String, HashMap> carrito = new HashMap<String, HashMap>();
		rellenarbaseDeDatos(baseDeDatos);

		mostrarMenu(baseDeDatos, carrito);

	}

	public static void mostrarMenu(HashMap<String, HashMap> baseDeDatos, HashMap<String, HashMap> carrito) {
		Scanner sc = new Scanner(System.in);
		int select = 0, choose = 0;
		while (select != 3) {
			menu();
			select = sc.nextInt();
			switch (select) {
			case 1:
				gestionarStock(baseDeDatos);
				break;
			case 2:
				// gestiona compra
				gestionarCarrito(baseDeDatos, carrito);
				break;
			case 3:
				// salir programa
				break;
			default:
				System.out.println("Error, introduce una opción válida\n");
				break;
			}
		}
	}
	
	public static void gestionarCarrito(HashMap<String, HashMap> baseDeDatos, HashMap<String, HashMap> carrito) {
		Scanner sc = new Scanner(System.in);
		int choose = 0;
		while (choose != 4) {
			menuCarrito();
			choose = sc.nextInt();
			sc.nextLine();
			switch (choose) {
			case 1:
				mostrarStock(baseDeDatos);
				break;
			case 2:
				addProducto(baseDeDatos, carrito);
				break;
			case 3:
				comprobarProducto(baseDeDatos);
				break;
			default:
				System.out.println("Error, introduce una opción válida\n");
				break;
			}
		}
	}

	public static void gestionarStock(HashMap<String, HashMap> baseDeDatos) {
		Scanner sc = new Scanner(System.in);
		int choose = 0;
		while (choose != 4) {
			menuStock();
			choose = sc.nextInt();
			sc.nextLine();
			switch (choose) {
			case 1:
				mostrarStock(baseDeDatos);
				break;
			case 2:
				addStock(baseDeDatos);
				break;
			case 3:
				comprobarProducto(baseDeDatos);
				break;
			case 4:
				break;
			default:
				System.out.println("Error, introduce una opción válida\n");
				break;
			}
		}
	}
	
	public static void addProducto(HashMap<String, HashMap> baseDeDatos, HashMap<String, HashMap> Carrito) {
		System.out.println("Selecciona uno de los sigüientes productos:\n");
		mostrarStock(baseDeDatos);
	}

	public static void comprobarProducto(HashMap<String, HashMap> baseDeDatos) {
		Scanner sc = new Scanner(System.in);
		System.out.println("¿Qué producto quieres comprobar?");
		String producto = sc.nextLine();
		System.out.println(baseDeDatos.get(producto) + "\n");

	}

	public static void addStock(HashMap<String, HashMap> baseDeDatos) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Nombre del producto:");
		String nombre = sc.nextLine();
		System.out.println("Precio del producto:");
		double precio = sc.nextDouble();
		System.out.println("Cantidad del producto:");
		int cantidad = sc.nextInt();
		System.out.println("IVA del producto:");
		double iva = sc.nextDouble();

		HashMap<String, Object> producto = new HashMap<String, Object>();
		producto.put("precio", precio);
		producto.put("cantidad", cantidad);
		producto.put("iva", iva);

		baseDeDatos.put(nombre, producto);

	}

	public static void menu() {
		System.out.println("---------SELECCIONA UNA OPCIÓN---------");
		System.out.println("1. Gestionar Stock");
		System.out.println("2. Hacer Compra");
		System.out.println("3. Salir");
		System.out.println("---------------------------------------");
	}

	public static void menuStock() {
		System.out.println("---------SELECCIONA UNA OPCIÓN---------");
		System.out.println("	1. Listar Stock");
		System.out.println("	2. Añadir Producto");
		System.out.println("	3. Consultar Producto");
		System.out.println("	4. Salir");
		System.out.println("---------------------------------------");
	}
	
	public static void menuCarrito() {
		System.out.println("---------SELECCIONA UNA OPCIÓN---------");
		System.out.println("	1. Añadir producto");
		System.out.println("	2. Comprobar carrito");
		System.out.println("	3. Comprar");
		System.out.println("---------------------------------------");
	}

	public static void mostrarStock(HashMap<String, HashMap> baseDeDatos) {
		for (String i : baseDeDatos.keySet()) {
			System.out.println(i + ": " + baseDeDatos.get(i));
		}
		System.out.println();
	}

	public static void rellenarbaseDeDatos(HashMap<String, HashMap> baseDeDatos) {
		HashMap<String, Object> elemento = new HashMap<String, Object>();
		elemento.put("precio", "0.50");
		elemento.put("cantidad", 10);
		elemento.put("IVA", 0.10);
		baseDeDatos.put("pan", elemento);

		elemento = new HashMap<String, Object>();
		elemento.put("precio", "1.50");
		elemento.put("cantidad", 10);
		elemento.put("IVA", 0.21);
		baseDeDatos.put("manzana", elemento);

		elemento = new HashMap<String, Object>();
		elemento.put("precio", "2.50");
		elemento.put("cantidad", 10);
		elemento.put("IVA", 0.21);
		baseDeDatos.put("pera", elemento);

		elemento = new HashMap<String, Object>();
		elemento.put("precio", "3.25");
		elemento.put("cantidad", 10);
		elemento.put("IVA", 0.21);
		baseDeDatos.put("pasta", elemento);

		elemento = new HashMap<String, Object>();
		elemento.put("precio", "4.50");
		elemento.put("cantidad", 10);
		elemento.put("IVA", 0.21);
		baseDeDatos.put("pizza", elemento);

		elemento = new HashMap<String, Object>();
		elemento.put("precio", "3.20");
		elemento.put("cantidad", 10);
		elemento.put("IVA", 0.21);
		baseDeDatos.put("canelones", elemento);

		elemento = new HashMap<String, Object>();
		elemento.put("precio", "0.50");
		elemento.put("cantidad", 10);
		elemento.put("IVA", 0.04);
		baseDeDatos.put("agua", elemento);

		elemento = new HashMap<String, Object>();
		elemento.put("precio", "1.00");
		elemento.put("cantidad", 10);
		elemento.put("IVA", 0.04);
		baseDeDatos.put("leche", elemento);

		elemento = new HashMap<String, Object>();
		elemento.put("precio", "0.90");
		elemento.put("cantidad", 10);
		elemento.put("IVA", 0.21);
		baseDeDatos.put("pila", elemento);

		elemento = new HashMap<String, Object>();
		elemento.put("precio", "1.40");
		elemento.put("cantidad", 10);
		elemento.put("IVA", 0.21);
		baseDeDatos.put("queso", elemento);

	}

}
