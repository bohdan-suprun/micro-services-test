package ua.suprun.user.dto;

import lombok.Data;

/**
 * Class UserDto implementation.
 *
 * @author Bohdan_Suprun
 */
@Data
public class UserDto
{
    private Long id;
    private String fullName;
    private String email;
}
