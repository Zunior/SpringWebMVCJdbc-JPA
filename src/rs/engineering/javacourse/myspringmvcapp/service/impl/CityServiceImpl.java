package rs.engineering.javacourse.myspringmvcapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.engineering.javacourse.myspringmvcapp.domain.City;
import rs.engineering.javacourse.myspringmvcapp.model.CityDto;
import rs.engineering.javacourse.myspringmvcapp.repository.CityRepository;
import rs.engineering.javacourse.myspringmvcapp.service.CityService;

@Service(value = "cityService")
@Transactional
public class CityServiceImpl implements CityService {
	private CityRepository cityRepository;
	
//	@Autowired
//	public CityServiceImpl(CityRepository cityRepository) {
//		this.cityRepository = cityRepository;
//	}

	@Override
	public void save(CityDto cityDto) {
		City city = new City(cityDto.getNumber(), cityDto.getName());
		cityRepository.save(city);
	}

	@Override
	public List<CityDto> getAll() {
		List<City> cities = cityRepository.getAll();
		List<CityDto> cityDtos = new ArrayList<CityDto>();
		for(City city: cities) {
			cityDtos.add(new CityDto(city.getNumber(), city.getName()));
		}
		return cityDtos;
	}
	
	@Override
	public CityDto findByNumber(Long number) {
		City city = cityRepository.findById(number);
		return new CityDto(city.getNumber(), city.getName());
	}
	
	@Autowired
	@Qualifier(value = "cityJpaRepository")
	public void setCityRepository(CityRepository cityRepository) {
		this.cityRepository = cityRepository;
	}

	
	
}
