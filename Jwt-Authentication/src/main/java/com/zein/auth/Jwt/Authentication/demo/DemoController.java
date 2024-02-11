package com.zein.auth.Jwt.Authentication.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users/sec/v1/demo-controller")
@Slf4j
public class DemoController {
	
	@GetMapping
	public ResponseEntity<String> sayHello() {
		log.info("try calling sayHello");

		return ResponseEntity.ok("Hello from secured endpoint");
	}

}
