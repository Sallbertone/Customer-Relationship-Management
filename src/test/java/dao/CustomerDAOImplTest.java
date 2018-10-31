package dao;
import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import mvc.dao.CustomerDAOImpl;
import mvc.entity.Customer;

@RunWith(MockitoJUnitRunner.class)
public class CustomerDAOImplTest
{
	@Mock
	private SessionFactory sessionFactory;

	@InjectMocks
	@Spy
	private CustomerDAOImpl customerDAOImpl;

	private Session session;
	
	private Query<Customer> query;

	private static List<Customer> customers;
	
	@BeforeClass
	public static void initData()
	{
		customers = new ArrayList<>();
		Customer cust1 = new Customer("Jan", "Kowalski", "kowal@ww.pl");
		Customer cust2 = new Customer("Olaf", "Nowak", "nowak@oo.pl");
		Customer cust3 = new Customer("Zyta", "Małopolska", "zyt@zyt.pl");
		
		customers.add(cust1);
		customers.add(cust2);
		customers.add(cust3);
	}
	
	@Before
	public void setUp() throws Exception
	{
		session = mock(Session.class);
		
		query = mock(Query.class);

		when(sessionFactory.getCurrentSession()).thenReturn(session);
	}

	@Test
	public void testGetSession()
	{
		assertEquals(session, customerDAOImpl.getSession());
		customerDAOImpl.getSession();		
		verify(sessionFactory, times(2)).getCurrentSession();
	}
	
	@Test
	public void testListAllCustomers()
	{
					
		doReturn(session).when(customerDAOImpl).getSession();
		when(session.createQuery("from Customer", Customer.class)).thenReturn(query);
		when(query.getResultList()).thenReturn(customers);
		
		query = customerDAOImpl.getSession().createQuery("from Customer", Customer.class);
		
		assertEquals(customers, query.getResultList());
		assertEquals(3, query.getResultList().size());
		verify(query, times(2)).getResultList();
		
	}

}
