package ua.suprun.dto.films;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/**
 * Class CreateFilmDto implementation.
 *
 * @author Bohdan_Suprun
 */
@Data
public class FilmDto
{
    private Long id;
    private String name;
    private Integer year;
    private String countries;
}
