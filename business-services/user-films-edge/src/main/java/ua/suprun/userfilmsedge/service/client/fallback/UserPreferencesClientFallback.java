package ua.suprun.userfilmsedge.service.client.fallback;

import org.springframework.stereotype.Component;
import ua.suprun.dto.userpref.UserPreferencesDto;
import ua.suprun.userfilmsedge.service.client.UserPreferencesClient;

import java.util.Collection;
import java.util.Collections;

/**
 * Class UserPreferencesClientFallback implementation.
 *
 * @author Bohdan_Suprun
 */
@Component
public class UserPreferencesClientFallback implements UserPreferencesClient
{
    @Override
    public UserPreferencesDto createUserPreferences(UserPreferencesDto userPreferencesDto)
    {
        return null;
    }

    @Override
    public Collection<UserPreferencesDto> getUserPreferencesByUserId(Long userId)
    {
        return Collections.emptyList();
    }

    @Override
    public Collection<UserPreferencesDto> getUserPreferencesByFilmId(Long filmId)
    {
        return Collections.emptyList();
    }
}
