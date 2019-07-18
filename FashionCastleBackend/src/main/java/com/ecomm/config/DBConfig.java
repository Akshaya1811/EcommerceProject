package com.ecomm.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ecomm.model.Category;
import com.ecomm.model.Product;
import com.ecomm.model.Supplier;

@Configuration
@EnableTransactionManagement
@ComponentScan("com.ecomm")
public class DBConfig 
{
	//create bean for datasource
	@Bean(name="dataSource")
	public DataSource getH2DataSource()
	{
	DriverManagerDataSource dataSource=new DriverManagerDataSource();
	dataSource.setDriverClassName("org.h2.Driver");
	dataSource.setUrl("jdbc:h2:tcp://localhost/~/h2akshaya");
	dataSource.setUsername("akshaya");
	dataSource.setPassword("akshaya");
	System.out.println("h2 connected");
	return dataSource;
}

//create bean for the sessionfactory
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory()
	{
		Properties hibernateproperties=new Properties();
		hibernateproperties.put("hibernate.hbm2ddl.auto","update");
		hibernateproperties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		
		LocalSessionFactoryBuilder factory=new LocalSessionFactoryBuilder(getH2DataSource());
		factory.addProperties(hibernateproperties);
		
		factory.addAnnotatedClass(Category.class);
		factory.addAnnotatedClass(Supplier.class);
		factory.addAnnotatedClass(Product.class);
		
		SessionFactory sessionFactory=factory.buildSessionFactory();
		System.out.println("===Session Factory Implementation===");
		return sessionFactory;
		
	}
	//create a Bean for HibernateTransationManeger
	@Bean(name="txManager")
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory)
	{
		System.out.println("hibernatetransactionmanager");
		return new HibernateTransactionManager(sessionFactory);
	}
	}
	

