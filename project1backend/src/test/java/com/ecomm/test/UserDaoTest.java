package com.ecomm.test;

import static org.junit.Assert.assertTrue;


import java.util.function.Supplier;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


class UserDaoTest {
		static UserDao userDao; 
		
		@BeforeClass
		public static void initialize()
		{
			AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
			context.scan("com.ecomm");
			context.refresh();
			
			userDao = (UserDaoTest) context.getBean("userDao");
		}
		
		@Ignore
		@Test
		public void registerUserTest()
		{
			UserDetail user = new UserDetail();
			user.setUsername("Nandhakumar");
			user.setPassword("vishalbond");
			user.setCustomerName("EV");
			user.setRole("Admin");
			user.setEnable(true);
			 user.setAddress11("Chennai");
			
			assertTrue("Problem in Adding User", userDao.registerUser(user));
			System.out.println("\n");
			System.out.println("user \""+user.getUsername()+"\" detail will be stored in database ");
			System.out.println("\n");
		}
		
		
		private Supplier<String> registerUser(UserDetail user) {
			// TODO Auto-generated method stub
			return null;
		}

		@Ignore
		@Test
		public void updateUserTest()
		{
			User user = userDao.getUser("Akshaya");
		    ((UserDetail) user).setPassword("akshaya");
			
			assertTrue("problem in updating user", userDao.updateUser(user));
			
			
			System.out.println("\n");
			System.out.println("user \""+user.getUsername()+"\" password will be updated in database ");
			System.out.println("\n");
			
		}

		private void assertTrue(String string, Supplier<String> updateUser) {
			// TODO Auto-generated method stub
			
		}

		private UserDetails getUser(String string) {
			// TODO Auto-generated method stub
			return null;
		}

		private Supplier<String> updateUser(UserDetails user) {
			// TODO Auto-generated method stub
			return null;
		}

	
	}
