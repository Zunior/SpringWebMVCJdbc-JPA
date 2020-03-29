package rs.engineering.javacourse.myspringmvcapp.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.engineering.javacourse.myspringmvcapp.domain.City;
import rs.engineering.javacourse.myspringmvcapp.domain.Company;
import rs.engineering.javacourse.myspringmvcapp.model.CityDto;
import rs.engineering.javacourse.myspringmvcapp.model.CompanyDto;
import rs.engineering.javacourse.myspringmvcapp.repository.CompanyRepository;
import rs.engineering.javacourse.myspringmvcapp.service.CompanyService;

@Service(value = "companyService")
@Transactional
public class CompanyServiceImpl implements CompanyService {
	private CompanyRepository companyRepository;
//	@SuppressWarnings("unused")
//	private CityRepository cityRepository;

//	@Autowired
//	public CompanyServiceImpl(CompanyRepository companyRepository) {
//		this.companyRepository = companyRepository;
//	}

	@Override
	public void save(CompanyDto companyDto) {
		Company company = new Company(companyDto.getName(), companyDto.getAddress(), companyDto.getNumber(),
				new City(companyDto.getCityDto().getNumber(), companyDto.getName()));
		companyRepository.save(company);
	}

	@Override
	public List<CompanyDto> getAll() {
		List<Company> companies = companyRepository.getAll();
		List<CompanyDto> companyDtos = new ArrayList<CompanyDto>();
		for(Company company: companies) {
			companyDtos.add(new CompanyDto(company.getName(), company.getAddress(), company.getNumber()));
		}
		return companyDtos;
	}
	
	@Override
	public CompanyDto findById(Long id) {
		Company company = companyRepository.findById(id);
		return new CompanyDto(company.getName(), company.getAddress(), company.getNumber());
	}

	@Autowired
	@Qualifier(value = "companyJpaRepository")
	public void setCompanyRepository(CompanyRepository companyRepository) {
		this.companyRepository = companyRepository;
	}

//	@Autowired
//	@Qualifier(value = "cityJdbcRepository")
//	public void setCityRepository(CityRepository cityRepository) {
//		this.cityRepository = cityRepository;
//	}

}
