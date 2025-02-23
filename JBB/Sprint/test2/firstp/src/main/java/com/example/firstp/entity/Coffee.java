package com.example.firstp.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Coffee {
    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;
    @Column
    private String name;
    @Column
    private String price;

    public void patch(Coffee coffee) {
        if (coffee.name != null) {
            this.name = coffee.name;
        }

        if (coffee.price != null) {
            this.price = coffee.price;
        }

    }

    public Coffee(final Long id, final String name, final String price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Coffee() {
    }

    public String toString() {
        Long var10000 = this.getId();
        return "Coffee(id=" + var10000 + ", name=" + this.getName() + ", price=" + this.getPrice() + ")";
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getPrice() {
        return this.price;
    }
}
