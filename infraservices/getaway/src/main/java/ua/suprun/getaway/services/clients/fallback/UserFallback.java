package ua.suprun.getaway.services.clients.fallback;

import org.springframework.stereotype.Component;
import ua.suprun.dto.user.UserDto;
import ua.suprun.getaway.services.clients.UserClient;

@Component
public class UserFallback implements UserClient {

    @Override
    public UserDto getUserByEmail(String userEmail) {
        return new UserDto();
    }
}
