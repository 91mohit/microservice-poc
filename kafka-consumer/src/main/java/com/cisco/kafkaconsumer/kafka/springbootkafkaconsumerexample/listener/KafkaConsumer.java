package com.cisco.kafkaconsumer.kafka.springbootkafkaconsumerexample.listener;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.cisco.kafkaconsumer.kafka.springbootkafkaconsumerexample.model.CurrencyBean;

@Service
public class KafkaConsumer {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private KafkaPublisher kafkaPublisher;
	
    @KafkaListener(topics = "kafka_example", groupId = "group_id")
    public void consume(String message) {
    	logger.info("Consumed message: " + message);
    }


    @KafkaListener(topics = "Request_Topic", groupId = "group_json",
            containerFactory = "conversionKafkaListenerFactory")
    public void consumeJson(CurrencyBean conversionBean) {
    	logger.info("Consumed JSON Message: " + conversionBean.toString());
    	conversionBean.setConversionMultiple(BigDecimal.valueOf(69));
    	kafkaPublisher.publishToKafka(conversionBean);
    }
}
