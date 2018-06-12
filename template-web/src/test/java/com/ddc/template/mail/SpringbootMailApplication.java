package com.ddc.template.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.ddc.template.component.mail.MailService;
import com.ddc.template.component.model.Email;


/**
 * 邮件发送测试类
 * @author harry.zhang
 *
 */
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
@ComponentScan(basePackages={"com.ddc.store.component"})
public class SpringbootMailApplication implements CommandLineRunner {
	@Autowired
	private MailService mailService;
	public static void main(String[] args) {
		SpringApplication.run(SpringbootMailApplication.class, args);
	}

	@Override
	public void run(String... args) {
		try {
			Email mail = new Email();
			mail.setEmail(new String[]{"harry.zhang@daydaycook.com"});
			mail.setSubject("测试");
			mail.setContent("---正常发送欢迎您");
			mail.setTemplate("welcome");
			mailService.send(mail);
			mail.setContent("---html发送欢迎您");
			mailService.sendHtml(mail);
			mail.setContent("---Freemarker发送欢迎您");
			mailService.sendFreemarker(mail);
			for(int i=0;i<1000;i++){
				//测试用 小心被封
			    //mailService.sendQueue(mail);
				//mailService.sendRedisQueue(mail);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
