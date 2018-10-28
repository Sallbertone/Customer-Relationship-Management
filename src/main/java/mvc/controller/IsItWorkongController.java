package mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import mvc.dao.CustomerDAO;
import mvc.service.CustomerService;




@Controller
public class IsItWorkongController
{
	@Autowired
	CustomerService c;
	
	@RequestMapping("/")
	public String start()
	{
		
		System.out.println(c.listAllCustomers().get(5).getCustomerDetail());
		
		return "index";
	}
}
