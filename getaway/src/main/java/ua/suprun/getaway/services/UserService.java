package ua.suprun.getaway.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

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
        final ResponseEntity<Map> entity = restTemplate.getForEntity("http://user/email/?userEmail={1}", Map.class, email);

        return entity.getBody().getOrDefault("role", "").toString();
    }
}
