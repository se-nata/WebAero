package AeroControllers;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import AeroDAO.AeroDAO;
import AeroDAO.Passenger;

@Controller
@RequestMapping("/passenger/")
public class AeroPassengerController {
	@Autowired
	AeroDAO service;

	public AeroDAO getService() {
		return service;
	}

	public void setService(AeroDAO service) {
		this.service = service;
	}
	
    @RequestMapping(method = RequestMethod.GET)
	public String  list(Model uiModel) {
		List <Passenger> passenger=service.findallPassenger();
		uiModel.addAttribute("passenger",passenger);
	return "passenger/list";
} 
    
    @PreAuthorize("hasRole('ROLE_Admin')")
    @RequestMapping(value="delete/{id}",method = RequestMethod.GET)
    public String delete(@PathVariable("id") int id, Model uiModel) {
    	if(service.findbyidpassenger(id)!=null)
    		service.deletePassenger(id);
    	return "redirect:/passenger/";
    }
    @PreAuthorize("hasRole('ROLE_Admin')")
	@RequestMapping(value = "update/{id}",method = RequestMethod.GET)
	public String updateForm(@PathVariable("id")int id, Model uiModel) {
    
		uiModel.addAttribute ("passenger", service.findbyidpassenger(id));
		return "passenger/edit";
    }
    
    @PreAuthorize("hasRole('ROLE_Admin')")
    @RequestMapping(value="update/{id}",method = RequestMethod.POST)
    public String update(Passenger passenger,@PathVariable("id") int id,BindingResult bindingResult, Model uiModel,
			HttpServletRequest httprervletrequest, RedirectAttributes redirectatributes) {
    
    	if (bindingResult.hasErrors()) {
			uiModel.addAttribute("passenger", passenger);
			return "passenger/update";
		}
   
    	passenger.setPassengerId(id);
    	service.updatePassenger(passenger);
    	return "redirect:/passenger/";
    }
    
    @PreAuthorize("hasRole('ROLE_Admin')")
    @RequestMapping(value="insert",method = RequestMethod.GET)
	public String newForm( Model uiModel) {
  
		return "passenger/insert";
	}
    @PreAuthorize("hasRole('ROLE_Admin')")
    @RequestMapping(value="insert",method = RequestMethod.POST)
    public String insert(@Valid Passenger  passenger,BindingResult bindingResult, Model uiModel,
			HttpServletRequest httprervletrequest, RedirectAttributes redirectatributes) {
    	service.updatePassenger(passenger);
    	return "redirect:/passenger/";
    }
}
