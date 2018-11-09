package mvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mvc.dao.CustomerDAO;
import mvc.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService
{

	private CustomerDAO customerDAO;
	
	
	
	public CustomerServiceImpl()
	{
	}


	@Autowired
	public CustomerServiceImpl(CustomerDAO customerDAO)
	{
		this.customerDAO = customerDAO;
	}

	
	@Override
	@Transactional
	public List<Customer> listAllCustomers()
	{
		return customerDAO.listAllCustomers();
	}

	
	@Override
	@Transactional
	public void saveOrUpdateCustomer(Customer customer)
	{
		customerDAO.saveOrUpdateCustomer(customer);

	}

	@Override
	@Transactional
	public List<Customer> findCustomers(String text)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public void findCustomerById(int id)
	{
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional
	public void deleteCustomer(int id)
	{
		// TODO Auto-generated method stub

	}

}
