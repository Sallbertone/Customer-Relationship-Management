package mvc.dao;

import java.util.List;

import mvc.entity.AccountManager;


public interface AccountManagerDAO
{
	public List<AccountManager> listAllAccountManagers();
	
	public void saveOrUpdateAccountManager(AccountManager accountManager);
	
	public List<AccountManager> findAccountManagers(String text);
	
	public void findAccountManagerById(int id);
	
	public void deleteAccountManager(int id);
	
	
}
