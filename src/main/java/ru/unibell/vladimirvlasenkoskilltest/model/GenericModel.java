package ru.unibell.vladimirvlasenkoskilltest.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "default_generator")
    private Long id;
}
