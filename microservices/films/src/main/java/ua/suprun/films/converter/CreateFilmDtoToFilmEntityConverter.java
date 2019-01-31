package ua.suprun.films.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import ua.suprun.dto.films.CreateFilmDto;
import ua.suprun.films.entity.FilmEntity;

/**
 * Class UserEntityToUserDtoConverter implementation.
 *
 * @author Bohdan_Suprun
 */
@Component
public class CreateFilmDtoToFilmEntityConverter implements Converter<CreateFilmDto, FilmEntity>
{
    @Override
    public FilmEntity convert(CreateFilmDto createFilmDto)
    {
        final FilmEntity filmEntity = new FilmEntity();
        filmEntity.setName(createFilmDto.getName());
        filmEntity.setCountries(createFilmDto.getCountries());
        filmEntity.setYear(createFilmDto.getYear());

        return filmEntity;
    }
}
