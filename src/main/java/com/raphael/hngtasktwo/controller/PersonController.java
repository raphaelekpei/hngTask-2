package com.raphael.hngtasktwo.controller;

import com.raphael.hngtasktwo.dto.request.CreatePersonRequest;
import com.raphael.hngtasktwo.dto.request.UpdatePersonRequest;
import com.raphael.hngtasktwo.dto.response.ApiResponse;
import com.raphael.hngtasktwo.service.PersonService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



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

    @GetMapping("{user_id}")
    public ResponseEntity<ApiResponse> getPersonById(@PathVariable Long user_id) {
        ApiResponse apiResponse = personService.getPersonById(user_id);
        return ResponseEntity.ok(apiResponse);
    }

    @PutMapping("{user_id}")
    public ResponseEntity<ApiResponse> updatePerson(@Valid @RequestBody UpdatePersonRequest updatePersonRequest, @PathVariable Long user_id){
        ApiResponse apiResponse = personService.updatePerson(updatePersonRequest, user_id);
        return ResponseEntity.ok(apiResponse);
    }

    @DeleteMapping("{user_id}")
    public ResponseEntity<String> deletePersonById(@PathVariable Long user_id) {
        String deletedMessage = personService.deletePersonById(user_id);
        return ResponseEntity.ok(deletedMessage);
    }

}
