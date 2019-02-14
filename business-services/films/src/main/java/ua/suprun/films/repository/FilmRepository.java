package ua.suprun.films.repository;

import org.springframework.data.repository.CrudRepository;
import ua.suprun.films.entity.FilmEntity;

import java.util.Collection;

/**
 * Class FilmRepository implementation.
 *
 * @author Bohdan_Suprun
 */
public interface FilmRepository extends CrudRepository<FilmEntity, Long>
{
    Collection<FilmEntity> findByNameContaining(String name);
}
