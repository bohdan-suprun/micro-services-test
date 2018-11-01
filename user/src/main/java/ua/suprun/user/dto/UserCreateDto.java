package ua.suprun.user.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * Class UserDto implementation.
 *
 * @author Bohdan_Suprun
 */
@Data
public class UserCreateDto
{
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String email;
}
