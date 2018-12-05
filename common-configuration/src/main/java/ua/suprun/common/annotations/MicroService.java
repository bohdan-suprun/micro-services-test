package ua.suprun.common.annotations;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Class MicroService implementation.
 *
 * @author Bohdan_Suprun
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootApplication
@EnableEurekaClient
@PropertySources({
    @PropertySource("classpath:/eureka-properties.properties"),
    @PropertySource("classpath:/server-properties.properties")
})
public @interface MicroService
{
}
