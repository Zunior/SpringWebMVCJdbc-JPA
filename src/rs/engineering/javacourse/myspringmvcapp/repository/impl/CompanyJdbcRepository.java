package rs.engineering.javacourse.myspringmvcapp.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import rs.engineering.javacourse.myspringmvcapp.domain.Company;
import rs.engineering.javacourse.myspringmvcapp.repository.CompanyRepository;

@Repository(value = "companyJdbcRepository")
public class CompanyJdbcRepository implements CompanyRepository{
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private CompanyJdbcRepository(JdbcTemplate jdbcTemplate){
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public void save(Company company) {
		String query = "INSERT INTO company (NAME, ADDRESS, NUMBER, CITY_NUMBER) VALUES (?,?,?,?)";
		jdbcTemplate.update(query, company.getName(), 
									company.getAddress(), 
									company.getNumber(),
									company.getCity().getNumber());
	}

	@Override
	public List<Company> getAll() {
		String query = "SELECT * FROM company";
		return jdbcTemplate.query(query, new UserMapper());
	}
	
	class UserMapper implements RowMapper<Company> {
		@Override
		public Company mapRow(ResultSet rs, int rowNum) throws SQLException {
			Company company = new Company();
			company.setId(rs.getLong("id"));
			company.setName(rs.getString("name"));
			company.setAddress(rs.getString("address"));
			company.setNumber(rs.getString("number"));
			return company;
		}
	}
	
	@Override
	public Company findById(Long id) {
		String query="SELECT * FROM company WHERE id = ?";
		return jdbcTemplate.queryForObject(query,new Object[] {id}, (ResultSet rs, int rowNum)->{
			Company company = new Company();
			company.setName(rs.getString("name"));
			company.setAddress(rs.getString("address"));
			company.setNumber(rs.getString("number"));
			return company;
		});
	}
	
	

}
