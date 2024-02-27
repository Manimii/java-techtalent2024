package tests;

import java.util.HashMap;
import java.util.Scanner;

public class HashmapsApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// Crear un HashMap con clave de tipo String y valor de tipo Integer
		HashMap<String, Integer> edadesAlumnos = new HashMap<>();

		// Agregar elementos al HashMap
		edadesAlumnos.put("Juan", 25);
		edadesAlumnos.put("Pedro", 28);
		edadesAlumnos.put("María", 30);

		// edadesAlumnos {
		// "María"=> 30,
		// "Pedro"=> 28,
		// "Juan"=> 25
		// }

		// Obtener el valor asociado a una clave
		int edadDeJuan = edadesAlumnos.get("Juan"); // 25
		int edadDeMaria = edadesAlumnos.get("María"); // 30
		int edadDePedro = edadesAlumnos.get("Pedro"); // 28
		System.out.println("Edad de Juan: " + edadDeJuan);
		System.out.println("Edad de María: " + edadDeMaria);
		System.out.println("Edad de Pedro: " + edadDePedro);

		// Iterar sobre las claves del HashMap
		System.out.println("Claves en el edadesAlumnos:");
		for (String nombre : edadesAlumnos.keySet()) {
			System.out.println(nombre);
		}

		// Iterar sobre los valores del HashMap
		System.out.println("Valores en el edadesAlumnos:");
		for (int edad : edadesAlumnos.values()) {
			System.out.println(edad);
		}

		// Comprobar si una clave está en el HashMap
		boolean contienePedro = edadesAlumnos.containsKey("Pedro");
		System.out.println("¿El edadesAlumnos contiene a Pedro? " + contienePedro);

		int tamaño = edadesAlumnos.size();
		System.out.println("Tamaño del edadesAlumnos: " + tamaño);
		// Eliminar un elemento del HashMap
		edadesAlumnos.remove("María");

		// Obtener el tamaño del HashMap
		tamaño = edadesAlumnos.size();
		System.out.println("Tamaño del edadesAlumnos: " + tamaño);

		// Actualizar valor "SETEAR"

		edadesAlumnos.put("Pedro", 29);
		edadDePedro = edadesAlumnos.get("Pedro"); // Ahora 29
		System.out.println("Edad de Pedro: " + edadDePedro);

//		  Ejercicio HASHMAP / HASTABLE
//        A través de un método que realice los put() para asinar key=>value
//        pedirle al usuario por INPUT estos dos parámetros clave y valor
//        para crear dos alumnos más en edadesAlumnos
		String clave = "";
		int valor = 0;
		
		for (int i = 0; i < 2; i++) {
			System.out.println("Introduce el nombre de otra persona");
			clave = sc.nextLine();
			
			System.out.println("Introduce la edad de esa persona");
			valor = Integer.parseInt(sc.nextLine());
			
			asignaKeyValue(edadesAlumnos, clave, valor);
		}		
		
		System.out.println("Claves en el edadesAlumnos:");
		for (String nombre : edadesAlumnos.keySet()) {
			System.out.println(nombre);
		}

		// Iterar sobre los valores del HashMap
		System.out.println("Valores en el edadesAlumnos:");
		for (int edad : edadesAlumnos.values()) {
			System.out.println(edad);
		}
	}
	
	public static void asignaKeyValue(HashMap<String,Integer> m, String k, int v) {
		m.put(k, v);
	}

}
