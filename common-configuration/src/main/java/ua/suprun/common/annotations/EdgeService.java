package ua.suprun.common.annotations;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import ua.suprun.asyncoperations.configuration.AsyncClientConfiguration;
import ua.suprun.common.configuration.SwaggerConfiguration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Class EdgeService implementation.
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
@Import({SwaggerConfiguration.class, AsyncClientConfiguration.class})
public @interface EdgeService
{
}
