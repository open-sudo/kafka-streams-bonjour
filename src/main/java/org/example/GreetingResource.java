package org.example;

import javax.enterprise.context.ApplicationScoped;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.inject.*;
import org.apache.kafka.streams.*;
import org.apache.kafka.streams.kstream.*;
import org.apache.kafka.streams.state.*;

@Path("/hello")
public class GreetingResource {
   @Inject
    KafkaStreams streams;

    @Inject
    GreetingQueries queries;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
	queries.hello();
        return "Hello from RESTEasy Reactive";
    }
}
