package mvc.config;

import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.format.FormatterRegistry;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import mvc.converter.IdToAccountManagerConverter;
import mvc.converter.OlyOneIdToLoyaltyProgramListConverter;
import mvc.converter.IdToLoyaltyProgramListConverter;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan({ "mvc" })
@PropertySource({ "classpath:persistence-mysql.properties", "classpath:app.properties" })
public class CrmAppConfig implements WebMvcConfigurer
{

	@Autowired
	private Environment environment;

	@Autowired
	private IdToAccountManagerConverter idToAccountManagerConverter;
	
	@Autowired
	private IdToLoyaltyProgramListConverter idToLoyaltyProgramListConverter;
	
	@Autowired
	private OlyOneIdToLoyaltyProgramListConverter olyOneIdToLoyaltyProgramListConverter;

	private Logger logger = Logger.getLogger(getClass().getName());


	
	@Bean
	public ViewResolver viewResolver()
	{

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");

		return viewResolver;
	}

	@Bean
	public DataSource myDataSource()
	{

		// create connection pool
		ComboPooledDataSource myDataSource = new ComboPooledDataSource();

		// set the jdbc driver
		try
		{
			myDataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
		} 
		catch (PropertyVetoException exc)
		{
			throw new RuntimeException(exc);
		}

		// logging just to make sure we are reading the data
		logger.info("==========>>>       jdbc.url=" + environment.getProperty("jdbc.url"));
		logger.info("==========>>>       jdbc.user=" + environment.getProperty("jdbc.user"));

		// set database connection props
		myDataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
		myDataSource.setUser(environment.getProperty("jdbc.user"));
		myDataSource.setPassword(environment.getProperty("jdbc.password"));

		// set connection pool props
		myDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		myDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		myDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		myDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));

		return myDataSource;
	}

	// helper method - read environment property and convert to int
	private int getIntProperty(String propName)
	{
		String propVal = environment.getProperty(propName);
		int intPropVal = Integer.parseInt(propVal);

		return intPropVal;
	}

	private Properties getHibernateProperties()
	{

		// set hibernate properties
		Properties props = new Properties();

		props.setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
		props.setProperty("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));

		return props;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory()
	{

		// create session factorys
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();

		// set the properties
		sessionFactory.setDataSource(myDataSource());
		sessionFactory.setPackagesToScan(environment.getProperty("hibernate.packagesToScan"));
		sessionFactory.setHibernateProperties(getHibernateProperties());

		return sessionFactory;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory)
	{

		// setup transaction manager based on session factory
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);

		return txManager;
	}

	public void addResourceHandlers(ResourceHandlerRegistry registry)
	{
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	// add converters
    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(idToAccountManagerConverter);
        registry.addConverter(idToLoyaltyProgramListConverter);
        registry.addConverter(olyOneIdToLoyaltyProgramListConverter);
    }

}
