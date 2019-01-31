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
public class CreateFilmDto
{
    @NotBlank
    private String name;
    @Min(1899)
    private Integer year;
    @NotBlank
    private String countries;
}
