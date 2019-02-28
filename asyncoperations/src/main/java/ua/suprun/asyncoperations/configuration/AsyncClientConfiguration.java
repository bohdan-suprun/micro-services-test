package ua.suprun.asyncoperations.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;
import ua.suprun.asyncoperations.RestAsyncClient;
import ua.suprun.asyncoperations.impl.AsyncClientImpl;

/**
 * Class AsyncClientConfiguration implementation.
 *
 * @author Bohdan_Suprun
 */
@Configuration
public class AsyncClientConfiguration
{
    @Value("${spring.application.name}")
    private String applicationName;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate()
    {
        return new RestTemplate();
    }

    @Bean
    public RestAsyncClient asyncClient(RestTemplate restTemplate, ThreadPoolTaskExecutor threadPoolExecutor)
    {
        return new AsyncClientImpl(restTemplate, threadPoolExecutor);
    }

    @Bean
    public ThreadPoolTaskExecutor taskExecutor()
    {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix(applicationName + "RestAsyncClient-");
        executor.initialize();
        return executor;
    }
}
