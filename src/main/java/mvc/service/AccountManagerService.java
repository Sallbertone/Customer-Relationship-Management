package mvc.service;

import java.util.List;
import java.util.Map;

import mvc.entity.AccountManager;
import mvc.entity.Customer;

public interface AccountManagerService
{
	public List<AccountManager> listAllAccountManagers();
	
	public void saveOrUpdateAccountManager(Customer customer);
	
	public List<AccountManager> findAccountManagers(String text);
	
	public AccountManager findAccountManagerById(int id);
	
	public void deleteAccountManager(int id);
	
	public Map<Integer, String> mapAllAccountManagersIdAndFullNames();
	
}
