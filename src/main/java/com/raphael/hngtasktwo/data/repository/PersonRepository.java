package com.raphael.hngtasktwo.data.repository;

import com.raphael.hngtasktwo.data.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
