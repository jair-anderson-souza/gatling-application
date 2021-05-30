package io.github.jass2125.gatling.service;

import io.github.jass2125.gatling.model.Person;
import io.github.jass2125.gatling.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAll(Pageable pageable) {
        return this.personRepository.findAll(pageable).getContent();
    }

    public Person getById(Long id) {
        return this.personRepository.findById(id).orElse(null);
    }

    public Person update(Person person) {
        return this.personRepository.save(person);
    }

    public Person save(Person person) {
        return this.personRepository.save(person);
    }

}
