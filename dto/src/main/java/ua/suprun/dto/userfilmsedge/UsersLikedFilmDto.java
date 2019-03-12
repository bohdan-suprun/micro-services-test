package ua.suprun.dto.userfilmsedge;

import lombok.Data;
import ua.suprun.dto.films.FilmDto;
import ua.suprun.dto.user.UserDto;

import java.util.Collection;

/**
 * Class UserFilmsDto implementation.
 *
 * @author Bohdan_Suprun
 */
@Data
public class UsersLikedFilmDto
{
    private FilmDto film;
    private Collection<UserDto> usersLikedFilm;
}
