package Manel.c4backend.t22.ej1.model;

public class Querys {

	public static String defineClientTable() {
		return "(" + "    `id` int(11) NOT NULL AUTO_INCREMENT," + "    `nombre` varchar(250) DEFAULT NULL,"
				+ "    `apellido` varchar(250) DEFAULT NULL," + "    `direccion` varchar(250) DEFAULT NULL,"
				+ "    `dni` int(11) DEFAULT NULL," + "    `fecha` date DEFAULT NULL," + "    PRIMARY KEY (`id`)" + ")";
	}

	public static String defineVideosTable() {
		return "(" + "    `id` int(11) NOT NULL AUTO_INCREMENT," + "    `title` varchar(250) DEFAULT NULL,"
				+ "    `director` varchar(250) DEFAULT NULL,"
				+ "    `cli_id` int(11) DEFAULT NULL," + "    PRIMARY KEY (`id`),"
				+ " CONSTRAINT `videos_fk` FOREIGN KEY (`cli_id`) REFERENCES `cliente` (`id`)" + ")";
	}

	public static String insertDefaultClientValues() {
		return "(`nombre`, `apellido`, `direccion`, `dni`, `fecha`) VALUES"
				+ "('Juan', 'Perez', 'Calle Falsa 123', 12345678, '2023-05-01'),"
				+ "('Maria', 'Garcia', 'Av. Siempre Viva 456', 23456789, '2023-06-01'),"
				+ "('Carlos', 'Lopez', 'Calle Luna 789', 34567890, '2023-07-01'),"
				+ "('Ana', 'Martinez', 'Av. Estrella 101', 45678901, '2023-08-01'),"
				+ "('Luis', 'Gomez', 'Calle Sol 202', 56789012, '2023-09-01'),"
				+ "('Elena', 'Fernandez', 'Av. Mar 303', 67890123, '2023-10-01'),"
				+ "('Jorge', 'Ramirez', 'Calle Tierra 404', 78901234, '2023-11-01'),"
				+ "('Marta', 'Sanchez', 'Av. Cielo 505', 89012345, '2023-12-01'),"
				+ "('Roberto', 'Torres', 'Calle Universo 606', 90123456, '2024-01-01'),"
				+ "('Laura', 'Diaz', 'Av. Galaxia 707', 12345679, '2024-02-01');";
	}

	public static String insertDefaultVideoValues() {
		return "(title, director, cli_id) VALUES"
				+ "('Inception', 'Christopher Nolan', 1),"
				+ "('The Matrix', 'Lana Wachowski', 2),"
				+ "('Interstellar', 'Christopher Nolan', 3),"
				+ "('The Godfather', 'Francis Ford Coppola', 4),"
				+ "('Pulp Fiction', 'Quentin Tarantino', 5),"
				+ "('Fight Club', 'David Fincher', 6),"
				+ "('Forrest Gump', 'Robert Zemeckis', 7),"
				+ "('The Shawshank Redemption', 'Frank Darabont', 8),"
				+ "('The Dark Knight', 'Christopher Nolan', 9),"
				+ "('The Lord of the Rings: The Return of the King', 'Peter Jackson', 10)";
	}
}
