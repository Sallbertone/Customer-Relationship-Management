package mvc.dao;

import java.util.List;

import mvc.entity.Customer;

public interface CustomerDAO
{
	public List<Customer> listAllCustomers();
	
	public void saveOrUpdateCustomer(Customer customer);
	
	public List<Customer> findCustomers(String text);
	
	public void findCustomerById(int id);
	
	public void deleteCustomer(int id);
	
	
}
