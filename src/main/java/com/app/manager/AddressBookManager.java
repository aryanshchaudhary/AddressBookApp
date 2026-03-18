package com.app.manager;

import java.util.*;
import java.util.HashMap;
import java.util.Map;

import com.app.service.AddressBook;

public class AddressBookManager {

	Map<String, AddressBook> addressBookMap = new HashMap<>();
	Scanner sc = new Scanner(System.in);

	// Add New Address Book
	public void addAddressBook() {
		System.out.println("Enter Address Book Name: ");
		String name = sc.nextLine();

		AddressBook addressBook = new AddressBook();
		addressBookMap.put(name, addressBook);

		System.out.println("Address Book Created Successfully");
	}

	public void selectAddressBook() {
		System.out.println("Enter Address Book Name: ");
		String name = sc.nextLine();

		AddressBook addressBook = addressBookMap.get(name);

		if (addressBook == null) {
			System.out.println("Address Book Not Found");
			return;
		}

		while (true) {
			System.out.println("\n1 Add Contact");
			System.out.println("2 Edit Contact");
			System.out.println("3 Delete Contact");
			System.out.println("4 Display Contacts");
			System.out.println("5 Back");

			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
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
            	 return;
            	 
             default:
            	 System.out.println("Invalid Choice");
			}
		}
	}
}
