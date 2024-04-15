package biblioteca;

public class Libro {

// ATRIBUTOS
	private int idLibro;
	private String titulo;
	private String autor;
	private int publication_year;
	private boolean disponible;
	
	
// CONSTRUCTORES. 
	public Libro() {
	
	}

	public Libro(int idLibro, String titulo, String autor, int publication_year , boolean disponible) {
		super();
		this.idLibro = idLibro;
		this.titulo = titulo;
		this.autor = autor;
		this.publication_year = publication_year;
		this.disponible = disponible; 
	}
	
	public Libro(String titulo, String autor, int publication_year) {
		super();
		this.titulo = titulo;
		this.autor = autor;
		this.publication_year = publication_year;
		this.disponible = true; // Cuando se añade un nuevo libro, lo declaramos por defecto como disponible.
	}
	
	

// GETTERS AND SETTERS. 
	
	public int getIdLibro() {
		return idLibro;
	}

	public void setIdLibro(int idLibro) {
		this.idLibro = idLibro;
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

	public int getPublication_year() {
		return publication_year;
	}

	public void setPublication_year(int publication_year) {
		this.publication_year = publication_year;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	


	
	
	
	
	
}
