package com.raphael.hngtasktwo.service;

import com.raphael.hngtasktwo.data.model.Address;
import com.raphael.hngtasktwo.data.model.Person;
import com.raphael.hngtasktwo.data.repository.PersonRepository;
import com.raphael.hngtasktwo.dto.request.CreatePersonRequest;
import com.raphael.hngtasktwo.dto.request.UpdatePersonRequest;
import com.raphael.hngtasktwo.dto.response.ApiResponse;
import com.raphael.hngtasktwo.exception.EmailTakenException;
import com.raphael.hngtasktwo.exception.PersonNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


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
            throw new EmailTakenException("Person with email " + createPersonRequest.getEmail() + " already exist");
        }


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
    public ApiResponse getPersonByEmail(String email) {
        Optional<Person> optionalPerson = personRepository.findByEmail(email);
        if (optionalPerson.isEmpty()) {
            throw new PersonNotFoundException("Person with email " + email + " not found");
        }
        return modelMapper.map(optionalPerson.get(), ApiResponse.class);
    }

    @Override
    public List<ApiResponse> getPersonsByName(String name) {
        List<Optional<Person>> optionalPeople = personRepository.findByName(name);
        if (optionalPeople.isEmpty()) {
            throw new PersonNotFoundException("Person with name " + name + "not found");
        }

        // Map the list of people to a list of ApiResponse objects
        List<ApiResponse> responseList = optionalPeople.stream()
                .map(person -> modelMapper.map(person, ApiResponse.class))
                .collect(Collectors.toList());

        return responseList;
    }

    @Override
    public ApiResponse getPersonByPhoneNumber(String phone_number) {
        Optional<Person> optionalPerson = personRepository.findByPhoneNumber(phone_number);
        if (optionalPerson.isEmpty()){
            throw new PersonNotFoundException("Person not found");
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
