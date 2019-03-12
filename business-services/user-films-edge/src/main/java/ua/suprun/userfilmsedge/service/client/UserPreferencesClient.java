package ua.suprun.userfilmsedge.service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ua.suprun.dto.userpref.UserPreferencesDto;
import ua.suprun.userfilmsedge.service.client.fallback.UserPreferencesClientFallback;

import java.util.Collection;

/**
 * Class UserClient implementation.
 *
 * @author Bohdan_Suprun
 */
@FeignClient(value = "user-preferences", fallback = UserPreferencesClientFallback.class)
public interface UserPreferencesClient
{
    @PostMapping
    UserPreferencesDto createUserPreferences(@RequestBody UserPreferencesDto userPreferencesDto);

    @GetMapping("/search/user-id/{userId}")
    Collection<UserPreferencesDto> getUserPreferencesByUserId(@PathVariable("userId") Long userId);

    @GetMapping("/search/film-id/{filmId}")
    Collection<UserPreferencesDto> getUserPreferencesByFilmId(@PathVariable("filmId") Long filmId);
}
