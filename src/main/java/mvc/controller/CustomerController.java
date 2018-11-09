package mvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mvc.entity.Customer;
import mvc.entity.CustomerDetail;
import mvc.service.AccountManagerService;
import mvc.service.CustomerService;
import mvc.service.LoyaltyProgramService;

@Controller
@RequestMapping("/customer")
public class CustomerController
{
	@Autowired
	CustomerService customerService;
	
	@Autowired
	AccountManagerService accountManagerService;
	
	@Autowired
	LoyaltyProgramService loyaltyProgramService;
	
	@GetMapping("/list")
	public ModelAndView list()
	{
		List<Customer> customers = customerService.listAllCustomers();
		
		return new ModelAndView("customer/list", "customers", customers);
		
	}
	
	@GetMapping("/showAddForm")
	public ModelAndView showAddForm()
	{
		
		ModelAndView model = new ModelAndView("customer/customer-form");
		
		Customer customer = new Customer();
		model.addObject("customer", customer);
		
		Map<Integer, String> accountManagersMap = new HashMap<>();
		accountManagersMap = accountManagerService.mapAllAccountManagersIdAndFullNames();
		model.addObject("accountManagersMap", accountManagersMap);
		
		Map<Integer, String> loyaltyProgramsMap = new HashMap<>();
		loyaltyProgramsMap = loyaltyProgramService.mapAllLoyaltyProgramsIdAndTitles();
		model.addObject("loyaltyProgramsMap", loyaltyProgramsMap);

		return model;
		
	}
	
	
	@GetMapping("/confirmCustomer")
	public ModelAndView confirmCustomer(@ModelAttribute("customer") Customer customer, BindingResult result)
	{
		ModelAndView model = new ModelAndView("customer/confirm-customer");
		
		
		
		return model;
		
	}
	
}
