package mvc.entity;

import java.util.ArrayList;
import java.util.List;

public class LoyaltyProgram
{
	private int id;
	private String title;
	private List<Customer> customers;
	
	public LoyaltyProgram()
	{
	}
	
	public int getId()
	{
		return id;
	}

	public String getTitle()
	{
		return title;
	}

	public List<Customer> getCustomers()
	{
		return customers;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public void setCustomers(List<Customer> customers)
	{
		this.customers = customers;
	}

	
	public void addCustomer (Customer theCustomer)
	{
		if(customers == null)
		{
			customers = new ArrayList<>();
		}
		
		customers.add(theCustomer);
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("LoyaltyProgram [id=");
		builder.append(id);
		builder.append(", title=");
		builder.append(title);
		builder.append("]");
		return builder.toString();
	}
	
	
}
