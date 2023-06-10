package AeroDAO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="passenger")
public class Passenger  implements Serializable {
  
	private String name;
	private int passengerId;

	@OneToMany(mappedBy = "passenger",fetch = FetchType.LAZY)
	private Set<PassInTrip> passInTrips;

	public Passenger() {
		 passInTrips=new HashSet<PassInTrip>();
	}

	@NotNull
	@Id
	@Column(insertable = false,updatable = false, name="id_psg")
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int idPsg) {
		this.passengerId = idPsg;
	}

	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Passenger [name=" + name + ", passengerId=" + passengerId + ", passInTrips=" + passInTrips + "]";
	}
}
