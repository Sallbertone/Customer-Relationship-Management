package mvc.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class LoyaltyProgram
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="title")
	private String title;
	
	@ManyToMany(fetch= FetchType.LAZY, cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name="course_student", 
				joinColumns=@JoinColumn(name="loyalty_program_id"),
				inverseJoinColumns=@JoinColumn(name="customer_id"))
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
