package com.ecomm.test;


import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ecomm.dao.CategoryDAO;
import com.ecomm.model.Category;

public class CategoryDAOTest 
{

	static CategoryDAO categoryDao;
	@BeforeClass
	public static void executeFirst()
	{
		AnnotationConfigApplicationContext context=new  AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		categoryDao=(CategoryDAO)context.getBean("categoryDAO");
		
	}
@Ignore
@Test
	public void addCategoryTest()
	{
		Category category=new Category();                                                                                                                                                
		category.setCategoryName("punjabi");
		category.setCategoryDesc("All clother related to punjabi");
		assertTrue("Problem Occured During Adding:",categoryDao.addCategory(category));
		
	}

@Test
 	public void listCategoriesTest()
 	{
 		List<Category> categoryList=categoryDao.listCategories(); //categoryDao is object
 		assertTrue("Problem occured While retrieving the List:",categoryList.size()>0);
 		for(Category category:categoryList)
 		{
 			System.out.print(category.getCategoryId()+":::");
 			System.out.print(category.getCategoryName()+":::");
 			System.out.println(category.getCategoryDesc());
 			
 		}
 	}

@Test
    public void updateCategoryTest()
    {
	Category category=categoryDao.getCategory(2);                                                                                                                                                
	category.setCategoryDesc("All type of kurties");
	assertTrue("Problem Occured During Adding:",categoryDao.updateCategory(category));
	
    }
@Ignore
@Test
	public void deleteCategoryTest()
	{
	Category category=categoryDao.getCategory(8);  
	assertTrue("Problem Occured During Adding:",categoryDao.deleteCategory(category));
 	}
}