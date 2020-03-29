package rs.engineering.javacourse.myspringmvcapp.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import rs.engineering.javacourse.myspringmvcapp.domain.City;
import rs.engineering.javacourse.myspringmvcapp.repository.CityRepository;

@Repository(value = "cityJdbcRepository")
public class CityJdbcRepository implements CityRepository{
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private CityJdbcRepository(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public void save(City city) {
		String query = "INSERT INTO city VALUES (?,?)";
		jdbcTemplate.update(query,city.getNumber(),city.getName());
	}

	@Override
	public List<City> getAll() {
		String query = "SELECT * FROM city";
		return jdbcTemplate.query(query, new UserMapper());
	}
	
	class UserMapper implements RowMapper<City> {
		@Override
		public City mapRow(ResultSet rs, int rowNum) throws SQLException {
			City city = new City();
			city.setNumber(rs.getLong("number"));
			city.setName(rs.getString("name"));
			return city;
		}
	}

	@Override
	public City findById(Long number) {
		String query="SELECT * FROM city WHERE number = ?";
		return jdbcTemplate.queryForObject(query,new Object[] {number}, (ResultSet rs, int rowNum)->{
			City city = new City();
			city.setNumber(rs.getLong("number"));
			city.setName(rs.getString("name"));
			return city;
		});
	}
	

}
