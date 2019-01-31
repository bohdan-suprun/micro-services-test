package ua.suprun.films.service;

import ua.suprun.films.entity.FilmEntity;

import java.util.Collection;

/**
 * Class FilmService implementation.
 *
 * @author Bohdan_Suprun
 */
public interface FilmService
{
    FilmEntity createFilm(FilmEntity filmEntity);

    FilmEntity findFilmById(Long id);

    Collection<FilmEntity> findFilmsByName(String filmName);
}
