package t07;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Ejercicio04App {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<HashMap> articulos = new ArrayList<HashMap>();
		ArrayList<HashMap> carrito = new ArrayList<HashMap>();
		int choose = 0;

		addStarterArticles(articulos);

		while (choose != 3) {
			listaMenu();
			choose = sc.nextInt();
			switch (choose) {
			case 1:
				controlDeStock(articulos);
				break;
			case 2:
				controlDeCompra(carrito, articulos);
				break;
			case 3:
				break;
			default:
				System.out.println("Error. Debes seleccionar una opción válida.");
				break;
			}
		}

		System.out.println("FIN DEL PROGRAMA");
		sc.close();
	}

	public static void controlDeStock(ArrayList<HashMap> articulos) {
		Scanner sc = new Scanner(System.in);
		String nombre = "";
		int cantidad = 0;
		double precio = 0, iva = 0.21;

		int choose = 0;
		while (choose != 4) {
			listaMenuStock();
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

	public static void controlDeCompra(ArrayList<HashMap> carrito, ArrayList<HashMap> articulos) {
		Scanner sc = new Scanner(System.in);
		String nombre = "";
		int cantidad = 0, choose = 0;
		double precio = 0, iva = 0.21;

		while (choose != 4) {
			listaMenuCompra();
			choose = sc.nextInt();
			switch (choose) {
			case 1:
				System.out.println("Qué artículo quires añadir al carrito?");
				nombre = sc.next();
				if (!existsArticle(articulos, nombre) && !nombre.equals("0")) {
					System.out.println("No disponemos de este producto.");
				} else {
					System.out.println("¿Cuantas unidades quieres comprar?");
					cantidad = sc.nextInt();

					addToCarrito(articulos, carrito, nombre, cantidad);
//					retirarCantidadArticulo(articulos, nombre, cantidad);
				}
				break;
			case 2:
				showCarrito(carrito);
				break;
			case 3:
				carrito.clear();
				break;
			case 4:
				
				break;
			default:
				System.out.println("Error. Debes seleccionar una opción válida.");
				break;
			}
		}

//		listArticles(articulos);
//		do {
//			System.out.println(
//					"Elige que producto quires añadir al carrito. Escribe '0' para terminar la compra");
//			nombre = sc.next();
//			if (!existsArticle(articulos, nombre) && !nombre.equals("0")) {
//				System.out.println("No disponemos de este producto.");
//			} else if (!nombre.equals("0")) {
//				System.out.println("¿Cuanta cantidad quieres añadir al carrito?");
//				cantidad = sc.nextInt();
//
//				cantidad = retirarCantidadArticulo(articulos, nombre, cantidad);
//				addToCarrito(articulos, carrito, nombre, cantidad);
//
//			}
//		} while (!nombre.equals("0"));
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
		System.out.println();
	}

	public static boolean existsArticle(ArrayList<HashMap> articulos, String nombre) {
		for (int i = 0; i < articulos.size(); i++) {
			if (articulos.get(i).get("nombre").equals(nombre)) {
				return true;
			}
		}

		return false;
	}

	// Retirar del stock un número determniado de un producto.
	public static void retirarCantidadArticulo(ArrayList<HashMap> articulos, String nombre, int cantidad) {
		int cantidadActual = 0, cantidadNueva = 0, cantidadSobrante = 0;
		boolean found = false;
		for (int i = 0; i < articulos.size() && !found; i++) {
			if (articulos.get(i).get("nombre").equals(nombre)) {
				cantidadActual = (int) articulos.get(i).get("cantidad");

				if (cantidadActual == 0) {
					System.out.println("Ya no queda " + nombre);
				} else {
					cantidadNueva = cantidadActual - cantidad;

					if (cantidadNueva < 0) {
						cantidadSobrante = Math.abs(cantidadNueva);
						cantidadNueva = 0;
						System.out.println("Ya no queda más " + nombre + " y solo puedes llevarte "
								+ (cantidad - cantidadSobrante));

					}

					articulos.get(i).put("cantidad", cantidadNueva);
					found = true;
				}

			}
		}

	}

	public static void addToCarrito(ArrayList<HashMap> articulos, ArrayList<HashMap> carrito, String nombre,
			int cantidad) {

		boolean found = false;
		for (int i = 0; i < articulos.size() && !found; i++) {
			if (articulos.get(i).get("nombre").equals(nombre)) {
				HashMap<String, Object> articulo = articulos.get(i);
				articulo.put("cantidad", cantidad);
				carrito.add(articulo);
				System.out.println(carrito.get(0));
				found = true;
			}
		}
	}

	public static void showCarrito(ArrayList<HashMap> carrito) {
		System.out.println("ARTICULOS EN EL CARRITO: ");
		for (int i = 0; i < carrito.size(); i++) {
			System.out.println(carrito.get(i));
		}
		System.out.println();
	}

	public static void hacerCompra(ArrayList<HashMap> productos) {
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

	public static void listaMenu() {
		System.out.println("	----------------------");
		System.out.println("	SELECCIONA UNA OPCIÓN");
		System.out.println("1. Gestionar Stock");
		System.out.println("2. Realizar una compra");
		System.out.println("3. Cerrar programa");
		System.out.println("	----------------------\n");
	}

	public static void listaMenuCompra() {
		System.out.println("	----------------------");
		System.out.println("	GESTIÓN DE COMPRA");
		System.out.println("1. Añadir un nuevo artículo al carrito");
		System.out.println("2. Listar todos los artículos del carrito");
		System.out.println("3. Realizar compra");
		System.out.println("4. Cancelar compra");
		System.out.println("	----------------------\n");
	}

	public static void listaMenuStock() {
		System.out.println("	----------------------");
		System.out.println("	GESTIÓN DE STOCK");
		System.out.println("1. Añadir un nuevo artículo");
		System.out.println("2. Consultar información de un artículo");
		System.out.println("3. Listar todos los artículos");
		System.out.println("4. Dejar la gestión de stock");
		System.out.println("	----------------------\n");
	}

	// Articulos añadidos manualmente
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
