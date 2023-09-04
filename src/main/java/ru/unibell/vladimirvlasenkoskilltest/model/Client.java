package ru.unibell.vladimirvlasenkoskilltest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Клиентская сущность содержит поля контактных данных клиента
 */

@Entity
@Table(name = "clients", uniqueConstraints = {@UniqueConstraint(name = "uniqueName", columnNames = "name")})
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "default_generator", sequenceName = "clients_seq", allocationSize = 1)
public class Client extends GenericModel {

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "email")
    private List<String> emails;

    @OneToMany(mappedBy = "phone")
    private List<String> phones;
}
