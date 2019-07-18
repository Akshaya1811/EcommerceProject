package com.ecomm.dao;

import java.util.List;

import com.ecomm.model.Product;

public interface ProductDAO 
{
	public  boolean addproduct(Product product);
	public  boolean deleteproduct(Product product);
	public  boolean updateproduct(Product product);
	public  List<Product> listproduct();
	public Product getproduct(int productId);
	public List<Product>listProductsCategoryWise(int CategoryId);
}


