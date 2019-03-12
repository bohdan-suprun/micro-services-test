package ua.suprun.asyncoperations.impl;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import ua.suprun.asyncoperations.AsyncClient;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * Class AsyncClientImpl implementation.
 *
 * @author Bohdan_Suprun
 */
public class AsyncClientImpl implements AsyncClient
{
    private final ThreadPoolTaskExecutor threadPoolExecutor;

    public AsyncClientImpl(ThreadPoolTaskExecutor threadPoolExecutor)
    {
        this.threadPoolExecutor = threadPoolExecutor;
    }

    @Override
    public <RS> Future<RS> executeAsync(Callable<RS> job)
    {
        return threadPoolExecutor.submit(job);
    }
}
