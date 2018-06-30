package com.ddc.template.modules.sys.service;

public interface MessageService {
	
	/**
	 * 无返回值
	 * @param message 消息体
	 */
	public void send(Object message);
	
	/**
	 * 有返回值
	 * @param message 消息体
	 */
	public void sendAndReceive(Object message);

}
