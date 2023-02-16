package com.edt.correiosAPI.repository;

import com.edt.correiosAPI.model.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, String> {

}
