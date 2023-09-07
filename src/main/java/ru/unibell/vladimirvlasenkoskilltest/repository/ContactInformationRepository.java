package ru.unibell.vladimirvlasenkoskilltest.repository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.unibell.vladimirvlasenkoskilltest.model.ContactInformation;

import java.util.Set;

/**
 * Репозиторий контактной информации унаследованный от GenericRepository параметризованный (ContactInformation)
 */

@RepositoryRestResource
public interface ContactInformationRepository extends GenericRepository<ContactInformation> {

//    Set<String> getContactInformationByClientId();

//    Set<String> getContactInformationByClientIdWhereContactTypeIsEmail(Long id);
//    Set<String> getEmailsByClientId(Long id);

//    Set<String> getContactInformationByClientIdWhereContactTypeIsPhone(Long id);
//    Set<String> getPhonesByClientId(Long id);
}
