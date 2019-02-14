package ua.suprun.userpref.service;

import ua.suprun.userpref.entity.UserPreferencesEntity;

import java.util.Collection;

/**
 * Class UserPreferencesService implementation.
 *
 * @author Bohdan_Suprun
 */
public interface UserPreferencesService
{
    UserPreferencesEntity createUserPreference(UserPreferencesEntity userPreferencesEntity);

    Collection<UserPreferencesEntity> findByUserId(Long userId);

    Collection<UserPreferencesEntity> findByFilmId(Long filmId);
}
