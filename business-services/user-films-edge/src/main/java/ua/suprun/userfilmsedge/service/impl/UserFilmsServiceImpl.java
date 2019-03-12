package ua.suprun.userfilmsedge.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
import ua.suprun.userfilmsedge.service.client.FilmClient;
import ua.suprun.userfilmsedge.service.client.UserClient;
import ua.suprun.userfilmsedge.service.client.UserPreferencesClient;

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

    @Autowired
    private UserClient userClient;
    @Autowired
    private UserPreferencesClient userPreferencesClient;
    @Autowired
    private FilmClient filmClient;

    @HystrixCommand(fallbackMethod = "getUserFilmsDefault")
    @Override
    public UserFilmsDto getUserFilms(Long userId) throws Exception
    {
        final Future<Collection<UserPreferencesDto>> userPreferencesFuture = asyncClient
            .executeAsync(() -> userPreferencesClient.getUserPreferencesByUserId(userId));
        final Future<UserDto> userFuture = asyncClient.executeAsync(() -> userClient.getUserById(userId));

        // Get responses
        final Collection<UserPreferencesDto> userPreferencesDtos = AsyncResultFetcher.fetchResult(userPreferencesFuture);
        final List<Long> filmsId = userPreferencesDtos.stream().map(UserPreferencesDto::getFilmId).collect(Collectors.toList());

        final Future<Collection<FilmDto>> filmsDto = asyncClient.executeAsync(() -> filmClient.getFilmsById(filmsId));

        final UserFilmsDto userFilmsDto = new UserFilmsDto();
        userFilmsDto.setUser(AsyncResultFetcher.fetchResult(userFuture));
        userFilmsDto.setUserFilms(AsyncResultFetcher.fetchResult(filmsDto));

        return userFilmsDto;
    }

    private UserFilmsDto getUserFilmsDefault(Long userId)
    {
        return null;
    }

    @Override
    public UsersLikedFilmDto getUsersLikedFilm(Long filmId) throws Exception
    {
        final Future<Collection<UserPreferencesDto>> userPreferencesFuture = asyncClient
            .executeAsync(() -> userPreferencesClient.getUserPreferencesByFilmId(filmId));
        final Future<FilmDto> filmDtoFuture = asyncClient.executeAsync(() -> filmClient.getFilmById(filmId));

        final List<Long> userIdsLikedFilm = AsyncResultFetcher.fetchResult(userPreferencesFuture)
            .stream()
            .map(UserPreferencesDto::getUserId)
            .collect(Collectors.toList());

        final Future<Collection<UserDto>> usersLikedFilmFuture = asyncClient
            .executeAsync(() -> userClient.getUsersById(userIdsLikedFilm));

        final UsersLikedFilmDto usersLikedFilmDto = new UsersLikedFilmDto();
        usersLikedFilmDto.setFilm(AsyncResultFetcher.fetchResult(filmDtoFuture));
        usersLikedFilmDto.setUsersLikedFilm(AsyncResultFetcher.fetchResult(usersLikedFilmFuture));

        return usersLikedFilmDto;
    }
}
