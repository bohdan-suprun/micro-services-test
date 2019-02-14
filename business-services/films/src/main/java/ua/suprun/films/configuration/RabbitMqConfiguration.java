package ua.suprun.films.configuration;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Class RabbitMqConfiguration implementation.
 *
 * @author Bohdan_Suprun
 */
@Configuration
@EnableRabbit
public class RabbitMqConfiguration
{
    private static final String queueName = "get-films-by-id";

    @Bean
    public Queue getFilmsByIdQueue()
    {
        return new Queue(queueName);
    }

    @Bean
    public FanoutExchange getFilmsByIdExchange()
    {
        return new FanoutExchange(queueName + "-exchange");
    }

    @Bean
    public Binding getFilmsByIdBinding(Queue getFilmsByIdQueue, FanoutExchange fanoutExchange)
    {
        return BindingBuilder.bind(getFilmsByIdQueue).to(fanoutExchange);
    }

    @Bean
    public AmqpTemplate amqpTemplate(ConnectionFactory connectionFactory, Jackson2JsonMessageConverter messageConverter)
    {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter);

        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter jacksonConverter()
    {
        return new Jackson2JsonMessageConverter();
    }

}
