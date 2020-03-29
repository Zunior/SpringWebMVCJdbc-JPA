package rs.engineering.javacourse.myspringmvcapp.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import rs.engineering.javacourse.myspringmvcapp.domain.City;

public class CompanyDto {
	@NotBlank(message = "Morate uneti ime")
	private String name;
	@NotBlank(message = "Morate uneti adresu")
	private String address;
	@NotBlank(message = "Morate uneti broj ulice")
	private String number;
	CityDto cityDto;

	public CompanyDto() {

	}

	
	
	public CompanyDto(@NotBlank(message = "Morate uneti ime") String name,
			@NotBlank(message = "Morate uneti adresu") String address,
			@NotBlank(message = "Morate uneti broj ulice") String number) {
		super();
		this.name = name;
		this.address = address;
		this.number = number;
	}



	public CompanyDto(String name, String address, String number, CityDto cityDto) {
		super();
		this.name = name;
		this.address = address;
		this.number = number;
		this.cityDto = cityDto;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public CityDto getCityDto() {
		return cityDto;
	}

	public void setCityDto(CityDto cityDto) {
		this.cityDto = cityDto;
	}

	@Override
	public String toString() {
		return "CompanyDto [name=" + name + ", address=" + address + ", number=" + number + ", cityDto=" + cityDto
				+ "]";
	}

	
	
}
