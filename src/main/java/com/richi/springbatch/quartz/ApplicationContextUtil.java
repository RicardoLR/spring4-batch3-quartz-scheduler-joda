package com.richi.springbatch.quartz;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;


/** Llamadas de scheduler Quartz a -> executeInternal método de clase implementando QuartzJobBean. 
 * 
 * En este método, simplemente llamamos a performJob de nuestra clase de trabajo por lotes de Spring.
 * 
 * Scheduler le decimos cómo encontrar nuestro bean de trabajo por lotes
 * en el contexto de Spring. Para ello, hemos utilizado una implementación de ApplicationContextAware.
 * 
 * */
public class ApplicationContextUtil implements ApplicationContextAware{

	
	private static ApplicationContextUtil instance;
	private ApplicationContext applicationContext;
	
	
	private static synchronized ApplicationContextUtil getInstance(){
		
		if(instance == null){
			instance = new ApplicationContextUtil();
		}
		
		return instance;
	}
	
	//@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		
		if(getInstance().applicationContext == null){
			getInstance().applicationContext = applicationContext;
		}
		
	}

	public static ApplicationContext getApplicationContext(){
		return getInstance().applicationContext;
	}
	
}
