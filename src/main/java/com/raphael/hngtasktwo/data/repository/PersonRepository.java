package com.raphael.hngtasktwo.data.repository;

import com.raphael.hngtasktwo.data.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    Optional<Person> findByEmail(String email);


    Optional<Person> findByPhoneNumber(String phone_number);

    List<Optional<Person>> findByName(String name);
}
