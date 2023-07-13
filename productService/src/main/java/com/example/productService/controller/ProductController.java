package com.example.productService.controller;

import com.example.productService.entity.Coupon;
import com.example.productService.entity.Product;
import com.example.productService.repository.ProductRepository;
import com.example.productService.restclients.CouponClient;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
@RefreshScope
public class ProductController {

	@Autowired
	CouponClient couponClient;

	@Autowired
	private ProductRepository repository;

	@Value("${com.example.productService.prop}")
	private String prop;

	@PostMapping
	@Retry(name = "product-api", fallbackMethod = "handleError")
	public Product create(@RequestBody Product product) {
		Coupon coupon = couponClient.getCoupon(product.getCouponCode());
		product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
		return repository.save(product);

	}

	@GetMapping("/prop")
	public String getProp(){
     return this.prop;
	}

	public Product handleError(Product product, Exception exception) {
		System.out.println("Inside handle error");
		return product;
	}
}
