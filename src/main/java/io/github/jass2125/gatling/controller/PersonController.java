package io.github.jass2125.gatling.controller;

import io.github.jass2125.gatling.dto.PersonRequest;
import io.github.jass2125.gatling.mapper.PersonMapper;
import io.github.jass2125.gatling.model.Person;
import io.github.jass2125.gatling.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

    @Autowired
    private PersonService service;
    @Autowired
    private PersonMapper personMapper;

    @PostMapping
    public Person save(@RequestBody PersonRequest personRequest) {
        return this.service.save(this.personMapper.toPerson(personRequest));
    }

    @PutMapping
    public Person update(@RequestBody Person person) {
        return this.service.update(person);
    }

    @GetMapping
    @RequestMapping("/{id}")
    public Person getById(@PathVariable("id") Long id) {
        return this.service.getById(id);
    }

    @GetMapping
    public List<Person> getAll(@RequestParam(name = "page", required = true, defaultValue = "0") int page, @RequestParam(name = "size", required = true, defaultValue = "5") int size) {
        Pageable pageable = PageRequest.of(page, size);
        return this.service.getAll(pageable);
    }

}