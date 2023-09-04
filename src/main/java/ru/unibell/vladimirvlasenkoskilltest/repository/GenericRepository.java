package ru.unibell.vladimirvlasenkoskilltest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import ru.unibell.vladimirvlasenkoskilltest.model.GenericModel;

/**
 * Абстрактный репозиторий
 *
 * @param <T> - Сущность с которой работает репозиторий
 */
@NoRepositoryBean
public interface GenericRepository<T extends GenericModel> extends JpaRepository<T, Long> {
}
