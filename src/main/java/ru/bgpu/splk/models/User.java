package ru.bgpu.splk.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "users")
@Data // Lombok: генерирует геттеры, сеттеры, toString, equals, hashCode
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String password; // Добавлено для аутентификации
    private String surname;

    @Enumerated(EnumType.STRING)
    private Role role; // Добавлено для задания 2 (роли пользователей)

    @ManyToMany
    @JoinTable(
        name = "user_group",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "group_id")
    )
    private List<Group> groups; // Связь Many-to-Many с моделью Group

    public enum Role {
        ADMIN, WAREHOUSE_MANAGER, WAREHOUSE_WORKER, GUEST
    }
}