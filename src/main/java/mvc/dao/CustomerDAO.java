package mvc.dao;

import java.util.List;

import mvc.entity.Customer;

public interface CustomerDAO
{
	public List<Customer> listAllCustomers();
	
	public void saveOrUpdateCustomer(Customer customer);
	
	public List<Customer> findCustomers(String text);
	
	public Customer findCustomerById(int id);
	
	public void deleteCustomer(int id);

	public List<Customer> getCustomersByPage(int pageNumber);
	
	public long getCustomersCount();
	
}
