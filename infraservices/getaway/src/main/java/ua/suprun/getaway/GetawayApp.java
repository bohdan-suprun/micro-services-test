package ua.suprun.getaway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.openfeign.EnableFeignClients;
import ua.suprun.getaway.services.clients.UserClient;

/**
 * Class GetawayApp implementation.
 *
 * @author Bohdan_Suprun
 */
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
@EnableFeignClients(clients = UserClient.class)
public class GetawayApp {

    public static void main(String[] args) {
        SpringApplication.run(GetawayApp.class, args);
    }
}
