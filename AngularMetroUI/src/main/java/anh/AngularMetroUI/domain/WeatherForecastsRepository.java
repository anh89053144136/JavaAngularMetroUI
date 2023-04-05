package anh.AngularMetroUI.domain;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import anh.AngularMetroUI.HibernateUtils;
import anh.AngularMetroUI.entities.WeatherForecast;
import anh.AngularMetroUI.interfaces.IWeatherForecastsRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

@Repository
public class WeatherForecastsRepository implements IWeatherForecastsRepository {

	private SessionFactory sessionFactory;

	public WeatherForecastsRepository() {
		try {
			sessionFactory = HibernateUtils.GetSessionFactory();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<WeatherForecast> GetList() throws Exception {
		List<WeatherForecast> result = null;

		try
		{
			EntityManager em = sessionFactory
					.openSession()
					.getEntityManagerFactory()
					.createEntityManager();

			CriteriaBuilder builder = em.getCriteriaBuilder();

			CriteriaQuery<WeatherForecast> criteria = builder.createQuery(WeatherForecast.class);
			Root<WeatherForecast> root = criteria.from(WeatherForecast.class);
			criteria.select(root);

			result = em.createQuery(criteria).getResultList();
		}
		catch(HibernateException ex)
		{
			throw new Exception(ex.getMessage());
		}

		return result;
	}

	@Override
	public WeatherForecast GetById(int id) throws Exception
	{
		try
		{
			EntityManager em = sessionFactory
					.openSession()
					.getEntityManagerFactory()
					.createEntityManager();

			CriteriaBuilder builder = em.getCriteriaBuilder();
/*
			CriteriaQuery<WeatherForecast> criteria = builder.createQuery(WeatherForecast.class);
			Root<WeatherForecast> root = criteria.from(WeatherForecast.class);

			criteria.select(root).where(
				    builder.and(builder.equal(root.get("Id"), id))
			);
*/
			return em.find(WeatherForecast.class, id);
			
			//return em.createQuery(criteria).getSingleResult();
		}
		catch(HibernateException ex)
		{
			throw new Exception(ex.getMessage());
		}
	}
}
