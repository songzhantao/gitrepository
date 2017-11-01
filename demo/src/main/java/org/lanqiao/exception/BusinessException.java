package org.lanqiao.exception;
/**
 * 自定义异常
 * @author songzt@lanqiao.org
 *
 */
public class BusinessException extends RuntimeException {

	public BusinessException(){
		super();
	}
	public BusinessException(String message, Throwable cause) {
	        super(message, cause);
	}
}
