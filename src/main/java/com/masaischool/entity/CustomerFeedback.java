package com.masaischool.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

/**
 * Customer Feedback Table:
   - Stores feedback and ratings provided by customers for service providers.
   - Columns: feedback_id (Primary Key), appointment_id (Foreign Key referencing Appointment Table), rating, comments, and other relevant feedback details.
 * @author 91736
 *
 */

@Entity
public class CustomerFeedback {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "feedback_id")
    private Long feedbackId;

    // Other feedback attributes
	@Column(nullable = false)
	private int rating;
	
	@Column(length = 300)
	private String comments;
	

    @ManyToOne
    @JoinColumn(name = "customer_id")
//    , referencedColumnName = "appointment_id"
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;

	public CustomerFeedback() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CustomerFeedback(int rating, String comments, Customer customer, Appointment appointment) {
		super();
		this.rating = rating;
		this.comments = comments;
		this.customer = customer;
		this.appointment = appointment;
	}
	
    // Getters, setters, and other methods

	public Long getFeedbackId() {
		return feedbackId;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Appointment getAppointment() {
		return appointment;
	}

	public void setAppointment(Appointment appointment) {
		this.appointment = appointment;
	}

    
    
}
