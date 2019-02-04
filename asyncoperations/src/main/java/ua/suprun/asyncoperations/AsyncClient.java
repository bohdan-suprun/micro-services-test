package ua.suprun.asyncoperations;

import java.util.Collection;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Class AsyncClient implementation.
 *
 * @author Bohdan_Suprun
 */
public interface AsyncClient
{
    <RS> Future<RS> get(String url, Class<RS> responseType, Object... args);

    <RS> Future<Collection<RS>> getForCollection(String url, Class<RS[]> responseType, Object... args);

    <RQ, RS> Future<RS> post(String url, RQ request, Class<RS> responseType, Object... args);

}
