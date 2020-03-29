package rs.engineering.javacourse.myspringmvcapp.repository;

import java.util.List;

import rs.engineering.javacourse.myspringmvcapp.domain.Company;

public interface CompanyRepository {
	void save(Company company);
	List<Company> getAll();
	public Company findById(Long id);
}
