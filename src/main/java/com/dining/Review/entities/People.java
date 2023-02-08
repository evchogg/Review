package com.dining.Review.entities;

import com.dining.Review.repository.DishesRepository;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "people")
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    public Integer getId() {
        return id;
    }

    @Column(name = "first_name")
    private String firstName;
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    @ManyToOne
    @JoinColumn(name = "dish_id")
    private Dishes dishes;

    @Column(name = "dish_rating")
    private Integer dishRating;
    public Integer getDishRating() {
        return dishRating;
    }
    public void setDishRating(Integer dishRating) {
        this.dishRating = dishRating;
    }
}
