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
import AeroDAO.Company;

@Controller
@RequestMapping("/company/")
public class AeroCompanyController {
	@Autowired
	private AeroDAO companyService;

	
	public void setCompanyService(AeroDAO companyService) {
		this.companyService = companyService;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model uiModel) {

		List<Company> company = companyService.findallCompany();
		uiModel.addAttribute ("company", company);
		return "company/list";
	}

	@PreAuthorize("hasRole('ROLE_Admin')")
	@RequestMapping(value = "delete/{id}",method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id, Model uiModel) {
		
			companyService.Companydel(id);
		  return "redirect:/company/";
	}
	@PreAuthorize("hasRole('ROLE_Admin')")
	@RequestMapping(value = "update/{id}",method = RequestMethod.GET)
	public String updateForm(@PathVariable("id") int id, Model uiModel) {
		uiModel.addAttribute ("company", companyService.findById(id));
		return "company/edit";
	}
	
	@PreAuthorize("hasRole('ROLE_Admin')")
	@RequestMapping(value = "update/{id}", method = RequestMethod.POST)
	public String update(Company company,@PathVariable("id") int id, BindingResult bindingResult,
				Model uiModel, HttpServletRequest httpServletRequest,
				RedirectAttributes redirectAttributes) {
	    company.setIdComp(id);
		companyService.update(company);
		return "redirect:/company/";
	}
    @PreAuthorize("hasRole('ROLE_Admin')")
    @RequestMapping(value="insert",method = RequestMethod.GET)
	public String insert( Model uiModel) {
  
		return "company/insert";
	}
    @PreAuthorize("hasRole('ROLE_Admin')")
    @RequestMapping(value="insert",method = RequestMethod.POST)
    public String insert(@Valid Company  company,BindingResult bindingResult, Model uiModel,
			HttpServletRequest httprervletrequest, RedirectAttributes redirectatributes) {
    	companyService.insert(company);
    	return "redirect:/company/";
    }
}
