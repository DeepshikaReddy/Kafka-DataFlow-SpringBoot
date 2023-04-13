package org.kafka.consume.data;

import org.springframework.stereotype.Service;
import org.kafka.consume.data.repository.MediaRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.kafka.consume.data.entity.StreamData;

@Service
public class DataBaseConsumer {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DataBaseConsumer.class);
	
	private MediaRepo dataRepository;

    public DataBaseConsumer(MediaRepo dataRepository) {
        this.dataRepository = dataRepository;
    }
    
	 @KafkaListener(
	            topics = "${spring.kafka.topic.name}",
	            groupId = "${spring.kafka.consumer.group-id}"
	    )
	    public void consume(String eventMessage){

		    //Keeps reading the data.
	        LOGGER.info(String.format("Consumer::Event message received -> %s", eventMessage));
	        StreamData media = new StreamData();
	        media.setWikiEventData(eventMessage);

	        dataRepository.save(media);

	 }

}
