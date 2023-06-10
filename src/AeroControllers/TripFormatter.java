package AeroControllers;

import java.text.ParseException;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;
import AeroDAO.AeroDAO;
import AeroDAO.Trip;

@Component(value="tripFormatter")
public class TripFormatter implements Formatter<Trip>{
	@Autowired
	AeroDAO service;
	
	public AeroDAO getService() {
		return service;
	}

	public void setService(AeroDAO service) {
		this.service = service;
	}

	@Override
	public String print(Trip trip, Locale locale) {
	
		
		return String.valueOf(trip.getTripNo());
	}

	@Override
	public Trip parse(String text, Locale locale) throws ParseException {
	
		return service.findbyidtrip(Integer.parseInt(text));
	}

}
