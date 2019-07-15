package com.cisco.currencyexchangeservice;

import java.math.BigDecimal;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@Api(value = "CurrencyExchangeController REST Endpoint", description = "Convert currency as per exchange Value")
public class CurrencyExchangeController {

	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from, @PathVariable String to){
		int id = new Random().nextInt(900) + 100;
		ExchangeValue exchange = new ExchangeValue((long)id, from, to, BigDecimal.valueOf(69));
		return exchange;
	}
}
