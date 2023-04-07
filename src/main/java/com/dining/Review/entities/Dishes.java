package com.dining.Review.entities;

//import com.sun.javafx.beans.IDProperty;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "dishes")
public class  Dishes {

    @Id
    @Column(name = "id")
    private Integer id;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "dish_name")
    private String dishName;
    public String getDishName() {
        return dishName;
    }
    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    @Column(name = "dish_overall_rating")
    private Integer dishOverallRating;
    public Integer getDishOverallRating() {
        return dishOverallRating;
    }
    public void setDishOverallRating(Integer dishOverallRating) {
        this.dishOverallRating = dishOverallRating;
    }

    @OneToMany(mappedBy = "dishes")
    private List<People> peopleList;
}
