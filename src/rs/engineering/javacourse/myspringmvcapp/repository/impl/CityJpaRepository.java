package rs.engineering.javacourse.myspringmvcapp.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import rs.engineering.javacourse.myspringmvcapp.domain.City;
import rs.engineering.javacourse.myspringmvcapp.repository.CityRepository;
import rs.engineering.javacourse.myspringmvcapp.repository.impl.CityJdbcRepository.UserMapper;

@Repository(value = "cityJpaRepository")
@Transactional(propagation = Propagation.MANDATORY)
public class CityJpaRepository implements CityRepository{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public void save(City city) {
		entityManager.persist(city);
	}

	@Override
	public List<City> getAll() {
		return entityManager.createQuery("select c from City c").getResultList();
	}
	
	@Override
	public City findById(Long id) {
		return entityManager.find(City.class, id);
	}
	
}
