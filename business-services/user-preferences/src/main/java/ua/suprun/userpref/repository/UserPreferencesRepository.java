package ua.suprun.userpref.repository;

import org.springframework.data.repository.CrudRepository;
import ua.suprun.userpref.entity.UserPreferencesEntity;

import java.util.Collection;

/**
 * Class UserPreferencesRepository implementation.
 *
 * @author Bohdan_Suprun
 */
public interface UserPreferencesRepository extends CrudRepository<UserPreferencesEntity, Long>
{
    Collection<UserPreferencesEntity> findByUserId(Long userId);

    Collection<UserPreferencesEntity> findByFilmId(Long filmId);
}
