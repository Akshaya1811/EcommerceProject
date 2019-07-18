package com.ecomm.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.ProductDAO;
import com.ecomm.model.Product;

public class ProductDAOTest 
{
	
		static ProductDAO productDao;
		@BeforeClass
		public static void executeFirst()
		{
			AnnotationConfigApplicationContext context=new  AnnotationConfigApplicationContext();
			context.scan("com.ecomm");
			context.refresh();
			productDao=(ProductDAO)context.getBean("productDAO"); //this is the name of repository//
		}
	    @Test
		public void addProductTest()
		{
			Product product=new Product();  
			product.setProductName("Chudi");
			product.setProductDesc("All Designs of Chudis");
			product.setCategoryId(2);
			product.setPrice(1000);
			product.setStock(10);
			product.setSupplierId(2);
			assertTrue("Problem Occured During Adding:",productDao.addproduct(product));
			
		}
	    @Test
	    public void listProductTest()
	    {
	    	List<Product> productList=productDao.listproduct();
	    	assertTrue("Problem Occured While Retrieving the List:",productList.size()>0);
	    	for(Product product:productList)
	    	{
	    		
	     			System.out.print(product.getProductName()+"::");						
	     			System.out.print(product.getProductDesc()+"::");
	     			System.out.println(product.getPrice()+"::");
	    	 }
	    }
	
}
