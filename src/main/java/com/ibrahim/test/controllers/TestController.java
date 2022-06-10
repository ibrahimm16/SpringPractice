package com.ibrahim.test.controllers;

import com.ibrahim.test.pojo.Person;
import com.ibrahim.test.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    TestService testService;

    @Autowired
    public TestController(TestService testService) {
        this.testService = testService;
    }

    @GetMapping("/person/{name}")
    public ResponseEntity<Person> getPerson(@PathVariable String name) {
        Person person = testService.getPerson(name);
        return ResponseEntity.ok().body(person);
    }

    @GetMapping("/people")
    public ResponseEntity<List<Person>> getPeople() {
        List<Person> people = testService.getPeople();
        return ResponseEntity.ok().body(people);
    }

    @PostMapping("/person") // @PutMapping
    public ResponseEntity<Person> addPerson(@RequestBody Person person) {
        Person response = testService.addPerson(person);
        return ResponseEntity.ok().body(response);
    }

    @DeleteMapping("/person/{name}")
    public ResponseEntity<Person> deletePerson(@PathVariable String name) {
        Person person = testService.deletePerson(name);
        return ResponseEntity.ok().body(person);
    }

    @GetMapping("/nasa")
    public ResponseEntity<String> nasaPicOfDay() {
        return ResponseEntity.ok().body(testService.getNasaStuff());
    }
}
