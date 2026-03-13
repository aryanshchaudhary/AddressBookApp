package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.app.service.AddressBook;

@SpringBootApplication
public class AddressBookAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressBookAppApplication.class, args);
		
		System.out.println("Welcome to Address Book Program");
		
		AddressBook addressBook = new AddressBook();
		addressBook.addContact();
		addressBook.editContact();
		addressBook.deleteContact();
	}

}
