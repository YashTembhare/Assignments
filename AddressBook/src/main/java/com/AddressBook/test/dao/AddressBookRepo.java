package com.AddressBook.test.dao;

import org.springframework.data.repository.CrudRepository;
import com.AddressBook.test.entities.AddressBookData;

public interface AddressBookRepo extends CrudRepository<AddressBookData,Integer> {

}
