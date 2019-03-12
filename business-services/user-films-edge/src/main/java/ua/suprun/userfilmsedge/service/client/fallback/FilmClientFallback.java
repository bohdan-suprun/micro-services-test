package ua.suprun.userfilmsedge.service.client.fallback;

import org.springframework.stereotype.Component;
import ua.suprun.dto.films.CreateFilmDto;
import ua.suprun.dto.films.FilmDto;
import ua.suprun.userfilmsedge.service.client.FilmClient;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Class UserClientFallback implementation.
 */
@Component
public class FilmClientFallback implements FilmClient
{
    @Override
    public FilmDto create(CreateFilmDto createFilmDto)
    {
        return null;
    }

    @Override
    public Collection<FilmDto> search(String filmName)
    {
        return Collections.emptyList();
    }

    @Override
    public FilmDto getFilmById(Long filmId)
    {
        return null;
    }

    @Override
    public Collection<FilmDto> getFilmsById(List<Long> filmsId)
    {
        return Collections.emptyList();
    }
}
