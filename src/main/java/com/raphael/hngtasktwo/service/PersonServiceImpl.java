package com.raphael.hngtasktwo.service;

import com.raphael.hngtasktwo.data.model.Address;
import com.raphael.hngtasktwo.data.model.Person;
import com.raphael.hngtasktwo.data.repository.PersonRepository;
import com.raphael.hngtasktwo.dto.request.CreatePersonRequest;
import com.raphael.hngtasktwo.dto.request.UpdatePersonRequest;
import com.raphael.hngtasktwo.dto.response.ApiResponse;
import com.raphael.hngtasktwo.exception.EmailAlreadyTakenException;
import com.raphael.hngtasktwo.exception.PersonNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService{

    private final PersonRepository personRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository, ModelMapper modelMapper) {
        this.personRepository = personRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public ApiResponse addPerson(CreatePersonRequest createPersonRequest) {
        Optional<Person> optionalPerson = personRepository.findByEmail(createPersonRequest.getEmail());
        if (optionalPerson.isPresent()) {
            throw new EmailAlreadyTakenException("email already in use");
        }
        Person newPerson = modelMapper.map(createPersonRequest, Person.class);
        Address address = modelMapper.map(createPersonRequest, Address.class);
        newPerson.setAddress(address);

        Person savedPerson = personRepository.save(newPerson);

        return ApiResponse
                .builder()
                .id(savedPerson.getId())
                .message("User with id " + savedPerson.getId() + " successfully created")
                .isSuccess(true)
                .build();
    }

    @Override
    public Person getPersonById(Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isEmpty()) {
            throw new PersonNotFoundException("Person with id " + id + "not found");
        }
        return optionalPerson.get();
    }

    @Override
    public ApiResponse updatePerson(UpdatePersonRequest updatePersonRequest, Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isEmpty()){
            throw new PersonNotFoundException("Person with id " + id + " not found");
        }

        Person person = optionalPerson.get();
        modelMapper.map(updatePersonRequest, person);
        Address address = person.getAddress();
        modelMapper.map(updatePersonRequest, address);
        personRepository.save(person);

        return ApiResponse
                .builder()
                .id(person.getId())
                .message("User with id " + person.getId() + " has been successfully updated")
                .isSuccess(true)
                .build();
    }

    @Override
    public String deletePersonById(Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isEmpty()){
            throw new PersonNotFoundException("Person with id " + id + " not found");
        }
        Person person = optionalPerson.get();
        personRepository.delete(person);
        return "User with id " + person.getId() + " has been successfully deleted";

    }

}
