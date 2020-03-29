package rs.engineering.javacourse.myspringmvcapp.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import rs.engineering.javacourse.myspringmvcapp.formatter.CityDtoFormatter;
import rs.engineering.javacourse.myspringmvcapp.service.CityService;

//konfigurisanje bean-ova koje koristi dispatcher servlet
//za obradu zahteva
@EnableWebMvc //autormatsko definisanje MapperHandler-a koji na osnovu URL-a poziva odgovarajuci kontroller
@ComponentScan(basePackages = {
		"rs.engineering.javacourse.myspringmvcapp.controller",
		"rs.engineering.javacourse.myspringmvcapp.service",
		"rs.engineering.javacourse.myspringmvcapp.repository",
		"rs.engineering.javacourse.myspringmvcapp.formatter"
})
@Configuration
@Import(MyDatabaseConfig.class)
public class MyWebContextConfig implements WebMvcConfigurer{
	
	private final CityService cityService;
	
	public MyWebContextConfig(CityService cityService) {
		System.out.println("=================================================================");
		System.out.println("==================== MyWebContextConfig =========================");
		System.out.println("=================================================================");
		this.cityService = cityService;
	}
	//hadler mapperi
	
	//controlleri
	//using omponentScan
	/*
	@Bean
	HomeController homeController() {
		return new HomeController();
	}
	*/
	
	//view resolveri
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/pages/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("index");
	}
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addFormatter(new CityDtoFormatter(cityService));
	}
	
}
