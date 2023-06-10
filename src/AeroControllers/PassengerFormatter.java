package AeroControllers;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import AeroDAO.AeroDAO;
import AeroDAO.Passenger;
@Component(value="passengerFormatter")
public class PassengerFormatter implements Formatter<Passenger>{
    @Autowired
	AeroDAO service;
    
    
	public AeroDAO getService() {
		return service;
	}

	public void setService(AeroDAO service) {
		this.service = service;
	}

	@Override
	public String print(Passenger passenger, Locale locale) {
		
		return String.valueOf(passenger.getPassengerId());
	}

	@Override
	public Passenger parse(String text, Locale locale) throws ParseException {
		
		return service.findbyidpassenger(Integer.parseInt(text));
	}

}
