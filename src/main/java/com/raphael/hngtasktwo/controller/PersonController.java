package com.raphael.hngtasktwo.controller;

import com.raphael.hngtasktwo.dto.request.CreatePersonRequest;
import com.raphael.hngtasktwo.dto.request.UpdatePersonRequest;
import com.raphael.hngtasktwo.dto.response.ApiResponse;
import com.raphael.hngtasktwo.service.PersonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class PersonController {

    private final PersonService personService;

    @PostMapping
    public ResponseEntity<ApiResponse> addPerson(@Valid @RequestBody CreatePersonRequest createPersonRequest){
        ApiResponse apiResponse = personService.addPerson(createPersonRequest);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse> getPersonById(@PathVariable Long id) {
        ApiResponse apiResponse = personService.getPersonById(id);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{email}")
    public ResponseEntity<ApiResponse> getPersonByEmail(@PathVariable String email) {
        ApiResponse apiResponse = personService.getPersonByEmail(email);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<ApiResponse>> getPersonsByName(@PathVariable String name){
        List<ApiResponse> apiResponse = personService.getPersonsByName(name);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/{phone_number}")
    public ResponseEntity<ApiResponse> getPersonByPhoneNumber(@PathVariable String phone_number) {
        ApiResponse apiResponse = personService.getPersonByPhoneNumber(phone_number);
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse> updatePerson(@Valid @RequestBody UpdatePersonRequest updatePersonRequest, @PathVariable Long id){
        ApiResponse apiResponse = personService.updatePerson(updatePersonRequest, id);
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePersonById(@PathVariable Long id) {
        String deleteMessage = personService.deletePersonById(id);
        return ResponseEntity.ok(deleteMessage);
    }

}
