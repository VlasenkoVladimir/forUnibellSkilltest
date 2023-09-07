package ru.unibell.vladimirvlasenkoskilltest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.BatchSize;
import ru.unibell.vladimirvlasenkoskilltest.model.enums.ContactType;

/**
 * Сущность контактной информации по клиенту (ContactType тип записи)
 */

@Entity
@Table(name = "contacts")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(name = "contact_generator", sequenceName = "contacts_seq", allocationSize = 1)
public class ContactInformation extends GenericModel {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false, foreignKey = @ForeignKey(name = "FK_CLIENT_CONTACT"))
    @BatchSize(size = 10)
    private Client client;

    @Column(name = "contact_type", nullable = false)
    private ContactType contactType;

    @Column(name = "contact")
    private String contact;
}
