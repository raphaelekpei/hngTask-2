package com.raphael.hngtasktwo.service;



import com.raphael.hngtasktwo.data.model.Person;
import com.raphael.hngtasktwo.dto.request.CreatePersonRequest;
import com.raphael.hngtasktwo.dto.request.UpdatePersonRequest;
import com.raphael.hngtasktwo.dto.response.ApiResponse;


public interface PersonService {
    ApiResponse addPerson(CreatePersonRequest createPersonRequest);

    Person getPersonById(Long id);
    ApiResponse updatePerson(UpdatePersonRequest updatePersonRequest, Long id);

    String deletePersonById(Long id);

}
