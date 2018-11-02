package mvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mvc.entity.AccountManager;
import mvc.entity.Customer;

@Repository
public class AccountManagerDAOImpl implements AccountManagerDAO
{
	
	private SessionFactory sessionFactory;
	
	
	@Autowired
	public AccountManagerDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}


	
	
	public Session getSession()
	{
		return sessionFactory.getCurrentSession();
		
//		Session session;
//		try {
//		    session = sessionFactory.getCurrentSession();
//		} catch (HibernateException e) {
//		    session = sessionFactory.openSession();
//		}
//		
//		return session;
	}
	
	

	@Override
	public List<AccountManager> listAllAccountManagers()
	{
		Query<AccountManager> query = getSession().createQuery("from AccountManager", AccountManager.class);
		List<AccountManager> accountManagers = query.getResultList();

		return accountManagers;
	}

	@Override
	public void saveOrUpdateAccountManager(Customer customer)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public List<AccountManager> findAccountManagers(String text)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void findAccountManagerById(int id)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAccountManager(int id)
	{
		// TODO Auto-generated method stub

	}

}
