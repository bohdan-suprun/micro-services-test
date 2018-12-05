package ua.suprun.user;

import org.springframework.boot.SpringApplication;
import ua.suprun.common.annotations.JpaMicroService;

/**
 * Class UserApp implementation.
 *
 * @author Bohdan_Suprun
 */
@JpaMicroService("ua.suprun.user.repository")
public class UserApp
{
    public static void main(String[] args)
    {
        SpringApplication.run(UserApp.class, args);
    }
}
