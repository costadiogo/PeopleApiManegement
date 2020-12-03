package com.restspring.pedromateus.service;


import com.restspring.pedromateus.dto.MessageResponseDTO;
import com.restspring.pedromateus.dto.request.PersonDTO;
import com.restspring.pedromateus.entity.Person;
import com.restspring.pedromateus.mapper.PersonMapper;
import com.restspring.pedromateus.repository.PersonRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {
    private PersonRespository personRespository;

    private PersonMapper personMapper=PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRespository personRespository) {
        this.personRespository = personRespository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person personToSave=personMapper.toModel(personDTO);
        Person savedPerson = personRespository.save(personToSave);
        return MessageResponseDTO.builder().message("Created person with id: " + savedPerson.getId()).build();
    }

    public List<PersonDTO> listAll() {
        List<Person> list=personRespository.findAll();
        return list.stream().map(personMapper::toDTO).collect(Collectors.toList());
    }
}
