package Manel.c4backend.t22.ej1.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Manel.c4backend.t22.ej1.model.*;

public class Conexiones {

	private Connection conexion;
	private String query;
	private Statement st;

	public Conexiones() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "");
			this.query = "";
			System.out.println("Server conectado ");
		} catch (SQLException | ClassNotFoundException e) {
			System.out.print("No se ha podido conectar con mi base de datos");
			System.out.println(e);
		}
	}

	public Conexiones(String user, String password) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			this.conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306", user, password);
			this.query = "";
			System.out.println("Server conectado ");
		} catch (SQLException | ClassNotFoundException e) {
			System.out.print("No se ha podido conectar con mi base de datos");
			System.out.println(e);
		}
	}

	public void closeConnection() {
		try {
			this.conexion.close();
			System.out.println("Se ha finalizado la conexión con el servidor");
		} catch (SQLException e) {
			System.out.println("Error cerrando la conexión con el server.");
		}
	}

	public void createDB(String name) {
		try {
			query = "CREATE DATABASE IF NOT EXISTS " + name;
			st = conexion.createStatement();
			st.executeUpdate(query);
			System.out.println("Se ha creado la base de datos " + name + " de manera exitosa.");
		} catch (SQLException e) {
			System.out.println("Error creando la base de datos " + name);
		}
	}

	public void createTable(String db, String name, String atributos) {
		try {
			useDB(db);
			query = "CREATE TABLE IF NOT EXISTS " + name + atributos;
			st.executeUpdate(query);
			System.out.println("Se ha creado la tabla " + name + " de manera exitosa.");

		} catch (SQLException e) {
			System.out.println("Error creando la tabla " + name);
		}
	}

	public void insertData(String db, String tabla, String values) {
		try {
			useDB(db);
			query = "INSERT INTO " + tabla + values;
			System.out.println(query);
			st.executeUpdate(query);
			System.out.println("Se han insertado los datos de la tabla " + tabla + " de manera exitosa.");
		} catch (SQLException e) {
			System.out.println("Error introduciendo datos en la tabla " + tabla);
		}
	}

	public void deleteData(String db, String tabla, String where) {
		try {
			useDB(db);
			query = "DELETE FROM " + tabla + " WHERE " + where;
			System.out.println(query);
			st.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Se ha borrado el registro de la tabla " + tabla);
		} catch (SQLException e) {
			System.out.println("Error eliminando el registro de la tabla " + tabla);
		}
	}

	public void updateData(String db, String tabla, String set, String where) {
		try {
			useDB(db);
			query = "UPDATE " + tabla + " SET " + set + " WHERE " + where;
			System.out.println(query);
			st.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Se ha actualizado la tabla " + tabla);
		} catch (SQLException e) {
			System.out.println("Error actualizando la tabla " + tabla);
		}
	}

	public ArrayList<Cliente> selectClienteData(String db, List<String> select, String from, String where,
			String groupby,
			String having,
			String orderby) {
		int id = 0, dni = 0;
		int selectSize = select.size();
		String nombre = "", apellido = "", direccion = "";
		Date fecha = null;
		ArrayList<Cliente> clientes = new ArrayList<Cliente>();

		try {
			useDB(db);
			query = "SELECT " + String.join(", ", select) + " FROM " + from;

			if (!where.equals("")) {
				query += " WHERE " + where;
			}

			if (!groupby.equals("")) {
				query += " GROUP BY " + groupby;
			}

			if (!having.equals("")) {
				query += " HAVING " + having;
			}

			if (!orderby.equals("")) {
				query += " ORDER BY " + orderby;
			}

			query += ";";

			System.out.println(query);
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {

				if (select.contains("id") || (selectSize == 1 && select.get(0).equals("*"))) {
					id = rs.getInt("id");
				}
				if (select.contains("nombre") || (selectSize == 1 && select.get(0).equals("*"))) {
					nombre = rs.getString("nombre");
				}
				if (select.contains("apellido") || (selectSize == 1 && select.get(0).equals("*"))) {
					apellido = rs.getString("apellido");
				}
				if (select.contains("direccion") || (selectSize == 1 && select.get(0).equals("*"))) {
					direccion = rs.getString("direccion");
				}
				if (select.contains("dni") || (selectSize == 1 && select.get(0).equals("*"))) {
					dni = rs.getInt("dni");
				}
				if (select.contains("fecha") || (selectSize == 1 && select.get(0).equals("*"))) {
					fecha = rs.getDate("fecha");
				}

				Cliente cl = new Cliente(id, nombre, apellido, direccion, dni, fecha);
				clientes.add(cl);
			}

		} catch (SQLException e) {
			System.out.println("Error en la consulta");
		}

		return clientes;
	}

	public ArrayList<Videos> selectVideosData(String db, List<String> select, String from, String where, String groupby,
			String having,
			String orderby) {
		int id = 0, cli_id = 0;
		int selectSize = select.size();
		String title = "", director = "";
		ArrayList<Videos> videos = new ArrayList<>();

		try {
			useDB(db);
			query = "SELECT " + String.join(", ", select) + " FROM " + from;

			if (!where.equals("")) {
				query += " WHERE " + where;
			}

			if (!groupby.equals("")) {
				query += " GROUP BY " + groupby;
			}

			if (!having.equals("")) {
				query += " HAVING " + having;
			}

			if (!orderby.equals("")) {
				query += " ORDER BY " + orderby;
			}

			query += ";";

			System.out.println(query);
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {

				if (select.contains("id") || (selectSize == 1 && select.get(0).equals("*"))) {
					id = rs.getInt("id");
				}
				if (select.contains("title") || (selectSize == 1 && select.get(0).equals("*"))) {
					title = rs.getString("title");
				}
				if (select.contains("director") || (selectSize == 1 && select.get(0).equals("*"))) {
					director = rs.getString("director");
				}
				if (select.contains("cli_id") || (selectSize == 1 && select.get(0).equals("*"))) {
					cli_id = rs.getInt("cli_id");
				}


				Videos v = new Videos(id, title, director, cli_id);
				videos.add(v);
			}

		} catch (SQLException e) {
			System.out.println("Error en la consulta");
		}

		return videos;
	}

	public ArrayList<Cientificos> selectCientificosData(String db, List<String> select, String from, String where, String groupby,
			String having,
			String orderby) {
		int selectSize = select.size();
		String dni = "", nomApels = "";
		ArrayList<Cientificos> cientificos = new ArrayList<>();

		try {
			useDB(db);
			query = "SELECT " + String.join(", ", select) + " FROM " + from;

			if (!where.equals("")) {
				query += " WHERE " + where;
			}

			if (!groupby.equals("")) {
				query += " GROUP BY " + groupby;
			}

			if (!having.equals("")) {
				query += " HAVING " + having;
			}

			if (!orderby.equals("")) {
				query += " ORDER BY " + orderby;
			}

			query += ";";

			System.out.println(query);
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {

				if (select.contains("dni") || (selectSize == 1 && select.get(0).equals("*"))) {
					dni = rs.getString("dni");
				}
				if (select.contains("nom_apels") || (selectSize == 1 && select.get(0).equals("*"))) {
					nomApels = rs.getString("nom_apels");
				}

				Cientificos ci = new Cientificos(dni, nomApels);
				cientificos.add(ci);
			}

		} catch (SQLException e) {
			System.out.println("Error en la consulta " + e.getMessage());
		}

		return cientificos;
	}

	public ArrayList<Proyecto> selectProyectoData(String db, List<String> select, String from, String where, String groupby,
			String having,
			String orderby) {
		int selectSize = select.size();
		String id = "", nombre = "";
		int horas = 0;
		ArrayList<Proyecto> proyecto = new ArrayList<>();

		try {
			useDB(db);
			query = "SELECT " + String.join(", ", select) + " FROM " + from;

			if (!where.equals("")) {
				query += " WHERE " + where;
			}

			if (!groupby.equals("")) {
				query += " GROUP BY " + groupby;
			}

			if (!having.equals("")) {
				query += " HAVING " + having;
			}

			if (!orderby.equals("")) {
				query += " ORDER BY " + orderby;
			}

			query += ";";

			System.out.println(query);
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {

				if (select.contains("id") || (selectSize == 1 && select.get(0).equals("*"))) {
					id = rs.getString("id");
				}
				if (select.contains("nombre") || (selectSize == 1 && select.get(0).equals("*"))) {
					nombre = rs.getString("nombre");
				}
				if (select.contains("horas") || (selectSize == 1 && select.get(0).equals("*"))) {
					horas = rs.getInt("horas");
				}

				Proyecto p = new Proyecto(id, nombre, horas);
				proyecto.add(p);
			}

		} catch (SQLException e) {
			System.out.println("Error en la consulta");
		}

		return proyecto;
	}

	public ArrayList<Asignado> selectAsignadoData(String db, List<String> select, String from, String where, String groupby,
			String having,
			String orderby) {
		int selectSize = select.size();
		String cientifico = "", proyecto = "";
		ArrayList<Asignado> asignados = new ArrayList<>();

		try {
			useDB(db);
			query = "SELECT " + String.join(", ", select) + " FROM " + from;

			if (!where.equals("")) {
				query += " WHERE " + where;
			}

			if (!groupby.equals("")) {
				query += " GROUP BY " + groupby;
			}

			if (!having.equals("")) {
				query += " HAVING " + having;
			}

			if (!orderby.equals("")) {
				query += " ORDER BY " + orderby;
			}

			query += ";";

			System.out.println(query);
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {

				if (select.contains("cientifico") || (selectSize == 1 && select.get(0).equals("*"))) {
					cientifico = rs.getString("cientifico");
				}
				if (select.contains("proyecto") || (selectSize == 1 && select.get(0).equals("*"))) {
					proyecto = rs.getString("proyecto");
				}

				Asignado a = new Asignado(cientifico, proyecto);
				asignados.add(a);
			}

		} catch (SQLException e) {
			System.out.println("Error en la consulta");
		}

		return asignados;
	}

	private void useDB(String db) {
		try {
			query = "USE " + db + ";";
			st = conexion.createStatement();
			st.executeUpdate(query);
		} catch (SQLException e) {
			System.out.println("Error usando la base de datos " + db);
		}
	}
}
