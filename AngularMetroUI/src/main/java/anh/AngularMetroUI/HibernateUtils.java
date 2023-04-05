package anh.AngularMetroUI;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import anh.AngularMetroUI.entities.WeatherForecast;

public class HibernateUtils {

	private static SessionFactory sessionFactory;

	/**
	 *  A SessionFactory is set up once for an application!
	 * @return
	 * @throws Exception
	 */
	public static SessionFactory GetSessionFactory() throws Exception {
		if(sessionFactory != null)
			return sessionFactory;


		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
		        //.configure( "resources/hibernate.cfg.xml" )
		        .loadProperties( "resources/application.properties" )
				.build();
		try {
			//sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();

			sessionFactory = new MetadataSources(registry)
			.addAnnotatedClass(WeatherForecast.class)
			.buildMetadata()
			.buildSessionFactory();
		}
		catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble building the SessionFactory
			// so destroy it manually.
			StandardServiceRegistryBuilder.destroy( registry );
		}

		return sessionFactory;
	}
}
