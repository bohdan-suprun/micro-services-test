package ua.suprun.getaway.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    public String getUserRoleByEmail(String email) {
        final ResponseEntity<UserDto> entity = restTemplate
            .getForEntity("http://user/email/?userEmail={1}", UserDto.class, email);

        return entity.getBody() != null
            ? entity.getBody().getRole()
            : "";
    }
}
