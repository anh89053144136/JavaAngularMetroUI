package anh.AngularMetroUI.domain;

import java.util.List;
import java.util.stream.Stream;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import anh.AngularMetroUI.HibernateUtils;
import anh.AngularMetroUI.entities.WeatherForecast;
import anh.AngularMetroUI.interfaces.IWeatherForecastsRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Order;
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

	/**
	 * Получить список
	 */
	@Override
	public List<WeatherForecast> GetList(int pageIndex, int pageSize,
            String sortField, String sortDirection) throws Exception {
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
			//criteria.select(root);
			
			if(sortDirection.toLowerCase().equals("asc") )
				criteria.orderBy(builder.asc(root.get(sortField)));
			else
				criteria.orderBy(builder.desc(root.get(sortField)));
				
			result = em.createQuery(criteria)
					.setFirstResult(pageIndex * pageSize)
					.setMaxResults(pageSize)
					.getResultList();
		}
		catch(HibernateException ex)
		{
			// ToDo BL exception 
			throw new Exception(ex.getMessage());
		}

		return result;
	}

	/**
	 * кол-во записей без фильтрав и постраничного вывода
	 * @return
	 * @throws Exception 
	 */
	public Long GetTotalCount() throws Exception {
		try
		{
			return sessionFactory
					.openSession()
					.getEntityManagerFactory()
					.createEntityManager()
					.createQuery("select count(*) from WeatherForecast", Long.class)
				    .getSingleResult();
		}
		catch(HibernateException ex)
		{
			// ToDo BL exception 
			throw new Exception(ex.getMessage());
		}
	}
	
	/**
	 * Получить одну запись(для редактирования)
	 */
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

			return em.find(WeatherForecast.class, id);
		}
		catch(HibernateException ex)
		{
			// ToDo BL exception 
			throw new Exception(ex.getMessage());
		}
	}
	
	/**
	 * Удалить
	 */
	@Override
	public void Delete(int id) throws Exception {
		var session = sessionFactory.openSession();
		session.beginTransaction();
		
		var obj = new WeatherForecast();
		obj.id = id;
		
		try
		{
			session.remove(obj);
			session.getTransaction().commit();
		}
		catch(HibernateException ex)
		{
			// ToDo BL exception 
			throw new Exception(ex.getMessage());
		}
		finally
		{
			session.close();
		}
	}
	
	/**
	 * Обновить или создать. Должен возвращать обьект т к 
	 */
	public WeatherForecast Save(WeatherForecast obj) throws Exception {
		var session = sessionFactory.openSession();
		session.beginTransaction();
		
		try
		{
			var result = session.merge(obj);
			session.getTransaction().commit();
			
			return result;
		}
		catch(HibernateException ex)
		{
			// ToDo BL exception 
			throw new Exception(ex.getMessage());
		}
		finally
		{
			session.close();
		}
	}
}
