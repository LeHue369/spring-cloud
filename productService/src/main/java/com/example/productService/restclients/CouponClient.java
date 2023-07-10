package com.example.productService.restclients;

import com.example.productService.entity.Coupon;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "gateway-service")
public interface CouponClient {

	@GetMapping("/coupons/fin")
	Coupon getCoupon(@RequestParam("code") String code);
}
