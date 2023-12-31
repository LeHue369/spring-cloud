package com.example.productService.restclients;

import com.example.productService.entity.Coupon;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "zuul-api-gateway")
//@RibbonClient(name = "coupon-service")
public interface CouponClient {

	@GetMapping("/coupon-service/coupons/find")
	Coupon getCoupon(@RequestParam("code") String code);
}
