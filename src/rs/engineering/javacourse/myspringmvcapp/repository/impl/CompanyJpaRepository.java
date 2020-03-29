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
import rs.engineering.javacourse.myspringmvcapp.domain.Company;
import rs.engineering.javacourse.myspringmvcapp.repository.CompanyRepository;

@Repository(value = "companyJpaRepository")
@Transactional(propagation = Propagation.MANDATORY)
public class CompanyJpaRepository implements CompanyRepository{
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public void save(Company company) {
		entityManager.persist(company);
	}
	
	@Override
	public List<Company> getAll() {
		return entityManager.createQuery("select c from Company c").getResultList();
	}

	@Override
	public Company findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
