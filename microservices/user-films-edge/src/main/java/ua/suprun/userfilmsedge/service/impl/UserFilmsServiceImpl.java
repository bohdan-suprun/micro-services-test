package ua.suprun.userfilmsedge.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.suprun.asyncoperations.AsyncClient;
import ua.suprun.asyncoperations.AsyncResultFetcher;
import ua.suprun.dto.films.FilmDto;
import ua.suprun.dto.user.UserDto;
import ua.suprun.dto.userfilmsedge.UserFilmsDto;
import ua.suprun.dto.userfilmsedge.UsersLikedFilmDto;
import ua.suprun.dto.userpref.UserPreferencesDto;
import ua.suprun.userfilmsedge.service.UserFilmsService;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

/**
 * Class UserFilmsServiceImpl implementation.
 *
 * @author Bohdan_Suprun
 */
@Service
public class UserFilmsServiceImpl implements UserFilmsService
{
    @Autowired
    private AsyncClient asyncClient;

    @Override
    public UserFilmsDto getUserFilms(Long userId) throws Exception
    {
        final Future<Collection<UserPreferencesDto>> userPreferencesFuture = asyncClient
            .getForCollection("/user-preferences/search/user-id/{userId}", UserPreferencesDto.class, userId);
        final Future<UserDto> userFuture = asyncClient.get("/user/{userId}", UserDto.class, userId);

        // Get responses
        final Collection<UserPreferencesDto> userPreferencesDtos = AsyncResultFetcher.fetchResult(userPreferencesFuture);
        final List<Future<FilmDto>> filmFutures = userPreferencesDtos
            .stream()
            .map(userPreferencesDto -> asyncClient.get("/films/{filmId}", FilmDto.class, userPreferencesDto.getFilmId()))
            .collect(Collectors.toList());

        final UserFilmsDto userFilmsDto = new UserFilmsDto();
        userFilmsDto.setUser(AsyncResultFetcher.fetchResult(userFuture));
        userFilmsDto.setUserFilms(AsyncResultFetcher.fetchResults(filmFutures));

        return userFilmsDto;
    }

    @Override
    public UsersLikedFilmDto getUsersLikedFilm(Long filmId)
    {
        return null;
    }
}
