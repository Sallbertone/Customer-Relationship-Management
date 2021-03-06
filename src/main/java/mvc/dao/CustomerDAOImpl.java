package mvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import mvc.entity.AccountManager;
import mvc.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO
{

	private SessionFactory sessionFactory;

	@Value("${pageSize:10}")
	private int pageSize;

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
		getSession().saveOrUpdate(customer);

	}

	@Override
	public List<Customer> findCustomers(String text)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Customer findCustomerById(int id)
	{
		Query<Customer> query = getSession().createQuery("select c from Customer c where c.id=:theId", Customer.class);
		query.setParameter("theId", id);

		return query.getSingleResult();

	}

	@Override
	public void deleteCustomer(int id)
	{
		Query query = getSession().createQuery("delete from Customer where id=:theId");

		query.setParameter("theId", id);

		query.executeUpdate();
	}

	@Override
	public List<Customer> getCustomersByPage(int pageNumber)
	{
		Query<Customer> query = getSession().createQuery("from Customer order by lastName", Customer.class);
		query.setFirstResult((pageNumber - 1) * pageSize);
		query.setMaxResults(pageSize);

		return query.getResultList();

	}

	@Override
	public long getCustomersCount()
	{
		Query<Long> query = getSession().createQuery("select count(1) from Customer", Long.class);

		return query.getSingleResult().longValue();
	}

}
