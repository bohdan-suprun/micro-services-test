package ua.suprun.films;

import org.springframework.boot.SpringApplication;
import ua.suprun.common.annotations.JpaMicroService;

/**
 * Class FilmsApp implementation.
 *
 * @author Bohdan_Suprun
 */
@JpaMicroService
public class FilmsApp
{
    public static void main(String[] args)
    {
        SpringApplication.run(FilmsApp.class, args);
    }
}
