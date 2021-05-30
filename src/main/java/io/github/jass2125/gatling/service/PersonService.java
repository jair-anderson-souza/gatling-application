package io.github.jass2125.gatling.service;

import io.github.jass2125.gatling.model.Person;
import io.github.jass2125.gatling.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Cacheable(cacheNames = "persons")
    public List<Person> getAll(Pageable pageable) {
        return this.personRepository.findAll(pageable).getContent();
    }

    @Cacheable(cacheNames = "persons", key = "#id")
    public Person getById(Long id) {
        return this.personRepository.findById(id).orElse(null);
    }

    @CachePut(cacheNames = "persons", key = "#person.id")
    public Person update(Person person) {
        return this.personRepository.save(person);
    }

    @CacheEvict(cacheNames = "persons", allEntries = true)
    public Person save(Person person) {
        return this.personRepository.save(person);
    }

}
