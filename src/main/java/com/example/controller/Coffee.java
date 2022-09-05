package com.example.controller;

import java.util.UUID;

import javax.persistence.*;

@Entity
public class Coffee {
    @Id
    String id;
    String name;

    Coffee(String id, String name) {
        this.id = id;
        this.name = name;
    }

    Coffee(String name) {
        this(UUID.randomUUID().toString(), name);
    }

    String getId() {
        return id;
    }

    String getName() {
        return name;
    }

    void setId(String id) {
        this.id = id;
    }

    void setName(String name) {
        this.name = name;
    }

}
