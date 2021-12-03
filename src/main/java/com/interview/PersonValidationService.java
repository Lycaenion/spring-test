package com.interview;

import com.interview.exception.FieldsNullOrEmptyException;
import com.interview.exception.InvalidAgeException;
import com.interview.exception.InvalidLastNameException;
import org.springframework.stereotype.Service;
import java.time.LocalDate;

@Service
public class PersonValidationService {

    //all fields are mandatory, length of last name must be at least 5 and max 10, person has to be at least 18 y.o.
    //if conditions not met throw exception, with explanation

    public void validatePerson(Person person){
        if (person.getFirstName() == null || person.getFirstName().isEmpty() || person.getLastName() == null || person.getBirthDate() == null){

            throw new FieldsNullOrEmptyException();

        }

        if(person.getLastName().length() < 5 || person.getLastName().length() > 10 ){
            throw new InvalidLastNameException();
        }

        if(!checkIfOver18(person.getBirthDate())){
            throw new InvalidAgeException();
        }

    }

    private boolean checkIfOver18(LocalDate birthdate){

        return birthdate.compareTo(LocalDate.now().minusYears(18)) < 0;

    }
}
