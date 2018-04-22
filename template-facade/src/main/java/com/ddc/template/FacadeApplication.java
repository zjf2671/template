package com.ddc.template;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

import com.ddc.template.facade.CityFacade;

/**
 * @author harry.zhang
 *
 */
@SpringBootApplication//(exclude = { DataSourceAutoConfiguration.class })
@ImportResource("classpath:config/consumer.xml")
public class FacadeApplication {

	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext run = SpringApplication.run(FacadeApplication.class, args);
		CityFacade cityFacade = (CityFacade) run.getBean("cityFacade");
		System.out.println(cityFacade.findCityByName(1L));
	}

}
