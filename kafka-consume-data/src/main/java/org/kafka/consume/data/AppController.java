package org.kafka.consume.data;

import org.kafka.consume.data.entity.StreamData;
import org.kafka.consume.data.repository.MediaRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppController {
    
    @Autowired
    private MediaRepo dataRepository;

    @RequestMapping("/fetchEventData")
    public List<StreamData> fetchEventData() {
        return dataRepository.findAll();
    }
}