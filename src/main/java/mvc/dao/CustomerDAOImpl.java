package mvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import mvc.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO
{

	
	private SessionFactory sessionFactory;
	
	
	@Autowired
	public CustomerDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}


	
	
	public Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}
	
	
	@Override
	public List<Customer> listAllCustomers()
	{

		Query<Customer> query = getSession().createQuery("from Customer", Customer.class);
		List<Customer> customers = query.getResultList();

		return customers;
	}

	@Override
	public void saveOrUpdateCustomer(Customer customer)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Customer> findCustomers(String text)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void findCustomerById(int id)
	{
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCustomer(int id)
	{
		// TODO Auto-generated method stub
		
	}

}
