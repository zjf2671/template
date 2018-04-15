package com.ddc.template;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;

import com.ddc.template.datasources.DynamicDataSourceConfig;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@Import({ DynamicDataSourceConfig.class })
// @EnableTransactionManagement
@ImportResource("classpath:config/provider.xml")
public class AdminApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(AdminApplication.class);
		application.setBannerMode(Banner.Mode.OFF);
		application.run(args);
	}
}
