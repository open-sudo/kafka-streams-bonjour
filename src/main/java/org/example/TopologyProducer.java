package org.example;

import javax.enterprise.context.ApplicationScoped;

import java.util.*;
import javax.enterprise.inject.*;
import org.apache.kafka.clients.*;
import org.apache.kafka.clients.producer.*;
import org.apache.kafka.common.serialization.*;
import org.apache.kafka.clients.*;
import org.apache.kafka.streams.*;
import org.apache.kafka.streams.kstream.*;


@ApplicationScoped
public class TopologyProducer{




	@Produces
	Topology createTopology(){
		StreamsBuilder builder= new StreamsBuilder();
		builder.stream("wc-in",Consumed.with(Serdes.String(),Serdes.String())).
						     mapValues( t -> t.toUpperCase()).
						     to("wc-out", Produced.with(Serdes.String(),Serdes.String()));
		return builder.build();

	}
}
