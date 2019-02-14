package ua.suprun.films.service;

import ua.suprun.films.entity.FilmEntity;

import java.util.Collection;
import java.util.List;

/**
 * Class FilmService implementation.
 *
 * @author Bohdan_Suprun
 */
public interface FilmService
{
    FilmEntity createFilm(FilmEntity filmEntity);

    FilmEntity findFilmById(Long id);

    List<FilmEntity> findFilmsById(List<Long> ids);

    Collection<FilmEntity> findFilmsByName(String filmName);
}
