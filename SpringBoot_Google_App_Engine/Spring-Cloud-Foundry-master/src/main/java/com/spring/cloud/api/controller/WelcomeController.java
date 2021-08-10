package com.spring.cloud.api.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {

  private static final String template = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong();

  @GetMapping("/welcome")
  public Greeting greeting(@RequestParam("name") String name) {
    return new Greeting(counter.incrementAndGet(), String.format(template, name));
  }

  @RequestMapping(method = RequestMethod.POST, value = "/create")
  public Person createPerson(@RequestBody Person person) {
    return  person;
  }

  @GetMapping("/advancedGet")
  public PersonData greetingAdvance(@RequestParam("name") String name) {
    return new PersonData();
  }

  @RequestMapping(method = RequestMethod.POST, value = "/advancedPost")
  public PersonData createPersonAdvance(@RequestBody Person person) {
    return new PersonData();
  }

}
