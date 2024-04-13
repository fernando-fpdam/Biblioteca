package libreria_fernando;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.SessionFactory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class main {

	public static void main(String[] args) {
		System.out.println("INICO DEL PROGRAMA...");
		// Para indicar que queremos usar Hibernate definimos las interfaces.
		
		Configuration cfg = new Configuration().configure();
		
		// Única instancia de sessionFactory en nuestra sesión.
		
		SessionFactory sessionFactory = cfg.buildSessionFactory(new StandardServiceRegistryBuilder().configure().build());
		Session session = sessionFactory.openSession();
		
		System.out.println("CONFIGURACIÓN REALIZADA");
		
		
		session.close();
		sessionFactory.close();
	}

}
