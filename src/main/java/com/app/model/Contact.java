package com.app.model;

import java.util.Objects;

public class Contact {
	
	public String firstName;
    public String lastName;
    public String address;
    public String city;
    public String state;
    public String zip;
    public String phoneNumber;
    public String email;
    
    //UC7 
    @Override
    public boolean equals(Object obj) {
    	if(this == obj) return true;
    	
    	if(obj == null || getClass() != obj.getClass()) return false;
    	
    	Contact contact = (Contact) obj;
    	
    	return firstName.equals(contact.firstName) &&
    			lastName.equals(contact.lastName);
    }
    
    @Override
    public int hashCode() {
    	return Objects.hash(firstName, lastName);
    }
}
