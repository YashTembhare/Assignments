package Addressbook;

import java.util.*;
import java.io.*;
import java.lang.reflect.Array;

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
    return result;
}


public void add(AddressBookData AddressBookData) throws FileNotFoundException, IOException {
    //Add new entry
    this.listOfEntries.add(AddressBookData);
    FileWriter fileWriter = new FileWriter("File.txt", true);
    fileWriter.write("\n" + AddressBookData.toString());
    fileWriter.close();
    System.out.println("\nSuccess : 1 record added.");
    
}

public void delete(int index) throws FileNotFoundException, IOException {
    //Delete new entry
    this.listOfEntries.remove(index);
}

public AddressBookData get(int index) {
    //give entry of inputed index
    return this.listOfEntries.get(index);
}

}
