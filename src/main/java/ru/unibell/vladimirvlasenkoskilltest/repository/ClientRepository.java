package ru.unibell.vladimirvlasenkoskilltest.repository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.unibell.vladimirvlasenkoskilltest.model.Client;

import java.util.Set;

/**
 * Клиентский репозиторий унаследованный от GenericRepository параметризованный (Client)
 */

@RepositoryRestResource
public interface ClientRepository extends GenericRepository<Client> {

//    Set<String> getContactInformationByClientId();
}
