package ua.suprun.userfilmsedge;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;
import ua.suprun.common.annotations.EdgeService;

/**
 * Class UserFilmsEdgeApp implementation.
 *
 * @author Bohdan_Suprun
 */
@EdgeService
@EnableCircuitBreaker
@EnableFeignClients
public class UserFilmsEdgeApp
{
    public static void main(String[] args)
    {
        SpringApplication.run(UserFilmsEdgeApp.class, args);
    }
}
