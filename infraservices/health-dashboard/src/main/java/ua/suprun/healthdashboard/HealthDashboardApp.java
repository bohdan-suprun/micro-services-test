package ua.suprun.healthdashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * Class HealthDashboardApp implementation.
 *
 * @author Bohdan_Suprun
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HealthDashboardApp
{
    public static void main(String[] args)
    {
        SpringApplication.run(HealthDashboardApp.class, args);
    }
}
