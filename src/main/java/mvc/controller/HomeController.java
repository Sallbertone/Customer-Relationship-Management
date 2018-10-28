package mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import mvc.dao.CustomerDAO;
import mvc.service.CustomerService;




@Controller
public class HomeController
{
	
	@RequestMapping("/")
	public String home()
	{
		return "index";
	}
}
