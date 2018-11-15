package mvc.entity;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="customer")
public class Customer
{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
//	@NotNull
//	@Size(min=1, message="*pole wymagane*")
	private String firstName;
	
	@Column(name="last_name")
//	@NotNull
//	@Size(min=1, message="*pole wymagane*")
	private String lastName;
	
	@Column(name="email")
//	@NotNull
//	@Size(min=8, message="*pole wymagane*")
	private String email;
	
	@OneToOne(cascade=CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="customer_detail_id")
	private CustomerDetail customerDetail;
	
	@ManyToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="account_manager_id")
//	@NotNull(message="*pole wymagane*")
	private AccountManager accountManager;
	
	@ManyToMany(fetch= FetchType.EAGER, cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinTable(name="customer_loyalty_program", 
				joinColumns=@JoinColumn(name="customer_id"),
				inverseJoinColumns=@JoinColumn(name="loyalty_program_id"))
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
