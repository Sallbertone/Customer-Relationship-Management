package mvc.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import mvc.dao.AccountManagerDAO;
import mvc.entity.AccountManager;
import mvc.entity.Customer;

@Service
public class AccountManagerServiceImpl implements AccountManagerService
{
	@Autowired
	private AccountManagerDAO accountManagerDAO;
	

	public AccountManagerServiceImpl()
	{
	}

	
	@Override
	@Transactional
	public List<AccountManager> listAllAccountManagers()
	{
		return accountManagerDAO.listAllAccountManagers();
	}

	@Override
	@Transactional
	public Map<Integer, String> mapAllAccountManagersIdAndFullNames()
	{
		List<AccountManager> accountManagers = new ArrayList<>();
		accountManagers = listAllAccountManagers();

		Map<Integer, String> accountManagersMap = new HashMap<>();

		for (AccountManager aManager : accountManagers)
		{
			accountManagersMap.put(aManager.getId(), aManager.getFirstName() + " " + aManager.getLastName());
		}

		return accountManagersMap;
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
	public AccountManager findAccountManagerById(int id)
	{
		return accountManagerDAO.findAccountManagerById(id);
		

	}

	@Override
	public void deleteAccountManager(int id)
	{
		// TODO Auto-generated method stub

	}

}
