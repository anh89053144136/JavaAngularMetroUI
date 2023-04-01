package anh.AngularMetroUI.entities;

import java.util.Date;
/*
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table( name = "WeatherForecasts" )*/
public class WeatherForecast {
	public WeatherForecast()
	{
		Id = 0;
	}
	
	/*@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")*/
	public Integer Id;
	
	//@Column(name="TemperatureC")
	public Integer TemperatureC;
	
	//@Column(name="Summary")
	public String Summary;
	
	//@Temporal(TemporalType.TIMESTAMP)
	public Date Date;
}
