package AeroDAO;

import java.util.List;

public interface AeroDAO {
	void insert(Company company);
	void save(PassInTrip passintrip);
	public Company findById(int id);
	public int findByCompany(String name);
	public List<Company> findallCompany();
    public void Companydel(int id);
    public void update(Company company);
    public List<PassInTrip> findallPassInTrip();
    public PassInTrip findByIdPassInTrip(int tripId, int passengerId);
    public void deletePassInTrip(int tripId, int passengerId);
    public void update(PassInTrip passintrip);
    public Trip findbyidtrip(int tripno);
    public Passenger findbyidpassenger(int passengerid);
    public List<Trip> findallTrip();
    public List<Passenger> findallPassenger();
    public void deletePassenger(int Id);
    public void updatePassenger(Passenger passenger);
    public void updateTrip(Trip trip);
    public void deleteTrip(int Id);
}



