package com.cisco.currencyconversionservice.service.Impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.cisco.currencyconversionservice.model.CurrencyBean;
import com.cisco.currencyconversionservice.model.mongodb.repositories.CurrencyConversionRepository;
import com.cisco.currencyconversionservice.service.CurrencyConversionService;

@Service
public class CurrencyConversionServiceImpl implements CurrencyConversionService {

@Autowired
private CurrencyConversionRepository currencyConversionRepository;
	
	@Override
	public CurrencyBean addConversionDetails(CurrencyBean currencyBean) {
		currencyBean.setStatus("UnInitialized");
		return currencyConversionRepository.save(currencyBean);
	}
	
	@Cacheable("CurrencyBean")
	@Override
	public CurrencyBean getConversionDetail(String id) {
		Optional<CurrencyBean> currencyDbBean = currencyConversionRepository.findById(id);
	        return currencyDbBean.get();
	}

	@Override
	public CurrencyBean updateConversionDetails(CurrencyBean currencyBean, String id) {
		Optional<CurrencyBean> currencyDbBean = currencyConversionRepository.findById(id);
		CurrencyBean dbBean = currencyDbBean.get();
		dbBean.setConversionMultiple(currencyBean.getConversionMultiple());
		dbBean.setTotalCalculatedAmount(currencyBean.getQuantity().multiply(dbBean.getConversionMultiple()));
		dbBean.setStatus("Success");
		return currencyConversionRepository.save(dbBean);
	}

}
