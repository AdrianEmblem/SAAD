package com.uabc.edu.saad.controller;

import java.util.List;
import java.util.Optional;

import com.uabc.edu.saad.exception.RecordNotFoundException;
import com.uabc.edu.saad.model.AnimalEntity;
import com.uabc.edu.saad.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class AnimalMvcController {
    @Autowired
    AnimalService service;

    @RequestMapping
    public String getAllAnimals(Model model){
        List<AnimalEntity> list = service.getAllAnimals();
        model.addAttribute("animales",list);
        return "list-animal";
    }

    @RequestMapping(path = {"/edit", "/edit/{id}"})
    public String editAnimalById(Model model, @PathVariable("id") Optional<Long> id) throws RecordNotFoundException {
        if (id.isPresent()){
            AnimalEntity entity = service.getAnimalById(id.get());
            model.addAttribute("animal", entity);
        } else {
            model.addAttribute("animal", new AnimalEntity());

        } return "add-edit-animal";
    }

    @RequestMapping(path = "/delete/{id}")
    public String deleteAnimalById(Model model, @PathVariable("id") Long id) throws RecordNotFoundException{
        service.deleteAnimalById(id);
        return "redirect:/";
    }

    @RequestMapping(path = "/createanimal", method = RequestMethod.POST)
    public String createOrUpdateAnimal(AnimalEntity animal){
        service.createOrUpdateAnimal(animal);
        return "redirect:/";
    }

    @RequestMapping(path = "/crateobj", method = RequestMethod.PUT)
    public String createObjt(Model model){
        model.addAttribute("animal",new AnimalEntity());
        return "list-animal";
    }

}
