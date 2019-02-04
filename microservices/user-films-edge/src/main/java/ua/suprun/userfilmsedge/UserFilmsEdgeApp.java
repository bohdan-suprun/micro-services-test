package ua.suprun.userfilmsedge;

import org.springframework.boot.SpringApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import ua.suprun.common.annotations.EdgeService;
import ua.suprun.common.annotations.MicroService;

/**
 * Class UserFilmsEdgeApp implementation.
 *
 * @author Bohdan_Suprun
 */
@EdgeService
public class UserFilmsEdgeApp
{
    public static void main(String[] args)
    {
        SpringApplication.run(UserFilmsEdgeApp.class, args);
    }
}
