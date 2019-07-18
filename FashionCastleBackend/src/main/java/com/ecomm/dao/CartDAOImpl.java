package com.ecomm.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecomm.model.Cart;
import com.ecomm.model.Product;
@Repository("CartDAO")
@Transactional
public class CartDAOImpl implements CartDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	@Override
	public boolean addToCart(Cart cartItem) 
	{
		try
		{
		sessionFactory.getCurrentSession().save(cartItem);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception"+ e);
		return false;
		}
		
	}

	@Override
	public boolean deleteCartItem(Cart CartItem)
	{
		try
		{
		sessionFactory.getCurrentSession().delete(CartItem);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception"+ e);
		return false;
		}
	}

	@Override
	public boolean updateCartItem(Cart CartItem)
	{
		try
		{
		sessionFactory.getCurrentSession().update(CartItem);
		return true;
		}
		catch(Exception e)
		{
		System.out.println("Exception"+ e);
		return false;
		}
	}

	@Override
	public List<Cart> listCartItems(String username) 
	{

		Session session=sessionFactory.openSession();
		Query query=session.createQuery("from Cart");
		List<Cart>CartList=query.list();
		session.close();
		return CartList;
	}

	@Override
	public Cart getCartItem(int cartItemId) 
	{

		Session session=sessionFactory.openSession();
		Cart CartItem= (Cart) session.get(Cart.class,cartItemId);//if put cartitemid means it will show error//
		session.close();
		return CartItem;
	}

}
