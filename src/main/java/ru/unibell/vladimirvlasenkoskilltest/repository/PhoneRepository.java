package ru.unibell.vladimirvlasenkoskilltest.repository;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.unibell.vladimirvlasenkoskilltest.model.Phone;

import java.util.List;

/**
 * Репозиторий телефонов клиентов унаследованный от GenericRepository параметризованный (Phone)
 */

@RepositoryRestResource
public interface PhoneRepository extends GenericRepository<Phone> {

    List<Phone> getPhonesByClientId(Long id);
}
