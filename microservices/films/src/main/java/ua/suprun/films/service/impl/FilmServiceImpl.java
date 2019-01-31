package ua.suprun.films.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.suprun.films.entity.FilmEntity;
import ua.suprun.films.repository.FilmRepository;
import ua.suprun.films.service.FilmService;

import java.util.Collection;

/**
 * Class FilmServiceImpl implementation.
 *
 * @author Bohdan_Suprun
 */
@Service
public class FilmServiceImpl implements FilmService
{
    @Autowired
    private FilmRepository filmRepository;

    @Override
    public FilmEntity createFilm(FilmEntity filmEntity)
    {
        return filmRepository.save(filmEntity);
    }

    @Override
    public FilmEntity findFilmById(Long id)
    {
        return filmRepository.findById(id).orElse(null);
    }

    @Override
    public Collection<FilmEntity> findFilmsByName(String filmName)
    {
        return filmRepository.findByNameContaining(filmName);
    }
}
