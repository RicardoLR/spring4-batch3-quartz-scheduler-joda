package com.richi.springbatch.quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.FactoryBean;


/** disparador CRON de cuarzo para especificar cuándo y con qué periodicidad debe ejecutarse el trabajo.
 * */
public class CronTriggerFactoryBean implements FactoryBean<Trigger> {

	
	private final String jobName;
	private final String cronExpression;
	
	
	public CronTriggerFactoryBean(String jobName, String cronExpression){
		this.jobName = jobName;
		this.cronExpression = cronExpression;
	}
	
	//@Override
	public Trigger getObject() throws Exception {

		return TriggerBuilder
				.newTrigger()
				.forJob(jobName, "DEFAULT")
				.withIdentity(jobName+"Trigger", "DEFAULT")
				.withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
				.build();
	}

	//@Override
	public Class<?> getObjectType() {
		return Trigger.class;
	}

	//@Override
	public boolean isSingleton() {
		return false;
	}

}
