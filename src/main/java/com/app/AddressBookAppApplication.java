package com.app;

import java.util.Scanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.app.manager.AddressBookManager;

@SpringBootApplication
public class AddressBookAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressBookAppApplication.class, args);
		
		System.out.println("Welcome to Address Book Program");
		
		AddressBookManager manager = new AddressBookManager();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("\n1 Add Address Book");
			System.out.println("2 Select Address Book");
			System.out.println("3 Search by City");
			System.out.println("4 Search by State");
			System.out.println("5 Exit");
			
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1:
				manager.addAddressBook();
				break;

			case 2:
				manager.selectAddressBook();
				break;
				
			case 3:
				manager.searchByCity();
				break;
				
			case 4:
				manager.searchByState();
				break;

			case 5:
				System.out.println("Exiting...");
				System.exit(0);
				
			default:
				System.out.println("Invalid Choice");	
			}
		}
	}
}
