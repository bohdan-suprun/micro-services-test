package ua.suprun.userfilmsedge.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.AsyncAmqpTemplate;
import org.springframework.amqp.rabbit.AsyncRabbitTemplate;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Class AmqpConfiguration implementation.
 *
 * @author Bohdan_Suprun
 */
@Configuration
@EnableRabbit
public class AmqpConfiguration
{
    @Bean
    public AsyncAmqpTemplate amqpTemplate(ConnectionFactory connectionFactory, Jackson2JsonMessageConverter messageConverter)
    {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter);

        return new AsyncRabbitTemplate(rabbitTemplate);
    }

    @Bean
    public Jackson2JsonMessageConverter jacksonConverter()
    {
        return new Jackson2JsonMessageConverter();
    }
}
