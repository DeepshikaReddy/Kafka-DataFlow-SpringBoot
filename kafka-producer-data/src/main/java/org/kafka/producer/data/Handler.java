package org.kafka.producer.data;

import com.launchdarkly.eventsource.EventHandler;
import com.launchdarkly.eventsource.MessageEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;

//How application handles requests recieved from server.
public class Handler implements EventHandler{
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Handler.class);

    private KafkaTemplate<String, String> kafkaTemplate;
    private String topic;

    public Handler(KafkaTemplate<String, String> kafkaTemplate, String topic) {
        this.kafkaTemplate = kafkaTemplate;
        this.topic = topic;
    }
    

	@Override
	public void onOpen() throws Exception {
		//Connection Opened
		
	}

	@Override
	public void onClosed() throws Exception {
		//Connection closed
		
	}

	@Override
	public void onMessage(String event, MessageEvent messageEvent) throws Exception {
		//New data is added , onMessage() is triggered.
		LOGGER.info(String.format("event data -> %s", messageEvent.getData()));
		System.out.println("*****");
        System.out.println(messageEvent.getData());
        System.out.println("*****");
        kafkaTemplate.send(topic, messageEvent.getData());//send data to kafka.
		
	}

	@Override
	public void onComment(String comment) throws Exception {
		//Comment is recieved from stream
		
	}

	@Override
	public void onError(Throwable t) {
		//error occured in the server connection.
		
	}

}
