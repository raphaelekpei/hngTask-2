package com.raphael.hngtasktwo.service;



import com.raphael.hngtasktwo.dto.request.CreatePersonRequest;
import com.raphael.hngtasktwo.dto.request.UpdatePersonRequest;
import com.raphael.hngtasktwo.dto.response.ApiResponse;

import java.util.List;

public interface PersonService {
    ApiResponse addPerson(CreatePersonRequest createPersonRequest);

    ApiResponse getPersonById(Long id);

    ApiResponse getPersonByEmail(String email);

    List<ApiResponse> getPersonsByName(String name);

    ApiResponse getPersonByPhoneNumber(String phone_number);

    ApiResponse updatePerson(UpdatePersonRequest updatePersonRequest, Long id);

    String deletePersonById(Long id);

}
