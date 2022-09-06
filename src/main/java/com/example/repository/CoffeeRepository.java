package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Coffee;

public interface CoffeeRepository extends CrudRepository<Coffee, String> {

}
