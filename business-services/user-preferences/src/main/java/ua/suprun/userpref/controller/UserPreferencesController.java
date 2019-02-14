package ua.suprun.userpref.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ua.suprun.dto.userpref.UserPreferencesDto;
import ua.suprun.userpref.entity.UserPreferencesEntity;
import ua.suprun.userpref.service.UserPreferencesService;

import javax.validation.Valid;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Class UserPreferencesController implementation.
 *
 * @author Bohdan_Suprun
 */
@RestController
public class UserPreferencesController
{
    @Autowired
    private UserPreferencesService userPreferencesService;
    @Autowired
    private ConversionService conversionService;

    @PostMapping
    public UserPreferencesDto createUserPreferences(@RequestBody @Valid UserPreferencesDto userPreferencesDto)
    {
        final UserPreferencesEntity userPreference = userPreferencesService
            .createUserPreference(conversionService.convert(userPreferencesDto, UserPreferencesEntity.class));

        return conversionService.convert(userPreference, UserPreferencesDto.class);
    }

    @GetMapping("/search/user-id/{userId}")
    public Collection<UserPreferencesDto> getUserPreferencesByUserId(@PathVariable("userId") Long userId)
    {
        final Collection<UserPreferencesEntity> byUserId = userPreferencesService.findByUserId(userId);

        return byUserId.stream()
            .map(userPreferencesEntity -> conversionService.convert(userPreferencesEntity, UserPreferencesDto.class))
            .collect(Collectors.toList());
    }

    @GetMapping("/search/film-id/{filmId}")
    public Collection<UserPreferencesDto> getUserPreferencesByFilmId(@PathVariable("filmId") Long filmId)
    {
        final Collection<UserPreferencesEntity> byFilmId = userPreferencesService.findByFilmId(filmId);

        return byFilmId.stream()
            .map(userPreferencesEntity -> conversionService.convert(userPreferencesEntity, UserPreferencesDto.class))
            .collect(Collectors.toList());
    }
}
