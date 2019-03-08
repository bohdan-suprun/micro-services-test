package ua.suprun.getaway.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.suprun.dto.user.UserDto;
import ua.suprun.getaway.services.clients.UserClient;

/**
 * Class UserService implementation.
 *
 * @author Bohdan_Suprun
 */
@Service
public class UserService
{
    @Autowired
    private UserClient userClient;

    public String getUserRoleByEmail(String email) {
        final UserDto userDto = userClient.getUserByEmail(email);

        return userDto.getEmail();
    }
}
