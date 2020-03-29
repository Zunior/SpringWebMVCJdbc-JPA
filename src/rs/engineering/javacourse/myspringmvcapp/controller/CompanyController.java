package rs.engineering.javacourse.myspringmvcapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import rs.engineering.javacourse.myspringmvcapp.model.CityDto;
import rs.engineering.javacourse.myspringmvcapp.model.CompanyDto;
import rs.engineering.javacourse.myspringmvcapp.service.CityService;
import rs.engineering.javacourse.myspringmvcapp.service.CompanyService;

@Controller
@RequestMapping(value = "/company")
public class CompanyController {
	
	private final CompanyService companyService;
	
	private final CityService cityService;
	
	CompanyController(CompanyService companyService, CityService cityService){
		this.cityService = cityService;
		this.companyService = companyService;
	}
	
	@GetMapping
	public String home() {
		return "company/home";
	}
	
	@GetMapping(value = "add")
	public ModelAndView add(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("====================================================================");
		System.out.println("====================   CompanyController: add()     ===================");
		System.out.println("====================================================================");
		
		ModelAndView modelAndView = new ModelAndView("company/add");
		
		CompanyDto companyDto = new CompanyDto("N/A", "N/A", "N/A", null);
		List<CityDto> cityDtos = cityService.getAll();
		modelAndView.addObject("companyDto",companyDto);
		modelAndView.addObject("cityDtos", cityDtos);
		
		return modelAndView;
	}
	
	
	
	@PostMapping(value = "save")
	public ModelAndView save(@ModelAttribute(name="companyDto")@Valid CompanyDto companyDto, BindingResult result) {
		System.out.println("===================================================================================");
		System.out.println(companyDto);
		System.out.println("====================   ComapnyController: save(@ModelAttribute)    ===================");
		System.out.println("===================================================================================");
		
		ModelAndView modelAndView = new ModelAndView();
		
		if(result.hasErrors()) {
			System.out.println("====================   NOT OK    ===================");
			modelAndView.setViewName("company/add");
			List<CityDto> cityDtos = cityService.getAll();
			modelAndView.addObject("cityDtos", cityDtos);
			modelAndView.addObject("companyDto", companyDto);
		}else {
			modelAndView.setViewName("company/home");
			System.out.println(companyDto);
			System.out.println("====================   OK    ===================");
			modelAndView.addObject("obavestenje", "Kompanija je uspesno dodata");
			companyService.save(companyDto);
		}
		return modelAndView;
	}
	
	@GetMapping(value = "list")
	public ModelAndView list() {
			ModelAndView modelAndView = new ModelAndView("company/list");
			List<CompanyDto> companyDtos = companyService.getAll();
			modelAndView.addObject("companyDtos", companyDtos);
			return modelAndView;
	}
}
