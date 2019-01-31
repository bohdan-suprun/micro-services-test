package ua.suprun.userpref;

import org.springframework.boot.SpringApplication;
import ua.suprun.common.annotations.JpaMicroService;

/**
 * Class UserPreferencesApp implementation.
 *
 * @author Bohdan_Suprun
 */
@JpaMicroService("ua.suprun.userpref.repository")
public class UserPreferencesApp
{
    public static void main(String[] args)
    {
        SpringApplication.run(UserPreferencesApp.class, args);
    }
}
