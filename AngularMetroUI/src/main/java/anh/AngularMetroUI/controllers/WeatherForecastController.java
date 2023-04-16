package anh.AngularMetroUI.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import anh.AngularMetroUI.entities.WeatherForecast;
import anh.AngularMetroUI.interfaces.IWeatherForecastsRepository;
import anh.AngularMetroUI.models.*;

@RestController
public class WeatherForecastController {

	@Autowired
	public IWeatherForecastsRepository repo;

	@GetMapping("weatherforecast")
	public RequestResult<ListPageResult> Get(int pageIndex, int pageSize,
            String sortField, String sortDirection)
	{
		var result = new RequestResult<ListPageResult>();

		var resultList = new ListPageResult<WeatherForecast>();
		try {
			resultList.list = repo.GetList(pageIndex, pageSize, sortField, sortDirection);
			resultList.totalCount = repo.GetTotalCount();
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
			result.result = repo.GetById(id);
		} catch (Exception e) {
			e.printStackTrace();

			result.message = e.getMessage();
			result.code = ResultStatus.Fail;

			return result;
		}

		return result;
	}
	
	@DeleteMapping("weatherforecast/{id}")
	public RequestResult<WeatherForecast> Delete(@PathVariable int id)
	{
		var result = new RequestResult<WeatherForecast>();

		result.code = ResultStatus.Ok;

		try {
			repo.Delete(id);
		} catch (Exception e) {
			e.printStackTrace();

			result.message = e.getMessage();
			result.code = ResultStatus.Fail;

			return result;
		}

		return result;
	}
	
	@PostMapping("edit/weatherforecast")
	public RequestResult<WeatherForecast> Save(@RequestBody WeatherForecast obj)
	{
		var result = new RequestResult<WeatherForecast>();

		result.code = ResultStatus.Ok;

		try {
			result.result = repo.Save(obj);
		} catch (Exception e) {
			e.printStackTrace();

			result.message = e.getMessage();
			result.code = ResultStatus.Fail;

			return result;
		}

		return result;
	}
}