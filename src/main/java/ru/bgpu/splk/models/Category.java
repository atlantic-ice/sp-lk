package ru.bgpu.splk.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Category {
    @Id @GeneratedValue
    private Long id;
    private String name;
}
