package AeroDAO;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
@Embeddable
public class KeysPassInTrip implements Serializable{
	
	@Column(name = "id_psg")
	private int psgId;
	
	@Column(name = "trip_no" )
	private int tripId;
	
	public KeysPassInTrip() {}

	public int getPsgId() {
		return psgId;
	}

	public void setPsgId(int psgId) {
		this.psgId = psgId;
	}

	public int getTripId() {
		return tripId;
	}

	public void setTripId(int tripId) {
		this.tripId = tripId;
	}
    @Override
	public int hashCode() {
		return Objects.hash(psgId, tripId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		KeysPassInTrip other = (KeysPassInTrip) obj;
		return psgId == other.psgId && tripId == other.tripId;
	}


}
