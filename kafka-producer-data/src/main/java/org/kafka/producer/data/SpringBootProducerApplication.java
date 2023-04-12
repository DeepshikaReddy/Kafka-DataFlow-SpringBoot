package org.kafka.producer.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringBootProducerApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootProducerApplication.class, args);
		System.out.println("Producer Microservice");
	}
	
	@Autowired
    private Producer producer;

	//when application starts, run method called.
    @Override
    public void run(String... args) throws Exception {
    	producer.sendMessage();
    }

}
