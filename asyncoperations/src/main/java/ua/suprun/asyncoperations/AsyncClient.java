package ua.suprun.asyncoperations;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

/**
 * Class AsyncClient implementation.
 *
 * @author Bohdan_Suprun
 */
public interface AsyncClient
{
    <RS> Future<RS> executeAsync(Callable<RS> job);
}
