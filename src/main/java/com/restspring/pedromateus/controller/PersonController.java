package com.restspring.pedromateus.controller;

import com.restspring.pedromateus.dto.MessageResponseDTO;
import com.restspring.pedromateus.entity.Person;
import com.restspring.pedromateus.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO getBook(@RequestBody Person person){
        return personService.createPerson(person);

    }
}
