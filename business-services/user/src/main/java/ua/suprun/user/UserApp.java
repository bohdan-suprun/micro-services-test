package ua.suprun.user;

import org.springframework.boot.SpringApplication;
import ua.suprun.common.annotations.JpaService;

/**
 * Class UserApp implementation.
 *
 * @author Bohdan_Suprun
 */
@JpaService("ua.suprun.user.repository")
public class UserApp
{
    public static void main(String[] args)
    {
        SpringApplication.run(UserApp.class, args);
    }
}
