package org.lanqiao.aspectj;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.reflect.MethodSignature;
import org.lanqiao.annotaion.Slave;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 读写分离的切面 在切面中,判断方法名的前缀或者注解来设置数据源
 * 
 * @author songzt@lanqiao.org
 *
 */
public class DataSourceAspectj {
	Logger loger  =LoggerFactory.getLogger(DataSourceAspectj.class);
	private String masterDataSourceKey="dataSource";
	private String slaveDataSourceKey="dataSource";
	
	public void setMasterDataSourceKey(String masterDataSourceKey) {
		this.masterDataSourceKey = masterDataSourceKey;
	}


	public void setSlaveDataSourceKey(String slaveDataSourceKey) {
		this.slaveDataSourceKey = slaveDataSourceKey;
	}


	
	/**
	 * 切换数据源
	 * @param joinPoint
	 */
	public void changeDataSourceBefore(JoinPoint joinPoint ) {
			Signature sig = joinPoint.getSignature();
	        MethodSignature msig = null;
	        if (!(sig instanceof MethodSignature)) {
	            throw new IllegalArgumentException("该注解只能用于方法");
	        }
	        msig = (MethodSignature) sig;
	        Object target = joinPoint.getTarget();
	        try {
				Method currentMethod = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
				loger.debug("当前业务方法名称为{}",msig.getName());
				Annotation  annotation =currentMethod.getAnnotation(Slave.class);
				if(annotation!=null){
					//切换到从数据源
					loger.debug("设置数据源为Salve数据源-{}",slaveDataSourceKey);
					DataSourceContextHolder.setDataSourceType(slaveDataSourceKey);
				}
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				
				e.printStackTrace();
			}
	        
	        
	        
	        
	        
	        
		
	}

}
