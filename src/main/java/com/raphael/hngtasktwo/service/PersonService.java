package com.raphael.hngtasktwo.service;



import com.raphael.hngtasktwo.dto.request.CreatePersonRequest;
import com.raphael.hngtasktwo.dto.request.UpdatePersonRequest;
import com.raphael.hngtasktwo.dto.response.ApiResponse;


public interface PersonService {
    ApiResponse addPerson(CreatePersonRequest createPersonRequest);

    ApiResponse getPersonById(Long id);
    ApiResponse updatePerson(UpdatePersonRequest updatePersonRequest, Long id);

    ApiResponse deletePersonById(Long id);

}
