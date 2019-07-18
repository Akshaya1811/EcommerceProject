package com.ecomm.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DBConfigTest 
{
 
	public static void main(String[] args)
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.ecomm");
		context.refresh();
		System.out.println("refresh");

	}

}
