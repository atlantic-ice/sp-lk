package ru.bgpu.splk.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "groups")
public class Group {

    @Id @GeneratedValue
    private Long id;
    private String name;

    @OneToMany(mappedBy = "group")
    private List<User> users;
}
