package com.logic.logic.controller;

import com.logic.logic.model.Hero;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@SpringBootApplication
@RestController
public class DiceController {
    @GetMapping(value = "/start-round/{id}")
    public void resolveGame(@PathVariable int id){
        RestTemplate restTemplate = new RestTemplate();
        String BASE_URL = "http://localhost:8080/characters/";
        int move = rollTheDice();

        System.out.println(restTemplate.getForObject(BASE_URL+id, Hero.class));

//        Hero hero = restTemplate.getForObject(BASE_URL + id, Hero.class);
//        hero.setPosition(hero.getPosition()+move);
//
//        restTemplate.put(BASE_URL + id, hero);
//
//        System.out.println(restTemplate.getForObject(BASE_URL+id, Hero.class));
    }

    public int rollTheDice() {

        Random random = new Random();
        return random.nextInt(6) + 1;

    }


}
