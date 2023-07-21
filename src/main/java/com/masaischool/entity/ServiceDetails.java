package com.masaischool.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
 
/**
 * Service Details Table:
   - Stores information about different services offered by service providers.
   - Columns: service_id (Primary Key), provider_id (Foreign Key referencing Service Provider Table), service_name, description, pricing, and other relevant service details.
 * @author 91736
 *
 */

@Entity
public class ServiceDetails {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "service_id")
    private Long serviceId;

	@Column(nullable = false, length = 100)
	private String serviceName;
	
	@Column(length = 200)
	private String description;
	
	@Column(nullable = false)
	private double pricing;
    // Other service details attributes

    @ManyToOne
    @JoinColumn(name = "provider_id", referencedColumnName = "provider_id")
    private ServiceProvider serviceProvider;

	public ServiceDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ServiceDetails(String serviceName, String description, double pricing, ServiceProvider serviceProvider) {
		super();
		this.serviceName = serviceName;
		this.description = description;
		this.pricing = pricing;
		this.serviceProvider = serviceProvider;
	}
	
    // Getters, setters, and other methods

	public Long getServiceId() {
		return serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPricing() {
		return pricing;
	}

	public void setPricing(double pricing) {
		this.pricing = pricing;
	}

	public ServiceProvider getServiceProvider() {
		return serviceProvider;
	}

	public void setServiceProvider(ServiceProvider serviceProvider) {
		this.serviceProvider = serviceProvider;
	}

    
}
