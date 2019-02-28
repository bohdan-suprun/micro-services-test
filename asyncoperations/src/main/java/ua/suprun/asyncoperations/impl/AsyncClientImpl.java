package ua.suprun.asyncoperations.impl;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;
import ua.suprun.asyncoperations.RestAsyncClient;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;

/**
 * Class AsyncClientImpl implementation.
 *
 * @author Bohdan_Suprun
 */
public class AsyncClientImpl implements RestAsyncClient
{
    private final RestTemplate restTemplate;
    private final ThreadPoolTaskExecutor threadPoolExecutor;

    public AsyncClientImpl(RestTemplate restTemplate, ThreadPoolTaskExecutor threadPoolExecutor)
    {
        this.restTemplate = restTemplate;
        this.threadPoolExecutor = threadPoolExecutor;
    }

    @Override
    public <RS> Future<RS> get(final String url, final Class<RS> responseType, final Object... args)
    {
        return threadPoolExecutor.submit(() -> restTemplate.getForEntity(translateUrl(url), responseType, args).getBody());
    }

    @Override
    public <RS> Future<Collection<RS>> getForCollection(String url, Class<RS[]> responseType, Object... args)
    {
        return threadPoolExecutor.submit(() -> {
            RS[] results = restTemplate.getForEntity(translateUrl(url), responseType, args).getBody();
            final List<RS> resultsAsList = new ArrayList<>();

            if (results != null)
            {
                Collections.addAll(resultsAsList, results);
            }

            return resultsAsList;
        });

    }

    @Override
    public <RQ, RS> Future<RS> post(String url, RQ request, Class<RS> responseType, Object... args)
    {
        return threadPoolExecutor
            .submit(() -> restTemplate.postForEntity(translateUrl(url), request, responseType, args).getBody());
    }
    private String translateUrl(String url)
    {
        return url.startsWith("/")
            ? "http:/" + url
            : url;
    }
}
