package com.cisco.currencyconversionservice.model;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;

public class CurrencyConversionBean {
	private Long id;
	@ApiModelProperty(notes = "Currency To be Exchange")
	private String from;
	@ApiModelProperty(notes = "Target Currency")
	private String to;
	private BigDecimal conversionMultiple;
	@ApiModelProperty(notes = "How much currency we want to convert")
	private BigDecimal quantity;
	private BigDecimal totalCalculatedAmount;
	public CurrencyConversionBean() {
		super();
	}
	public CurrencyConversionBean(Long id, String from, String to, BigDecimal conversionMultiple, BigDecimal quantity,
			BigDecimal totalCalculatedAmount) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.quantity = quantity;
		this.totalCalculatedAmount = totalCalculatedAmount;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getTotalCalculatedAmount() {
		return totalCalculatedAmount;
	}
	public void setTotalCalculatedAmount(BigDecimal totalCalculatedAmount) {
		this.totalCalculatedAmount = totalCalculatedAmount;
	}

}
