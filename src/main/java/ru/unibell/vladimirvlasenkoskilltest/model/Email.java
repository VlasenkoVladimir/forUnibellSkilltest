package ru.unibell.vladimirvlasenkoskilltest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Email сущность содержит электронные почты клиента
 */

@Entity
@Table(name = "emails")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "default_generator", sequenceName = "emails_seq", allocationSize = 1)
public class Email extends GenericModel {

    @ManyToOne
    @JoinColumn(name = "client_id", nullable = false, foreignKey = @ForeignKey(name = "FK_CLIENT_EMAIL"))
    private String email;
}
