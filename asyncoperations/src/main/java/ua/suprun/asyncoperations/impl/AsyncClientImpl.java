package ua.suprun.asyncoperations.impl;

import org.springframework.web.client.RestTemplate;
import ua.suprun.asyncoperations.AsyncClient;

import java.util.Collection;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Class AsyncClientImpl implementation.
 *
 * @author Bohdan_Suprun
 */
public class AsyncClientImpl implements AsyncClient
{
    private final RestTemplate restTemplate;
    private final ThreadPoolExecutor threadPoolexecutor;

    public AsyncClientImpl(RestTemplate restTemplate, ThreadPoolExecutor threadPoolExecutor)
    {
        this.restTemplate = restTemplate;
        this.threadPoolexecutor = threadPoolExecutor;
    }

    @Override
    public <RS> Future<RS> get(final String url, final Class<RS> responseType, final Object... args)
    {
        return threadPoolexecutor.submit(() -> restTemplate.getForEntity(url, responseType, args).getBody());
    }

    @Override
    @SuppressWarnings("unchecked")
    public <RS> Future<Collection<RS>> getForCollection(String url, Class<RS> responseType, Object... args)
    {
        return threadPoolexecutor.submit(() -> restTemplate.getForEntity(url, Collection.class, args).getBody());

    }

    @Override
    public <RQ, RS> Future<RS> post(String url, RQ request, Class<RS> responseType, Object... args)
    {
        return threadPoolexecutor.submit(() -> restTemplate.postForEntity(url, request, responseType, args).getBody());
    }

    private String translateUrl(String url)
    {
        return url.startsWith("/")
            ? "http:/" + url
            : url;
    }
}
