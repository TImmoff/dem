package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.controller.Coffee;

public interface CoffeeRepository extends CrudRepository<Coffee, String> {

}
