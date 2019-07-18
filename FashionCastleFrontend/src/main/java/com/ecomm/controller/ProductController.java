package com.ecomm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ecomm.dao.ProductDAO;
import com.ecomm.model.Product;

@Controller
public class ProductController 
{
	@Autowired
	ProductDAO productDAO;
	 @RequestMapping(value="/product")
	 public String showProductPage(Model m)
	 {
		 Product product=new Product();
		// m.addAttribute("product" product);
		  m.addAttribute("product",product);
		 return "Product";
	 }
	 @RequestMapping(value="/InsertProduct",method=RequestMethod.POST)
	    public String insertProduct(@ModelAttribute("product")Product product,Model m) 
	 {
		 productDAO.addproduct(product);
		 return "Product";
	 }
}
