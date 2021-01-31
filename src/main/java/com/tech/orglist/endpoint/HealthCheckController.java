package com.tech.orglist.endpoint;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {
	@GetMapping("/healthcheck")
	String healthcheck() {
		return "success";
	}
}
