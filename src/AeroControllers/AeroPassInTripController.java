package AeroControllers;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import AeroDAO.AeroDAO;
import AeroDAO.PassInTrip;
import AeroDAO.Passenger;
import AeroDAO.Trip;

@Controller
@RequestMapping("/passintrip/")
public class AeroPassInTripController {

	private AeroDAO service;

	@Autowired
	public void setService(AeroDAO service) {
		this.service = service;
	}
	

	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model uiModel) {

		List<PassInTrip> passintrip = service.findallPassInTrip();

		uiModel.addAttribute("passintrip", passintrip);
		;
		return "/passintrip/list";

	}

	@PreAuthorize("hasRole('ROLE_Admin')")
	@RequestMapping(value = "delete/{p1}/{p2}", method = RequestMethod.GET)
	public String delete(@PathVariable("p1") int id, @PathVariable("p2") int id2, Model uiModel) {

		if (service.findByIdPassInTrip(id, id2) != null)
			service.deletePassInTrip(id, id2);
		return "redirect:/passintrip/";
	}

	@PreAuthorize("hasRole('ROLE_Admin')")
	@RequestMapping(value = "update/{tripId}/{passengerId}", method = RequestMethod.GET)
	public String updateform(@PathVariable("tripId") int tripId, @PathVariable("passengerId") int passengerId,
			Model uiModel) {

		uiModel.addAttribute("passintrip", service.findByIdPassInTrip(tripId, passengerId));
	
		return "/passintrip/edit";
	}

	@RequestMapping(value = "update/0", method = RequestMethod.GET)
	public String newform(Model uiModel) {
	return "/passintrip/edit";
	}

	@PreAuthorize("hasRole('ROLE_Admin')")
	@RequestMapping(value = "update/{tripId}/{passengerId}", method = RequestMethod.POST)
	public String update(@Valid PassInTrip passintrip, BindingResult bindingResult, Model uiModel,
			HttpServletRequest httprervletrequest, RedirectAttributes redirectatributes, @PathVariable("tripId") int id,
			@PathVariable("passengerId") int id2) {
		Trip trip = service.findbyidtrip(id);
		Passenger passenger = service.findbyidpassenger(id2);
		passintrip.setTrip(trip);
		passintrip.setPassenger(passenger);
	
		
		  if (bindingResult.hasErrors()) { uiModel.addAttribute("passintrip",
		  passintrip); return "passintrip/edit"; }
		 
		service.save(passintrip);
		return "redirect:/passintrip/";
	}

	@PreAuthorize("hasRole('ROLE_Admin')")
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String insertnewform(Model uiModel) {

		List<Trip> tripList = service.findallTrip();
		List<Passenger> passengerList = service.findallPassenger();
		uiModel.addAttribute("tripList", tripList);
		uiModel.addAttribute("passengerList", passengerList); 
		
		uiModel.addAttribute("command", new PassInTrip());
		return "/passintrip/insert";
	}

	
	@PreAuthorize("hasRole('ROLE_Admin')")
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(@ModelAttribute("command") @Valid PassInTrip passintrip, BindingResult bindingResult, Model uiModel,
			HttpServletRequest httprervletrequest, RedirectAttributes redirectatributes) {

		  if (bindingResult.hasErrors()) { uiModel.addAttribute("passintrip",
		  passintrip); return "passintrip/edit"; }
		 
		service.save(passintrip);

		return "redirect:/passintrip/";
	}



}