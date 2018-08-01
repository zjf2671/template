package com.ddc.template.modules.sys.service;

/**
 * @author harry.zhang
 */
public interface MessageService {
	
	/**
	 * 无返回值
	 * @param message 消息体
	 */
	void send(Object message);
	
	/**
	 * 有返回值
	 * @param message 消息体
	 */
	void sendAndReceive(Object message);

}
