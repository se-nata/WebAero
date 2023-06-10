package AeroDAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("jpaService")
@Repository
@Transactional
public class JPAAreoDAO implements AeroDAO {

	@PersistenceContext
	private EntityManager em;


	public void insert(Company company) {
		em.persist(company);
	}

	public List<Company> findallCompany() {
		List<Company> company = em.createQuery("select с from  Company с", Company.class).getResultList();
		return company;
	}

	public Company findById(int id) {
		TypedQuery<Company> query = em.createQuery("select c from Company c where c.id=:id", Company.class);
		query.setParameter("id", id);
		return query.getSingleResult();
	}

	public int findByCompany(String name) {
		TypedQuery<Company> query = em.createQuery("select c from Company c where c.name=:name", Company.class);
		query.setParameter("name", name);
		Company c = query.getSingleResult();
		return c.getIdComp();
	}

	@Override
	public void Companydel(int id) {
		
		em.remove(em.find(Company.class, id));
	
	}

	@Override
	public void update(Company company) {
		 if (company.getIdComp()!=0 && em.find(Company.class,
		 company.getIdComp())!=null)
		em.merge(company);
	}

	@Override
	public List<PassInTrip> findallPassInTrip() {

		List<PassInTrip> passintrip = em.createQuery("select c from  PassInTrip c", PassInTrip.class).getResultList();

		return passintrip;

	}

	@Override
	public PassInTrip findByIdPassInTrip(int tripId, int passengerId) {
		KeysPassInTrip kpit = new KeysPassInTrip();
		kpit.setTripId(tripId);
		kpit.setPsgId(passengerId);
		return em.find(PassInTrip.class, kpit);
	}

	@Override
	public void deletePassInTrip(int tripId, int passengerId) {
		KeysPassInTrip kpit = new KeysPassInTrip();
		kpit.setTripId(tripId);
		kpit.setPsgId(passengerId);

		em.remove(em.find(PassInTrip.class, kpit));

	}

	@Override
	public void save(PassInTrip passintrip) {

		em.merge(passintrip);

	}

	@Override
	public void update(PassInTrip passintrip) {
		em.merge(passintrip);

	}

	@Override
	public Trip findbyidtrip(int tripno) {
		TypedQuery<Trip> query = em.createQuery("select c from Trip c where c.id=:id", Trip.class);
		query.setParameter("id", tripno);
		return query.getSingleResult();
	}

	@Override
	public Passenger findbyidpassenger(int passengerid) {
		TypedQuery<Passenger> query = em.createQuery("select c from Passenger c where c.id=:id", Passenger.class);
		query.setParameter("id", passengerid);
		return query.getSingleResult();
	}

	@Override
	public List<Trip> findallTrip() {
		List<Trip> trip = em.createQuery("select с from  Trip с", Trip.class).getResultList();
		return trip;
	}

	@Override
	public List<Passenger> findallPassenger() {
		List<Passenger> passenger = em.createQuery("select с from  Passenger с", Passenger.class).getResultList();
		return passenger;
	}

	@Override
	public void deletePassenger(int Id) {
		em.remove(em.find(Passenger.class, Id));
		
	}

	@Override
	public void updatePassenger(Passenger passenger) {
		
		em.merge(passenger);
		
	}

	@Override
	public void updateTrip(Trip trip) {
		em.merge(trip);
		
	}

	@Override
	public void deleteTrip(int Id) {
		em.remove(em.find(Trip.class, Id));
		
	}

}
