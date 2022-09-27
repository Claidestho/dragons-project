package com.createchar.createChar.web;

import com.createchar.createChar.form.CharForm;
import com.createchar.createChar.model.Character;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Controller
@RequestMapping
public class CharacterController {

    RestTemplate restTemplate = new RestTemplate();
    String BASE_URL = "http://localhost:8080/characters/";

    // Liste des methodes à faire suivant la route empruntée

    @RequestMapping(value = "/liste-des-personnages", method = RequestMethod.GET)
    public String charList(Model model) {

        Character[] allChar = restTemplate.getForObject(BASE_URL, Character[].class);

        model.addAttribute("characterList", allChar);


        return "characterList";
    }

    @RequestMapping(value = "/creer-mon-personnage", method = RequestMethod.GET)
    public String createChar(Model model) {
        // je dis que je vais utiliser le form (donc avoir acces au nom et à la classe)
        CharForm charForm = new CharForm();

        //j'envois dans la vue l'objet chatForm
        model.addAttribute("charForm", charForm);

        return "createChar";
    }

    @RequestMapping(value = "/creer-mon-personnage", method = RequestMethod.POST)
    public String storeCha(Model model,
                           @ModelAttribute("charForm") CharForm charForm) {
        // je recupère la reponse de mon post => toujours grace aux attributs du form
        String name = charForm.getName();
        String type = charForm.getType();
        int hp = 0;
        int lastId;
        // set des nouvelles data qui vont entrer dans le constructer de mon Character
        switch (charForm.getType()) {
            case "Paladin":
                hp = 12;
                break;
            case "Magicien":
                hp = 6;
                break;
            case "Voleur":
                hp = 8;
                break;
            case "Pecno":
                hp = 3;
                break;
        }

        Character[] charList = restTemplate.getForObject(BASE_URL, Character[].class);
        Character newCharacter = new Character( name, type, hp);
        // j'envois une requet API pour créer une entrée

        Character message = restTemplate.postForObject(BASE_URL, newCharacter, Character.class);
        System.out.println(message);


        return "redirect:/liste-des-personnages";
    }

    @RequestMapping(value = "/personnage/{id}", method = RequestMethod.GET)
    public String showCharacter(Model model, @PathVariable("id") long id) {


        Character showChar = restTemplate.getForObject(BASE_URL + id, Character.class);

        model.addAttribute("character", showChar);
        return "showChar";
    }

    @RequestMapping(value = "/personnage/edit/{id}", method = RequestMethod.GET)
    public String updateCharacter(Model model, @PathVariable("id") long id) {

        Character character = restTemplate.getForObject(BASE_URL + id, Character.class);

        model.addAttribute("character", character);
        return "updateChar";
    }

    @RequestMapping(value = "/personnage/edit/{id}", method = RequestMethod.PUT)
    public String putCharacter(@PathVariable("id") long id, @ModelAttribute("character") Character character) {
        Character charToUpdate = restTemplate.getForObject(BASE_URL + id, Character.class);
        String newName = character.getName();
        String newType = character.getType();

        charToUpdate.setName(newName);
        charToUpdate.setType(newType);

        restTemplate.put(BASE_URL + id, charToUpdate);


        return "redirect:/liste-des-personnages";
    }

    @RequestMapping(value = "/personnage/delete/{id}", method = RequestMethod.DELETE)
    public String deleteCharacter(@PathVariable("id") long id) {
        restTemplate.delete(BASE_URL + id);
        return "redirect:/liste-des-personnages";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showHome(){
        return "gameStart";
    }
}