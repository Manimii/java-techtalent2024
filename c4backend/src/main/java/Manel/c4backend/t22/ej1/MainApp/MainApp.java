package Manel.c4backend.t22.ej1.MainApp;

import Manel.c4backend.t22.ej1.controller.*;
import Manel.c4backend.t22.ej1.model.*;
import Manel.c4backend.t22.ej1.view.*;

public class MainApp {

	public static void main(String[] args) {
		Conexiones c = new Conexiones();
		Methods.crearBaseDatos(c);
		
		Startmenu sm = new Startmenu(c);
//		c.closeConnection();
	}

}
