package ua.suprun.userfilmsedge.service.impl;

import com.netflix.discovery.converters.Auto;
import org.springframework.amqp.core.AsyncAmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import ua.suprun.asyncoperations.AsyncResultFetcher;
import ua.suprun.asyncoperations.RestAsyncClient;
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
    private RestAsyncClient asyncClient;
    @Value("${application.amqp.films.get-films-by-id-exchange-name}")
    private String filmsByIdExchangeName;
    @Autowired
    private AsyncAmqpTemplate asyncAmqpTemplate;

    @Override
    public UserFilmsDto getUserFilms(Long userId) throws Exception
    {
        final Future<Collection<UserPreferencesDto>> userPreferencesFuture = asyncClient
            .getForCollection("/user-preferences/search/user-id/{userId}", UserPreferencesDto[].class, userId);
        final Future<UserDto> userFuture = asyncClient.get("/user/{userId}", UserDto.class, userId);

        // Get responses
        final Collection<UserPreferencesDto> userPreferencesDtos = AsyncResultFetcher.fetchResult(userPreferencesFuture);
        final List<Long> filmsId = userPreferencesDtos.stream().map(UserPreferencesDto::getFilmId).collect(Collectors.toList());

        final ListenableFuture<Collection<FilmDto>> filmsDto = asyncAmqpTemplate
            .convertSendAndReceive(filmsByIdExchangeName, "films-id", filmsId);

        final UserFilmsDto userFilmsDto = new UserFilmsDto();
        userFilmsDto.setUser(AsyncResultFetcher.fetchResult(userFuture));
        userFilmsDto.setUserFilms(AsyncResultFetcher.fetchResult(filmsDto));

        return userFilmsDto;
    }

    @Override
    public UsersLikedFilmDto getUsersLikedFilm(Long filmId)
    {
        return null;
    }
}
