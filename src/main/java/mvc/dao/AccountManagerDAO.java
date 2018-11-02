package mvc.dao;

import java.util.List;

import mvc.entity.AccountManager;
import mvc.entity.Customer;

public interface AccountManagerDAO
{
	public List<AccountManager> listAllAccountManagers();
	
	public void saveOrUpdateAccountManager(Customer customer);
	
	public List<AccountManager> findAccountManagers(String text);
	
	public void findAccountManagerById(int id);
	
	public void deleteAccountManager(int id);
	
	
}
