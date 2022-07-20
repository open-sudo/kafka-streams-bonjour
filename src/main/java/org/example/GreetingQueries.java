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

@ApplicationScoped
public class GreetingQueries {
   @Inject
    KafkaStreams streams;

    public void hello() {
          ReadOnlyKeyValueStore<Integer, Long> store = streams
            .store(StoreQueryParameters.fromNameAndType( 
                "numbers", 
                QueryableStoreTypes.keyValueStore() 
            ));

          store.all()
             .forEachRemaining(row -> {
                  System.out.println(row.key + " - " + row.value); 
          });
    }
}
