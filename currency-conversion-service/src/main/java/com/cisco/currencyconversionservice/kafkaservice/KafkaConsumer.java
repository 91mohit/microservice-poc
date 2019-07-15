package com.cisco.currencyconversionservice.kafkaservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.cisco.currencyconversionservice.model.CurrencyBean;
import com.cisco.currencyconversionservice.service.CurrencyConversionService;

@Service
public class KafkaConsumer {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CurrencyConversionService conversionService;

    @KafkaListener(topics = "Response_Topic", groupId = "group_json",
            containerFactory = "kafkaListenerContainerFactory")
    public void consumeJson(CurrencyBean conversionBean) {
    	logger.info("Consumed Response Response Message: " + conversionBean.toString());
    	conversionService.updateConversionDetails(conversionBean, conversionBean.getId());
    	logger.info("DB updated Successfully for RequestId: "+conversionBean.getId());
    }
}
