package com.ibrahim.test.service;

import com.ibrahim.test.pojo.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TestService {

    RestTemplate restTemplate;

    @Autowired
    public TestService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    Map<String, Person> people = new HashMap<>();

    public List<Person> getPeople() {
        return new ArrayList<>(people.values());
    }

    public Person getPerson(String name) {
        return people.get(name);
    }

    public Person addPerson(Person person) {
        return people.put(person.getName(), person);
    }

    public Person deletePerson(String name) {
        return people.remove(name);
    }

    public String getNasaStuff() {
        return restTemplate.getForObject("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY", String.class);
    }
}
