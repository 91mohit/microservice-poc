package com.cisco.currencyconversionservice.kafkaservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.cisco.currencyconversionservice.model.CurrencyBean;

@Service
public class KafkaPublisher {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	private static final String REQ_Topic = "Request_Topic";
	@Autowired
	private KafkaTemplate<String, CurrencyBean> kafkaTemplate;
	
   
	public void publishToKafka(CurrencyBean conversionBean) {
		logger.info("published JSON Message: " + conversionBean.toString());
		kafkaTemplate.send(REQ_Topic, conversionBean);
		logger.info("Published Request Successfully");
		
	}
}
