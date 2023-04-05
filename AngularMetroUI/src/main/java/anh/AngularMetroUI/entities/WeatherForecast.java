package anh.AngularMetroUI.entities;

import java.util.Date;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table( name = "WeatherForecasts" )
public class WeatherForecast {
	public WeatherForecast()
	{
		id = 0;
	}

	@Id
	@GeneratedValue(generator="increment")
	@GenericGenerator(name="increment", strategy = "increment")
	public Integer id;

	@Column(name="TemperatureC")
	public Integer temperatureC;

	@Column(name="Summary")
	public String summary;

	@Temporal(TemporalType.TIMESTAMP)
	public Date date;
	
	//@Formula("grossIncome * taxInPercents / 100")
}
