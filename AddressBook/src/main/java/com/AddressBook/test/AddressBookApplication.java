package com.AddressBook.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.AddressBook.test.dao.AddressBookRepo;
import com.AddressBook.test.entities.AddressBookData;

@SpringBootApplication
public class AddressBookApplication {
	
	//Compare
	public static Iterator sortedIterator(Iterator it, Comparator comparator) {
	      List list = new ArrayList();
	      while (it.hasNext()) {
	          list.add(it.next());
	      }

	      Collections.sort(list, comparator);
	      return list.iterator();
	  }
	

	// for help
    public static void help() {
        System.out.println();
        System.out.println("Information Can Stored in Address Book are:");
        System.out.println("	First Name , Last name , Phone number , Address and Email Address");
    }
    
    
	public static void main(String[] args) throws FileNotFoundException, IOException {
		
		ApplicationContext context = SpringApplication.run(AddressBookApplication.class, args);
		AddressBookRepo addressbookRepo = context.getBean(AddressBookRepo.class);
		
		
		System.out.println("----------- Address Book -----------");
        String input;
        Scanner in = new Scanner(System.in);

        
        AddressBookApplication addressBook = new AddressBookApplication();

        
        do
        {
            //operations are to done
            System.out.println();
            System.out.println("Following operations can be done:");
            System.out.println("1) Load All Entries ");
            System.out.println("2) Add an Entry");
            System.out.println("3) Remove an Entry");
            System.out.println("4) Edit an Existing Entry");
            System.out.println("5) Sort All Entries");
            System.out.println("6) Search");
            System.out.println("7) Help");
            System.out.println("8) Exit");
            System.out.print("Please, Enter The Number: \n");
            input =(in.next());

            switch (input) {

            
            case "1":
                System.out.println("Your Address Book contains the following entries:");
                System.out.println("Format: First Name | Last name | Phone number | Address | Email Address");
                //get array of all entries
                Iterable <AddressBookData> itr = addressbookRepo.findAll();
                Iterator<AddressBookData> iterator=itr.iterator();
                while(iterator.hasNext()) {
                	AddressBookData addressbookdata = iterator.next();
                	System.out.println(addressbookdata);
                }
                break;

                
            case "2":
                //create a new entry for the Address Book
                AddressBookData entry = new AddressBookData();
                System.out.println("Enter unique Email Address.");

                System.out.println("Adding Entry:");
                
                System.out.print("	First Name: ");
                entry.setFirstName(in.next());

                System.out.print("	Last Name: ");
                entry.setLastName(in.next());

                System.out.print("	Phone Number: ");
                entry.setPhoneNumber(in.next());

                System.out.print("	Address: ");
                entry.setAddress(in.next());

                System.out.print("	Email Address: ");
                entry.setEmailAddress(in.next());
                
                //add our new entry to the Address Book
                AddressBookData add = addressbookRepo.save(entry);

                System.out.println("New Entry is added in Address Book.");
                break;

                
            case "3":
            	 try {
                     System.out.println("Enter the Index of the Entry, For Removing: ");
                     //delete the entry at the given index
                     Integer remove1= in.nextInt();
                     System.out.println();
                     System.out.println("Do you really want to delete.?   yes=1/no=2");
                     int ask =in.nextInt();
                     if(ask==1) {
                     	addressbookRepo.deleteById(remove1);
                     	System.out.println("Deleted.");
                     }
                     else if(ask==2) {
                     	break;
                     }
                     else {
                     	System.out.println("Enter only 1 or 2.");
                     }
                     }
                 catch (Exception e) {
                     System.out.println("Choosen Index number is gnot present in Address Book List.");
                 }
                 break;

                
            case "4":
                try {
                    System.out.println("Enter the Index of the Entry, For Editing:");
                    //get entry at the given index
                    Integer remove2= in.nextInt();
                    System.out.println();
                    Optional<AddressBookData> optional =addressbookRepo.findById(remove2);
                    AddressBookData entryToUpdate= optional.get();

                    System.out.print("First Name (current: " + entryToUpdate.getFirstName() + "):");
                    entryToUpdate.setFirstName(in.next());

                    System.out.print("Last Name (current: " + entryToUpdate.getLastName() + "):");
                    entryToUpdate.setLastName(in.next());

                    System.out.print("Phone Number: (current: " + entryToUpdate.getPhoneNumber() + "):");
                    entryToUpdate.setPhoneNumber(in.next());

                    System.out.print("Address: (current: " + entryToUpdate.getAddress() + "):");
                    entryToUpdate.setAddress(in.next());

                    System.out.print("Email Address: (current: " + entryToUpdate.getEmailAddress() + "):");
                    entryToUpdate.setEmailAddress(in.next());
                    
                    addressbookRepo.save(entryToUpdate);
                }
                catch (Exception e){
                    System.out.println("first add entry to that index then only can be updated");
                }

                break;

                
            case "5":
            	Iterable <AddressBookData> itr1 = addressbookRepo.findAll();
                Iterator<AddressBookData> iterator1=itr1.iterator();
            	
            	Iterator sortedIterator = sortedIterator(iterator1, AddressBookData.FirstNameComparator);
            	while(sortedIterator.hasNext()) {
                	AddressBookData addressbookdata = (AddressBookData) sortedIterator.next();
                	System.out.println(addressbookdata);
                }

                break;
                
            case "6":
            	List<AddressBookData> listOfEntries = new ArrayList<>();
            	Iterable <AddressBookData> itr2 = addressbookRepo.findAll();
                Iterator<AddressBookData> iterator2=itr2.iterator();
                while(iterator2.hasNext()) {
                	AddressBookData addressbookdata = iterator2.next();
                	listOfEntries.add(addressbookdata);
                }
            	List<AddressBookData> searchEntries = new ArrayList<>();
            	Scanner in1 = new Scanner(System.in);

            	System.out.println("1.FirstName 2.LastName 3.PhoneNumber 4.Address 5.EmailAdderss");
            	System.out.println("Please, Enter The Number:");
            	String input1 = in1.next() ;
            	switch (input1) {
            	
            	
            	 case "1":
            		 System.out.println("Enter First Name");
        	         String fname=in1.next();
        	         for(AddressBookData data : listOfEntries) {
        	        	if(data.getFirstName().equals(fname))
        	        		searchEntries.add(data);
        	        	}
        	        	
        	         System.out.println("Search entries -:");
        	         for(AddressBookData search : searchEntries) {
        	         	System.out.println(search.toString());
        	         	}
        	         break;
                 	
                 	
            	 case "2":
            		 System.out.println("Enter Last Name");
            		 String lname=in.next();
            		 for(AddressBookData data : listOfEntries) {
            	    	if(data.getLastName().equals(lname))
            	    		searchEntries.add(data);
            	    	}
            	    	
            		 System.out.println("Search entries -:");
            		 for(AddressBookData search : searchEntries) {
            	    		System.out.println(search.toString());
            	    	}
            		 break;
            	    	
            		 
            	 case "3":
            		 System.out.println("Enter Phone Number");
            		 String phone=in.next();
            		 for(AddressBookData data : listOfEntries) {
            				if(data.getPhoneNumber().equals(phone))
            					searchEntries.add(data);
            			}
            			
            			System.out.println("Search entries -:");
            			for(AddressBookData search : searchEntries) {
            				System.out.println(search.toString());
            			}
            			break;
            			
            			
            		case "4":
            			System.out.println("Enter Address");
            			String address=in.next();
            			for(AddressBookData data : listOfEntries) {
            				if(data.getAddress().equals(address))
            					searchEntries.add(data);
            			}
            			
            			System.out.println("Search entries -:");
            			for(AddressBookData search : searchEntries) {
            				System.out.println(search.toString());
            			}
            			break;
            			
            			
                    case "5":
                    	System.out.println("Enter Email Address");
                    	String email=in.next();
                    	for(AddressBookData data : listOfEntries) {
                    		if(data.getEmailAddress().equals(email))
                    			searchEntries.add(data);
                    	}
                    	
                    	System.out.println("Search entries -:");
                    	for(AddressBookData search : searchEntries) {
                    		System.out.println(search.toString());
                    	}
                    	break;

                	}
                	
            	break;
                
            case "7":
                help();
                
            default:
                break;
        }


    }


        //execute while stop is false
        while (!input.equals("8"));
        System.out.println("End Of The Program");
		
	}


}
