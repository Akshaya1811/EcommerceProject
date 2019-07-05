package com.niit.dao;

import com.niit.models.Customer;

public interface CustomerDao {
void registerCustomer(Customer customer);
boolean isEmailUnique(String email);
}
