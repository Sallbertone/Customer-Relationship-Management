package mvc.entity;

import java.sql.Date;

public class CustomerDetail
{
	private int id;
	private Date date;
	private String phoneNumber;
	private String city;
	private Customer customer;
	
	public CustomerDetail()
	{
	}

	public CustomerDetail(Date date, String phoneNumber, String city)
	{
		this.date = date;
		this.phoneNumber = phoneNumber;
		this.city = city;
	}

	public int getId()
	{
		return id;
	}

	public Date getDate()
	{
		return date;
	}

	public String getPhoneNumber()
	{
		return phoneNumber;
	}

	public String getCity()
	{
		return city;
	}

	public Customer getCustomer()
	{
		return customer;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	public void setPhoneNumber(String phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public void setCustomer(Customer customer)
	{
		this.customer = customer;
	}

	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("CustomerDetail [id=");
		builder.append(id);
		builder.append(", date=");
		builder.append(date);
		builder.append(", phoneNumber=");
		builder.append(phoneNumber);
		builder.append(", city=");
		builder.append(city);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
