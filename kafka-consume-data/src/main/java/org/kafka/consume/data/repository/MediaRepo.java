package org.kafka.consume.data.repository;



import org.kafka.consume.data.entity.StreamData;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaRepo extends JpaRepository<StreamData, Long> {


}
