package Addressbook;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
public class AddressBookMain {
	// for help
	public static void help() {
		System.out.println();
		System.out.println("Information Can Stored in Address Book are:");
		System.out.println("	First Name , Last name , Phone number , Address and Email Address");
		}

public static void main(String[] args) throws FileNotFoundException, IOException {

    System.out.println("----------- Address Book -----------");
    String input;
    Scanner in = new Scanner(System.in);

    AddressBook addressBook = new AddressBook();

    do
    {
    	//operations are to done
    	System.out.println();
        System.out.println("Following operations can be done:");
        System.out.println("1) Load All Entries ");
        System.out.println("2) Add an Entry");
        System.out.println("3) Remove an Entry");
        System.out.println("4) Edit an Existing entry");
        System.out.println("5) Help");
        System.out.println("6) Exit");
        System.out.print("Please, Enter  from 1 to 6: \n");
        input =(in.next());

        switch (input) {
        
        case "1":
        	System.out.println("Your Address Book contains the following entries:");
        	//get array of all entries
        	AddressBookData[] listOfEntries = addressBook.viewAll();
        	//for every entry in the array
        	for (int i = 0; i < listOfEntries.length; i++) {
        		System.out.println(listOfEntries[i].toString());
        		}
        	break;
                

        case "2":
        	//create a new entry for the Address Book
            AddressBookData entry = new AddressBookData();

            System.out.println("Adding Entry:");
            
            System.out.print("	First Name: ");
            entry.setFirstName(in.next());        
            
            System.out.print("	Last Name: ");
            entry.setLastName(in.next());
                
            System.out.print("	Phone Number: ");
            entry.setPhoneNumber(in.nextDouble());

            System.out.print("	Address: ");
            entry.setAddress(in.next());

            System.out.print("	Email Address: ");
            entry.setEmailAddress(in.next());

            //add our new entry to the Address Book
            addressBook.add(entry);

            System.out.println("New Entry is added in Address Book");
            break;

        case "3":
        	System.out.println("Enter the Index of the Entry, For Removing: ");
        	//delete the entry at the given index
        	addressBook.delete(in.nextInt());
        	break;
                
        case "4":
        	System.out.println("Enter the Index of the Entry, For Editing:");
        	//get entry at the given index
        	AddressBookData entryToUpdate = addressBook.get(in.nextInt());

        	System.out.print("First Name (current: " + entryToUpdate.getFirstName() + "):");
        	entryToUpdate.setFirstName(in.next());
                
        	System.out.print("Last Name (current: " + entryToUpdate.getLastName() + "):");
        	entryToUpdate.setLastName(in.next());
                
        	System.out.print("Phone Number: (current: " + entryToUpdate.getPhoneNumber() + "):");
        	entryToUpdate.setPhoneNumber(in.nextDouble());

        	System.out.print("Address: (current: " + entryToUpdate.getAddress() + "):");
        	entryToUpdate.setAddress(in.next());

        	System.out.print("Email Address: (current: " + entryToUpdate.getEmailAddress() + "):");
        	entryToUpdate.setEmailAddress(in.next());

        	break;
            
        case "5":
        	help();
             

        default:
        	break;
        }
    
        
        } 
    //execute while stop is false
    while (!input.equals("6"));
    System.out.println("End Of The Program");
    }
}
