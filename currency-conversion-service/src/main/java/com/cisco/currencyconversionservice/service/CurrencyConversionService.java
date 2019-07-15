package com.cisco.currencyconversionservice.service;

import org.springframework.stereotype.Service;

import com.cisco.currencyconversionservice.model.CurrencyBean;

@Service
public interface CurrencyConversionService {
    public CurrencyBean addConversionDetails(CurrencyBean userDTO);
    public CurrencyBean getConversionDetail(String id);
    public CurrencyBean updateConversionDetails(CurrencyBean userUpdateDTO, String id);
}
