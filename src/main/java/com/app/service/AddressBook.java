package com.app.service;

import com.app.model.Contact;

public class AddressBook {
	
	public void addContact() {
		Contact person = new Contact();
		
		person.firstName = "Aryansh";
		person.lastName = "Chaudhary";
        person.address = "Delhi";
        person.city = "Delhi";
        person.state = "Delhi";
        person.zip = "110001";
        person.phoneNumber = "9876543210";
        person.email = "aryansh@gmail.com";

        System.out.println("Contact Added Successfully");

        System.out.println("First Name: " + person.firstName);
        System.out.println("Last Name: " + person.lastName);
        System.out.println("Address: " + person.address);
        System.out.println("City: " + person.city);
        System.out.println("State: " + person.state);
        System.out.println("Zip: " + person.zip);
        System.out.println("Phone: " + person.phoneNumber);
        System.out.println("Email: " + person.email);
        
	}
}
