package anh.AngularMetroUI.interfaces;

import java.util.List;

import anh.AngularMetroUI.entities.WeatherForecast;

public interface IWeatherForecastsRepository {
	List<WeatherForecast> GetList () throws Exception;

	WeatherForecast GetById (int id) throws Exception;
}
