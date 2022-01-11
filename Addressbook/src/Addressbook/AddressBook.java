package Addressbook;

import java.util.*;

public class AddressBook {

//AddressBookData Objects stored in list
private List<AddressBookData> listOfEntries;

public AddressBook() {
	//initialize list of entries
    this.listOfEntries = new ArrayList<>();
}

public AddressBookData[] viewAll() {
	//create a new array with the size of our list
    AddressBookData[] result = new AddressBookData[this.listOfEntries.size()];
    
    this.listOfEntries.toArray(result);

    //return the filled array
    return result;
}


public void add(AddressBookData AddressBookData) {
    //Add new entry
    this.listOfEntries.add(AddressBookData);
}

public void delete(int index) {
    //Delete new entry
    this.listOfEntries.remove(index);
}

public AddressBookData get(int index) {
    //give entry of inputed index
    return this.listOfEntries.get(index);
}

}