package biblioteca;
import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "Prestamos")
public class Prestamo {

// ATRIBUTOS.
	@Id 
	@GeneratedValue(strategy = GenerationType.TABLE)
    private int idPrestamo;
	
	@Column(name = "fecha_prestamo")
    private Date fechaPrestamo;
	
	@Column(name = "fecha_devolucion")
	private Date fechaDevolucion;
    
	@OneToMany
	private Libro libro;
	
    @OneToMany
	private Lector lector;

// CONSTRUCTORES.   
    public Prestamo() {
    }

   
    public Prestamo(Date fechaPrestamo, Date fechaDevolucion, Libro libro, Lector lector) {
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.libro = libro;
        this.lector = lector;
    }

// GETTERS AND SETTERS. 
    public int getIdPrestamo() {
        return idPrestamo;
    }

    public void setIdPrestamo(int idPrestamo) {
        this.idPrestamo = idPrestamo;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public Lector getLector() {
        return lector;
    }

    public void setLector(Lector lector) {
        this.lector = lector;
    }
}

