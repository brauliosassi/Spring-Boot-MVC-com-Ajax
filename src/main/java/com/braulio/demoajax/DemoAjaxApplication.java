package com.braulio.demoajax;

import com.braulio.demoajax.domain.SocialMetaTag;
import com.braulio.demoajax.service.SocialMetaTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableWebMvc
public class DemoAjaxApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(DemoAjaxApplication.class, args);
	}

	@Autowired
	SocialMetaTagService service;
	@Override
	public void run(String... args) throws Exception {


	}
}
