package com.restspring.pedromateus.service;


import com.restspring.pedromateus.dto.MessageResponseDTO;
import com.restspring.pedromateus.entity.Person;
import com.restspring.pedromateus.repository.PersonRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class PersonService {
    private PersonRespository personRespository;

    @Autowired
    public PersonService(PersonRespository personRespository) {
        this.personRespository = personRespository;
    }

    public MessageResponseDTO createPerson(Person person){
        Person savedPerson=personRespository.save(person);
        return MessageResponseDTO.builder().message("Created person with id: "+savedPerson.getId()).build();
    }
}
