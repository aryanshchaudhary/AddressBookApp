package com.app.service;

import com.app.model.Contact;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {

	List<Contact> contactList = new ArrayList<>();
	Scanner sc = new Scanner(System.in);

	// UC 2 & UC 5 Add Contact
	public void addContact() {
		Contact person = new Contact();

		System.out.println("Enter First Name:");
		person.firstName = sc.nextLine();

		System.out.println("Enter Last Name:");
		person.lastName = sc.nextLine();
		
		//UC7 Duplicate Check
		if(contactList.contains(person)) {
			System.out.println("Duplicate Contact! Cannot Add.");
			return;
		}

		System.out.println("Enter Address:");
		person.address = sc.nextLine();

		System.out.println("Enter City:");
		person.city = sc.nextLine();

		System.out.println("Enter State:");
		person.state = sc.nextLine();

		System.out.println("Enter Zip:");
		person.zip = sc.nextLine();

		System.out.println("Enter Phone Number:");
		person.phoneNumber = sc.nextLine();

		System.out.println("Enter Email:");
		person.email = sc.nextLine();

		contactList.add(person);

		System.out.println("Contact Added Successfully");
	}

	// UC 3 Edit Contact
	public void editContact() {
		System.out.println("Enter the First Name of Contact to Edit: ");
		String name = sc.nextLine();

		for (Contact person : contactList) {
			if (person.firstName.equals(name)) {
				System.out.println("Enter new Address:");
				person.address = sc.nextLine();

				System.out.println("Enter new City:");
				person.city = sc.nextLine();

				System.out.println("Enter new State:");
				person.state = sc.nextLine();

				System.out.println("Enter new Zip:");
				person.zip = sc.nextLine();

				System.out.println("Enter new Phone Number:");
				person.phoneNumber = sc.nextLine();

				System.out.println("Enter new Email:");
				person.email = sc.nextLine();

				System.out.println("Contact Updated Successfully");
				return;
			}
		}
		System.out.println("Contact not found");
	}

	// UC 4 Delete Contact
	public void deleteContact() {
		System.out.println("Enter the First Name of Contact to Delete: ");
		String name = sc.nextLine();

		for (Contact person : contactList) {
			if (person.firstName.equals(name)) {
				contactList.remove(person);

				System.out.println("Contact Deleted Successfully");
				return;
			}
		}
		System.out.println("Contact not found");
	}
	
	//Display Contacts
	public void displayContacts() {
		for(Contact person : contactList) {
			System.out.println("\nFirst Name: " + person.firstName);
            System.out.println("Last Name: " + person.lastName);
            System.out.println("Address: " + person.address);
            System.out.println("City: " + person.city);
            System.out.println("State: " + person.state);
            System.out.println("Zip: " + person.zip);
            System.out.println("Phone: " + person.phoneNumber);
            System.out.println("Email: " + person.email);
		}
	}
}
