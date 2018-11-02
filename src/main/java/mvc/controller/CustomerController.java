package mvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mvc.entity.Customer;
import mvc.service.AccountManagerService;
import mvc.service.CustomerService;

@Component
@RequestMapping("/customer")
public class CustomerController
{
	@Autowired
	CustomerService customerService;
	
	@Autowired
	AccountManagerService accountManagerService;
	
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
		
		Map<Integer, String> accountManagersMap = new HashMap<>();
		accountManagersMap = accountManagerService.mapAllAccountManagersIdAndFullNames();
		
		model.addObject("customer", customer);
		model.addObject("accountManagersMap", accountManagersMap);
		
		
		
		
		return model;
		
	}
	
}
