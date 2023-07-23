package com.masaischool.ui;

import java.time.LocalDate;
import java.util.Scanner;

import com.masaischool.entity.Customer;
import com.masaischool.exception.SomeThingWentWrongException;
import com.masaischool.service.CustomerService;
import com.masaischool.service.CustomerServiceImpl;


public class CustomerUI {

	static void displayCustomerMenu() {
        System.out.println("=== Customer Menu ===");
        System.out.println("1. View Service Providers and Availability");
        System.out.println("2. Book an Appointment");
        System.out.println("3. View My Appointments");
        System.out.println("4. Cancel My Appointment");
        System.out.println("5. Provide Feedback and Ratings");
		System.out.println("6. Change Password");
		System.out.println("7. Delete Account");
        System.out.println("0. Logout");
    }
	
	static void customerMenu(Scanner sc) {
        int choice;

        do {
            displayCustomerMenu();
            System.out.print("Enter Selection: ");

            // Validate input to handle non-integer values
            while (!sc.hasNextInt()) {
                sc.next(); // Clear invalid input
                System.out.print("Invalid input. Enter a number: ");
            }

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    viewServiceProvidersAndAvailability();
                    break;

                case 2:
                    bookAppointment();
                    break;

                case 3:
                    viewMyAppointments();
                    break;

                case 4:
                    cancelMyAppointment();
                    break;

                case 5:
                    provideFeedbackAndRatings();
                    break;
                    
                case 6:
                	changePassword();
                	break;
                	
                case 7:
                	deleteAccount();
                	System.out.println("Logging out. Goodbye!");
                	choice = 0;

                case 0:
                    System.out.println("Logging out. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid Selection, try again");
            }
        } while (choice != 0);
    }

    private static void deleteAccount() {
		// TODO Auto-generated method stub
		
	}

	private static void changePassword() {
		// TODO Auto-generated method stub
		
	}

	static void viewServiceProvidersAndAvailability() {
        // Implement the functionality to view service providers and their availability
        System.out.println("Viewing Service Providers and Availability");
        // Add code here...
    }

    static void bookAppointment() {
        // Implement the functionality to allow the customer to book an appointment
        System.out.println("Booking an Appointment");
        // Add code here...
    }

    static void viewMyAppointments() {
        // Implement the functionality to view the customer's appointments
        System.out.println("Viewing My Appointments");
        // Add code here...
    }

    static void cancelMyAppointment() {
        // Implement the functionality to allow the customer to cancel an appointment
        System.out.println("Canceling My Appointment");
        // Add code here...
    }

    static void provideFeedbackAndRatings() {
        // Implement the functionality to allow the customer to provide feedback and ratings
        System.out.println("Providing Feedback and Ratings");
        // Add code here...
    }
    
    static void customerRegistration(Scanner sc) {
        System.out.println("=== Customer Registration ===");
        
        sc.nextLine();
        System.out.print("Enter full name: ");
        String fullName = sc.nextLine();

//        sc.nextLine();
        System.out.print("Enter date of birth (yyyy-MM-dd): ");
        LocalDate dateOfBirth = LocalDate.parse(sc.nextLine());

        // Taking input for gender
        System.out.print("Enter gender (MALE/FEMALE/OTHER): ");
        String gender = sc.nextLine().toUpperCase();

        System.out.print("Enter email address: ");
        String emailAddress = sc.nextLine();


        System.out.print("Enter username: ");
        String username = sc.nextLine();

        System.out.print("Enter password: ");
        String password = sc.nextLine();
        
        // Create an object of Service class
        CustomerService cSr = new CustomerServiceImpl();
        
        try {
        	Customer customer = new Customer(fullName, username, password, dateOfBirth, gender, emailAddress, null);
        	cSr.addCustomer(customer);
        	
        	System.out.println("------------------------------------");
        	System.out.println("Customer details added successfully");
        	System.out.println("------------------------------------");
        }catch(SomeThingWentWrongException se) {
        	System.out.println(se.getMessage());
        }
        
//        System.out.print("Preferred language: ");
//        String preferredLanguage = sc.next();

    }

    static void customerLogin(Scanner sc) {
		// TODO Auto-generated method stub
    	System.out.print("Enter username ");
		String username = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();
		customerMenu(sc);
	}
}
