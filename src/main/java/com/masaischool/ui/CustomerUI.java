package com.masaischool.ui;

import java.time.LocalDate;
import java.util.Scanner;


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

        System.out.print("Enter full name: ");
        String fullName = sc.nextLine();

        System.out.print("Enter date of birth (yyyy-MM-dd): ");
        LocalDate dateOfBirth = LocalDate.parse(sc.next());

        System.out.print("Enter gender: ");
        String gender = sc.next();

        System.out.print("Enter email address: ");
        String emailAddress = sc.next();

        System.out.print("Enter phone number: ");
        String phoneNumber = sc.next();

        System.out.print("Enter username: ");
        String username = sc.next();

        System.out.print("Enter password: ");
        String password = sc.next();

        System.out.print("Enter street address: ");
        sc.nextLine(); // Consume the newline character
        String streetAddress = sc.nextLine();

        System.out.print("Enter city: ");
        String city = sc.next();

        System.out.print("Enter state/province: ");
        String stateProvince = sc.next();

        System.out.print("Enter postal/ZIP code: ");
        String postalCode = sc.next();

        System.out.print("Do you have any medical condition? [y/n]: ");
        boolean hasMedicalCondition = sc.next().equalsIgnoreCase("y");

        System.out.print("Preferred language: ");
        String preferredLanguage = sc.next();

        System.out.print("Do you want to receive marketing materials? [y/n]: ");
        boolean receiveMarketingMaterials = sc.next().equalsIgnoreCase("y");

        // You can store the collected information in your database or data model
        // For demonstration purposes, we will simply print the input values
        System.out.println("Customer Registration Successful!");
        System.out.println("Full Name: " + fullName);
        System.out.println("Date of Birth: " + dateOfBirth);
        System.out.println("Gender: " + gender);
        System.out.println("Email Address: " + emailAddress);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        System.out.println("Street Address: " + streetAddress);
        System.out.println("City: " + city);
        System.out.println("State/Province: " + stateProvince);
        System.out.println("Postal/ZIP Code: " + postalCode);
        System.out.println("Medical Condition: " + (hasMedicalCondition ? "Yes" : "No"));
        System.out.println("Preferred Language: " + preferredLanguage);
        System.out.println("Receive Marketing Materials: " + (receiveMarketingMaterials ? "Yes" : "No"));
        
        // Call the method to create a new customer account in your system using the collected information
        // createNewCustomerAccount(fullName, dateOfBirth, gender, emailAddress, phoneNumber, username, password, streetAddress, city, stateProvince, postalCode, hasMedicalCondition, preferredLanguage, receiveMarketingMaterials);
    }

    static void customerLogin(Scanner sc) {
		// TODO Auto-generated method stub
    	System.out.print("Enter username ");
		String username = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();
//		try {
//			CustomerService customerService = new CustomerServiceImpl();
//			customerService.login(username, password);
		customerMenu(sc);
//		}catch(NoRecordFoundException | SomeThingWentWrongException ex) {
//			System.out.println(ex.getMessage());
//		}
	}
}
