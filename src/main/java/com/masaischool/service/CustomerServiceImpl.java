package com.masaischool.service;

import java.util.List;

import com.masaischool.dao.CustomerDAO;
import com.masaischool.dao.CustomerDAOImpl;
import com.masaischool.entity.Customer;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomeThingWentWrongException;

public class CustomerServiceImpl implements CustomerService {

	/**
	 * The private access modifier means that the customerDAO field can only be accessed within the same class
	 * The final keyword makes the customerDAO field immutable, meaning its reference cannot be changed after it's initialized.
	 */
	private final CustomerDAO cDao = new CustomerDAOImpl();
	
	@Override
	public void addCustomer(Customer customer) throws SomeThingWentWrongException {
		cDao.addCustomer(customer);
	}

	@Override
	public void login(String username, String password) throws SomeThingWentWrongException {
		cDao.login(username, password);
	}

	@Override
	public void changePassword(String oldPassword, String newPassword) throws SomeThingWentWrongException {
		cDao.changePassword(oldPassword, newPassword);
	}

	@Override
	public void deleteAccount() throws SomeThingWentWrongException {
		cDao.deleteAccount();
	}

	@Override
	public List<Object[]> getCustomerList() throws SomeThingWentWrongException, NoRecordFoundException {
		return cDao.getCustomerList();
	}

}
