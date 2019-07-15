package com.cisco.currencyconversionservice.model.mongodb.repositories;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.cisco.currencyconversionservice.model.CurrencyBean;


public interface CurrencyConversionRepository extends MongoRepository<CurrencyBean, String>{
}