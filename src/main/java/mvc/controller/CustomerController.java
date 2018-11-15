package mvc.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import mvc.entity.Customer;
import mvc.entity.LoyaltyProgram;
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

	@Value("${pageSize:10}")
	private int pageSize;

	@GetMapping("/list")
	public ModelAndView list(@RequestParam(name = "pageNumber", required = false, defaultValue = "1") int pageNumber)
	{
		ModelAndView model = new ModelAndView("customer/list");

		long totalCustomerCount = customerService.getCustomersCount();

		int totalPages = (int) Math.ceil(totalCustomerCount / (double) pageSize);

		List<Customer> customers = customerService.getCustomersByPage(pageNumber);

		model.addObject("customers", customers);
		model.addObject("totalCustomerCount", totalCustomerCount);
		model.addObject("currentPage", pageNumber);
		model.addObject("totalPages", totalPages);
		model.addObject("pageSize", pageSize);

		return model;

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
	public String saveAndConfirmCustomer( @ModelAttribute("customer") Customer customer, BindingResult result)
	{
		customerService.saveOrUpdateCustomer(customer);

		return "customer/confirm-customer";

	}

	@GetMapping("/showUpdateForm")
	public ModelAndView showUpdateForm(@RequestParam("customerId") int id)
	{

		ModelAndView model = new ModelAndView("customer/customer-form");

		Customer customer = customerService.findCustomerById(id);
		model.addObject("customer", customer);

		int accountManagerId;
		try
		{
			accountManagerId = customer.getAccountManager().getId();
		} catch (NullPointerException e)
		{
			accountManagerId = 0;
		}
		
		model.addObject("accountManagerId", accountManagerId);

		List<Integer> programsIDs = new ArrayList<>();
		List<LoyaltyProgram> customerPrograms = customer.getPrograms();
		programsIDs = customerPrograms.stream().map(p -> p.getId()).collect(Collectors.toList());
		model.addObject("programsIDs", programsIDs);

		Map<Integer, String> accountManagersMap = new HashMap<>();
		accountManagersMap = accountManagerService.mapAllAccountManagersIdAndFullNames();
		accountManagersMap.remove(accountManagerId);
		model.addObject("accountManagersMap", accountManagersMap);

		Map<Integer, String> loyaltyProgramsMap = new HashMap<>();
		loyaltyProgramsMap = loyaltyProgramService.mapAllLoyaltyProgramsIdAndTitles();
		model.addObject("loyaltyProgramsMap", loyaltyProgramsMap);

		return model;

	}

	@GetMapping("/deleteCustomer")
	public String deleteCustomer(@RequestParam("customerId") int id)
	{
		customerService.deleteCustomer(id);

		return "redirect;/customer/list";
	}

}
