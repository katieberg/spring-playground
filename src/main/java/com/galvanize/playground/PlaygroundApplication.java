package com.galvanize.playground;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class PlaygroundApplication {
	@RestController
	@RequestMapping("/math")
	public class MyController {
		@GetMapping("/pi")
		public String myMethod() {
			return "3.141592653589793";
		}
	}
	public static void main(String[] args) {
		SpringApplication.run(PlaygroundApplication.class, args);
	}

}

