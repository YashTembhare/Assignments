package Addressbook;

public class AddressBookData {

private String firstname;
private String lastname;
private Double phonenumber;
private String address;
private String emailaddress;

public AddressBookData() {}

public AddressBookData(String firstname,String lastname, String address,Double phonenumber, String emailaddress){
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

public Double getPhoneNumber(){
    return phonenumber;
    }
public void setPhoneNumber(Double phonenumber){
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

public String toString(){
	return "First Name: " + firstname +", Last Name: " + lastname +", Phone Number: " + phonenumber +
			", Address: " + address + ", Email Address: " + emailaddress;
	}
}