package ru.bgpu.splk.models;

import jakarta.persistence.*;
import ru.bgpu.splk.models.Role;

@Entity
@Table(name = "users")
public class User {

    @Id @GeneratedValue
    private Long id;

    private String name;
    private String surname;

    @ManyToOne
    private Group group;
}
