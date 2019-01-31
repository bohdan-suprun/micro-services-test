package ua.suprun.films.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.suprun.dto.films.CreateFilmDto;
import ua.suprun.dto.films.FilmDto;
import ua.suprun.films.entity.FilmEntity;
import ua.suprun.films.service.FilmService;

import javax.validation.Valid;
import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class FilmController
{

    @Autowired
    private FilmService filmService;
    @Autowired
    private ConversionService conversionService;

    @PostMapping("/create")
    public FilmDto create(@RequestBody @Valid CreateFilmDto createFilmDto)
    {
        final FilmEntity createdFilm = filmService.createFilm(conversionService.convert(createFilmDto, FilmEntity.class));

        return conversionService.convert(createdFilm, FilmDto.class);
    }

    @GetMapping("/search")
    public Collection<FilmDto> search(@RequestParam("name") String filmName)
    {
        final Collection<FilmEntity> foundFilms = filmService
            .findFilmsByName(filmName);

        return foundFilms.stream()
            .map(filmEntity -> conversionService.convert(filmEntity, FilmDto.class))
            .collect(Collectors.toList());
    }

    @GetMapping("/{filmId}")
    public FilmDto getFilmById(@PathVariable("filmId") Long filmId)
    {
        final FilmEntity filmById = filmService.findFilmById(filmId);

        return conversionService.convert(filmById, FilmDto.class);
    }
}
