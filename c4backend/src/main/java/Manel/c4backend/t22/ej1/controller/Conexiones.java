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
			st.executeUpdate(query);
			System.out.println("Se han insertado los datos de la tabla " + tabla + " de manera exitosa.");
		} catch (SQLException e) {
			System.out.println("Error introduciendo datos en la tabla " + tabla);
		}
	}

	public void deleteData(String db, String tabla, String id) {
		try {
			useDB(db);
			query = "DELETE FROM " + tabla + " WHERE ID = '" + id + "'";
			System.out.println(query);
			st.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Se ha borrado el registro " + id + " de la tabla " + tabla);
		} catch (SQLException e) {
			System.out.println("Error eliminando el registro " + id + " de la tabla " + tabla);
		}
	}

	public void updateData(String db, String tabla, String set, String where) {
		try {
			useDB(db);
			query = "UPDATE " + tabla + " SET " + set + " WHERE " + where;
			st.executeUpdate(query);
			JOptionPane.showMessageDialog(null, "Se ha actualizado la tabla " + tabla);
		} catch (SQLException e) {
			System.out.println("Error actualizando la tabla " + tabla);
		}
	}

	public ArrayList<Cliente> selectData(String db, List<String> select, String from, String where, String groupby,
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
