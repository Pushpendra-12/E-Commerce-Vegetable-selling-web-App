package org.vegetableApp.address.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.vegetableApp.address.model.Address;

public interface AddressRepository extends JpaRepository<Address,Integer> {

}
