package Addressbook;

import java.io.Serializable;
import java.util.Comparator;

public class AddressBookData implements Serializable , Comparable<AddressBookData>{

private String firstname;
private String lastname;
private long phonenumber;
private String address;
private String emailaddress;

public AddressBookData() {}

public AddressBookData(String firstname,String lastname, String address,long phonenumber, String emailaddress){
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

public long getPhoneNumber(){
    return phonenumber;
    }
public void setPhoneNumber(long phonenumber){
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
	
	return firstname +" | " + lastname +" | " + phonenumber +
			" | " + address + " | " + emailaddress;
	}

public static Comparator<AddressBookData> FirstNameComparator = new Comparator<AddressBookData>() {

public int compare(AddressBookData first1, AddressBookData first2) {

String firstName1 = first1.getFirstName().toUpperCase();
String firstName2 = first2.getFirstName().toUpperCase();

//ascending order
return firstName1.compareTo(firstName2);

//descending order
//return firstName1.compareTo(firstName2);
}

};

@Override
public int compareTo(AddressBookData o) {
	// TODO Auto-generated method stub
	return 0;
}

}
