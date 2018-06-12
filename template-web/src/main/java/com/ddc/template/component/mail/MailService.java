package com.ddc.template.component.mail;

import com.ddc.template.component.model.Email;

public interface MailService {
	 /**
	  * 纯文本
	  */
	 public void send(Email mail) throws Exception;
	 /**
	  * 富文本
	  */
	 public void sendHtml(Email mail) throws Exception;
	 /**
	  * 模版发送 freemarker
	  */
	 public void sendFreemarker(Email mail) throws Exception;
}
