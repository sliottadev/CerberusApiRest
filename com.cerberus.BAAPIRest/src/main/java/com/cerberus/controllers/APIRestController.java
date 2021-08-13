package com.cerberus.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class APIRestController {
	@GetMapping("test")
	public String HelloTest() {
		return "Hello World!!! ASFASDASDASD";
	}
}
