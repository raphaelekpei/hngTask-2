package com.raphael.hngtasktwo.service;

import com.raphael.hngtasktwo.data.model.Address;
import com.raphael.hngtasktwo.data.model.Person;
import com.raphael.hngtasktwo.data.repository.PersonRepository;
import com.raphael.hngtasktwo.dto.request.CreatePersonRequest;
import com.raphael.hngtasktwo.dto.request.UpdatePersonRequest;
import com.raphael.hngtasktwo.dto.response.ApiResponse;
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

        Person newPerson = modelMapper.map(createPersonRequest, Person.class);
        Address address = modelMapper.map(createPersonRequest, Address.class);
        newPerson.setAddress(address);

        Person savedPerson = personRepository.save(newPerson);

        return modelMapper.map(savedPerson, ApiResponse.class);
    }

    @Override
    public ApiResponse getPersonById(Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isEmpty()) {
            throw new PersonNotFoundException("Person with id " + id + "not found");
        }
        return modelMapper.map(optionalPerson.get(), ApiResponse.class);
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

        return modelMapper.map(person, ApiResponse.class);
    }

    @Override
    public String deletePersonById(Long id) {
        Optional<Person> optionalPerson = personRepository.findById(id);
        if (optionalPerson.isEmpty()){
            throw new PersonNotFoundException("Person with id " + id + " not found");
        }
        personRepository.delete(optionalPerson.get());
        return "success";
    }

}
