package com.cisco.currencyconversionservice;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.swagger.annotations.Api;

@RestController
@Api(value = "CurrencyConversionController REST Endpoint", description = "Convert currency as per exchange Value")
public class CurrencyConversionController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CurrencyExchangeServiceProxy proxy;
	@Autowired
	private KafkaTemplate<String, CurrencyConversionBean> kafkaTemplate;
	private static final String TOPIC = "kafka_example";

	@PostMapping("/publishToKafka")
	public String convertCurrency(@RequestBody CurrencyConversionBean conversionBean) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", conversionBean.getFrom());
		uriVariables.put("to", conversionBean.getTo());

		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class,
				uriVariables);

		CurrencyConversionBean response = responseEntity.getBody();

		kafkaTemplate.send(TOPIC,response);
		return "Published successfully";
		
	}

	@PostMapping("/currencyconverter")
	public CurrencyConversionBean convertCurrencyFeign(@RequestBody CurrencyConversionBean conversionBean) {
		Map<String, String> uriVariables = new HashMap<>();
		uriVariables.put("from", conversionBean.getFrom());
		uriVariables.put("to", conversionBean.getTo());
		System.out.println(uriVariables);

		ResponseEntity<CurrencyConversionBean> responseEntity = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversionBean.class,
				uriVariables);

		CurrencyConversionBean response = responseEntity.getBody();

		logger.info("{}", response);
		return new CurrencyConversionBean(response.getId(), conversionBean.getFrom(), conversionBean.getTo(), response.getConversionMultiple(), conversionBean.getQuantity(),
				conversionBean.getQuantity().multiply(response.getConversionMultiple()));
	}

}
