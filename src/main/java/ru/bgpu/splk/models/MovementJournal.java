package ru.bgpu.splk.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class MovementJournal {
    @Id @GeneratedValue
    private Long id;

    @ManyToOne
    private Product product;

    private Integer quantity;

    @Enumerated(EnumType.STRING)
    private MovementType type;

    private LocalDateTime timestamp = LocalDateTime.now();
}
