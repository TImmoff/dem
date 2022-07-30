package com.example.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class RestApiDemoController {
    private List<Coffee> coffees = new ArrayList<>();

    public RestApiDemoController() {
        coffees.addAll(List.of(
                new Coffee("Cafe Cereza"),
                new Coffee("Cafe Ganador"),
                new Coffee("Cafe Lareno"),
                new Coffee("Cafe Tres")));
    }

    @RequestMapping(value = "/coffees", method = RequestMethod.GET)
    Iterable<Coffee> getCoffees() {
        return coffees;
    }

    @GetMapping("?coffees/{id}")
    Optional<Coffee> getCoffeeById(@PathVariable String id) {
        for (Coffee c : coffees) {
            if (c.getId().equals(id)) {
                return Optional.of(c);
            }
        }
        return Optional.empty();
    }

    @PostMapping(value = "path")
    Coffee postMCoffee(@RequestBody Coffee coffee) {
        // TODO: process POST request
        coffees.add(coffee);
        return coffee;
    }

    @PutMapping("/coffees/{id}")
    Coffee putCoffee(@PathVariable String id, @RequestBody Coffee coffee) {
        // TODO: process PUT request
        int coffeeIndex = -1;
        for (Coffee c : coffees) {
            if (c.getId().equals(id)) {
                coffeeIndex = coffees.indexOf(c);
                coffees.set(coffeeIndex, coffee);
            }
        }
        return (coffeeIndex == -1) ? postMCoffee(coffee) : coffee;
    }

}
