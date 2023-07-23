package com.masaischool.dao;

import java.util.List;

import com.masaischool.entity.Customer;
import com.masaischool.entity.LoggedInUserId;
import com.masaischool.exception.NoRecordFoundException;
import com.masaischool.exception.SomeThingWentWrongException;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.Query;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public void addCustomer(Customer customer) throws SomeThingWentWrongException {
		EntityTransaction et = null;
		
		try(EntityManager em = EMUtils.getEntityManager()) {
			
			try {
				if(isCustomerExists(customer.getUsername())) {
					throw new SomeThingWentWrongException("Welcome again! You're already my Customer, Please Login!\n");
				}
			} catch (NoRecordFoundException e) {
				System.out.println(e.getMessage());
			}
			
			et = em.getTransaction();
			et.begin();
			em.persist(customer);
			et.commit();
			
		}catch(PersistenceException pe) {
			et.rollback();
			throw new SomeThingWentWrongException(pe.getMessage());
		}
 
	}

	@Override
	public void login(String username, String password) throws SomeThingWentWrongException {
		try(EntityManager em = EMUtils.getEntityManager()){
			Query query = em.createQuery("SELECT c.id FROM Customer c WHERE username = :username AND password = :password AND isDeleted = 0");
			query.setParameter("username", username);
			query.setParameter("password", password);
			List<Integer> listInt = (List<Integer>)query.getResultList();
			if(listInt.size() == 0) {
				//you are here means company with given name exists so throw exceptions
				throw new SomeThingWentWrongException("The username or password is incorrect");
			}
			LoggedInUserId.loggedInUserId = listInt.get(0);
		}catch(PersistenceException ex) {
			throw new SomeThingWentWrongException("Unable to process request, try again later");
	}
	}
	
	@Override
	public void changePassword(String oldPassword, String newPassword) throws SomeThingWentWrongException {
		try(EntityManager em = EMUtils.getEntityManager()){
			String selectQuery = "SELECT COUNT(c) FROM Customer c WHERE password = :oldPassword AND id = :id";
			Query query = em.createQuery(selectQuery);
			
			query.setParameter("oldPassword", oldPassword);
			query.setParameter("id", LoggedInUserId.loggedInUserId);
			
			Long userCount = (Long) query.getSingleResult();
			
			if(userCount == 0) {
				throw new SomeThingWentWrongException("Incorrect Old Password\n");
			}
			
			Customer customer = em.find(Customer.class, LoggedInUserId.loggedInUserId);
			
			EntityTransaction et = em.getTransaction();
			et.begin();
			customer.setPassword(newPassword);
			et.commit();
		}catch(PersistenceException ex) {
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		}
	}

	@Override
	public void deleteAccount() throws SomeThingWentWrongException {
		try(EntityManager em = EMUtils.getEntityManager()){
			Customer customer = em.find(Customer.class, LoggedInUserId.loggedInUserId);
			EntityTransaction et = em.getTransaction();
			et.begin();
			customer.setIsDeleted(1);
			et.commit();
		}catch(PersistenceException ex) {
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		}
	}

	@Override
	public List<Object[]> getCustomerList() throws SomeThingWentWrongException, NoRecordFoundException {
		List<Object[]> customerList = null;
		try(EntityManager em = EMUtils.getEntityManager()){
			String selectQuery = "SELECT c.fullName, c.username, c.dateOfBirth, c.gender, c.email, c.isDeleted FROM Customer c";
			Query query = em.createQuery(selectQuery);
			customerList = query.getResultList();
			
			if(customerList.size() == 0) {
				throw new NoRecordFoundException("No Customer Found\n");
			}
			
		}catch(PersistenceException ex) {
			throw new SomeThingWentWrongException("Unable to process request, try again later");
		}
		
		return customerList;
	}

	@Override
	public boolean isCustomerExists(String username) throws NoRecordFoundException {
		try(EntityManager em = EMUtils.getEntityManager()){
			String countCustomers = "SELECT COUNT(c) FROM Customer c WHERE c.username = :username";
			long count = em.createQuery(countCustomers, Long.class).setParameter("username", username).getSingleResult();
			
			return count > 0;
		}catch(NoResultException se) {
			throw new NoRecordFoundException("Customer doesn't exists with the username " + username + "\n");
		}
	}

}
