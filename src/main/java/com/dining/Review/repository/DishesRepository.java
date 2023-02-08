package com.dining.Review.repository;

import com.dining.Review.entities.Dishes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishesRepository extends JpaRepository<Dishes, Integer> {
}
