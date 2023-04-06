package anh.AngularMetroUI.interfaces;

import java.util.List;

import anh.AngularMetroUI.entities.WeatherForecast;

public interface IWeatherForecastsRepository {
	List<WeatherForecast> GetList () throws Exception;

	WeatherForecast GetById (int id) throws Exception;
	
	void Delete(int id) throws Exception;
	
	WeatherForecast Save(WeatherForecast obj) throws Exception;
}
