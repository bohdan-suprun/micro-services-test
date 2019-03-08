package ua.suprun.getaway.services;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import ua.suprun.dto.user.UserDto;

/**
 * Class UserService implementation.
 *
 * @author Bohdan_Suprun
 */
@Service
public class UserService
{
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(defaultFallback = "userServiceIsNotAvailable")
    public String getUserRoleByEmail(String email) {
        final ResponseEntity<UserDto> entity = restTemplate
            .getForEntity("http://user/email/?userEmail={1}", UserDto.class, email);

        return entity.getBody() != null
            ? entity.getBody().getRole()
            : "";
    }

    private String userServiceIsNotAvailable()
    {
        throw new InternalAuthenticationServiceException("Can not retrieve user credentials");
    }
}
