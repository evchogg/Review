package com.dining.Review.controller;

import com.dining.Review.entities.Dishes;
import com.dining.Review.entities.People;
import com.dining.Review.repository.DishesRepository;
import com.dining.Review.repository.PeopleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class Controller {

    private final PeopleRepository peopleRepository;
    private final DishesRepository dishesRepository;

    @Autowired
    public Controller(PeopleRepository peopleRepository, DishesRepository dishesRepository) {
        this.dishesRepository = dishesRepository;
        this.peopleRepository = peopleRepository;
    }

    @GetMapping("/people/{id}")
    public ResponseEntity<People> getPeople(@PathVariable Integer id) {
        People people = peopleRepository.findByIdWithDish(id);
        return ResponseEntity.ok().body(people);
    }

    @GetMapping("/testconnection")
    public String test() {
        return "It works.";
    }

    @PostMapping("/dishes")
    public String createNewDish(@RequestBody Dishes dish) {
        this.dishesRepository.save(dish);
        return "Table updated";
    }

    @DeleteMapping("/dishes/{id}")
    public String deleteDish(@PathVariable("id") Integer id) {
        Optional<Dishes> dishToDelete = this.dishesRepository.findById(id);
        if (!dishToDelete.isPresent()) {
            return null;
        }
        Dishes deletedDish = dishToDelete.get();

        this.dishesRepository.delete(deletedDish);
        return String.format("Dish with ID:%s is deleted", id);

    }

    @GetMapping("/searchpeople")
    public Iterable<People> getPeople() {
        return this.peopleRepository.findAll();
    }

}
