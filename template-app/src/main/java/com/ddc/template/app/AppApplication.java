package com.ddc.template.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import com.ddc.template.app.datasources.DynamicDataSourceConfig;



@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@Import({ DynamicDataSourceConfig.class })
@ImportResource("classpath:config/provider.xml")
public class AppApplication   {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

}
