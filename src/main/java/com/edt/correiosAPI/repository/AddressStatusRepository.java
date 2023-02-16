package com.edt.correiosAPI.repository;

import com.edt.correiosAPI.model.Address;
import com.edt.correiosAPI.model.AdressStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressStatusRepository extends CrudRepository<AdressStatus,Integer> {

}
