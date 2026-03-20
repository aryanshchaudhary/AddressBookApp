package com.app.manager;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

import com.app.model.Contact;

import com.app.service.AddressBook;

public class AddressBookManager {

	Map<String, AddressBook> addressBookMap = new HashMap<>();
	
	//UC 9
	Map<String, List<Contact>> cityMap = new HashMap<>();
	Map<String, List<Contact>> stateMap = new HashMap<>();
	
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
	
	// UC8 
	public void searchByCity() {

	    System.out.println("Enter City:");
	    String city = sc.nextLine();

	    addressBookMap.values().stream()
	        .flatMap(addressBook -> addressBook.getContactList().stream())
	        .filter(person -> person.city.equals(city))
	        .forEach(person -> {
	            System.out.println(person.firstName + " " + person.lastName + " - " + person.city);
	        });
	}
	
	public void searchByState() {
		System.out.println("Enter State: ");
		String state = sc.nextLine();
		
		addressBookMap.values().stream()
		.flatMap(addressBook -> addressBook.getContactList().stream())
		.filter(person -> person.state.equals(state))
		.forEach(person -> {
			System.out.println(person.firstName + " " + person.lastName + " " + person.state);
		});
	}
	
	//UC 9
	public void buildMaps() {

	    cityMap.clear();
	    stateMap.clear();

	    addressBookMap.values().stream()
	        .flatMap(addressBook -> addressBook.getContactList().stream())
	        .forEach(person -> {

	            cityMap
	                .computeIfAbsent(person.city, k -> new ArrayList<>())
	                .add(person);

	            stateMap
	                .computeIfAbsent(person.state, k -> new ArrayList<>())
	                .add(person);
	        });
	}
	
	public void viewByCity() {

	    buildMaps();

	    System.out.println("Enter City:");
	    String city = sc.nextLine();

	    List<Contact> list = cityMap.get(city);

	    if (list == null) {
	        System.out.println("No contacts found");
	        return;
	    }

	    list.forEach(person ->
	        System.out.println(person.firstName + " " + person.lastName)
	    );
	}
	
	public void viewByState() {

	    buildMaps();

	    System.out.println("Enter State:");
	    String state = sc.nextLine();

	    List<Contact> list = stateMap.get(state);

	    if (list == null) {
	        System.out.println("No contacts found");
	        return;
	    }

	    list.forEach(person ->
	        System.out.println(person.firstName + " " + person.lastName)
	    );
	}
	
	//UC 10
	public void countByCity() {
		buildMaps();
		
		cityMap.forEach((city, list) -> {
			System.out.println(city + " : " + list.size());
		});
	}
	
	public void countByState() {
		buildMaps();
		
		stateMap.forEach((state, list) -> {
			System.out.println(state + " :" + list.size());
		});
	}
}
