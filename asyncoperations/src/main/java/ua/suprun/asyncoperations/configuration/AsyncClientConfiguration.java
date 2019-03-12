package ua.suprun.asyncoperations.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import ua.suprun.asyncoperations.AsyncClient;
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
    public ThreadPoolTaskExecutor taskExecutor()
    {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix(applicationName + "AsyncClient-");
        executor.initialize();
        return executor;
    }

    @Bean
    public AsyncClient asyncClient(ThreadPoolTaskExecutor threadPoolTaskExecutor)
    {
        return new AsyncClientImpl(threadPoolTaskExecutor);
    }
}
