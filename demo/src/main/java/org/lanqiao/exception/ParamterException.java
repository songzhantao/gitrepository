package org.lanqiao.exception;
/**
 * 自定义异常
 * @author songzt@lanqiao.org
 *
 */
public class ParamterException extends RuntimeException {

	public ParamterException(){
		super();
	}
	public ParamterException(String message, Throwable cause) {
	        super(message, cause);
	}
}
