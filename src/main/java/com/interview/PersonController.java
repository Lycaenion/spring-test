package com.interview;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    private PersonValidationService personValidationService;

    @PostMapping("/person")
    public ResponseEntity<Person> createPerson(@RequestBody Person person){

        personValidationService.validatePerson(person);

        return ResponseEntity.ok(person);

    }
}
