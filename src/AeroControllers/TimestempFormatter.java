package AeroControllers;

import java.sql.Timestamp;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.util.Locale;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

@Component(value = "timestempFormatter")
public class TimestempFormatter implements Formatter<Timestamp>{

	@Override
	public String print(Timestamp object, Locale locale) {
	

		return object.toString();
	}

	@Override
	public Timestamp parse(String text, Locale locale) throws ParseException {

	
		return Timestamp.valueOf(LocalDateTime.parse(text));
	}

}
