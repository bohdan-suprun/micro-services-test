package ua.suprun.getaway.security;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.AuthoritiesExtractor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import ua.suprun.getaway.services.UserService;

import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * Class UserAuthoritiesExtractor implementation.
 *
 * @author Bohdan_Suprun
 */
@Component
public class UserAuthoritiesExtractor implements AuthoritiesExtractor
{
    @Autowired
    private UserService userService;

    @Override
    public List<GrantedAuthority> extractAuthorities(Map<String, Object> map)
    {
        final String email = map.get("email").toString();
        final String userRoleByEmail = userService.getUserRoleByEmail(email);

        if (StringUtils.isNotBlank(userRoleByEmail))
        {
            return Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + userRoleByEmail.toUpperCase()));
        }

        return Collections.emptyList();
    }
}
