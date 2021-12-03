package com.interview;
;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JSR310Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PersonController.class)
@ExtendWith(SpringExtension.class)
public class PersonControllerTest {

    @Autowired
    MockMvc mvc;

    @MockBean
    PersonValidationService personValidationService;

    @Test
    public void createPersonTest() throws Exception {

        final String URL = "/person";

        Person person = new Person("John", "Travolta", LocalDate.of(2000, 12, 12));

        ObjectMapper om = new ObjectMapper().registerModule(new JavaTimeModule());
        om.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        String requestBody = om.writeValueAsString(person);

        mvc.perform(post(URL)
                .contentType(MediaType.APPLICATION_JSON)
                .content(requestBody)).andExpect(status().isOk());

    }

}
