package t09.ejercicio03;

public class Libro {

	private String isbn;
	private String titulo;
	private String autor;
	private int nPaginas;

	public Libro() {
		this.isbn = "";
		this.titulo = "";
		this.autor = "";
		this.nPaginas = 0;
	}

	public Libro(String isbn, String titulo, String autor, int nPaginas) {
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.nPaginas = nPaginas;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
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

	public int getnPaginas() {
		return nPaginas;
	}

	public void setnPaginas(int nPaginas) {
		this.nPaginas = nPaginas;
	}

	@Override
	public String toString() {
		return "El libro " + this.titulo + " con ISBN " + this.isbn + " creado por " + this.autor + " tiene " + this.nPaginas + " páginas";
	}
	
	public Libro compararPaginas(Libro l) {
		int paginas1 = this.nPaginas;
		int paginas2 = l.nPaginas;
		
		if (paginas1 >= paginas2) {
			return this;
		}
		return l;
	}

}
