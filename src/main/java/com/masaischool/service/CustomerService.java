package com.masaischool.service;

import java.util.List;

import com.masaischool.entity.Customer;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomeThingWentWrongException;

public interface CustomerService {
	void addCustomer(Customer customer) throws SomeThingWentWrongException;
	void login(String username, String password) throws SomeThingWentWrongException;
	void changePassword(String oldPassword, String newPassword) throws SomeThingWentWrongException;
	void deleteAccount() throws SomeThingWentWrongException;
	List<Object[]> getCustomerList() throws SomeThingWentWrongException, NoRecordFoundException;
}
