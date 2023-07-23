package com.masaischool.entity;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
/**
 * Customer Table:
   - Stores information about registered customers.
   - Columns: customer_id (Primary Key), full_name, username, password, date_of_birth, gender, email_address, phone_number, has_medical_condition, preferred_language, receive_marketing_materials, and other relevant customer details.
 * @author 91736
 */
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    
    @Column(name = "full_name", nullable = false, length = 50)
    private String fullName;
    
    @Column(nullable = false, unique = true, length = 50)
    private String username;
    
    @Column(nullable = false, length = 50)
    private String password;
    
    @Column(name = "date_of_birth", nullable = false)
    private LocalDate dateOfBirth;
    
    @Column(nullable = false, length = 10)
    private String gender;
    
    @Column(nullable = false)
    private String email;
    
    @Column(name = "is_deleted", nullable = false)
    private int isDeleted;

    // Other customer attributes

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Appointment> appointments;


	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Customer(String full_Name, String username, String password, LocalDate dateOfBirth, String gender,
			String email, List<Appointment> appointments) {
		super();
		this.fullName = full_Name;
		this.username = username;
		this.password = password;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.email = email;
		this.appointments = appointments;
	}

	// Getters, setters, and other methods
	
	public int getIsDeleted() {
		return isDeleted;
	}
	
	
	public void setIsDeleted(int isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	
	public Long getCustomerId() {
		return customerId;
	}


	public String getFull_Name() {
		return fullName;
	}


	public void setFull_Name(String full_Name) {
		this.fullName = full_Name;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public LocalDate getDate_of_birth() {
		return dateOfBirth;
	}


	public void setDate_of_birth(LocalDate date_of_birth) {
		this.dateOfBirth = date_of_birth;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public List<Appointment> getAppointments() {
		return appointments;
	}


	public void setAppointments(List<Appointment> appointments) {
		this.appointments = appointments;
	}


	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", full_Name=" + fullName + ", username=" + username
				+ ", password=" + password + ", date_of_birth=" + dateOfBirth + ", gender=" + gender + ", email="
				+ email + ", appointments=" + appointments + "]";
	}

    
    
    
    
    
    
/*
 * To create the Console-based Appointment Scheduling System, we need to define tables in the database to store information related to customers, service providers, appointments, customer feedback, service details, and more. Based on the requirements provided earlier, here are the tables needed for the system:

6. Additional Tables (Optional):
   - Depending on the implementation and additional features, you might need other tables, such as:
     - Waitlist Table: To manage waitlist entries when appointment slots are unavailable.
     - Calendar Integration Table: If integrating with external calendar systems like Google Calendar.
     - Payment Table: To store payment information for online payment options.

These are the core tables required to implement the appointment scheduling system. However, in a real-world scenario, you might need to consider other factors, such as data normalization, indexing, and constraints, based on the specific requirements of your system. The table structures may vary depending on the complexity and scope of the application.
 */
}
