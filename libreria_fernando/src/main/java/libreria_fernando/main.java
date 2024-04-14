package libreria_fernando;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.SessionFactory;

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
			System.out.println("\t\tBIBLIOTECA");
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
			
			switch (opcion) {
			case 1: // 1. Insertar Libro.
				
				break;	
			case 2: // 2. Insertar Lector.
				
				break;
			case 3: // 3. Listado de Libros.
				
				break;
			case 4: // 4. Listado de Lectores.
	
				break;
			
			case 5: // 5. Ver Libro por ID.
				
				break;
			case 6: // 6. Ver Lector por ID.
				
				break;
				
			default:
				System.out.println("Opción incorrecta, inténtalo de nuevo...");
				break;
			}
			
		} while (opcion !=7);
		
		
		
		
		session.close();
		sessionFactory.close();
	}

}
