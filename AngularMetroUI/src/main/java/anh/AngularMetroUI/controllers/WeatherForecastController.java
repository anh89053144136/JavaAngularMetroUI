package anh.AngularMetroUI.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import anh.AngularMetroUI.entities.WeatherForecast;
import anh.AngularMetroUI.interfaces.IWeatherForecastsRepository;
import anh.AngularMetroUI.models.ListPageResult;
import anh.AngularMetroUI.models.RequestResult;
import anh.AngularMetroUI.models.ResultStatus;

@RestController
public class WeatherForecastController {

	@Autowired
	public IWeatherForecastsRepository repoUser;

	@GetMapping("weatherforecast")
	public RequestResult<ListPageResult> Get()
	{
		var result = new RequestResult<ListPageResult>();

		var resultList = new ListPageResult<WeatherForecast>();
		resultList.totalcount = 10;
		try {
			resultList.list = repoUser.GetList();
		} catch (Exception e) {
			e.printStackTrace();

			result.message = e.getMessage();
			result.code = ResultStatus.Fail;

			return result;
		}

		result.code = ResultStatus.Ok;
		result.result = resultList;

		return result;
	}

	@GetMapping("weatherforecast/{id}")
	public RequestResult<WeatherForecast> Get(@PathVariable int id)
	{
		var result = new RequestResult<WeatherForecast>();

		result.code = ResultStatus.Ok;

		try {
			result.result = repoUser.GetById(id);
		} catch (Exception e) {
			e.printStackTrace();

			result.message = e.getMessage();
			result.code = ResultStatus.Fail;

			return result;
		}

		return result;
	}
}
