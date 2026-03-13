package com.app;

import java.util.Scanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.app.service.AddressBook;

@SpringBootApplication
public class AddressBookAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressBookAppApplication.class, args);
		
		System.out.println("Welcome to Address Book Program");
		
		AddressBook addressBook = new AddressBook();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("\n1. Add Contact");
			System.out.println("2. Edit Contact");
			System.out.println("3. Delete Contact");
			System.out.println("4. Display Contacts");
			System.out.println("5. Exit");
			
			System.out.println("Enter Choice");
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1:
				addressBook.addContact();
				break;
				
			case 2: 
				addressBook.editContact();
				break;
				
			case 3:
				addressBook.deleteContact();
				break;
				
			case 4:
				addressBook.displayContacts();
				break;
				
			case 5:
				System.out.println("Exiting Program...");
				System.exit(0);
				
			default:
				System.out.println("Invalid Choice");	
			}
		}
	}
}
