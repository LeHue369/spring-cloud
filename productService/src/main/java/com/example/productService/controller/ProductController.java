package com.example.productService.controller;

import com.example.productService.entity.Coupon;
import com.example.productService.entity.Product;
import com.example.productService.repository.ProductRepository;
import com.example.productService.restclients.CouponClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	CouponClient couponClient;

	@Autowired
	private ProductRepository repository;

	@PostMapping
	public Product create(@RequestBody Product product) {
		Coupon coupon = couponClient.getCoupon(product.getCouponCode());
		product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
		return repository.save(product);

	}

//	public Product sendErrorResponse(Product product) {
//		return product;
//	}
}
