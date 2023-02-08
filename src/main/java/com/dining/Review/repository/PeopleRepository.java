package com.dining.Review.repository;

import com.dining.Review.entities.People;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeopleRepository extends JpaRepository<People, Integer> {
}
