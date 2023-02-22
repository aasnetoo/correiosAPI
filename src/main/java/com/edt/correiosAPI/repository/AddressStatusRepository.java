package com.edt.correiosAPI.repository;

import com.edt.correiosAPI.model.AddressStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressStatusRepository extends CrudRepository<AddressStatus,Integer> {

}
