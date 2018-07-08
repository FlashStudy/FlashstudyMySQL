package br.com.flashstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@SpringBootApplication
public class FlashSpringTesteApplication {
	
	@RequestMapping("/")
	public String welcome() {
		return "index";
	}

	public static void main(String[] args) {
		SpringApplication.run(FlashSpringTesteApplication.class, args);
	}
}
