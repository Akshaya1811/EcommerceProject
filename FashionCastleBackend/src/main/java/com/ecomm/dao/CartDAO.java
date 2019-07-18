package com.ecomm.dao;

import java.util.List;

import com.ecomm.model.Cart;
import com.ecomm.model.Product;

public interface CartDAO
{
	public boolean addToCart(Cart cartItem);
	public boolean deleteCartItem (Cart CartItem);
	public boolean updateCartItem(Cart CartItem);
	public List<Cart>listCartItems(String username);
    public Cart getCartItem(int cartItemId);
    
}
