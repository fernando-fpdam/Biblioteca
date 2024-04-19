package biblioteca;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.SessionFactory;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Date;

import org.hibernate.HibernateException;
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
		Transaction tx = null;
		int idLector=0;
		
	
		while (opcion !=4) {
			System.out.println("--------------------------------");
			System.out.println("           BIBLIOTECA           ");
			System.out.println("--------------------------------");
			System.out.println("1. Libros.");
			System.out.println("2. Lectores.");
			System.out.println("3. Prestamos.");
			System.out.println("4. Salir.");
			System.out.println("--------------------------------");
			System.out.println("selecciona una opción:");
			opcion = sc.nextInt();
			try {
				switch (opcion) {
				case 1: // Libros.
					while (opcion!=5) {
						System.out.println("--------------------------------");
						System.out.println("             LIBROS             ");
						System.out.println("--------------------------------");
						System.out.println("1. Insertar Libro.");
						System.out.println("2. Actualizar Libro.");
						System.out.println("3. Borrar libro.");
						System.out.println("4. Listado de todos los libros.");
						System.out.println("5. Volver atrás.");
						System.out.println("--------------------------------");
						System.out.println("selecciona una opción:");
						opcion = sc.nextInt();
						try {
							switch (opcion) {
							case 1: // Insertar Libro.
								System.out.println("--------------------------------");					
								System.out.println("Escriba los siguientes datos:");
								System.out.print("Titulo: ");
								String titulo = sc.next();
								sc.nextLine();
								System.out.print("Autor: ");
								String autor = sc.next();
								sc.nextLine();
								System.out.print("Año de publicación: ");
								int publication_year = sc.nextInt();
								sc.nextLine();
								System.out.println("--------------------------------");
								
								// Transación a la base de datos.  
								try {
									tx = session.beginTransaction();
									Libro libro = new Libro(titulo,autor,publication_year);
									session.save(libro);
									tx.commit();
									
								} catch (HibernateException e) {
									if(tx != null) {tx.rollback(); e.printStackTrace();}
								}
								
								break;
							case 2: // Actualizar libro. 
								System.out.println("--------------------------------");					
								System.out.print("Introduzca el ID del libro: ");
								int idLibro = sc.nextInt();
								Libro libro = session.get(Libro.class, idLibro);
														
								if (libro != null) {
									
								}else {
									System.out.println("El libro con ID: " + idLibro + " no existe");
								}
								break;
								
							case 3: // Borrar Libro
								System.out.print("Introduzca el ID del libro:");
								idLibro = sc.nextInt();
								
								// Transación a la base de datos. 
								try {
									tx = session.beginTransaction();
									Libro libro = new Libro();
									libro.setIdLibro(idLibro);
									session.delete(libro);
									tx.commit();
									
								} catch (HibernateException e) {
									if (tx != null) { tx.rollback(); e.printStackTrace();}
								}
								
								break;
							case 4: //  Listado de todos los libros.
								// Consultar y mostrar todos los libros que están registrados en la base de datos.
								
								System.out.println("--------------------------------");
								System.out.println("       Listado de libros        ");
								System.out.println("--------------------------------");
								
								List<Libro> libros = session.createQuery("FROM Libro", Libro.class).getResultList();
								for (Libro li : libros) {
									System.out.println("Titulo: "                 + li.getTitulo()           +
													   "\n\tID: "                 + li.getIdLibro()          +
													   "\n\tAutor: "              + li.getAutor()            +
													   "\n\tAño de publicación: " + li.getPublication_year() +
													   "\n\t¿Disponible?: "       + li.isDisponible()        + "\n");		
								}
								break;
							default:
								System.out.println("Las opciones son entre 1 y 4");
								break;
						}	
						} catch (InputMismatchException e) {
							System.out.println("Debes escribir un número");
						}	
					}
				
				case 2: // Lectores
					while (opcion!=7) {
						System.out.println("--------------------------------");
						System.out.println("             LECTORES             ");
						System.out.println("--------------------------------");
						System.out.println("1. Insertar lector.");
						System.out.println("2. Actualizar lector.");
						System.out.println("3. Borrar lector.");
						System.out.println("4. Listado de todos los lectores.");
						System.out.println("5. Historial de prestamos por lector");
						System.out.println("6. Libros actualmente prestados a un lector.");
						System.out.println("7. Volver atrás.");
						System.out.println("--------------------------------");
						System.out.println("selecciona una opción:");
						opcion = sc.nextInt();
						try {
							switch (opcion) {
							case 1: // Insertar lector.
								System.out.println("--------------------------------");				
								System.out.println("Escriba los siguientes datos:");
								System.out.print("Nombre: ");
								String nombre = sc.next();
								sc.nextLine();
								System.out.print("Apellido: ");
								String apellido = sc.next();
								sc.nextLine();
								System.out.print("Email: ");
								String email = sc.next();
								sc.nextLine();
								System.out.print("Edad: ");
								int edad = sc.nextInt();
								System.out.println("--------------------------------");

								// Transación a la base de datos. 
								tx = session.beginTransaction();
								try {
									Lector lector = new Lector();
									lector.setNombre(nombre);
									lector.setApellido(apellido);
									lector.setEmail(email);
									lector.setEdad(edad);
									session.save(lector);
									tx.commit();
								} catch (HibernateException e) {
									if(tx != null) {tx.rollback(); e.printStackTrace();}
								}
								
								break;
							case 2:
								
								break;
							case 3: // Borrar Lectores
								System.out.println("Introduzca el ID del lector.");
								idLector = sc.nextInt();
								
								// Transación a la base de datos. 
								try {
									tx = session.beginTransaction();
									Lector lector = new Lector();
									lector.setIdLector(idLector);
									session.delete(lector);
									tx.commit();
									
								} catch (HibernateException e) {
									if (tx != null) { tx.rollback(); e.printStackTrace();}
								}
								
								break;
							case 4: // Listado de Lectores.
								// Consultar y mostrar todos los lectores que están registrados en la base de datos.
								
								System.out.println("--------------------------------");
								System.out.println("       Listado de lectores      ");
								System.out.println("--------------------------------");
								
								List<Lector> lectores = session.createQuery("FROM Lector", Lector.class).getResultList();
								for (Lector le : lectores) {
									System.out.println("Nombre: "         + le.getNombre()   +"   " + "Apellido: "  + le.getApellido() +
											           "\n\tID: "         + le.getIdLector() +
											           "\n\tEmail: "      + le.getEmail()    +
											           "\n\tEdad: "       + le.getEdad()     + "\n");		
								}
								
								break;
							default:
								System.out.println("Las opciones son entre 1 y 7");
								break;
						}	
						} catch (InputMismatchException e) {
							System.out.println("Debes escribir un número");
						}	
					}
					
				case 3:  // Prestamos
					while (opcion!=4) {
						System.out.println("--------------------------------");
						System.out.println("           PRESTAMOS            ");
						System.out.println("--------------------------------");
						System.out.println("1. Realizar un prestamo.");
						System.out.println("2. Realizar una devulución.");
						System.out.println("3. Libros disponibles para prestamos.");
						System.out.println("4. Volver atrás.");
						System.out.println("--------------------------------");
						System.out.println("selecciona una opción:");
						opcion = sc.nextInt();
						try {
							switch (opcion) {
							case 1: //1. Insertar lector.
								System.out.println("--------------------------------");
								//Solicitud de datos. 
								System.out.print("ID del libro:");
								int idLibro = sc.nextInt();
								Libro libroPres = session.get(Libro.class, idLibro);
								if(libroPres == null) {System.out.println("El libro con ID: " + idLibro + " no existe");}
								
								System.out.print("ID del lector: ");
								int idLector = sc.nextInt();
								Lector lectorPres = session.get(Lector.class, idLector);
								if (lectorPres == null) { System.out.println("El lector con ID: "+ idLector + "no exite.");}
								System.out.println("--------------------------------");
								
														
								
								// Transación a la base de datos. 
								tx = session.beginTransaction();
								try {
									Prestamo prestamo = new Prestamo(new Date(), null, libroPres, lectorPres);
									session.save(prestamo);
									tx.commit();
								} catch (HibernateException e) {
									if(tx != null) {tx.rollback(); e.printStackTrace();}
								}
								
								
								
								break;
							case 2:
								
								break;
							case 3:
								
								break;
							
							default:
								System.out.println("Las opciones son entre 1 y 4");
								break;
						}	
						} catch (InputMismatchException e) {
							System.out.println("Debes escribir un número");
						}	
					}
				default:
					System.out.println("Las opciones son entre 1 y 4");
				}
				
			} catch (InputMismatchException e) {
				System.out.println("Debes escribir un número");
			}
		}
		session.close();
		sessionFactory.close();
	}
}
