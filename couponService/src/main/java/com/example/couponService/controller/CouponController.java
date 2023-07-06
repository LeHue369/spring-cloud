package com.example.couponService.controller;

import com.example.couponService.entity.Coupon;
import com.example.couponService.repository.CouponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/coupons")
public class CouponController {

	@Autowired
	CouponRepository couponRepository;

	@PostMapping("/create")
	public Coupon create(@RequestBody Coupon coupon) {
		return couponRepository.save(coupon);
	}


	@GetMapping("/find")
	public Coupon getCoupon(@RequestParam("code") String code) {
		return couponRepository.findByCode(code);
	}
}
