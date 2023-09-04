package ru.unibell.vladimirvlasenkoskilltest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import ru.unibell.vladimirvlasenkoskilltest.model.GenericModel;

import java.util.List;

/**
 * Абстрактный репозиторий
 * @param <T> - Сущность с которой работает репозиторий
 */
@NoRepositoryBean
public interface GenericRepository<T extends GenericModel> extends JpaRepository<T, Long> {

//    Page<T> findAllByIsDeletedFalse (Pageable pageable);
//    List<T> findAllByIsDeletedFalse();
}
