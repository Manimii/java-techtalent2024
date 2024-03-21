package t09.ejercicio02;

public class Serie implements Entregable{

	private String titulo;
	private int nTemporadas;
	private boolean entregado;
	private String genero;
	private String creador;

	public Serie() {
		this.titulo = "";
		this.nTemporadas = 3;
		this.entregado = false;
		this.genero = "";
		this.creador = "";
	}

	public Serie(String titulo, String creador) {
		this();
		this.titulo = titulo;
		this.creador = creador;
	}

	public Serie(String titulo, int nTemporadas, String genero, String creador) {
		this.titulo = titulo;
		this.nTemporadas = nTemporadas;
		this.genero = genero;
		this.creador = creador;
		this.entregado = false;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getnTemporadas() {
		return nTemporadas;
	}

	public void setnTemporadas(int nTemporadas) {
		this.nTemporadas = nTemporadas;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getCreador() {
		return creador;
	}

	public void setCreador(String creador) {
		this.creador = creador;
	}

	@Override
	public String toString() {
		return "Serie [titulo=" + titulo + ", nTemporadas=" + nTemporadas + ", entregado=" + entregado + ", genero="
				+ genero + ", creador=" + creador + "]";
	}

	@Override
	public void entregar() {
		this.entregado = true;
	}

	@Override
	public void devolver() {
		this.entregado = false;
	}

	@Override
	public boolean isEntregado() {
		return this.entregado;
	}

	@Override
	public void compareTo(Object a) {
		
	}

	
}
