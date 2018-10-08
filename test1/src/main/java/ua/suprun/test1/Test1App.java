package ua.suprun.test1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Class Test1App implementation.
 *
 * @author Bohdan_Suprun
 */
@SpringBootApplication
@EnableWebMvc
@RestController
public class Test1App
{
    public static void main(String[] args)
    {
        SpringApplication.run(Test1App.class, args);
    }

    @GetMapping
    public String ping() {
        return "Hello";
    }
}
