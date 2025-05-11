package ru.bgpu.splk.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Product {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private Double price;

    @ManyToOne
    private Category category;
}
