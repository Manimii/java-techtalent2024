package t08.extra;

/*
 * Problema: Crea una clase llamada Libro que tenga como atributos título, autor y año de publicación.
 *  Implementa métodos para obtener y establecer estos atributos.
 * */

public class Libro {

	private String titulo;
	private String autor;
	private int publicacion;

	public Libro(String titulo, String autor, int publicacion) {
		this.titulo = titulo;
		this.autor = autor;
		this.publicacion = publicacion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getPublicacion() {
		return publicacion;
	}

	public void setPublicacion(int publicacion) {
		this.publicacion = publicacion;
	}

}
