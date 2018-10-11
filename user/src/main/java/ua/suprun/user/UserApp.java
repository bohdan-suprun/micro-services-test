package ua.suprun.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Class UserApp implementation.
 *
 * @author Bohdan_Suprun
 */
@SpringBootApplication
@EnableJpaRepositories(basePackages = "ua.suprun.user.repository")
@EnableEurekaClient
public class UserApp
{
    public static void main(String[] args)
    {
        SpringApplication.run(UserApp.class, args);
    }
}
