package com.ecomm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController 
{
	@RequestMapping("/login")
	public String showLoginPage()
	{
		return "Login";
		
	}
	@RequestMapping("/register")
	public String showRegisterPage()
	{
		return "Register";
		
	}
	@RequestMapping("/aboutus")
	public String showAboutUsPage()
	{
		return "AboutUs";
		
	}
	@RequestMapping("/contactus")
	public String showContactUsPage()
	{
		return "ContactUs";
		
	}
	
}
