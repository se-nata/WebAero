package AeroDAO;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table (name="pass_in_trip")
public class PassInTrip implements Serializable  {

	@EmbeddedId
	private KeysPassInTrip key=new KeysPassInTrip();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("tripId")
	@JoinColumn(name="trip_no")
	Trip trip = new Trip();
	
	@ManyToOne(fetch = FetchType.LAZY)
	@MapsId("psgId")
	@JoinColumn(name="id_psg")
	Passenger passenger = new Passenger();
	
	@Column(name="place")
	private String place;
	
	@Column(name="date")
	private Timestamp date;
	

	public Timestamp getDate() {
		return date;
	}

	public void setDate(Timestamp date) {
		this.date = date;
	}

	public PassInTrip() {}

	public KeysPassInTrip getKey() {
		return key;
	}

	public void setKey(KeysPassInTrip key) {
		this.key = key;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	@Override
	public String toString() {
		return "PassInTrip [key=" + key.getPsgId() + ", trip=" + trip + ", passenger=" + passenger + ", place=" + place
				+ ", date=" + date + "]";
	}
}
