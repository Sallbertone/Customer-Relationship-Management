package mvc.entity;

import java.util.ArrayList;
import java.util.List;

public class AccountManager
{
	private int id;
	private String firstName;
	private String lastName;
	private List<Customer> customers;

	public AccountManager()
	{
	}

	public AccountManager(String firstName, String lastName)
	{
		this.firstName = firstName;
		this.lastName = lastName;
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

	public List<Customer> getCustomers()
	{
		return customers;
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

	public void setCustomers(List<Customer> customers)
	{
		this.customers = customers;
	}

	public void addCustomer(Customer theCustomer)
	{
		if (customers == null)
		{
			customers = new ArrayList<>();
		}

		customers.add(theCustomer);
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("AccountManager [id=");
		builder.append(id);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append("]");
		return builder.toString();
	}

}
