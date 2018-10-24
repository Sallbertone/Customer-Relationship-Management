package mvc.entity;



import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class CustomerDetail
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="date_of_birth")
	private Date dateOfBirth;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="city")
	private String city;
	
	@OneToOne(mappedBy="customerDetail", cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private Customer customer;
	
	public CustomerDetail()
	{
	}

	public CustomerDetail(Date dateOfBirth, String phoneNumber, String city)
	{
		this.dateOfBirth = dateOfBirth;
		this.phoneNumber = phoneNumber;
		this.city = city;
	}

	public int getId()
	{
		return id;
	}

	public Date getDateOfBirth()
	{
		return dateOfBirth;
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

	public void setDateOfBirth(Date dateOfBirth)
	{
		this.dateOfBirth = dateOfBirth;
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
		builder.append(", date of birth=");
		builder.append(dateOfBirth);
		builder.append(", phoneNumber=");
		builder.append(phoneNumber);
		builder.append(", city=");
		builder.append(city);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
