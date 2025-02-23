package com.example.firstp.dto;

import com.example.firstp.entity.Coffee;

public class CoffeeDto {
    private Long id;
    private String name;
    private String price;

    public Coffee toEntity() {
        return new Coffee(this.id, this.name, this.price);
    }

    public CoffeeDto(final Long id, final String name, final String price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String toString() {
        return "CoffeeDto(id=" + this.id + ", name=" + this.name + ", price=" + this.price + ")";
    }
}
