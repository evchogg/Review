package com.dining.Review.controller;

import com.dining.Review.entities.Dishes;
import com.dining.Review.repository.DishesRepository;
import com.dining.Review.repository.PeopleRepository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class Controller {

    private final PeopleRepository peopleRepository;
    private final DishesRepository dishesRepository;

    public Controller(PeopleRepository peopleRepository, DishesRepository dishesRepository) {
        this.dishesRepository = dishesRepository;
        this.peopleRepository = peopleRepository;
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
            return  null;
        }
        Dishes deletedDish = dishToDelete.get();

        this.dishesRepository.delete(deletedDish);
        return  String.format("Dish with ID:%s is deleted",id);

    }




}
