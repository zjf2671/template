package com.ddc.template;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import com.ddc.template.datasources.DynamicDataSourceConfig;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@Import({ DynamicDataSourceConfig.class })
@ImportResource("classpath:config/provider.xml")
public class TemplateApplication /*extends SpringBootServletInitializer*/ {

	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext run = SpringApplication.run(TemplateApplication.class, args);
		/*CityDubboConsumerService cityService = run.getBean(CityDubboConsumerService.class);
		System.out.println(JSON.json(cityService.printCity()));*/
	}

	/*@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(TemplateApplication.class);

	}*/
	
}
