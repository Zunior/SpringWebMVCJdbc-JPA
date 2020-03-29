package rs.engineering.javacourse.myspringmvcapp.repository;

import java.util.List;

import rs.engineering.javacourse.myspringmvcapp.domain.City;

public interface CityRepository {
	void save(City city);
	List<City> getAll();
	City findById(Long id);
}
