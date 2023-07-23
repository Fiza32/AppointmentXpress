package com.masaischool.ui;

import java.util.Scanner;

public class MainUI {
	/**
	 * In the updated code, I've added three more lines to the menu to include the integration options with calendar systems, CRM systems, and a payment gateway as sub-options under menu item number 10.

Explanation of the new menu options:

Manage Waitlist and Notify Customers: Allows the service provider to view and manage the waitlist for appointments, notify customers when a slot becomes available, and offer the appointment to interested customers in the waitlist.

Accept/Reject Appointment Requests: If the system allows customers to request appointments instead of directly booking, this option lets the service provider view and respond to pending appointment requests.

Generate Appointment Reports: Provides the service provider with the ability to generate reports summarizing appointments, revenue, or other relevant metrics for business analysis.

Integration Options: This is a new menu option that groups various integration choices for the service provider:

a. Integration with Calendar Systems: Explains the option for synchronizing appointment schedules with popular calendar systems.
b. Integration with CRM Systems: Details the option to integrate customer management or CRM systems for streamlined data handling.
c. Integration with Payment Gateway: Describes the possibility of integrating an online payment gateway for seamless online payment processing.
The updated menu provides more options and gives the service provider an overview of the available features and integration possibilities for their appointment scheduling needs.
	 */
	static void displayServiceProviderMenu() {
	    System.out.println("=== Service Provider Menu ===");
	    System.out.println("1. Set Up Availability and Working Hours");
	    System.out.println("2. View Appointment Details");
	    System.out.println("3. Open Slots for Booking");
	    System.out.println("4. Cancel an Appointment");
	    System.out.println("5. View Customer Feedback and Ratings");
	    System.out.println("6. Update Service Descriptions and Pricing");
	    System.out.println("7. Manage Waitlist and Notify Customers");
	    System.out.println("8. Accept/Reject Appointment Requests");
	    System.out.println("9. Generate Appointment Reports");
	    System.out.println("10. Integration Options:");
	    System.out.println("    a. Integration with Calendar Systems");
	    System.out.println("    b. Integration with CRM Systems");
	    System.out.println("    c. Integration with Payment Gateway");
	    System.out.println("0. Logout");
	}
	
	
	static void serviceProviderMenu(Scanner sc) {
		int choice = 0;
		
		do {
			displayServiceProviderMenu();
			System.out.println("Enter Selection: ");
			
			// Validate input to handle non-integer values
            while (!sc.hasNextInt()) {
                sc.next(); // Clear invalid input
                System.out.print("Invalid input. Enter a number: ");
            }

            choice = sc.nextInt();
            
			switch(choice) {
			case 1:
				ServiceProviderUI.setUpAvailabilityAndWorkingHours();
				break;
				
			case 2:
				ServiceProviderUI.viewAppointmentDetails();
				break;
				
			case 3:
				ServiceProviderUI.openSlotsForBooking();
				break;
				
			case 4:
				ServiceProviderUI.cancelAppointment();
				break;
				
			case 5:
				ServiceProviderUI.viewCustomerFeedbackAndRatings();
				break;
				
			case 6:
				ServiceProviderUI.updateServiceDescriptionsAndPricing();
				break;
				
			case 7:
				ServiceProviderUI.manageWaitlistAndNotifyCustomers();
				break;
				
			case 8:
				ServiceProviderUI.acceptRejectAppointmentRequests();
				break;
				
			case 9:
				ServiceProviderUI.generateAppointmentReports();
				break;
				
			case 10:
				ServiceProviderUI.integrationOptions();
				break;
				
			case 11:
				ServiceProviderUI.logout();
				break;
				
			case 0:
				System.out.println("Bye Bye Admin");
				break;
				
			default:
				System.out.println("Invalid Selection, try again");
			}
		}while(choice != 0);
	}


	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("=== Appointment Scheduling System ===");
            System.out.println("1. Service Provider Login");
            System.out.println("2. New Customer Registration");
            System.out.println("3. Customer Login");
            System.out.println("0. Exit");

            System.out.print("\nEnter Selection: ");

            // Validate input to handle non-integer values
            while (!sc.hasNextInt()) {
                sc.next(); // Clear invalid input
                System.out.print("Invalid input. Enter a number: ");
            }

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    // Implement service provider login functionality
                    serviceProviderLogin(sc);
                    break;

                case 2:
                    // Implement new customer registration functionality
                    CustomerUI.customerRegistration(sc);
                    break;

                case 3:
                    // Implement customer login functionality
                    CustomerUI.customerLogin(sc);
                    break;

                case 0:
                    System.out.println("Exiting the Appointment Scheduling System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid selection. Please choose a valid option.");
            }

        } while (choice != 0);

        sc.close();
    }


	


	private static void serviceProviderLogin(Scanner sc) {
		// TODO Auto-generated method stub
		System.out.print("Enter username ");
		String username = sc.next();
		System.out.print("Enter password ");
		String password = sc.next();
		if(username.equals("admin") && password.equals("admin")) {
			serviceProviderMenu(sc);
		}else {
			System.out.println("Invalid Username of Password");
		}
	}
}
