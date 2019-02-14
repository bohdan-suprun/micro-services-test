package ua.suprun.films.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ua.suprun.dto.films.FilmDto;
import ua.suprun.films.entity.FilmEntity;

/**
 * Class UserEntityToUserDtoConverter implementation.
 *
 * @author Bohdan_Suprun
 */
@Component
public class FilmEntityToFilmDtoConverter implements Converter<FilmEntity, FilmDto>
{
    @Override
    public FilmDto convert(FilmEntity filmEntity)
    {
        final FilmDto filmDto = new FilmDto();
        filmDto.setId(filmEntity.getId());
        filmDto.setCountries(filmEntity.getCountries());
        filmDto.setName(filmEntity.getName());
        filmDto.setYear(filmEntity.getYear());

        return filmDto;
    }
}
