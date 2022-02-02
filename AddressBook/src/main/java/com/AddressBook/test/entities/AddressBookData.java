package com.AddressBook.test.entities;

import java.util.Comparator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class AddressBookData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String firstname;
	private String lastname;
	private String phonenumber;
	private String address;
	private String emailaddress;
	
	public AddressBookData() {
		
	}
	
	
	public AddressBookData(String firstname,String lastname, String address,String phonenumber, String emailaddress){
		this.firstname = firstname;
	    this.lastname = lastname;
	    this.phonenumber = phonenumber;
	    this.address = address;
	    this.emailaddress = emailaddress;
	    }

	
	public String getFirstName(){
		return firstname;
		}
	public void setFirstName(String firstname){
		this.firstname = firstname;
		}

	
	public String getLastName(){
		return lastname;
	    }
	public void setLastName(String lastname){
	    this.lastname = lastname;
	    }

	
	public String getPhoneNumber(){
	    return phonenumber;
	    }
	public void setPhoneNumber(String phonenumber){
	    this.phonenumber = phonenumber;
	    }

	
	public String getAddress(){
		return address;
		}
	public void setAddress(String address){
		this.address = address;
		}


	public String getEmailAddress(){
		return emailaddress;
		}
	public void setEmailAddress(String emailaddress){
		this.emailaddress = emailaddress;
		}

	
	@Override
	public String toString(){
		
		return firstname +" | " + lastname +" | " + phonenumber +" | " + address +" | " + emailaddress;
		}
	
	
	public static Comparator<AddressBookData> FirstNameComparator = new Comparator<AddressBookData>() {
		public int compare(AddressBookData first1, AddressBookData first2) {
			String firstName1 = first1.getFirstName().toUpperCase();
			String firstName2 = first2.getFirstName().toUpperCase();

			//ascending order
			return firstName1.compareTo(firstName2);

		}

	};

}
