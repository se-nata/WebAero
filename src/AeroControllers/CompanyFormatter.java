package AeroControllers;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import AeroDAO.AeroDAO;
import AeroDAO.Company;
@Component(value="companyFormatter")
public class CompanyFormatter implements Formatter<Company>{
	@Autowired
	AeroDAO service;
 
	public AeroDAO getService() {
		return service;
	}

	public void setService(AeroDAO service) {
		this.service = service;
	}

	@Override
	public String print(Company company, Locale locale) {
		
		return String.valueOf(company.getIdComp());
	}

	@Override
	public Company parse(String text, Locale locale) throws ParseException {
		System.out.println(service.findById(Integer.parseInt(text)));
		return service.findById(Integer.parseInt(text));
	}

	

}
