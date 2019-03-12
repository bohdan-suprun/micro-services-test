package ua.suprun.userfilmsedge.service.client.fallback;

import org.springframework.stereotype.Component;
import ua.suprun.dto.user.UserCreateDto;
import ua.suprun.dto.user.UserDto;
import ua.suprun.userfilmsedge.service.client.UserClient;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Class UserClientFallback implementation.
 */
@Component
public class UserClientFallback implements UserClient
{
    @Override
    public UserDto createUser(UserCreateDto userCreateDto)
    {
        return null;
    }

    @Override
    public UserDto getUserById(Long userId)
    {
        return null;
    }

    @Override
    public UserDto getUserByEmail(String email)
    {
        return null;
    }

    @Override
    public Collection<UserDto> getUsersById(List<Long> userIds)
    {
        return Collections.emptyList();
    }
}
