package rs.engineering.javacourse.myspringmvcapp.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import rs.engineering.javacourse.myspringmvcapp.model.CityDto;
import rs.engineering.javacourse.myspringmvcapp.service.CityService;

@Component
public class CityDtoFormatter implements Formatter<CityDto>{
	
	private final CityService cityService;
	
	public CityDtoFormatter(CityService cityService) {
		this.cityService = cityService;
		System.out.println("========================CityDtoFormatter   constructor===============================");

	}

	@Override
	public String print(CityDto cityDto, Locale locale) {
		System.out.println("========================CityDtoFormatter   print===============================");
		System.out.println(cityDto);
		System.out.println("==============================================================================");
		return cityDto.toString();
	}

	@Override
	public CityDto parse(String city, Locale locale) throws ParseException {
		System.out.println("========================CityDtoFormatter   parse===============================");
		System.out.println(city);
		System.out.println("====================================================================");
		return cityService.findByNumber(new Long(city));
	}

}
