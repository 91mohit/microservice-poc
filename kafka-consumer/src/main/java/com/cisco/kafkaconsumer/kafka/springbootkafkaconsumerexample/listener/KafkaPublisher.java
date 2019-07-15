package com.cisco.kafkaconsumer.kafka.springbootkafkaconsumerexample.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.cisco.kafkaconsumer.kafka.springbootkafkaconsumerexample.model.CurrencyBean;

@Service
public class KafkaPublisher {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private static final String RES_Topic = "Response_Topic";
	@Autowired
	private KafkaTemplate<String, CurrencyBean> kafkaTemplate;
	
   
	public void publishToKafka(CurrencyBean conversionBean) {
		logger.info("published JSON Message: " + conversionBean.toString());
		kafkaTemplate.send(RES_Topic, conversionBean);
		logger.info("Published Response Successfully");
		
	}
}
