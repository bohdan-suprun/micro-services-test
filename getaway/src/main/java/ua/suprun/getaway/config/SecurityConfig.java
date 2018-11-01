package ua.suprun.getaway.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.token.grant.code.AuthorizationCodeResourceDetails;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;
import org.springframework.security.web.authentication.preauth.AbstractPreAuthenticatedProcessingFilter;
import org.springframework.security.web.context.SecurityContextPersistenceFilter;
import ua.suprun.getaway.security.UserAuthoritiesExtractor;

/**
 * Class SecurityConfig implementation.
 *
 * @author Bohdan_Suprun
 */
@EnableOAuth2Client
@Configuration
@SuppressWarnings("all")
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    @Autowired
    private OAuth2ClientContextFilter oAuth2ClientContextFilter;

    @Autowired
    private OAuth2ClientContext context;

    @Autowired
    private UserAuthoritiesExtractor authoritiesExtractor;

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http
            .csrf().disable()
            .authorizeRequests()
                .antMatchers( "/error**").permitAll()
                .antMatchers( "/user/**").hasAnyRole("USER", "ADMIN")
                .antMatchers( "/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
            .and()
                .addFilterAfter(ssoFilter(), AbstractPreAuthenticatedProcessingFilter.class)
                .addFilterAfter(oAuth2ClientContextFilter, SecurityContextPersistenceFilter.class)
            .exceptionHandling()
                .authenticationEntryPoint(new LoginUrlAuthenticationEntryPoint("/login"))
            .and()
            .httpBasic()
        ;
    }

    @Bean
    @ConfigurationProperties("security.oauth2.client")
    OAuth2ProtectedResourceDetails oauth2Client()
    {
        return new AuthorizationCodeResourceDetails();
    }

    @Bean
    @ConfigurationProperties("security.oauth2.resource")
    ResourceServerProperties oauth2Resources()
    {
        return new ResourceServerProperties();
    }

    private OAuth2ClientAuthenticationProcessingFilter ssoFilter()
    {
        OAuth2ClientAuthenticationProcessingFilter filter = new OAuth2ClientAuthenticationProcessingFilter("/login");
        OAuth2RestTemplate oAuth2RestTemplate = new OAuth2RestTemplate(oauth2Client(), context);
        filter.setRestTemplate(oAuth2RestTemplate);

        UserInfoTokenServices tokenServices = new UserInfoTokenServices(oauth2Resources().getUserInfoUri(),
            oauth2Client().getClientId());
        tokenServices.setRestTemplate(oAuth2RestTemplate);
        tokenServices.setAuthoritiesExtractor(authoritiesExtractor);
        filter.setTokenServices(tokenServices);

        return filter;
    }
}
