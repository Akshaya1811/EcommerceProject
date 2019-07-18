package com.ecomm.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ecomm.model.Product;

public class ProductDAOImpl implements ProductDAO 
{
     @Autowired
     SessionFactory sessionFactory;
     
	@Override
	public boolean addproduct(Product product) 
	{
		try
		{	
		  sessionFactory.getCurrentSession().save(product);
		  return true;	
		}
		catch(Exception e)
		{
			System.out.println("Exception"+e);
			return false;
		}
	}

	@Override
	public boolean deleteproduct(Product product) 
	{
		try
		{	
		  sessionFactory.getCurrentSession().delete(product);
		  return true;	
		}
		catch(Exception e)
		{
			return false;
		}
		
	}

	@Override
	public boolean updateproduct(Product product) 
	{
		try
		{	
		  sessionFactory.getCurrentSession().update(product);
		  return true;	
		}
		catch(Exception e)
		{
			return false;
		}
	}

	@Override
	public List<Product> listproduct() 
	{
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product");
		List<Product>productList=query.list();
		session.close();
		return productList;
	}

	@Override
	public Product getproduct(int productId)
	{
		Session session=sessionFactory.openSession();
		Product product=(Product) session.get(Product.class,productId);
		session.close();
		return product;
	}

	@Override
	public List<Product> listProductsCategoryWise(int CategoryId)
	{
		
		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Product where categoryId=:catId");
		query.setParameter("catId",CategoryId);
		List<Product>productList=query.list();
		session.close();
		return productList;
	}

}
