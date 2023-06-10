package AeroDAO;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "trip")
public class Trip implements Serializable {

	private int tripNo;
	private Company comp = new Company();
	private String plane;
	private String townFrom;
	private String townTo;
    private Timestamp timeOut;
	private Timestamp timeIn;
	 
	@OneToMany(mappedBy = "trip", fetch = FetchType.LAZY)
	private Set<PassInTrip> passInTrips = new HashSet<PassInTrip>();

	public Trip(int tripNo, Company comp, String plane, String townFrom, String townTo, Timestamp timeOut,
	Timestamp timeIn) {
		super();
		this.tripNo = tripNo;
		this.comp = comp;
		this.plane = plane;
		this.townFrom = townFrom;
		this.townTo = townTo;
		this.timeOut = timeOut; 
		this.timeIn = timeIn; 
	}

	public Trip() {
	}

	@NotNull
	@Id
	@Column(name="trip_no",insertable = false, updatable = false)
	public int getTripNo() {
		return tripNo;
	}

	public void setTripNo(int tripNo) {
		this.tripNo = tripNo;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_comp")
	public Company getComp() {
		return this.comp;
	}

	public void setComp(Company comp) {
		this.comp = comp;
	}

	@Column(name = "plane")
	public String getPlane() {
		return plane;
	}

	public void setPlane(String plane) {
		this.plane = plane;
	}

	@Column(name = "town_from")
	public String getTownFrom() {
		return townFrom;
	}

	public void setTownFrom(String townFrom) {
		this.townFrom = townFrom;
	}

	@Column(name = "town_to")
	public String getTownTo() {
		return townTo;
	}

	public void setTownTo(String townTo) {
		this.townTo = townTo;
	}
     
    @Column(name = "time_out")
    public Timestamp getTimeOut() {
	    return timeOut; }
		  
	public void setTimeOut(Timestamp timeOut) {
		this.timeOut = timeOut; }
		  
	@Column(name = "time_in") 
	public Timestamp getTimeIn() {
		  return timeIn; }
		  
    public void setTimeIn(Timestamp timeIn) {
		  this.timeIn = timeIn; }
    
	@Override
	public String toString() {
		return "Trip [tripNo=" + tripNo + ", comp=" + comp + ", plane=" + plane + ", townFrom=" + townFrom
				+ ", townTo=" + townTo + ", timeOut=" + timeOut + ", timeIn=" + timeIn + ", passInTrips="
				+ passInTrips + "]";
	}
}
