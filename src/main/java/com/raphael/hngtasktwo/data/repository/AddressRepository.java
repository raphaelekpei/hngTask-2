package com.raphael.hngtasktwo.data.repository;

import com.raphael.hngtasktwo.data.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {


}
