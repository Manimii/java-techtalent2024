package TrabajoEnEquipo;

import java.util.ArrayList;
import java.util.HashMap;

public class TE_001 {

	public static void main(String[] args) {

		HashMap<String, Integer> estudiantesTechTalent = new HashMap<>();

		estudiantesTechTalent.put("Laia", 23);
		estudiantesTechTalent.put("Aurora", 30);
		estudiantesTechTalent.put("Alexandre", 21);
		estudiantesTechTalent.put("Jose", 26);
		estudiantesTechTalent.put("Santos", 24);
		estudiantesTechTalent.put("Manel", 26);
		estudiantesTechTalent.put("Alejandro", 20);
		estudiantesTechTalent.put("Isabel", 22);
		estudiantesTechTalent.put("Toni", 21);
		estudiantesTechTalent.put("Diego", 22);
		estudiantesTechTalent.put("Sebas", 29);
		estudiantesTechTalent.put("Abdel", 21);
		estudiantesTechTalent.put("Joel", 19);
		estudiantesTechTalent.put("Jessica", 22);
		estudiantesTechTalent.put("Ana Maria", 29);
		HashMap<String, Integer> grupo1 = new HashMap<>();
		HashMap<String, Integer> grupo2 = new HashMap<>();
		HashMap<String, Integer> grupo3 = new HashMap<>();
		HashMap<String, Integer> grupo4 = new HashMap<>();
		HashMap<String, Integer> grupo5 = new HashMap<>();

		generarGrupos(estudiantesTechTalent, grupo1, grupo2, grupo3, grupo4, grupo5);
	}

	public static void generarGrupos(HashMap<String, Integer> listaAlumnos, HashMap<String, Integer> grupo1,
			HashMap<String, Integer> grupo2, HashMap<String, Integer> grupo3, HashMap<String, Integer> grupo4,
			HashMap<String, Integer> grupo5) {

		// HAY QUE CAMBIARLO POR UN DO-WHILE(booleano)
		for (String i : listaAlumnos.keySet()) {
			int grupo = generarRandom();
			boolean interruptor = false;
			while (!interruptor) {
				switch (grupo) {

				case 0:
					if (grupo1.size() >= 3) {
						grupo = generarRandom();
					} else {
						grupo1.put(i, listaAlumnos.get(i));
						interruptor=true;
					}

					break;

				case 1:
					if (grupo2.size() >= 3) {
						grupo = generarRandom();
					} else {
						grupo2.put(i, listaAlumnos.get(i));
						interruptor=true;
					}
					break;

				case 2:
					if (grupo3.size() >= 3) {
						grupo = generarRandom();
					} else {
						grupo3.put(i, listaAlumnos.get(i));
						interruptor=true;

					}
					break;

				case 3:
					if (grupo4.size() >= 3) {
						grupo = generarRandom();
					} else {
						grupo4.put(i, listaAlumnos.get(i));
						interruptor=true;

					}
					break;

				case 4:
					if (grupo5.size() >= 3) {
						grupo = generarRandom();
					} else {
						grupo5.put(i, listaAlumnos.get(i));
						interruptor=true;

					}
					break;

				}

			}

		}
		System.out.println("Grupo1:\n " + grupo1.toString());
		System.out.println("Grupo2:\n " + grupo2.toString());
		System.out.println("Grupo3:\n " + grupo3.toString());
		System.out.println("Grupo4:\n " + grupo4.toString());
		System.out.println("Grupo5:\n " + grupo5.toString());
	}

	public static int generarRandom() {
		return (int) (Math.random() * 5);

	}

}
