package AddressBook;

import java.util.*;
import java.io.*;


public class AddressBook {

    //AddressBookData Objects stored in list
    private List<AddressBookData> listOfEntries;

    
    public AddressBook() throws FileNotFoundException {
        //initialize list of entries
        this.listOfEntries = new ArrayList<>();
        
        File file = new File("file.txt");
        Scanner s = new Scanner(file);
        		
		if(s.hasNextLine()) {
        	while(s.hasNextLine()) {
 
        		String[] split = s.nextLine().split("\\| " );

        		AddressBookData addressEntity = new AddressBookData();
        		addressEntity.setFirstName(split[0]);
        		addressEntity.setLastName(split[1]);
        		addressEntity.setPhoneNumber(split[2]);
        		addressEntity.setAddress(split[3]);
        		addressEntity.setEmailAddress(split[4]);
        		
        		this.listOfEntries.add(addressEntity);
        		
        	}
		}
        	s.close();        

    }

    
    //searching process
    public void search() {
    	List<AddressBookData> searchEntries = new ArrayList<>();
    	Scanner in = new Scanner(System.in);
    	String input ;
    	System.out.println("1.FirstName 2.LastName 3.PhoneNumber 4.Address 5.EmailAdderss");
    	System.out.println("Please, Enter The Number:");
    	input =(in.next());
    	switch (input) {
    	
    	
    	 case "1":
    		 System.out.println("Enter First Name");
	         String fname=in.next();
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
        	
        }

 
    public AddressBookData[] viewAll() throws FileNotFoundException, IOException {
        //create a new array with the size of our list   	
  
        AddressBookData[] result = new AddressBookData[this.listOfEntries.size()];
        HashSet<AddressBookData> hashSet = new HashSet<>(listOfEntries);
        hashSet.toArray(result);
        //return the filled array
        return result;
    }
    
    
    public AddressBookData[] sort() throws FileNotFoundException, IOException {
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

    }

    
    public void delete(int index) throws FileNotFoundException, IOException {
    	this.listOfEntries.remove(index);
    }

    
    public AddressBookData get(int index) {
        //give entry of inputed index
        return this.listOfEntries.get(index);
    }
    


}
