package mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import mvc.entity.Customer;
import mvc.service.CustomerService;

@Component
@RequestMapping("/customer")
public class CustomerController
{
	@Autowired
	CustomerService customerService;
	
	@GetMapping("/list")
	public ModelAndView list()
	{
		List<Customer> customers = customerService.listAllCustomers();
		
		return new ModelAndView("customer/list", "customers", customers);
		
	}
	
}
