package biblioteca;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.SessionFactory;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class main {

	public static void main(String[] args) {
		
	// CONFIGURACIÓN DEL PROGRAMA
		System.out.println("INICO DEL PROGRAMA...");
		// Para indicar que queremos usar Hibernate definimos las interfaces.
		
		Configuration cfg = new Configuration().configure();
		
		// Única instancia de sessionFactory en nuestra sesión.
		
		SessionFactory sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
		Session session = sessionFactory.openSession();
		
		System.out.println("CONFIGURACIÓN REALIZADA");
		
	// PROGRAMA PRINCIPAL.
		int opcion = 0;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("--------------------------------");
			System.out.println("           BIBLIOTECA           ");
			System.out.println("--------------------------------");
			System.out.println("1- Insertar Libro.");
			System.out.println("2- Insertar Lector.");
			System.out.println("3- Listado de Libros.");
			System.out.println("4- Listado de Lectores.");
			System.out.println("5- Ver Libro por ID.");
			System.out.println("6- Ver Lector por ID.");
			System.out.println("7- Salir.");
			System.out.println("--------------------------------");
			System.out.println("selecciona una opción:");
			opcion = sc.nextInt();
			
			// While para controlar que el usuario introduce una opción valida.
			while (opcion <1 || opcion >= 8) {
				System.out.println("Opción incorrecta, inténtalo de nuevo...");
				opcion = sc.nextInt();
			}
			
			switch (opcion) {
			case 1: // 1. Insertar Libro.
				// Solicitud de datos.
				System.out.println("--------------------------------");
				System.out.println("     Añadir un nuevo libro      ");
				System.out.println("--------------------------------");
				System.out.println("Escriba los siguientes datos:");
				System.out.println("Titulo:");
				String titulo = sc.nextLine();
				System.out.println("Autor:");
				String autor = sc.nextLine();
				System.out.print("Año de publicación:");
				int publication_year = sc.nextInt();
				
				System.out.println(titulo);
				
				// Transación a la base de datos. 
				Transaction tx = session.beginTransaction();
				Libro libro = new Libro();
				libro.setTitulo(titulo);
				libro.setAutor(autor);
				libro.setPublication_year(publication_year);
				session.save(libro);
				tx.commit();				
				break;	
				
			case 2: // 2. Insertar Lector.
				// Solicitud de datos.
				System.out.println("--------------------------------");
				System.out.println("     Añadir un nuevo lector     ");
				System.out.println("--------------------------------");
				System.out.println("Escriba los siguientes datos:");
				System.out.println("Nombre:");
				String nombre = sc.nextLine();
				System.out.println("Apellido:");
				String apellido = sc.next();
				System.out.println("Email:");
				String email = sc.next();
				System.out.println("Edad:");
				int edad = sc.nextInt();
				
				// Transación a la base de datos.
				tx = session.beginTransaction();
				Lector lector = new Lector();
				lector.setNombre(nombre);
				lector.setApellido(apellido);
				lector.setEmail(email);
				lector.setEdad(edad);
				session.save(lector);
				tx.commit();
				break;
				
			case 3: // 3. Listado de Libros.
				// Consultar y mostrar todos los libros que están registrados en la base de datos.
				
				System.out.println("--------------------------------");
				System.out.println("       Listado de libros        ");
				System.out.println("--------------------------------");
				
				List<Libro> libros = session.createQuery("FROM Libro", Libro.class).getResultList();
				for (Libro li : libros) {
					System.out.println("Titulo: "                 + li.getTitulo()           +
									   "\n\tID: "                 + li.getIdLibro()          +
									   "\n\tAutor: "              + li.getAutor()           +
									   "\n\tAño de publicación: " + li.getPublication_year() +
									   "\n\t¿Disponible?: "       + li.isDisponible());		
				}
				break;
				
			case 4: // 4. Listado de Lectores.
				// Consultar y mostrar todos los lectores que están registrados en la base de datos.
				
				System.out.println("--------------------------------");
				System.out.println("       Listado de lectores      ");
				System.out.println("--------------------------------");
				
				List<Lector> lectores = session.createQuery("FROM Lector", Lector.class).getResultList();
				for (Lector le : lectores) {
					System.out.println("Nombre: "         + le.getNombre()   +
							   		   "\n\tApellidos: "  + le.getApellido() +
							           "\n\tID: "         + le.getIdLector() +
							           "\n\tEmail: "      + le.getEmail()    +
							           "\n\tEdad: "       + le.getEdad());		
				}
				break;
			
			case 5: // 5. Ver Libro por ID.
				
				break;
			case 6: // 6. Ver Lector por ID.
				
				break;
				
			}
			
		} while (opcion !=7);
		
		
		
		
		session.close();
		sessionFactory.close();
	}

}
