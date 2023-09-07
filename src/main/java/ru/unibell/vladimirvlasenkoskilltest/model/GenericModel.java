package ru.unibell.vladimirvlasenkoskilltest.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Абстрактная сущность
 * содержит основную служебную информацию
 */
@Setter
@Getter
@NoArgsConstructor
@MappedSuperclass
public abstract class GenericModel {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "default_generator")
    private Long id;
}
