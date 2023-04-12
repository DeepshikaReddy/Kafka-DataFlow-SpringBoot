package org.kafka.producer.data;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.EventSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.concurrent.TimeUnit;

@Service
public class Producer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);
	
	//Template for passing data to Kafka broker.
	
	private KafkaTemplate<String, String> kafkaTemplate;

	
	//Using Constructor based Dependency Injection.
	@Autowired
	public Producer(KafkaTemplate<String, String> kafkaTemplate) {
		super();
		this.kafkaTemplate = kafkaTemplate;
	}
	
	//Reads stream data using Event Source.
	public void sendMessage() throws InterruptedException {
		String topic = "recentchange";
		
		//Event Source 
		EventHandler event = new Handler(kafkaTemplate,topic);
		String rest_api="https://stream.wikimedia.org/v2/stream/recentchange";
		
		//builder instance for the stream api.
		EventSource.Builder builder = new EventSource.Builder(event, URI.create(rest_api));
		
		//Built event source.
        EventSource eventSource = builder.build();
        
        //Listen to event source for new events and push to topic.
        //Eventsource internally uses Multi-threading.
        eventSource.start();

        //10 minutes sleep time.
        TimeUnit.MINUTES.sleep(10);	
		
	}
	
	

}
