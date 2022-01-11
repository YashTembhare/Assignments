package Addressbook;

import java.util.*;
import java.io.*;

public class AddressBook {

//AddressBookData Objects stored in list
private List<AddressBookData> listOfEntries;

public AddressBook() {
	//initialize list of entries
    this.listOfEntries = new ArrayList<>();
}

public AddressBookData[] viewAll() throws FileNotFoundException, IOException {
	//create a new array with the size of our list
    AddressBookData[] result = new AddressBookData[this.listOfEntries.size()];
    this.listOfEntries.toArray(result);
    //return the filled array
    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("File.txt"));
    out.writeObject(result);
    out.close();
    return result;
}


public void add(AddressBookData AddressBookData) throws FileNotFoundException, IOException {
    //Add new entry
    this.listOfEntries.add(AddressBookData);
    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("File.txt"));
    out.writeObject(AddressBookData);
    out.close();
}

public void delete(int index) throws FileNotFoundException, IOException {
    //Delete new entry
    this.listOfEntries.remove(index);
    ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("File.txt"));
    out.writeObject(index);
    out.close();
}

public AddressBookData get(int index) {
    //give entry of inputed index
    return this.listOfEntries.get(index);
}

}
