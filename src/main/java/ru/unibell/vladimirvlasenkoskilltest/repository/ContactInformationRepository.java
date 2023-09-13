package ru.unibell.vladimirvlasenkoskilltest.repository;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.core.annotation.RestResource;
import ru.unibell.vladimirvlasenkoskilltest.model.ContactInformation;

import java.util.List;
import java.util.Set;

/**
 * Репозиторий контактной информации унаследованный от GenericRepository параметризованный (ContactInformation)
 */

public interface ContactInformationRepository extends GenericRepository<ContactInformation> {

    Set<String> findEmailsByClientId(Long id);

    Set<String> findPhonesByClientId(Long id);

    @Override
    @RestResource(exported = false)
    List<ContactInformation> findAll();

    @Override
    @RestResource(exported = false)
    List<ContactInformation> findAllById(Iterable<Long> longs);

    @Override
    @RestResource(exported = false)
    <S extends ContactInformation> List<S> findAll(Example<S> example);

    @Override
    @RestResource(exported = false)
    <S extends ContactInformation> List<S> findAll(Example<S> example, Sort sort);

    @Override
    @RestResource(exported = false)
    List<ContactInformation> findAll(Sort sort);

    @Override
    @RestResource(exported = false)
    Page<ContactInformation> findAll(Pageable pageable);

    @Override
    @RestResource(exported = false)
    <S extends ContactInformation> Page<S> findAll(Example<S> example, Pageable pageable);
}
