package ua.suprun.userpref.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.DefaultConversionService;

import java.util.List;

/**
 * Class ConversionServiceConfiguration implementation.
 *
 * @author Bohdan_Suprun
 */
@Configuration
public class ConversionServiceConfiguration
{

    @Bean
    @Order(1)
    public ConversionService conversionService(List<Converter<?, ?>> converters){
        final DefaultConversionService defaultConversionService = new DefaultConversionService();
        converters.forEach(defaultConversionService::addConverter);

        return defaultConversionService;
    }
}
