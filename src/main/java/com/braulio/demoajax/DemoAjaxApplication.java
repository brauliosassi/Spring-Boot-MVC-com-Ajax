package com.braulio.demoajax;

import com.braulio.demoajax.domain.SocialMetaTag;
import com.braulio.demoajax.service.SocialMetaTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoAjaxApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(DemoAjaxApplication.class, args);
	}

	@Autowired
	SocialMetaTagService service;
	@Override
	public void run(String... args) throws Exception {

		SocialMetaTag og = service.getOpenGraphByUrl("https://www.mobly.com.br/sofa-3-lugares-corsega-linho-bege-314731.html?origin=jetmobly&label=");
		System.out.println(og.toString());

	}
}
