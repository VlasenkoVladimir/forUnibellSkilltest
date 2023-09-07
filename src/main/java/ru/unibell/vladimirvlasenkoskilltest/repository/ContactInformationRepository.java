package ru.unibell.vladimirvlasenkoskilltest.repository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.unibell.vladimirvlasenkoskilltest.model.ContactInformation;

import java.util.Set;

/**
 * Репозиторий контактной информации унаследованный от GenericRepository параметризованный (ContactInformation)
 */

@RepositoryRestResource
public interface ContactInformationRepository extends GenericRepository<ContactInformation> {

    Set<String> findContactInformationByClientId(Long clientId);

    Set<String> findEmailsByClientId(Long id);

    Set<String> findPhonesByClientId(Long id);
}
