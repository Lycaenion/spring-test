package com.interview;

import com.interview.exception.FieldsNullOrEmptyException;
import com.interview.exception.InvalidAgeException;
import com.interview.exception.InvalidLastNameException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class PersonValidationServiceTest {

    @Autowired
    PersonValidationService personValidationService;

    Person testCase1 = new Person("Carl", "Johnson", LocalDate.of(2010, 12, 12));
    Person testCase2 = new Person(null, "Travolta", LocalDate.of(2000, 12, 12));
    Person testCase3 = new Person("John", "Tr", LocalDate.of(2000, 12, 12));

    @Test
    public void ageValidationTest(){

        InvalidAgeException invalidAgeException = Assertions.assertThrows(InvalidAgeException.class, () ->{
            personValidationService.validatePerson(testCase1);
        }, "The age you have entered is below 18 years of age.");

        Assertions.assertEquals("The age you have entered is below 18 years of age.", invalidAgeException.getMessage());
    }

    @Test
    public void nullOrEmptyValidationTest(){

        FieldsNullOrEmptyException fieldsNullOrEmptyException = Assertions.assertThrows(FieldsNullOrEmptyException.class, () ->{
            personValidationService.validatePerson(testCase2);
        }, "One or more of your fields are null and/or empty. Please look over your request and try again");

        Assertions.assertEquals("One or more of your fields are null and/or empty. Please look over your request and try again", fieldsNullOrEmptyException.getMessage());

    }

    @Test
    public void lastNameValidation(){

        InvalidLastNameException invalidLastNameException = Assertions.assertThrows(InvalidLastNameException.class, () ->{
            personValidationService.validatePerson(testCase3);
        }, "The last name is invalid. It has to be at least 5 characters long and max 10 characters long.");

        Assertions.assertEquals("The last name is invalid. It has to be at least 5 characters long and max 10 characters long.", invalidLastNameException.getMessage());

    }






}
