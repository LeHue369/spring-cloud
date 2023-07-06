package com.example.productService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Coupon {

	private Long id;
	private String code;
	private BigDecimal discount;
	private String expDate;
}
