package ua.suprun.asyncoperations;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Class AsyncClient implementation.
 *
 * @author Bohdan_Suprun
 */
public class AsyncResultFetcher
{
    private static final long DEFAULT_WAIT_TIMEOUT = 1;
    private static final TimeUnit DEFAULT_WAIT_TIME_UNIT = TimeUnit.MINUTES;

    public static <RS> RS fetchResult(Future<RS> future) throws InterruptedException, ExecutionException, TimeoutException
    {
        return future.get(DEFAULT_WAIT_TIMEOUT, DEFAULT_WAIT_TIME_UNIT);
    }

    public static <RS> Collection<RS> fetchResults(Collection<Future<RS>> futures)
        throws InterruptedException, ExecutionException, TimeoutException
    {
        final List<RS> results = new ArrayList<>();
        for (Future<RS> future : futures)
        {
            results.add(future.get(DEFAULT_WAIT_TIMEOUT, DEFAULT_WAIT_TIME_UNIT));
        }
        return results;
    }
}
