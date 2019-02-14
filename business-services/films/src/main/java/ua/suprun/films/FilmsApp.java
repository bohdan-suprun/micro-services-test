package ua.suprun.films;

import org.springframework.boot.SpringApplication;
import ua.suprun.common.annotations.JpaService;

/**
 * Class FilmsApp implementation.
 *
 * @author Bohdan_Suprun
 */
@JpaService
public class FilmsApp
{
    public static void main(String[] args)
    {
        SpringApplication.run(FilmsApp.class, args);
    }
}
