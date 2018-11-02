package mvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import mvc.entity.LoyaltyProgram;

@Repository
public class LoyaltyProgramDAOImpl implements LoyaltyProgramrDAO
{

	private SessionFactory sessionFactory;
	
	
	@Autowired
	public LoyaltyProgramDAOImpl(SessionFactory sessionFactory)
	{
		this.sessionFactory = sessionFactory;
	}

	
	public Session getSession()
	{
		return sessionFactory.getCurrentSession();
	}
	
	
	@Override
	public List<LoyaltyProgram> listAllLoyaltyPrograms()
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveOrUpdateLoyaltyProgram(LoyaltyProgram loyaltyProgram)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public List<LoyaltyProgram> findLoyaltyProgram(String text)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void findLoyaltyProgramById(int id)
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteLoyaltyProgram(int id)
	{
		// TODO Auto-generated method stub

	}

}
