package ua.suprun.traceserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

/**
 * Class TraceServerApp implementation.
 *
 * @author Bohdan_Suprun
 */
@SpringBootApplication
@EnableZipkinServer
public class TraceServerApp
{
    public static void main(String[] args)
    {
        SpringApplication.run(TraceServerApp.class, args);
    }
}
