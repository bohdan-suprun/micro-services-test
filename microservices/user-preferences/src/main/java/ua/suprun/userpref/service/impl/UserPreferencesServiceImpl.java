package ua.suprun.userpref.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.suprun.userpref.entity.UserPreferencesEntity;
import ua.suprun.userpref.repository.UserPreferencesRepository;
import ua.suprun.userpref.service.UserPreferencesService;

import java.util.Collection;

/**
 * Class UserPreferencesServiceImpl implementation.
 *
 * @author Bohdan_Suprun
 */
@Service
public class UserPreferencesServiceImpl implements UserPreferencesService
{
    @Autowired
    private UserPreferencesRepository userPreferencesRepository;

    @Override
    public UserPreferencesEntity createUserPreference(UserPreferencesEntity userPreferencesEntity)
    {
        return userPreferencesRepository.save(userPreferencesEntity);
    }

    @Override
    public Collection<UserPreferencesEntity> findByUserId(Long userId)
    {
        return userPreferencesRepository.findByUserId(userId);
    }

    @Override
    public Collection<UserPreferencesEntity> findByFilmId(Long filmId)
    {
        return userPreferencesRepository.findByFilmId(filmId);
    }
}
