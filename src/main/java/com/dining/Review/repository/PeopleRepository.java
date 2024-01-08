package com.dining.Review.repository;

import com.dining.Review.entities.People;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PeopleRepository extends JpaRepository<People, Integer> {

    @Query("SELECT p FROM People p LEFT JOIN FETCH p.dishes WHERE p.id = :id")
    People findByIdWithDish(@Param("id") Integer id);
}
