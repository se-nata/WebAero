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
import AeroDAO.Company;
import AeroDAO.Trip;

@Controller
@RequestMapping("/trip/")
public class AeroTripController {
	@Autowired
	AeroDAO service;

	public AeroDAO getService() {
		return service;
	}

	public void setService(AeroDAO service) {
		this.service = service;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String list(Model uiModel) {
		List <Trip> trip=service.findallTrip();
		uiModel.addAttribute("trip", trip);
		return "trip/list";
	}

	@PreAuthorize("hasRole('ROLE_Admin')")
	@RequestMapping(value = "update/{tripNo}/{idComp}", method = RequestMethod.GET)
	public String updateform(@PathVariable("tripNo") int tripNo, @PathVariable("idComp") int idComp,
			Model uiModel) {
		uiModel.addAttribute("trip", service.findbyidtrip(tripNo));
		uiModel.addAttribute("idComp", service.findById(idComp));

		return "/trip/edit";
	}
	@PreAuthorize("hasRole('ROLE_Admin')")
	@RequestMapping(value = "update/{tripNo}/{idComp}", method = RequestMethod.POST)
	public String update(@Valid Trip trip, BindingResult bindingResult, Model uiModel,
			HttpServletRequest httprervletrequest, RedirectAttributes redirectatributes, @PathVariable("tripNo") int tripNo,@PathVariable("idComp") int idComp) {
		 trip.setTripNo(tripNo);
         Company company=service.findById(idComp);
          trip.setComp(company);
	
		  if (bindingResult.hasErrors()) { uiModel.addAttribute("trip",
		  trip); return "trip/edit"; }
		 
		service.updateTrip(trip);
		return "redirect:/trip/";
	}
	@PreAuthorize("hasRole('ROLE_Admin')")
	@RequestMapping(value = "delete/{tripNo}", method = RequestMethod.GET)
	public String delete( @PathVariable("tripNo") int tripNo,Model uiModel) {
		if (service.findbyidtrip(tripNo) != null)
			service.deleteTrip(tripNo);
		
		return "redirect:/trip/";
	}
	
	@PreAuthorize("hasRole('ROLE_Admin')")
	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public String insertnewform(Model uiModel) {
		List <Company> list=service.findallCompany();
		uiModel.addAttribute("companyList",list);
		uiModel.addAttribute("command", new Trip());
	return "trip/insert";	
	}
	
	@PreAuthorize("hasRole('ROLE_Admin')")
	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public String insert(@ModelAttribute("command") @Valid Trip trip, BindingResult bindingResult, Model uiModel,
			HttpServletRequest httprervletrequest, RedirectAttributes redirectatributes) {
			 System.out.println(uiModel);
	
		 service.updateTrip(trip);
		return "redirect:/trip/";
	}
}
