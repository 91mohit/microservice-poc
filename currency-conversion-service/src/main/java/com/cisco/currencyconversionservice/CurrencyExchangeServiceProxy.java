package com.cisco.currencyconversionservice;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "currency-exchange-service", url = "localhost:8000")
//@FeignClient(name="currency-exchange-service")  
@RibbonClient(name="exchangeapi") 
@FeignClient(name="netflix-zuul-api-gateway-server")
public interface CurrencyExchangeServiceProxy {
	// @GetMapping("/currency-exchange/from/{from}/to/{to}")
	@GetMapping("/exchangeapi/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from,
			@PathVariable("to") String to);
}