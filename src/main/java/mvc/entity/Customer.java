package mvc.entity;

import java.util.List;

public class Customer
{
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private CustomerDetail customerDetail;
	private AccountManager accountManager;
	private List<LoyaltyProgram> programs;
	
	
	public Customer()
	{
	}


	public Customer(String firstName, String lastName, String email)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}


	public int getId()
	{
		return id;
	}


	public String getFirstName()
	{
		return firstName;
	}


	public String getLastName()
	{
		return lastName;
	}


	public String getEmail()
	{
		return email;
	}


	public CustomerDetail getCustomerDetail()
	{
		return customerDetail;
	}


	public AccountManager getAccountManager()
	{
		return accountManager;
	}

	
	public List<LoyaltyProgram> getPrograms()
	{
		return programs;
	}

	
	public void setId(int id)
	{
		this.id = id;
	}


	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}


	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}


	public void setEmail(String email)
	{
		this.email = email;
	}


	public void setCustomerDetail(CustomerDetail customerDetail)
	{
		this.customerDetail = customerDetail;
	}


	public void setAccountManager(AccountManager accountManager)
	{
		this.accountManager = accountManager;
	}


	public void setPrograms(List<LoyaltyProgram> programs)
	{
		this.programs = programs;
	}


	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("Customer [id=");
		builder.append(id);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", email=");
		builder.append(email);
		builder.append("]");
		return builder.toString();
	}
	
	
	
	
}
