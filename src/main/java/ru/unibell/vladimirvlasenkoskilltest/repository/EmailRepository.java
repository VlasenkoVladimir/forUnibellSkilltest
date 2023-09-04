package ru.unibell.vladimirvlasenkoskilltest.repository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.unibell.vladimirvlasenkoskilltest.model.Email;

import java.util.List;

/**
 * Репозиторий email-ов клиентов унаследованный от GenericRepository параметризованный (Email)
 */

@RepositoryRestResource
public interface EmailRepository extends GenericRepository<Email> {

    List<Email> getEmailsByClientId(Long id);
}
